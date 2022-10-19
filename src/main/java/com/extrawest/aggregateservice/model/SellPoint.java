package com.extrawest.aggregateservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RedisHash("sellPoints")
public class SellPoint implements Serializable {
    @Id
    private long id;
    private String address;
    private String name;
    private float mark;
    private boolean offlineShop;
}
