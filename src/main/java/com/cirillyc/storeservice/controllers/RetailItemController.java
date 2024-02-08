package com.cirillyc.storeservice.controllers;

import com.cirillyc.storeservice.models.entities.RetailItemEntity;
import com.cirillyc.storeservice.services.RetailItemService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Path("/retail-item")
public class RetailItemController {

    @Autowired
    RetailItemService retailItemService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRetailItems() {
        List<RetailItemEntity> retailItemEntities = retailItemService.getAllRetailItems();
        return Response.ok(retailItemEntities).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRetailItemById(@PathParam("id") Long id) {
        Optional<RetailItemEntity> optionalRetailItem = retailItemService.getRetailItemById(id);
        return optionalRetailItem.map(item -> Response.ok(item).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRetailItem(RetailItemEntity retailItemEntity) {
        RetailItemEntity createdItem = retailItemService.createRetailItem(retailItemEntity);
        return Response.status(Response.Status.CREATED).entity(createdItem).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRetailItem(@PathParam("id") Long id, RetailItemEntity updatedRetailItem) {
        updatedRetailItem.setId(id);
        RetailItemEntity savedRetailItem = retailItemService.updateRetailItem(updatedRetailItem);
        return Response.ok(savedRetailItem).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRetailItem(@PathParam("id") Long id) {
        retailItemService.deleteRetailItemById(id);
        return Response.noContent().build();
    }
}
