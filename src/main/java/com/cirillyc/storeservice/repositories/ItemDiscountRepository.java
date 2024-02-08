package com.cirillyc.storeservice.repositories;

import com.cirillyc.storeservice.models.entities.ItemDiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDiscountRepository extends JpaRepository<ItemDiscountEntity, Long> {
}
