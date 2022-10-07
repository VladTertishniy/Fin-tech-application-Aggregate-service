package com.extrawest.aggregateservice.feignClient;

import com.extrawest.aggregateservice.model.dto.response.SellPointResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sell-point-application")
public interface SellPointFeignClient {
    @GetMapping("/sellPoints/getById/{id}")
    ResponseEntity<SellPointResponseDto> getSellPoint(@PathVariable Long id);
    @GetMapping("/sellPoints/getAll")
    ResponseEntity<Page<SellPointResponseDto>> getAll(@PageableDefault Pageable pageable);
}
