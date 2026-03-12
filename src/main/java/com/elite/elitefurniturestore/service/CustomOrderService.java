package com.elite.elitefurniturestore.service;

import com.elite.elitefurniturestore.entity.CustomOrder;
import com.elite.elitefurniturestore.repository.CustomOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomOrderService {

    private final CustomOrderRepository customOrderRepository;

    public CustomOrderService(CustomOrderRepository customOrderRepository) {
        this.customOrderRepository = customOrderRepository;
    }

    public List<CustomOrder> getAllCustomOrders() {
        return customOrderRepository.findAll();
    }

    public Optional<CustomOrder> getCustomOrderById(Long id) {
        return customOrderRepository.findById(id);
    }

    public CustomOrder saveCustomOrder(CustomOrder customOrder) {
        return customOrderRepository.save(customOrder);
    }

    public CustomOrder updateCustomOrder(Long id, CustomOrder updatedOrder) {
        return customOrderRepository.findById(id).map(order -> {
            order.setCustomerName(updatedOrder.getCustomerName());
            order.setEmail(updatedOrder.getEmail());
            order.setPhone(updatedOrder.getPhone());
            order.setFurnitureType(updatedOrder.getFurnitureType());
            order.setPreferredMaterial(updatedOrder.getPreferredMaterial());
            order.setPreferredColor(updatedOrder.getPreferredColor());
            order.setDimensions(updatedOrder.getDimensions());
            order.setEstimatedBudget(updatedOrder.getEstimatedBudget());
            order.setDesignDetails(updatedOrder.getDesignDetails());
            return customOrderRepository.save(order);
        }).orElseThrow(() -> new RuntimeException("Custom order not found"));
    }

    public void deleteCustomOrder(Long id) {
        customOrderRepository.deleteById(id);
    }
}