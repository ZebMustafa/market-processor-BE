package com.marketing.processor.domain.converter.impl;

import com.marketing.processor.domain.atomic.MarketTradeDate;
import com.marketing.processor.domain.converter.DTOToEntityConverter;
import com.marketing.processor.domain.dto.MarketingDataDTO;
import com.marketing.processor.domain.entity.MarketingDataEntity;
import org.springframework.stereotype.Component;

@Component
public class MarketingDataDTOToEntityConverter implements DTOToEntityConverter<MarketingDataDTO, MarketingDataEntity> {
    @Override
    public MarketingDataEntity convertToEntity(MarketingDataDTO sourceObject) {
        final MarketingDataEntity destinationMarketingDataEntity = new MarketingDataEntity();

        destinationMarketingDataEntity.setCurrencyFrom(sourceObject.getCurrencyFrom());
        destinationMarketingDataEntity.setCurrencyTo(sourceObject.getCurrencyTo());
        destinationMarketingDataEntity.setAmountSell(sourceObject.getAmountSell());
        destinationMarketingDataEntity.setAmountBuy(sourceObject.getAmountBuy());
        destinationMarketingDataEntity.setRate(sourceObject.getRate());
        destinationMarketingDataEntity.setTimePlaced(new MarketTradeDate(sourceObject.getTimePlaced()).getAsDate());
        destinationMarketingDataEntity.setOriginatingCountry(sourceObject.getOriginatingCountry());
        destinationMarketingDataEntity.setUserId(sourceObject.getUserId());

        return destinationMarketingDataEntity;
    }
}
