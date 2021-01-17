package com.trendyol.convertlink.domain.link.deepLinkGenerators;

import com.trendyol.convertlink.domain.link.BaseUrl;
import com.trendyol.convertlink.domain.link.LinkAdaptor;
import com.trendyol.convertlink.domain.link.PageType;
import com.trendyol.convertlink.domain.link.WebUrl;
import com.trendyol.convertlink.domain.shared.LinkGenerator;
import org.springframework.stereotype.Component;

@Component
public class SectionPageDeepLinkGenerator implements LinkGenerator<WebUrl, String> {
    private final LinkAdaptor linkAdaptor;

    public SectionPageDeepLinkGenerator(LinkAdaptor linkAdaptor) {
        this.linkAdaptor = linkAdaptor;
    }

    @Override
    public String generate(WebUrl input) {
        String[] urlAry = input.getValue().split("/");

        String section = urlAry[urlAry.length - 1];

        Integer sectionId = linkAdaptor.getSectionId(section);

        String existingTemplate = linkAdaptor.getDeepLinkTemplate(PageType.SECTION);

        return BaseUrl.BASE_DEEP_LINK + "Home" + existingTemplate.replace("{SectionId}", sectionId.toString());
    }

    @Override
    public boolean isMatch(PageType pageType) {
        return pageType == PageType.SECTION;
    }
}
