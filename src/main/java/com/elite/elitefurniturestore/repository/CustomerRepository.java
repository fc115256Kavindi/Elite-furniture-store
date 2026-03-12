package com.elite.elitefurniturestore.repository;

import com.elite.elitefurniturestore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}