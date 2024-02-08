package com.cirillyc.storeservice.invoices;

import com.cirillyc.storeservice.models.entities.InvoiceEntity;
import com.cirillyc.storeservice.repositories.InvoiceRepository;
import com.cirillyc.storeservice.services.InvoiceService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class InvoiceServiceTest {

    @Mock
    InvoiceRepository invoiceRepository;

    @InjectMocks
    InvoiceService invoiceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllInvoices() {
        // Prepare
        List<InvoiceEntity> invoices = Arrays.asList(
                new InvoiceEntity(1L, LocalDateTime.of(2024, 1, 1, 0, 0)),
                new InvoiceEntity(2L, LocalDateTime.of(2024, 1, 2, 0, 0))
        );
        when(invoiceRepository.findAll()).thenReturn(invoices);

        // Execute
        List<InvoiceEntity> result = invoiceService.getAllInvoices();

        // Verify
        assertEquals(2, result.size());
    }

    @Test
    void testGetInvoiceById() {
        // Prepare
        long id = 1L;
        LocalDateTime date = LocalDateTime.of(2024, 1, 1, 0, 0);
        InvoiceEntity invoice = new InvoiceEntity(id, date);
        when(invoiceRepository.findById(id)).thenReturn(Optional.of(invoice));

        // Execute
        Optional<InvoiceEntity> result = invoiceService.getInvoiceById(id);

        // Verify
        assertEquals(invoice, result.orElse(null));
    }

    @Test
    @Transactional
    void testCreateInvoice() {
        // Prepare
        LocalDateTime date = LocalDateTime.of(2024, 1, 1, 0, 0);
        InvoiceEntity invoice = new InvoiceEntity(7L, date);

        when(invoiceRepository.save(invoice)).thenReturn(invoice);
        InvoiceEntity result = invoiceService.createInvoice(invoice);
        assertEquals(invoice, result);
        verify(invoiceRepository, times(1)).save(invoice);
    }


    @Test
    void testUpdateInvoice() {
        // Prepare
        LocalDateTime date = LocalDateTime.of(2024, 1, 1, 0, 0);
        InvoiceEntity updatedInvoice = new InvoiceEntity(1L, date);
        when(invoiceRepository.save(updatedInvoice)).thenReturn(updatedInvoice);

        // Execute
        InvoiceEntity result = invoiceService.updateInvoice(updatedInvoice);

        // Verify
        assertEquals(updatedInvoice, result);
    }

    @Test
    void testDeleteInvoiceById() {
        // Prepare
        long id = 1L;

        // Execute
        invoiceService.deleteInvoiceById(id);

        // Verify
        verify(invoiceRepository, times(1)).deleteById(id);
    }
}
