package com.example.labsample.service;

import com.example.labsample.domain.Sample;
import com.example.labsample.repository.SampleRepository;
import com.example.labsample.web.dto.SampleRequest;
import com.example.labsample.web.dto.SampleResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SampleService {
    private final SampleRepository sampleRepository;

    public SampleService(SampleRepository sampleRepository){
        this.sampleRepository = sampleRepository;
    }

    @Transactional
    public SampleResponse create(SampleRequest request){
        Sample sample = new Sample(request.productId().trim(), request.batchId().trim(), request.receivedBy().trim());
        Sample saved = sampleRepository.save(sample);
        return SampleResponse.from(saved);
    }

    @Transactional(readOnly = true)
    public SampleResponse getById(Long id){
        Sample sample = sampleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Sample not found: " + id)
        );
        return SampleResponse.from(sample);
    }
}
