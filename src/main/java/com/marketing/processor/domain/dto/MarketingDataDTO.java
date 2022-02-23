package com.marketing.processor.domain.dto;

import java.io.Serializable;
import java.util.Objects;

public class MarketingDataDTO implements Serializable {
    private Long id;
    private String currencyFrom;
    private String currencyTo;
    private Double amountSell;
    private Double amountBuy;
    private Double rate;
    private String timePlaced;
    private String originatingCountry;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public Double getAmountSell() {
        return amountSell;
    }

    public void setAmountSell(Double amountSell) {
        this.amountSell = amountSell;
    }

    public Double getAmountBuy() {
        return amountBuy;
    }

    public void setAmountBuy(Double amountBuy) {
        this.amountBuy = amountBuy;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(String timePlaced) {
        this.timePlaced = timePlaced;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public void setOriginatingCountry(String originatingCountry) {
        this.originatingCountry = originatingCountry;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketingDataDTO that = (MarketingDataDTO) o;
        return Objects.equals(id, that.id)
                && Objects.equals(currencyFrom, that.currencyFrom)
                && Objects.equals(currencyTo, that.currencyTo)
                && Objects.equals(amountSell, that.amountSell)
                && Objects.equals(amountBuy, that.amountBuy)
                && Objects.equals(rate, that.rate)
                && Objects.equals(timePlaced, that.timePlaced)
                && Objects.equals(originatingCountry, that.originatingCountry)
                && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                currencyFrom,
                currencyTo,
                amountSell,
                amountBuy,
                rate,
                timePlaced,
                originatingCountry,
                userId);
    }
}
