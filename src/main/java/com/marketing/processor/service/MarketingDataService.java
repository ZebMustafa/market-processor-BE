package com.marketing.processor.service;

import com.marketing.processor.domain.entity.MarketingDataEntity;

import java.util.List;

public interface MarketingDataService {
    List<MarketingDataEntity> findAll();

    MarketingDataEntity save(MarketingDataEntity marketingDataEntity);

    List<MarketingDataEntity> findAllByCurrencyFromAndCurrencyTo(String currFrom, String currTo);
}
