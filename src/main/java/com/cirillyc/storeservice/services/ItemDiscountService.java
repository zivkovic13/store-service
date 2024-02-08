package com.cirillyc.storeservice.services;

import com.cirillyc.storeservice.models.entities.InvoiceEntity;
import com.cirillyc.storeservice.models.entities.ItemDiscountEntity;
import com.cirillyc.storeservice.repositories.InvoiceRepository;
import com.cirillyc.storeservice.repositories.ItemDiscountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemDiscountService {

    @Autowired
    ItemDiscountRepository itemDiscountRepository;

    public List<ItemDiscountEntity> getAllItemDiscounts() {
        return itemDiscountRepository.findAll();
    }

    public Optional<ItemDiscountEntity> getItemDiscountById(Long id) {
        return itemDiscountRepository.findById(id);
    }

    @Transactional
    public ItemDiscountEntity createItemDiscount(ItemDiscountEntity itemDiscountEntity) {
        return itemDiscountRepository.save(itemDiscountEntity);
    }

    @Transactional
    public ItemDiscountEntity updateItemDiscount(ItemDiscountEntity itemDiscountEntity) {
        return itemDiscountRepository.save(itemDiscountEntity);
    }

    @Transactional
    public void deleteItemDiscountById(Long id) {
        itemDiscountRepository.deleteById(id);
    }

}
