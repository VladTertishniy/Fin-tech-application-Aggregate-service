package com.extrawest.aggregateservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public abstract class Persona {
    private long id;
    private String name;
    private LocalDateTime dateOfBirth;
}
