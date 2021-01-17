package com.trendyol.convertlink.domain.link.deepLinkGenerators;

import com.trendyol.convertlink.domain.link.BaseUrl;
import com.trendyol.convertlink.domain.link.LinkAdaptor;
import com.trendyol.convertlink.domain.link.PageType;
import com.trendyol.convertlink.domain.link.WebUrl;
import com.trendyol.convertlink.domain.shared.LinkGenerator;
import org.springframework.stereotype.Component;

@Component
public class SearchPageDeepLinkGenerator implements LinkGenerator<WebUrl, String> {
    private final LinkAdaptor linkAdaptor;

    public SearchPageDeepLinkGenerator(LinkAdaptor linkAdaptor) {
        this.linkAdaptor = linkAdaptor;
    }

    @Override
    public String generate(WebUrl input) {
        int queryStartIndex = input.getValue().indexOf("q=");
        String queryValue = input.getValue().substring(queryStartIndex + 2);

        String existingTemplate = linkAdaptor.getDeepLinkTemplate(PageType.SEARCH);

        return BaseUrl.BASE_DEEP_LINK + "Search" + existingTemplate.replace("{QueryValue}", queryValue);
    }

    @Override
    public boolean isMatch(PageType pageType) {
        return pageType == PageType.SEARCH;
    }
}
