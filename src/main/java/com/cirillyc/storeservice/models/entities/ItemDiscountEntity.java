package com.cirillyc.storeservice.models.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item_discount")
public class ItemDiscountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "starting_from")
    private LocalDateTime startingFrom;

    @Column(name = "ends")
    private LocalDateTime ends;

    @Column(name = "percentage")
    private Double percentage;

    public ItemDiscountEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartingFrom() {
        return startingFrom;
    }

    public void setStartingFrom(LocalDateTime startingFrom) {
        this.startingFrom = startingFrom;
    }

    public LocalDateTime getEnds() {
        return ends;
    }

    public void setEnds(LocalDateTime ends) {
        this.ends = ends;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}
