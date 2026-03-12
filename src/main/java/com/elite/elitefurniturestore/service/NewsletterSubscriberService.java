package com.elite.elitefurniturestore.service;

import com.elite.elitefurniturestore.entity.NewsletterSubscriber;
import com.elite.elitefurniturestore.repository.NewsletterSubscriberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsletterSubscriberService {

    private final NewsletterSubscriberRepository newsletterSubscriberRepository;

    public NewsletterSubscriberService(NewsletterSubscriberRepository newsletterSubscriberRepository) {
        this.newsletterSubscriberRepository = newsletterSubscriberRepository;
    }

    public List<NewsletterSubscriber> getAllSubscribers() {
        return newsletterSubscriberRepository.findAll();
    }

    public Optional<NewsletterSubscriber> getSubscriberById(Long id) {
        return newsletterSubscriberRepository.findById(id);
    }

    public NewsletterSubscriber saveSubscriber(NewsletterSubscriber subscriber) {
        return newsletterSubscriberRepository.save(subscriber);
    }

    public NewsletterSubscriber updateSubscriber(Long id, NewsletterSubscriber updatedSubscriber) {
        return newsletterSubscriberRepository.findById(id).map(subscriber -> {
            subscriber.setEmail(updatedSubscriber.getEmail());
            return newsletterSubscriberRepository.save(subscriber);
        }).orElseThrow(() -> new RuntimeException("Subscriber not found"));
    }

    public void deleteSubscriber(Long id) {
        newsletterSubscriberRepository.deleteById(id);
    }
}