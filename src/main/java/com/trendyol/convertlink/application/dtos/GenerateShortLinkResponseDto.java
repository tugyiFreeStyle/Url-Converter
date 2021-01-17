package com.trendyol.convertlink.application.dtos;

import com.trendyol.convertlink.domain.link.ShortLink;
import lombok.Value;

@Value
public class GenerateShortLinkResponseDto {

    private String shortlink;

    public static GenerateShortLinkResponseDto convertFrom(ShortLink shortlink) {
        return new GenerateShortLinkResponseDto(shortlink.getCode());
    }
}
