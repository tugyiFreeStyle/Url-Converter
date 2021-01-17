package com.trendyol.convertlink.domain.link.webUrlGenerators;

import com.trendyol.convertlink.domain.link.BaseUrl;
import com.trendyol.convertlink.domain.link.DeepLink;
import com.trendyol.convertlink.domain.link.LinkAdaptor;
import com.trendyol.convertlink.domain.link.PageType;
import com.trendyol.convertlink.domain.shared.LinkGenerator;
import org.springframework.stereotype.Component;

@Component
public class SearchPageWebUrlGenerator implements LinkGenerator<DeepLink, String> {

    private final LinkAdaptor linkAdaptor;

    public SearchPageWebUrlGenerator(LinkAdaptor linkAdaptor) {
        this.linkAdaptor = linkAdaptor;
    }

    @Override
    public String generate(DeepLink input) {
        int queryStartIndex = input.getValue().indexOf("Query=");
        String queryValue = input.getValue().substring(queryStartIndex + 6);
        String existingTemplate = linkAdaptor.getWebUrlTemplate(PageType.SEARCH);
        return BaseUrl.BASE_URL + existingTemplate.replace("{QueryValue}", queryValue);
    }

    @Override
    public boolean isMatch(PageType pageType) {
        return pageType == PageType.SEARCH;
    }
}
