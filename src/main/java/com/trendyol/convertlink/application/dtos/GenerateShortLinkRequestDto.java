package com.trendyol.convertlink.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateShortLinkRequestDto {

    private String deeplink;
    private String webURL;

}
