package com.marketing.processor.repository;

import com.marketing.processor.domain.entity.MarketingDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarketingDataRepository extends JpaRepository<MarketingDataEntity, Long> {
    List<MarketingDataEntity> findAllByCurrencyFromAndCurrencyTo(String currencyFrom, String CurrencyTo);
}
