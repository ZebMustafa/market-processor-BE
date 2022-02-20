package com.marketing.processor.service;

import com.marketing.processor.domain.entity.MarketingData;

import java.net.http.HttpResponse;
import java.util.List;

public interface MarketingDataService {
    List<MarketingData> findAll();

    boolean save(MarketingData marketingData);
}
