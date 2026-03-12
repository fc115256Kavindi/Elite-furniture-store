package com.elite.elitefurniturestore.repository;

import com.elite.elitefurniturestore.entity.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
}