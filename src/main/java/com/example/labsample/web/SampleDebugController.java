package com.example.labsample.web;

import com.example.labsample.domain.Sample;
import com.example.labsample.repository.SampleRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/debug/samples")
public class SampleDebugController {
    private final SampleRepository sampleRepository;

    public SampleDebugController(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @PostMapping
    public Sample create(){
        return sampleRepository.save(new Sample("PROD-001", "LOT-001", "sg"));
    }

    @GetMapping("/{id}")
    public Sample get(@PathVariable Long id){
        return sampleRepository.findById(id).orElseThrow();
    }
}
