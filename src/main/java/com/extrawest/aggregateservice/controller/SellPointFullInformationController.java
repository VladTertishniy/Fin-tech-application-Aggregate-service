package com.extrawest.aggregateservice.controller;

import com.extrawest.aggregateservice.model.dto.response.SellPointFullInformationResponseDto;
import com.extrawest.aggregateservice.service.SellPointFullInformationService;
import com.extrawest.aggregateservice.util.PathUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PathUtil.SELL_POINT_FULL_INFO_PATH)
@AllArgsConstructor
public class SellPointFullInformationController {
    private final SellPointFullInformationService sellPointFullInformationService;

    @GetMapping()
    public ResponseEntity<SellPointFullInformationResponseDto> getFullInfo() {
        return ResponseEntity.ok(sellPointFullInformationService.getFullInformation());
    }
}
