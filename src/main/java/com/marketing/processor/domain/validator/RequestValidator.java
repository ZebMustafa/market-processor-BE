package com.marketing.processor.domain.validator;

import javax.xml.bind.ValidationException;

public interface RequestValidator<T> {
    void validate(T values) throws ValidationException;
}
