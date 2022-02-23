package com.marketing.processor.domain.validator.Impl;

import com.marketing.processor.domain.atomic.MarketTradeDate;
import com.marketing.processor.domain.validator.RequestValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class DateValidatorImpl implements RequestValidator {
    @Override
    public void validate(Object value) throws ValidationException {
        if (new MarketTradeDate(value.toString()).areDateValueAndFormatInValid()) {
            throw new ValidationException(String
                    .format("Invalid date format. Expected format is [%s] ", MarketTradeDate.MARKET_TRADE_DATE_FORMAT));
        }
    }
}