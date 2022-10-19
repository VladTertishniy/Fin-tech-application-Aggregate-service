package com.extrawest.aggregateservice.mapper;

import com.extrawest.aggregateservice.model.Operator;
import com.extrawest.aggregateservice.model.dto.response.OperatorResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperatorMapper {
    OperatorResponseDto toDto (Operator operator);
    Operator toModel (OperatorResponseDto operatorResponseDto);
}
