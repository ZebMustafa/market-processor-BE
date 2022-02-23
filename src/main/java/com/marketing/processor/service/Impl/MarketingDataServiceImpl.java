package com.marketing.processor.service.Impl;

import com.marketing.processor.domain.entity.MarketingDataEntity;
import com.marketing.processor.domain.entity.UserEntity;
import com.marketing.processor.repository.MarketingDataRepository;
import com.marketing.processor.service.MarketingDataService;
import com.marketing.processor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarketingDataServiceImpl implements MarketingDataService {
    @Autowired
    MarketingDataRepository marketingDataRepository;

    @Autowired
    UserService userService;

    @Override
    public List<MarketingDataEntity> findAll() {
        return marketingDataRepository.findAll();
    }

    @Override
    public MarketingDataEntity save(MarketingDataEntity marketingDataEntity) {
        if (marketingDataEntity.getUserId() == null) {
            return null;
        }
        Optional<UserEntity> userOptional = userService.findById(marketingDataEntity.getUserId());

        if (userOptional.isEmpty()) {
            userService.createNewUser(marketingDataEntity.getUserId());
        }

        return marketingDataRepository.save(marketingDataEntity);
    }

    @Override
    public List<MarketingDataEntity> findAllByCurrencyFromAndCurrencyTo(String currFrom, String currTo) {
        return marketingDataRepository.findAllByCurrencyFromAndCurrencyTo(currFrom, currTo);
    }
}
