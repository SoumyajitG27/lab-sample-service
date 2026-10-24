package com.example.labsample.repository;

import com.example.labsample.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpecificationRepository extends JpaRepository<Specification, Long> {
    List<Specification> findByProductCode(String productCode);

    Optional<Specification> findByProductCodeAndTestName(String productCode, String testName);
}
