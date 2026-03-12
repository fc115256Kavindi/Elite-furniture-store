package com.elite.elitefurniturestore.controller;

import com.elite.elitefurniturestore.entity.NewsletterSubscriber;
import com.elite.elitefurniturestore.service.NewsletterSubscriberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/newsletter")
@CrossOrigin(origins = "*")
public class NewsletterSubscriberController {

    private final NewsletterSubscriberService newsletterSubscriberService;

    public NewsletterSubscriberController(NewsletterSubscriberService newsletterSubscriberService) {
        this.newsletterSubscriberService = newsletterSubscriberService;
    }

    @GetMapping
    public List<NewsletterSubscriber> getAllSubscribers() {
        return newsletterSubscriberService.getAllSubscribers();
    }

    @GetMapping("/{id}")
    public NewsletterSubscriber getSubscriberById(@PathVariable Long id) {
        return newsletterSubscriberService.getSubscriberById(id)
                .orElseThrow(() -> new RuntimeException("Subscriber not found"));
    }

    @PostMapping
    public NewsletterSubscriber createSubscriber(@RequestBody NewsletterSubscriber subscriber) {
        return newsletterSubscriberService.saveSubscriber(subscriber);
    }

    @PutMapping("/{id}")
    public NewsletterSubscriber updateSubscriber(@PathVariable Long id, @RequestBody NewsletterSubscriber subscriber) {
        return newsletterSubscriberService.updateSubscriber(id, subscriber);
    }

    @DeleteMapping("/{id}")
    public String deleteSubscriber(@PathVariable Long id) {
        newsletterSubscriberService.deleteSubscriber(id);
        return "Subscriber deleted successfully";
    }
}