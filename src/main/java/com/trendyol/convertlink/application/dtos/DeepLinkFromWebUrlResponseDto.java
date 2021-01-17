package com.trendyol.convertlink.application.dtos;

import com.trendyol.convertlink.domain.link.DeepLink;
import lombok.Value;

@Value
public class DeepLinkFromWebUrlResponseDto {

    private String deeplink;

    public static DeepLinkFromWebUrlResponseDto convertFrom(DeepLink deeplink) {
        return new DeepLinkFromWebUrlResponseDto(deeplink.getValue());
    }
}