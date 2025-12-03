package com.example.ecom.inventory.repository;

import com.example.ecom.inventory.model.Inventory;
import java.util.List;

public interface InventoryRepositoryCustom {
    List<Inventory> findInventoryByProductId(String productId);
}
