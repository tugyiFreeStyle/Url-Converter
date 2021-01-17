package com.trendyol.convertlink.domain.link;

import com.trendyol.convertlink.domain.shared.ValueObject;
import lombok.Getter;

@Getter
public class DeepLink extends ValueObject {

    private String value;

    public DeepLink(String value) {
        this.value = value;
    }

}
