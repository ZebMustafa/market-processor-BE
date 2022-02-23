package com.marketing.processor.domain.converter;

public interface DTOToEntityConverter<T, U> {
    U convertToEntity(T sourceObject);
}
