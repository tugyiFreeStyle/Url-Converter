package com.trendyol.convertlink.application;

import com.trendyol.convertlink.domain.link.PageType;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class PageTypeRegex {
    private PageTypeRegex() {
    }

    public static Map<Pattern, PageType> getDeepLinkPageType() {

        Map<Pattern, PageType> pageTypes = new HashMap();
        pageTypes.put(Pattern.compile(".*(Page=Home)$"), PageType.HOME);
        pageTypes.put(Pattern.compile(".Page=Home&SectionId=."), PageType.SECTION);
        pageTypes.put(Pattern.compile(".Page=Product."), PageType.PRODUCT);
        pageTypes.put(Pattern.compile(".Page=Search."), PageType.SEARCH);
        return pageTypes;
    }

    public static Map<Pattern, PageType> getWebUrlPageType() {

        Map<Pattern, PageType> pageTypes = new HashMap();

        pageTypes.put(Pattern.compile(".*(trendyol.com)$"), PageType.HOME);
        pageTypes.put(Pattern.compile(".butik/liste."), PageType.SECTION);
        pageTypes.put(Pattern.compile("(?<=-p-)"), PageType.PRODUCT);
        pageTypes.put(Pattern.compile("(?<=tum--urunler)"), PageType.SEARCH);
        return pageTypes;
    }
}
