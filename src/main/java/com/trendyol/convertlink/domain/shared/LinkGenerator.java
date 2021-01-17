package com.trendyol.convertlink.domain.shared;

import com.trendyol.convertlink.domain.link.PageType;

public interface LinkGenerator<T, R> {
    R generate(T input);
    boolean isMatch(PageType pageType);
}
