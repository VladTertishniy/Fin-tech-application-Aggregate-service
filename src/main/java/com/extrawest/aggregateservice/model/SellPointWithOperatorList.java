package com.extrawest.aggregateservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SellPointWithOperatorList {
    private SellPoint sellPoint;
    private List<Operator> operatorList;
}
