package com.example.labsample.web;

import com.example.labsample.service.SampleService;
import com.example.labsample.web.dto.SampleRequest;
import com.example.labsample.web.dto.SampleResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/samples")
public class SampleController {
    private final SampleService sampleService;

    public SampleController(SampleService sampleService){
        this.sampleService = sampleService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SampleResponse create(@Valid @RequestBody SampleRequest request){
        return sampleService.create(request);
    }

    @GetMapping("/{id}")
    public SampleResponse getById(@PathVariable Long id){
        return sampleService.getById(id);
    }
}
