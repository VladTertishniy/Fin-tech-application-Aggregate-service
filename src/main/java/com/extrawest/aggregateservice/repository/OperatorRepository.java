package com.extrawest.aggregateservice.repository;

import com.extrawest.aggregateservice.model.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OperatorRepository {
    public static final String HASH_KEY = "operators";
    @Autowired
    private RedisTemplate<String, Object> template;

    public Operator save(Operator operator){
        template.opsForHash().put(HASH_KEY, operator.getId(), operator);
        return operator;
    }

    public List<Object> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Operator findOperatorById(long id){
        return (Operator) template.opsForHash().get(HASH_KEY, id);
    }


    public String deleteOperator(long id){
        template.opsForHash().delete(HASH_KEY,id);
        return "operator removed";
    }
}
