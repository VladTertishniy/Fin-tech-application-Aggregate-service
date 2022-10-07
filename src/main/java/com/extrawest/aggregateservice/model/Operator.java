package com.extrawest.aggregateservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RedisHash("operators")
public class Operator extends Persona {
    @Id
    private long id;
    private String sellPointIdentifier;
    private String taxpayerNumber;
}
