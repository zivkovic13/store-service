package com.cirillyc.storeservice.controllers;

import com.cirillyc.storeservice.models.entities.InvoiceEntity;
import com.cirillyc.storeservice.models.entities.InvoiceItemEntity;
import com.cirillyc.storeservice.services.InvoiceItemService;
import com.cirillyc.storeservice.services.InvoiceService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Path("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;
    @Autowired
    InvoiceItemService invoiceItemService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllInvoices() {
        List<InvoiceEntity> invoiceEntityList = invoiceService.getAllInvoices();
        return Response.ok(invoiceEntityList).build();
    }

    /**
     * Retrieves the details of an invoice, including a list of items associated  with the invoice and additional calculations for each item.
     *
     * @param id the unique identifier of the invoice to retrieve
     * @return a Response object containing the invoice details and item details with calculations
     *         if the invoice is found; otherwise, returns a 404 Not Found response
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInvoiceById(@PathParam("id") Long id) {
        Optional<InvoiceEntity> optionalInvoice = invoiceService.getInvoiceById(id);
        if (optionalInvoice.isPresent()) {
            InvoiceEntity invoiceEntity = optionalInvoice.get();
            List<InvoiceItemEntity> invoiceItems = invoiceItemService.getItemsByInvoice(id);

            // Extracts item details for the invoice with additional calculations
            Map<String, Object> invoiceDetails = invoiceItemService.getItemsWithDetails(invoiceEntity, invoiceItems);

            return Response.ok(invoiceDetails).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createInvoice(InvoiceEntity invoiceEntity) {
        InvoiceEntity createdInvoice = invoiceService.createInvoice(invoiceEntity);
        return Response.status(Response.Status.CREATED).entity(createdInvoice).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateInvoice(@PathParam("id") Long id, InvoiceEntity updatedInvoice) {
        updatedInvoice.setId(id);
        InvoiceEntity savedInvoice = invoiceService.updateInvoice(updatedInvoice);
        return Response.ok(savedInvoice).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteInvoice(@PathParam("id") Long id) {
        invoiceService.deleteInvoiceById(id);
        return Response.noContent().build();
    }
}
