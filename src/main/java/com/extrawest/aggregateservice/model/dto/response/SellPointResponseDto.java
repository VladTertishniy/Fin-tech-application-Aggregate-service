package com.extrawest.aggregateservice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SellPointResponseDto {
    private long id;
    private String address;
    private String name;
    private String mark;
    private boolean offlineShop;
}
