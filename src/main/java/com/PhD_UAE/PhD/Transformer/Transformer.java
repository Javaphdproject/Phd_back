package com.PhD_UAE.PhD.Transformer;

import org.springframework.stereotype.Component;

@Component

public abstract class Transformer<E, D> {
    public abstract E toEntity(D dto);
    public abstract D toDTO(E entity);
}
