package com.example.ecom.inventory.repository;

import com.example.ecom.inventory.model.Inventory;
import com.example.ecom.inventory.model.QInventory;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class InventoryRepositoryImpl implements InventoryRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Inventory> findInventoryByProductId(String productId) {
        QInventory qInventory = QInventory.inventory;
        JPAQuery query = new JPAQuery(entityManager);

        return query.from(qInventory)
                .where(qInventory.productId.eq(productId))
                .list(qInventory);
    }
}
