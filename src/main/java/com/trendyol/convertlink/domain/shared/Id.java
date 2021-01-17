package com.trendyol.convertlink.domain.shared;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class Id extends ValueObject {

    private String value;
    public static Id generate(){
        return new Id(UUID.randomUUID().toString());
    }
}
