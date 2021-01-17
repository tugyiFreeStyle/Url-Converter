package com.trendyol.convertlink.infrastructure.adaptors;

import com.trendyol.convertlink.domain.link.*;
import com.trendyol.convertlink.infrastructure.model.LinkRecord;
import com.trendyol.convertlink.infrastructure.model.LinkTemplate;
import com.trendyol.convertlink.infrastructure.repositories.LinkRecordRepository;
import com.trendyol.convertlink.infrastructure.repositories.LinkTemplateRepository;
import com.trendyol.convertlink.infrastructure.repositories.LogEntryRepository;
import com.trendyol.convertlink.infrastructure.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class HibernateAdaptor implements LinkAdaptor {

    private final LinkRecordRepository linkRecordRepository;
    private final LinkTemplateRepository linkTemplateRepository;
    private final LogEntryRepository logEntryRepository;
    private final SectionRepository sectionRepository;

    @Autowired
    public HibernateAdaptor(LinkRecordRepository linkRecordRepository, LinkTemplateRepository linkTemplateRepository, LogEntryRepository logEntryRepository, SectionRepository sectionRepository) {
        this.linkRecordRepository = linkRecordRepository;
        this.linkTemplateRepository = linkTemplateRepository;
        this.logEntryRepository = logEntryRepository;
        this.sectionRepository = sectionRepository;
    }

    @Override
    public boolean isExist(WebUrl webUrl) {

        LinkRecord result = linkRecordRepository.findByWebURL(webUrl.toString());
        return result.getShortLink() != null;
    }

    @Override
    public boolean isExist(DeepLink deepLink) {
        LinkRecord result = linkRecordRepository.findByDeeplink(deepLink.toString());
        return result.getShortLink() != null;
    }

    @Override
    public String getDeepLinkTemplate(PageType pageType) {
        LinkTemplate linkTemplate = linkTemplateRepository.findByPageType(pageType);
        return linkTemplate.getDeepLinkFormat();
    }

    @Override
    public String getWebUrlTemplate(PageType pageType) {
        LinkTemplate linkTemplate = linkTemplateRepository.findByPageType(pageType);
        return linkTemplate.getWebUrlFormat();
    }

    @Override
    public int getSectionId(String sectionName) {
        return sectionRepository.findBySectionName(sectionName);
    }

    @Override
    public String getSectionName(int sectionId) {

        return sectionRepository.findBySectionId(sectionId);
    }

    @Override
    public LinkRecord getLinksAccordingTo(ShortLink shortLink) {
        return linkRecordRepository.findByShortLink(shortLink.toString());
    }

    @Override
    @Transactional
    public void createLinkRecord(ShortLink shortLink, DeepLink deepLink, WebUrl webUrl) {

        LinkRecord linkRecord = new LinkRecord();
        linkRecord.setDeeplink(deepLink.getValue());
        linkRecord.setWebURL(webUrl.getValue());
        linkRecord.setShortLink(shortLink.getCode());

        linkRecordRepository.save(linkRecord);
    }
}
