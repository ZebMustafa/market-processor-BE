package com.marketing.processor.service.Impl;

import com.marketing.processor.domain.entity.MarketingData;
import com.marketing.processor.domain.entity.User;
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
    public List<MarketingData> findAll() {
        return marketingDataRepository.findAll();
    }

    @Override
    public boolean save(MarketingData marketingData) {
        if (marketingData.getUserId() == null) {
            return false;
        }
        Optional<User> userOptional = userService.findById(marketingData.getUserId());

        if (userOptional.isEmpty()) {
            userService.createNewUser(marketingData.getUserId());
        }

        marketingDataRepository.save(marketingData);
        return true;
    }
}
