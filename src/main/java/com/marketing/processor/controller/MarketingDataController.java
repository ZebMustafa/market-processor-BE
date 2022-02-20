package com.marketing.processor.controller;

import com.marketing.processor.domain.entity.MarketingData;
import com.marketing.processor.service.MarketingDataService;
import com.marketing.processor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MarketingDataController {
    @Autowired
    MarketingDataService marketingDataService;

    @Autowired
    UserService userService;

    @GetMapping("/data")
    public ResponseEntity<List<MarketingData>> getAllData() {
        try {
            List<MarketingData> data = new ArrayList<>(marketingDataService.findAll());
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<Void> createMessage(
            @RequestBody MarketingData marketingData) {
        boolean result = marketingDataService.save(marketingData);
        if (result) {
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .build();
    }
}
