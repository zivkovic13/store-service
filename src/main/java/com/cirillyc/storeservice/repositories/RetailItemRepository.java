package com.cirillyc.storeservice.repositories;

import com.cirillyc.storeservice.models.entities.RetailItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailItemRepository extends JpaRepository<RetailItemEntity, Long> {

}
