package com.trendyol.convertlink.infrastructure.repositories;

import com.trendyol.convertlink.infrastructure.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, String> {
    int findBySectionName(String sectionName);

    String findBySectionId(int sectionId);
}
