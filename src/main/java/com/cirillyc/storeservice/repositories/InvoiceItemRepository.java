package com.cirillyc.storeservice.repositories;

import com.cirillyc.storeservice.models.entities.InvoiceItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItemEntity, Long> {

    @Query(value = "SELECT * FROM invoice_item i WHERE i.invoice_id = :id", nativeQuery = true)
    List<InvoiceItemEntity> getItemsByInvoice(@Param("id") Long id);

}
