package com.extrawest.aggregateservice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperatorResponseDto {
    private long id;
    private String name;
    private LocalDateTime dateOfBirth;
    private String sellPointIdentifier;
    private String taxpayerNumber;
}
