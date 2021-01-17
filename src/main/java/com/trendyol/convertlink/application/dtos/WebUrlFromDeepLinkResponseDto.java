package com.trendyol.convertlink.application.dtos;

import com.trendyol.convertlink.domain.link.WebUrl;
import lombok.Value;

@Value
public class WebUrlFromDeepLinkResponseDto {

    private String webURL;

    public static WebUrlFromDeepLinkResponseDto convertFrom(WebUrl webURL) {
        return new WebUrlFromDeepLinkResponseDto(webURL.getValue());
    }
}
