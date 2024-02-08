package com.cirillyc.storeservice.controllers;


import com.cirillyc.storeservice.models.entities.InvoiceItemEntity;
import com.cirillyc.storeservice.services.InvoiceItemService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Path("/invoice-item")
public class InvoiceItemController {

    @Autowired
    InvoiceItemService invoiceItemService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllInvoiceItems() {
        List<InvoiceItemEntity> invoiceItems = invoiceItemService.getAllInvoiceItems();
        return Response.ok(invoiceItems).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInvoiceItemById(@PathParam("id") Long id) {
        Optional<InvoiceItemEntity> optionalInvoiceItem = invoiceItemService.getInvoiceItemById(id);
        return optionalInvoiceItem.map(invoiceItem -> Response.ok(invoiceItem).build())
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createInvoiceItem(InvoiceItemEntity invoiceItemEntity) {
        InvoiceItemEntity createdInvoiceItem = invoiceItemService.createInvoiceItem(invoiceItemEntity);
        return Response.status(Response.Status.CREATED).entity(createdInvoiceItem).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateInvoiceItem(@PathParam("id") Long id, InvoiceItemEntity updatedInvoiceItem) {
        updatedInvoiceItem.setId(id);
        InvoiceItemEntity savedInvoiceItem = invoiceItemService.updateInvoiceItem(updatedInvoiceItem);
        return Response.ok(savedInvoiceItem).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteInvoiceItem(@PathParam("id") Long id) {
        invoiceItemService.deleteInvoiceItemById(id);
        return Response.noContent().build();
    }
}
