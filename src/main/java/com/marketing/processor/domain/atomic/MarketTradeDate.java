package com.marketing.processor.domain.atomic;

import com.marketing.processor.util.DateUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MarketTradeDate implements Serializable {
    public static final String MARKET_TRADE_DATE_FORMAT = "dd-MMM-yy HH:mm:ss";
    protected String value = "";

    protected MarketTradeDate() {
    }

    public MarketTradeDate(String value) {
        if (value != null)
            this.value = value;
    }

    public MarketTradeDate(Date date) {
        if (date != null) {
            this.value = new SimpleDateFormat(MARKET_TRADE_DATE_FORMAT)
                    .format(date);
        }
    }

    public boolean areDateValueAndFormatValid() {
        return DateUtils.areDateValueAndFormatValid(value, MARKET_TRADE_DATE_FORMAT);
    }

    public boolean areDateValueAndFormatInValid() {
        return !areDateValueAndFormatValid();
    }

    public String getValue() {
        return value;
    }

    public Date getAsDate(){
        if (!value.isEmpty()) {
            return DateUtils.convertStringToDateWithPattern(value, MARKET_TRADE_DATE_FORMAT);
        }
        return null;
    }

    @Override
    public String toString() {
        return "MarketTradeDate{" +
                "value='" + value + '\'' +
                '}';
    }
}
