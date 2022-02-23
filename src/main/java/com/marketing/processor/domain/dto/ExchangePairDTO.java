package com.marketing.processor.domain.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ExchangePairDTO implements Serializable {
    private String currenyPair;
    private List<ExchangeRateDTO> exchangeRateList;

    public String getCurrenyPair() {
        return currenyPair;
    }

    public void setCurrenyPair(String currenyPair) {
        this.currenyPair = currenyPair;
    }

    public List<ExchangeRateDTO> getExchangeRateList() {
        return exchangeRateList;
    }

    public void setExchangeRateList(List<ExchangeRateDTO> exchangeRateList) {
        this.exchangeRateList = exchangeRateList;
    }

    @Override
    public String toString() {
        return "ExchangePairDTO{" +
                "currenyPair='" + currenyPair + '\'' +
                ", exchangeRateList=" + exchangeRateList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangePairDTO that = (ExchangePairDTO) o;
        return Objects.equals(currenyPair, that.currenyPair) && Objects.equals(exchangeRateList, that.exchangeRateList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currenyPair, exchangeRateList);
    }
}
