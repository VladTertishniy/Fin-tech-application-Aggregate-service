package com.extrawest.aggregateservice.service.impl;

import com.extrawest.aggregateservice.exception.ApiRequestException;
import com.extrawest.aggregateservice.feignClient.OperatorFeignClient;
import com.extrawest.aggregateservice.feignClient.SellPointFeignClient;
import com.extrawest.aggregateservice.mapper.OperatorMapper;
import com.extrawest.aggregateservice.mapper.SellPointMapper;
import com.extrawest.aggregateservice.model.Operator;
import com.extrawest.aggregateservice.model.SellPoint;
import com.extrawest.aggregateservice.model.dto.response.OperatorResponseDto;
import com.extrawest.aggregateservice.model.dto.response.SellPointResponseDto;
import com.extrawest.aggregateservice.repository.OperatorRepository;
import com.extrawest.aggregateservice.repository.SellPointRepository;
import com.extrawest.aggregateservice.service.AggregateData;
import com.github.andrewoma.dexx.collection.ArrayList;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AggregateDataImpl implements AggregateData {
    @Autowired
    private final SellPointFeignClient sellPointFeignClient;
    private final OperatorFeignClient operatorFeignClient;
    private final OperatorRepository operatorRepository;
    private final SellPointRepository sellPointRepository;
    private final SellPointMapper sellPointMapper;
    private final OperatorMapper operatorMapper;

    @Override
    @PostConstruct
    public void aggregate() {
        List<SellPoint> sellPointsList = getAllSelPoints();
        List<Operator> operatorList = getAllOperators();
        for (SellPoint sellpoint:sellPointsList) {
            sellPointRepository.save(sellpoint);
        }
        for (Operator operator:operatorList) {
            operatorRepository.save(operator);
        }
    }

    private List<SellPoint> getAllSelPoints() {
        ResponseEntity<List<SellPointResponseDto>> sellPointResponse = sellPointFeignClient.getAll();
        if (sellPointResponse.getBody() != null) {
            return sellPointResponse.getBody().stream().map(sellPointMapper::toModel).toList();
        } else throw new ApiRequestException("Sell point response body is null");
    }

    private List<Operator> getAllOperators() {
        ResponseEntity<List<OperatorResponseDto>> operatorsResponse = operatorFeignClient.getAll();
        if (operatorsResponse.getBody() != null) {
            return operatorsResponse.getBody().stream().map(operatorMapper::toModel).toList();
        } else throw new ApiRequestException("Operator response body is null");
    }
}
