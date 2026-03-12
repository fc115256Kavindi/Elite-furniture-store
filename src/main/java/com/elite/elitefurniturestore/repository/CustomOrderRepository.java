package com.elite.elitefurniturestore.repository;

import com.elite.elitefurniturestore.entity.CustomOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomOrderRepository extends JpaRepository<CustomOrder, Long> {
}