package com.trendyol.convertlink.domain.link.deepLinkGenerators;

import com.trendyol.convertlink.domain.link.BaseUrl;
import com.trendyol.convertlink.domain.link.PageType;
import com.trendyol.convertlink.domain.link.WebUrl;
import com.trendyol.convertlink.domain.shared.LinkGenerator;
import org.springframework.stereotype.Component;

@Component
public class HomePageDeepLinkGenerator implements LinkGenerator<WebUrl, String> {
    @Override
    public String generate(WebUrl input) {
        return BaseUrl.BASE_DEEP_LINK + "Home";
    }

    @Override
    public boolean isMatch(PageType pageType) {
        return pageType == PageType.HOME;
    }
}
