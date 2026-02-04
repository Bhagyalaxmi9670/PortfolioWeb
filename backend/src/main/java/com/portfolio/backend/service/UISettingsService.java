package com.portfolio.backend.service;

import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.UISettings;
import com.portfolio.backend.repository.UISettingsRepository;

@Service
public class UISettingsService {

    private final UISettingsRepository repository;

    public UISettingsService(UISettingsRepository repository) {
        this.repository = repository;
    }

    // Get current settings (latest / first)
    public UISettings getSettings() {
        return repository.findAll()
                .stream()
                .findFirst()
                .orElse(null);
    }

    // Save or update settings
    public UISettings saveSettings(UISettings settings) {
        return repository.save(settings);
    }
}
