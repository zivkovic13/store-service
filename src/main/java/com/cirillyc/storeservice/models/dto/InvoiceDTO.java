package com.cirillyc.storeservice.models.dto;

import java.time.LocalDateTime;
import java.util.List;

public class InvoiceDTO {

    private Long id;
    private LocalDateTime issuanceDate;
    private List<InvoiceItemDTO> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getIssuanceDate() {
        return issuanceDate;
    }

    public void setIssuanceDate(LocalDateTime issuanceDate) {
        this.issuanceDate = issuanceDate;
    }

    public List<InvoiceItemDTO> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItemDTO> items) {
        this.items = items;
    }
}
