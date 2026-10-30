package com.example.labsample.repository;

import com.example.labsample.domain.OOSCondition;
import com.example.labsample.domain.OOSRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OOSRecordRepository extends JpaRepository<OOSRecord, Long> {
    List<OOSRecord> findByStatus(OOSCondition status);
}
