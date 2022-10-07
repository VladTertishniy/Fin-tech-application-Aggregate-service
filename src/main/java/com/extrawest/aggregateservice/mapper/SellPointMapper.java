package com.extrawest.aggregateservice.mapper;

import com.extrawest.aggregateservice.model.SellPoint;
import com.extrawest.aggregateservice.model.dto.response.SellPointResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SellPointMapper {
    SellPointResponseDto toDto (SellPoint sellPoint);
    SellPoint toModel(SellPointResponseDto sellPointResponseDto);
}
