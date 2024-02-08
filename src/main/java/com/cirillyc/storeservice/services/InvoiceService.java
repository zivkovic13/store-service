package com.cirillyc.storeservice.services;

import com.cirillyc.storeservice.models.entities.InvoiceEntity;
import com.cirillyc.storeservice.repositories.InvoiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    public List<InvoiceEntity> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Optional<InvoiceEntity> getInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    @Transactional
    public InvoiceEntity createInvoice(InvoiceEntity invoiceEntity) {
        return invoiceRepository.save(invoiceEntity);
    }

    @Transactional
    public InvoiceEntity updateInvoice(InvoiceEntity updatedInvoice) {
        return invoiceRepository.save(updatedInvoice);
    }

    @Transactional
    public void deleteInvoiceById(Long id) {
        invoiceRepository.deleteById(id);
    }
}
