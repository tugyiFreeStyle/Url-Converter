package com.trendyol.convertlink.domain.shared;

import lombok.Getter;

@Getter
public abstract class AggregateRoot<T> extends Entity<T>{

    public AggregateRoot(T id) {
        super(id);
    }

}
