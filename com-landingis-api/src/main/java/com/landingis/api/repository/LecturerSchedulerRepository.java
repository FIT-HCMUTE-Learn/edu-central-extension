package com.landingis.api.repository;

import com.landingis.api.model.entity.LecturerScheduler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LecturerSchedulerRepository extends JpaRepository<LecturerScheduler, Long>, JpaSpecificationExecutor<LecturerScheduler> {
}
