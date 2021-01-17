package com.trendyol.convertlink.application.dtos;

import com.trendyol.convertlink.infrastructure.model.LinkRecord;
import lombok.Value;

@Value
public class ServeShortLinkResponseDto {

    private String deeplink;
    private String webURL;


    public static ServeShortLinkResponseDto convertFrom(LinkRecord link) {
        return new ServeShortLinkResponseDto(link.getDeeplink(), link.getWebURL());
    }
}
