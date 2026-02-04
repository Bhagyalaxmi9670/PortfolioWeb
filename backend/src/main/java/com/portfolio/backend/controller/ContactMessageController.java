package com.portfolio.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.entity.ContactMessage;
import com.portfolio.backend.service.ContactMessageService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactMessageController {

    private final ContactMessageService service;

    public ContactMessageController(ContactMessageService service) {
        this.service = service;
    }

    // Contact form submit
    @PostMapping
    public ContactMessage submit(@RequestBody ContactMessage message) {
        return service.save(message);
    }

    // Admin: view all messages
    @GetMapping
    public List<ContactMessage> getAll() {
        return service.getAll();
    }

    // Admin: delete message
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
