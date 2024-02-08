package com.cirillyc.storeservice.services;

import com.cirillyc.storeservice.models.entities.InvoiceEntity;
import com.cirillyc.storeservice.models.entities.InvoiceItemEntity;
import com.cirillyc.storeservice.repositories.InvoiceItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InvoiceItemService {

    @Autowired
    InvoiceItemRepository invoiceItemRepository;

    public List<InvoiceItemEntity> getAllInvoiceItems() {
        return invoiceItemRepository.findAll();
    }

    public Optional<InvoiceItemEntity> getInvoiceItemById(Long id) {
        return invoiceItemRepository.findById(id);
    }

    @Transactional
    public InvoiceItemEntity createInvoiceItem(InvoiceItemEntity invoiceItemEntity) {
        return invoiceItemRepository.save(invoiceItemEntity);
    }

    @Transactional
    public InvoiceItemEntity updateInvoiceItem(InvoiceItemEntity invoiceItemEntity) {
        return invoiceItemRepository.save(invoiceItemEntity);
    }

    @Transactional
    public void deleteInvoiceItemById(Long id) {
        invoiceItemRepository.deleteById(id);
    }

    public List<InvoiceItemEntity> getItemsByInvoice(Long id) {
        return invoiceItemRepository.getItemsByInvoice(id);
    }

    public Map<String, Object> getItemsWithDetails(InvoiceEntity invoiceEntity, List<InvoiceItemEntity> invoiceItems) {
        Map<String, Object> invoiceDetails = new HashMap<>();
        List<Map<String, Object>> invoiceItemsWithDetails = new ArrayList<>();
        double totalPrice = 0.0;

        for (InvoiceItemEntity item : invoiceItems) {
            Map<String, Object> itemDetails = new HashMap<>();
            itemDetails.put("amount", item.getAmount());
            itemDetails.put("priceForItem", item.getPrice());
            itemDetails.put("priceForUnit", item.getPrice() / item.getAmount());
            invoiceItemsWithDetails.add(itemDetails);
            totalPrice += item.getPrice();
        }

        invoiceDetails.put("invoice", invoiceEntity);
        invoiceDetails.put("invoiceItems", invoiceItemsWithDetails);
        invoiceDetails.put("totalPrice", totalPrice);

        return invoiceDetails;
    }

}
