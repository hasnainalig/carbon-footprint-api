package com.example.carbonfootprint.repository;

import com.example.carbonfootprint.model.FootprintLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootprintLogRepository extends JpaRepository<FootprintLog, Long> {
}
