package com.example.ecom.inventory.listener;

import com.example.ecom.common.event.OrderCreatedEvent;
import com.example.ecom.inventory.model.Inventory;
import com.example.ecom.inventory.repository.InventoryRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryListener {

    @Autowired
    private InventoryRepository inventoryRepository;

    @RabbitListener(queues = "order.created.inventory")
    public void handleOrderCreated(OrderCreatedEvent event) {
        // Logic to deduct inventory
        if (event.getItems() != null) {
            for (OrderCreatedEvent.OrderItemDto item : event.getItems()) {
                Inventory inventory = inventoryRepository.findByProductId(item.getProductId()).orElse(null);
                if (inventory != null) {
                    inventory.setQuantity(inventory.getQuantity() - item.getQuantity());
                    inventoryRepository.save(inventory);
                }
            }
        }
    }
}
