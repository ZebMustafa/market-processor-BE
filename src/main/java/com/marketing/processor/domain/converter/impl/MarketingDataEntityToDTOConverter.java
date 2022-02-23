package com.marketing.processor.domain.converter.impl;

import com.marketing.processor.domain.atomic.MarketTradeDate;
import com.marketing.processor.domain.converter.EntityToDTOConverter;
import com.marketing.processor.domain.dto.MarketingDataDTO;
import com.marketing.processor.domain.entity.MarketingDataEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MarketingDataEntityToDTOConverter implements EntityToDTOConverter<MarketingDataEntity, MarketingDataDTO> {

    @Override
    public MarketingDataDTO convertToDTO(MarketingDataEntity sourceMarketingDataEntity) {
        final MarketingDataDTO destinationMarketingDataDTO = new MarketingDataDTO();

        destinationMarketingDataDTO.setId(sourceMarketingDataEntity.getId());
        destinationMarketingDataDTO.setCurrencyFrom(sourceMarketingDataEntity.getCurrencyFrom());
        destinationMarketingDataDTO.setCurrencyTo(sourceMarketingDataEntity.getCurrencyTo());
        destinationMarketingDataDTO.setAmountSell(sourceMarketingDataEntity.getAmountSell());
        destinationMarketingDataDTO.setAmountBuy(sourceMarketingDataEntity.getAmountBuy());
        destinationMarketingDataDTO.setTimePlaced(
                new MarketTradeDate(sourceMarketingDataEntity
                        .getTimePlaced())
                        .getValue());
        destinationMarketingDataDTO.setRate(sourceMarketingDataEntity.getRate());
        destinationMarketingDataDTO.setOriginatingCountry(sourceMarketingDataEntity.getOriginatingCountry());
        destinationMarketingDataDTO.setUserId(sourceMarketingDataEntity.getUserId());

        return destinationMarketingDataDTO;
    }

    @Override
    public List<MarketingDataDTO> convertToListDTOs(List<MarketingDataEntity> sourceMarketingDataEntities) {
        return sourceMarketingDataEntities
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
