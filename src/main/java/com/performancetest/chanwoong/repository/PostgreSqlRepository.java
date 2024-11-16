package com.performancetest.chanwoong.repository;

import com.performancetest.chanwoong.domain.RoundDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgreSqlRepository extends JpaRepository<RoundDataEntity, Long> {
}
