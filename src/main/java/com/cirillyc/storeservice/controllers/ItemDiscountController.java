package com.cirillyc.storeservice.controllers;

import com.cirillyc.storeservice.models.entities.ItemDiscountEntity;
import com.cirillyc.storeservice.services.ItemDiscountService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Path("/item-discount")
public class ItemDiscountController {

    @Autowired
    ItemDiscountService itemDiscountService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllItemDiscounts() {
        List<ItemDiscountEntity> itemDiscountEntityList = itemDiscountService.getAllItemDiscounts();
        return Response.ok(itemDiscountEntityList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemDiscountById(@PathParam("id") Long id) {
        Optional<ItemDiscountEntity> optionalItemDiscount = itemDiscountService.getItemDiscountById(id);
        if (optionalItemDiscount.isPresent()) {
            ItemDiscountEntity itemDiscountEntity = optionalItemDiscount.get();
            return Response.ok(itemDiscountEntity).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createItemDiscount(ItemDiscountEntity itemDiscountEntity) {
        ItemDiscountEntity createdItemDiscount = itemDiscountService.createItemDiscount(itemDiscountEntity);
        return Response.status(Response.Status.CREATED).entity(createdItemDiscount).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateItemDiscount(@PathParam("id") Long id, ItemDiscountEntity updatedItemDiscount) {
        updatedItemDiscount.setId(id);
        ItemDiscountEntity savedItemDiscount = itemDiscountService.updateItemDiscount(updatedItemDiscount);
        return Response.ok(savedItemDiscount).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteItemDiscount(@PathParam("id") Long id) {
        itemDiscountService.deleteItemDiscountById(id);
        return Response.noContent().build();
    }
}
