package com.elite.elitefurniturestore.controller;

import com.elite.elitefurniturestore.entity.CustomOrder;
import com.elite.elitefurniturestore.service.CustomOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/custom-orders")
@CrossOrigin(origins = "*")
public class CustomOrderController {

    private final CustomOrderService customOrderService;

    public CustomOrderController(CustomOrderService customOrderService) {
        this.customOrderService = customOrderService;
    }

    @GetMapping
    public List<CustomOrder> getAllCustomOrders() {
        return customOrderService.getAllCustomOrders();
    }

    @GetMapping("/{id}")
    public CustomOrder getCustomOrderById(@PathVariable Long id) {
        return customOrderService.getCustomOrderById(id)
                .orElseThrow(() -> new RuntimeException("Custom order not found"));
    }

    @PostMapping
    public CustomOrder createCustomOrder(@RequestBody CustomOrder customOrder) {
        return customOrderService.saveCustomOrder(customOrder);
    }

    @PutMapping("/{id}")
    public CustomOrder updateCustomOrder(@PathVariable Long id, @RequestBody CustomOrder customOrder) {
        return customOrderService.updateCustomOrder(id, customOrder);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomOrder(@PathVariable Long id) {
        customOrderService.deleteCustomOrder(id);
        return "Custom order deleted successfully";
    }
}