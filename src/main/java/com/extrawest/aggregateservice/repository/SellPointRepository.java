package com.extrawest.aggregateservice.repository;

import com.extrawest.aggregateservice.model.Operator;
import com.extrawest.aggregateservice.model.SellPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SellPointRepository {
    public static final String HASH_KEY = "sellPoints";
    @Autowired
    private RedisTemplate<String, Object> template;

    public SellPoint save(SellPoint sellPoint){
        template.opsForHash().put(HASH_KEY, sellPoint.getId(), sellPoint);
        return sellPoint;
    }

    public List<Object> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public SellPoint findSellPointById(long id){
        return (SellPoint) template.opsForHash().get(HASH_KEY, id);
    }


    public String deleteSellPoint(long id){
        template.opsForHash().delete(HASH_KEY,id);
        return "sell point removed";
    }
}
