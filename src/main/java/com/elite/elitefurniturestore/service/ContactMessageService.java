package com.elite.elitefurniturestore.service;

import com.elite.elitefurniturestore.entity.ContactMessage;
import com.elite.elitefurniturestore.repository.ContactMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    public ContactMessageService(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    public List<ContactMessage> getAllMessages() {
        return contactMessageRepository.findAll();
    }

    public Optional<ContactMessage> getMessageById(Long id) {
        return contactMessageRepository.findById(id);
    }

    public ContactMessage saveMessage(ContactMessage contactMessage) {
        return contactMessageRepository.save(contactMessage);
    }

    public ContactMessage updateMessage(Long id, ContactMessage updatedMessage) {
        return contactMessageRepository.findById(id).map(message -> {
            message.setName(updatedMessage.getName());
            message.setEmail(updatedMessage.getEmail());
            message.setSubject(updatedMessage.getSubject());
            message.setMessage(updatedMessage.getMessage());
            return contactMessageRepository.save(message);
        }).orElseThrow(() -> new RuntimeException("Contact message not found"));
    }

    public void deleteMessage(Long id) {
        contactMessageRepository.deleteById(id);
    }
}