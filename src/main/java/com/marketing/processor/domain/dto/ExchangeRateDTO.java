package com.marketing.processor.domain.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ExchangeRateDTO implements Serializable {

    private Double rate;
    private String timePlaced;

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

    @Override
    public String toString() {
        return "ExchangeRateDTO{" +
                "rate=" + rate +
                ", timePlaced=" + timePlaced +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRateDTO that = (ExchangeRateDTO) o;
        return Objects.equals(rate, that.rate) && Objects.equals(timePlaced, that.timePlaced);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, timePlaced);
    }
}
