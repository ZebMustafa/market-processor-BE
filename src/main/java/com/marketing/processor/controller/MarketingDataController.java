package com.marketing.processor.controller;

import com.marketing.processor.domain.converter.DTOToEntityConverter;
import com.marketing.processor.domain.converter.EntityToDTOConverter;
import com.marketing.processor.domain.dto.ExchangePairDTO;
import com.marketing.processor.domain.dto.ExchangeRateDTO;
import com.marketing.processor.domain.dto.MarketingDataDTO;
import com.marketing.processor.domain.entity.MarketingDataEntity;
import com.marketing.processor.domain.validator.Impl.DateValidatorImpl;
import com.marketing.processor.service.MarketingDataService;
import com.marketing.processor.service.UserService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.time.Duration;
import java.util.List;

@RestController
public class MarketingDataController {
    @Autowired
    MarketingDataService marketingDataService;

    @Autowired
    UserService userService;

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private DTOToEntityConverter<MarketingDataDTO, MarketingDataEntity> dtoToEntityConverter;

    @Autowired
    private EntityToDTOConverter<MarketingDataEntity, MarketingDataDTO> entityToDTOConverter;

    @Autowired
    private EntityToDTOConverter<MarketingDataEntity, ExchangeRateDTO> entityMarketDataToExchangeRateDTOConverter;

    @Autowired
    private DateValidatorImpl dateValidator;

    private final Bucket bucket;

    public MarketingDataController() {
        Bandwidth limit = Bandwidth
                .classic(15, Refill.greedy(15, Duration.ofMinutes(1)));
        this.bucket = Bucket4j.builder()
                .addLimit(limit)
                .build();
    }

    @GetMapping("/message-list")
    public ResponseEntity<List<MarketingDataDTO>> getAllData() {
        try {
            List<MarketingDataDTO> marketingDataDTOList = entityToDTOConverter
                    .convertToListDTOs(marketingDataService.findAll());
            return new ResponseEntity<>(marketingDataDTOList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/send-message")
    public ResponseEntity<Void> createMessage(
            @RequestBody MarketingDataDTO marketingDataDTO) throws ValidationException {
        if (bucket.tryConsume(1)) {

            dateValidator.validate(marketingDataDTO.getTimePlaced());

            MarketingDataEntity result = marketingDataService
                    .save(dtoToEntityConverter.convertToEntity(marketingDataDTO));
            if (result == null) {
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .build();
            }
            this.template.convertAndSend(
                    "/topic/messages",
                    result);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.TOO_MANY_REQUESTS)
                .build();
    }

    @GetMapping("/message-exhange-pair")
    public ResponseEntity<ExchangePairDTO> getAllDataExchangePairList(
            @RequestParam String currencyFrom,
            @RequestParam String currencyTo
    ) {
        try {
            if (currencyFrom == null || currencyTo == null) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .build();
            }
            final ExchangePairDTO destinationExchangePairDTO = new ExchangePairDTO();
            destinationExchangePairDTO.setCurrenyPair(currencyFrom + " to " + currencyTo);
            destinationExchangePairDTO.setExchangeRateList(
                    entityMarketDataToExchangeRateDTOConverter.convertToListDTOs(
                            marketingDataService.findAllByCurrencyFromAndCurrencyTo(currencyFrom, currencyTo))
            );
            return new ResponseEntity<>(destinationExchangePairDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}