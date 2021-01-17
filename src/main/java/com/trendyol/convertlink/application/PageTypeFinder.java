package com.trendyol.convertlink.application;

import com.trendyol.convertlink.domain.link.DeepLink;
import com.trendyol.convertlink.domain.link.PageType;
import com.trendyol.convertlink.domain.link.WebUrl;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PageTypeFinder {

    public PageType find(DeepLink data) {
        return PageTypeRegex.getDeepLinkPageType()
                .entrySet()
                .stream()
                .filter(p -> p.getKey().matcher(data.getValue()).find())
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(PageType.OTHERS);
    }

    public PageType find(WebUrl data) {
        return PageTypeRegex.getWebUrlPageType()
                .entrySet()
                .stream()
                .filter(p -> p.getKey().matcher(data.getValue()).find())
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(PageType.OTHERS);
    }
}
