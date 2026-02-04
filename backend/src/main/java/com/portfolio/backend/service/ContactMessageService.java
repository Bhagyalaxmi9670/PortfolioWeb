package com.portfolio.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.ContactMessage;
import com.portfolio.backend.repository.ContactMessageRepository;

@Service
public class ContactMessageService {

    private final ContactMessageRepository repository;

    public ContactMessageService(ContactMessageRepository repository) {
        this.repository = repository;
    }

    // SAVE message (from contact form)
    public ContactMessage save(ContactMessage message) {
        return repository.save(message);
    }

    // ADMIN can read all messages
    public List<ContactMessage> getAll() {
        return repository.findAll();
    }

    // ADMIN can delete message
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
