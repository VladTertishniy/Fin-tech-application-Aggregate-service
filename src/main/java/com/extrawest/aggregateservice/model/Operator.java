package com.extrawest.aggregateservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RedisHash("operators")
public class Operator extends Persona implements Serializable {
    private Long sellPointIdentifier;
    private String taxpayerNumber;
}
