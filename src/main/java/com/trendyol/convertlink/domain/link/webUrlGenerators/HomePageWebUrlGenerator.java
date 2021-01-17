package com.trendyol.convertlink.domain.link.webUrlGenerators;

import com.trendyol.convertlink.domain.link.BaseUrl;
import com.trendyol.convertlink.domain.link.DeepLink;
import com.trendyol.convertlink.domain.link.PageType;
import com.trendyol.convertlink.domain.shared.LinkGenerator;
import org.springframework.stereotype.Component;

@Component
public class HomePageWebUrlGenerator implements LinkGenerator<DeepLink, String> {
    @Override
    public String generate(DeepLink input) {
        return BaseUrl.BASE_URL;
    }

    @Override
    public boolean isMatch(PageType pageType) {
        return pageType == PageType.HOME;
    }
}
