package com.extrawest.aggregateservice.model.dto.response;

import com.extrawest.aggregateservice.model.SellPointWithOperatorList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SellPointFullInformationResponseDto {
    private List<SellPointWithOperatorList> sellPointWithOperatorLists;
}
