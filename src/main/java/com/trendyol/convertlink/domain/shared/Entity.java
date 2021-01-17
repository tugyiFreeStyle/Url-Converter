package com.trendyol.convertlink.domain.shared;

import lombok.Getter;

@Getter
public abstract class Entity<T> {

    private T id;

    public Entity(T id) {
        this.id = id;
    }

}
