package com.trendyol.convertlink.infrastructure.repositories;

import com.trendyol.convertlink.infrastructure.model.LinkRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRecordRepository extends JpaRepository<LinkRecord, String> {

    LinkRecord findByWebURL(String werbURL);

    LinkRecord findByDeeplink(String deepLink);

    LinkRecord findByShortLink(String webURL);
}
