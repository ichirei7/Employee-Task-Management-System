package com.etms.EmployeeTaskManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.etms.EmployeeTaskManagementSystem.model.TimeLog;
import java.util.List;

public interface TimeLogRepository extends JpaRepository<TimeLog, Long> {
    List<TimeLog> findByUserId(Long userId);
    List<TimeLog> findByTaskId(Long taskId);
}