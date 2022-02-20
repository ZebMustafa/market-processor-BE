package com.marketing.processor.controller;

import com.marketing.processor.domain.entity.MarketingData;
import com.marketing.processor.service.MarketingDataService;
import com.marketing.processor.service.UserService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MarketingDataController {
    @Autowired
    MarketingDataService marketingDataService;

    @Autowired
    UserService userService;

    private final Bucket bucket;

    public MarketingDataController() {
        Bandwidth limit = Bandwidth.classic(15, Refill.greedy(15, Duration.ofMinutes(1)));
        this.bucket = Bucket4j.builder()
                .addLimit(limit)
                .build();
    }

    @GetMapping("/message-list")
    public ResponseEntity<List<MarketingData>> getAllData() {
        try {
            List<MarketingData> data = new ArrayList<>(marketingDataService.findAll());
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/send-message")
    public ResponseEntity<Void> createMessage(
            @RequestBody MarketingData marketingData) {
        if (bucket.tryConsume(1)) {
            boolean result = marketingDataService.save(marketingData);
            if (!result) {
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .build();
            }
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .build();
        }
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
    }
}
