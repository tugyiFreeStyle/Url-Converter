package com.trendyol.convertlink.domain.link;

import com.trendyol.convertlink.infrastructure.model.LinkRecord;

public interface LinkAdaptor {

    boolean isExist(WebUrl webUrl);

    boolean isExist(DeepLink deepLink);

    int getSectionId(String sectionName);

    LinkRecord getLinksAccordingTo(ShortLink shortLink);

    String getDeepLinkTemplate(PageType pageType);

    String getWebUrlTemplate(PageType pageType);

    String getSectionName(int sectionId);

    void createLinkRecord(ShortLink shortLink, DeepLink  deepLink, WebUrl webUrl);
}
