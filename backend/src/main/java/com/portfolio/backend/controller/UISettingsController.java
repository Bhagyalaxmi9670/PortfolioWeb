package com.portfolio.backend.controller;

import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.entity.UISettings;
import com.portfolio.backend.service.UISettingsService;

@RestController
@RequestMapping("/api/ui-settings")
@CrossOrigin(origins = "http://localhost:4200")
public class UISettingsController {

    private final UISettingsService service;

    public UISettingsController(UISettingsService service) {
        this.service = service;
    }

    // Client & Admin: get current UI settings
    @GetMapping
    public UISettings getSettings() {
        return service.getSettings();
    }

    // Admin: save/update UI settings
    @PostMapping
    public UISettings save(@RequestBody UISettings settings) {
        return service.saveSettings(settings);
    }
}
