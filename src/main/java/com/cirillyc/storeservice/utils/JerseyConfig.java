package com.cirillyc.storeservice.utils;
import com.cirillyc.storeservice.controllers.InvoiceController;
import com.cirillyc.storeservice.controllers.InvoiceItemController;
import com.cirillyc.storeservice.controllers.ItemDiscountController;
import com.cirillyc.storeservice.controllers.RetailItemController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        // controllers
        register(InvoiceController.class);
        register(InvoiceItemController.class);
        register(ItemDiscountController.class);
        register(RetailItemController.class);
    }
}



