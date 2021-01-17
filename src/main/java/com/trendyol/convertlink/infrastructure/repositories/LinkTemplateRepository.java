package com.trendyol.convertlink.infrastructure.repositories;

import com.trendyol.convertlink.domain.link.PageType;
import com.trendyol.convertlink.infrastructure.model.LinkTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkTemplateRepository extends JpaRepository<LinkTemplate, String> {
    LinkTemplate findByPageType(PageType pageType);
}
