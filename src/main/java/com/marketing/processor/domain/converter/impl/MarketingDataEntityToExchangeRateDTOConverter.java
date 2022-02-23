package com.marketing.processor.domain.converter.impl;

import com.marketing.processor.domain.converter.EntityToDTOConverter;
import com.marketing.processor.domain.dto.ExchangeRateDTO;
import com.marketing.processor.domain.entity.MarketingDataEntity;
import com.marketing.processor.util.DateUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MarketingDataEntityToExchangeRateDTOConverter implements EntityToDTOConverter<MarketingDataEntity, ExchangeRateDTO> {
    @Override
    public ExchangeRateDTO convertToDTO(MarketingDataEntity sourceMarketingDataEntity) {
        final ExchangeRateDTO destinationExchangeRateDTO = new ExchangeRateDTO();

        destinationExchangeRateDTO.setRate(sourceMarketingDataEntity.getRate());
        destinationExchangeRateDTO.setTimePlaced(
                DateUtils.convertDateToStringWithPattern(sourceMarketingDataEntity
                                .getTimePlaced(),
                        "MM-dd-yyyy"));

        return destinationExchangeRateDTO;
    }

    @Override
    public List<ExchangeRateDTO> convertToListDTOs(List<MarketingDataEntity> sourceMarketingDataEntities) {
        return sourceMarketingDataEntities
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
