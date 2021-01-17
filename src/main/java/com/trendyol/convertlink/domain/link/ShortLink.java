package com.trendyol.convertlink.domain.link;

import com.trendyol.convertlink.domain.shared.ValueObject;
import lombok.Getter;

@Getter
public class ShortLink extends ValueObject {

    private String code;

    public ShortLink(String code) {
        this.code = code;
    }
}
