package com.extrawest.aggregateservice.feignClient;

import com.extrawest.aggregateservice.model.dto.response.OperatorResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "persona-application")
public interface OperatorFeignClient {
    @GetMapping("/operators/getById/{id}")
    ResponseEntity<OperatorResponseDto> getOperator(@PathVariable Long id);
    @GetMapping("/operators/getAll")
    ResponseEntity<Page<OperatorResponseDto>> getAll(@PageableDefault Pageable pageable);
}
