package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.backend.entity.UISettings;

public interface UISettingsRepository extends JpaRepository<UISettings, Long> {
}
