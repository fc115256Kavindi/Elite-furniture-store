package com.elite.elitefurniturestore.controller;

import com.elite.elitefurniturestore.entity.ContactMessage;
import com.elite.elitefurniturestore.service.ContactMessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-messages")
@CrossOrigin(origins = "*")
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    public ContactMessageController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    @GetMapping
    public List<ContactMessage> getAllMessages() {
        return contactMessageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public ContactMessage getMessageById(@PathVariable Long id) {
        return contactMessageService.getMessageById(id)
                .orElseThrow(() -> new RuntimeException("Message not found"));
    }

    @PostMapping
    public ContactMessage createMessage(@RequestBody ContactMessage contactMessage) {
        return contactMessageService.saveMessage(contactMessage);
    }

    @PutMapping("/{id}")
    public ContactMessage updateMessage(@PathVariable Long id, @RequestBody ContactMessage contactMessage) {
        return contactMessageService.updateMessage(id, contactMessage);
    }

    @DeleteMapping("/{id}")
    public String deleteMessage(@PathVariable Long id) {
        contactMessageService.deleteMessage(id);
        return "Message deleted successfully";
    }
}