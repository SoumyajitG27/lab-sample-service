package com.example.labsample.web.dto;

import com.example.labsample.domain.Sample;
import com.example.labsample.domain.Specification;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TestResultRequest (
        @NotNull long id,
        @NotNull Sample sample,
        @NotNull Specification specification,
        @NotBlank String testName,
        @NotNull BigDecimal measuredValue
){
}
