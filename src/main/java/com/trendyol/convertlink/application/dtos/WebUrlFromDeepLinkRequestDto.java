package com.trendyol.convertlink.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebUrlFromDeepLinkRequestDto {

    private String deeplink;
}
