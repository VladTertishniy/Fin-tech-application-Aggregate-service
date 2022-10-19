package com.extrawest.aggregateservice.service.impl;

import com.extrawest.aggregateservice.model.Operator;
import com.extrawest.aggregateservice.model.SellPoint;
import com.extrawest.aggregateservice.model.SellPointWithOperatorList;
import com.extrawest.aggregateservice.model.dto.response.SellPointFullInformationResponseDto;
import com.extrawest.aggregateservice.repository.OperatorRepository;
import com.extrawest.aggregateservice.repository.SellPointRepository;
import com.extrawest.aggregateservice.service.SellPointFullInformationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SellPointFullInformationServiceImpl implements SellPointFullInformationService {
    private final OperatorRepository operatorRepository;
    private final SellPointRepository sellPointRepository;

    @Override
    public SellPointFullInformationResponseDto getFullInformation() {
        SellPointFullInformationResponseDto responseDto = new SellPointFullInformationResponseDto();
        List<Object> operatorList = operatorRepository.findAll();
        List<Object> sellPointAsObjectList = sellPointRepository.findAll();
        for (Object sellPointAsObject:sellPointAsObjectList) {
            SellPointWithOperatorList sellPointWithOperatorList = new SellPointWithOperatorList();
            SellPoint sellPoint = (SellPoint)sellPointAsObject;
            sellPointWithOperatorList.setSellPoint(sellPoint);
            for (Object operatorAsObject:operatorList) {
                Operator operator = (Operator) operatorAsObject;
                if (operator.getSellPointIdentifier() == sellPoint.getId()) {
                    sellPointWithOperatorList.getOperatorList().add(operator);
                }
            }
            responseDto.getSellPointWithOperatorLists().add(sellPointWithOperatorList);
        }
        return responseDto;
    }
}
