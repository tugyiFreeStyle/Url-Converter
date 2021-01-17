package com.trendyol.convertlink.domain.link;

import com.trendyol.convertlink.domain.shared.ValueObject;
import lombok.Getter;


@Getter
public class WebUrl extends ValueObject {

    private String value;

    public WebUrl(String value) {
        this.value = value;
    }
}
