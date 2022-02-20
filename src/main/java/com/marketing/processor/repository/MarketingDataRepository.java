package com.marketing.processor.repository;

import com.marketing.processor.domain.entity.MarketingData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketingDataRepository extends JpaRepository<MarketingData, Long> {
}
