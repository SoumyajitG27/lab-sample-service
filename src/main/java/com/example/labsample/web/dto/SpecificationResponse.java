package com.example.labsample.web.dto;

import com.example.labsample.domain.Specification;

import java.math.BigDecimal;

public record SpecificationResponse (
        String specId,
        long specVersionId,
        String productCode,
        String testName,
        BigDecimal lowerLimit,
        BigDecimal upperLimit,
        String unit
){
    public static SpecificationResponse from (Specification specification){
        return new SpecificationResponse(
                specification.getSpecId(),
                specification.getSpecVersionId(),
                specification.getProductCode(),
                specification.getTestName(),
                specification.getLowerLimit(),
                specification.getUpperLimit(),
                specification.getUnit()
        );
    }
}
