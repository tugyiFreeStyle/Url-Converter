package com.trendyol.convertlink.domain.link.webUrlGenerators;

import com.trendyol.convertlink.domain.link.BaseUrl;
import com.trendyol.convertlink.domain.link.DeepLink;
import com.trendyol.convertlink.domain.link.LinkAdaptor;
import com.trendyol.convertlink.domain.link.PageType;
import com.trendyol.convertlink.domain.shared.LinkGenerator;
import org.springframework.stereotype.Component;

@Component
public class SectionPageWebUrlGenerator implements LinkGenerator<DeepLink, String> {
    private final LinkAdaptor linkAdaptor;

    public SectionPageWebUrlGenerator(LinkAdaptor linkAdaptor) {
        this.linkAdaptor = linkAdaptor;
    }

    @Override
    public String generate(DeepLink input) {
        int startIndex = input.getValue().indexOf("SectionId=") + 10;

        int sectionId = Integer.parseInt(input.getValue().substring(startIndex));

        String existingTemplate = linkAdaptor.getWebUrlTemplate(PageType.SECTION);

        String sectionName = linkAdaptor.getSectionName(sectionId);

        return BaseUrl.BASE_URL + existingTemplate.replace("{SectionName}", sectionName);
    }

    @Override
    public boolean isMatch(PageType pageType) {
        return pageType == PageType.SECTION;
    }
}
