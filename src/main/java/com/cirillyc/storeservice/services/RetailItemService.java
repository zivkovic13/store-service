package com.cirillyc.storeservice.services;

import com.cirillyc.storeservice.models.entities.RetailItemEntity;
import com.cirillyc.storeservice.repositories.RetailItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetailItemService {

    @Autowired
    RetailItemRepository retailItemRepository;

    public List<RetailItemEntity> getAllRetailItems() {
        return retailItemRepository.findAll();
    }

    public Optional<RetailItemEntity> getRetailItemById(Long id) {
        return retailItemRepository.findById(id);
    }

    @Transactional
    public RetailItemEntity createRetailItem(RetailItemEntity retailItemEntity) {
        return retailItemRepository.save(retailItemEntity);
    }

    @Transactional
    public RetailItemEntity updateRetailItem(RetailItemEntity retailItemEntity) {
        return retailItemRepository.save(retailItemEntity);
    }

    @Transactional
    public void deleteRetailItemById(Long id) {
        retailItemRepository.deleteById(id);
    }
}
