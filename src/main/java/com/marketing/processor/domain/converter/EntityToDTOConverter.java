package com.marketing.processor.domain.converter;

import java.util.List;

public interface EntityToDTOConverter<T, U> {
    U convertToDTO(T sourceObject);
    List<U> convertToListDTOs(List<T> list);
}
