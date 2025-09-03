package com.etms.EmployeeTaskManagementSystem.service;

import com.etms.EmployeeTaskManagementSystem.model.TimeLog;
import com.etms.EmployeeTaskManagementSystem.repository.TimeLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeLogService {

    private final TimeLogRepository timeLogRepository;

    public TimeLogService(TimeLogRepository timeLogRepository) {
        this.timeLogRepository = timeLogRepository;
    }

    public TimeLog createTimeLog(TimeLog timeLog) {
        return timeLogRepository.save(timeLog);
    }

    public List<TimeLog> getAllTimeLogs() {
        return timeLogRepository.findAll();
    }

    public Optional<TimeLog> getTimeLogById(Long id) {
        return timeLogRepository.findById(id);
    }

    public List<TimeLog> getTimeLogsByUser(Long userId) {
        return timeLogRepository.findByUserId(userId);
    }

    public List<TimeLog> getTimeLogsByTask(Long taskId) {
        return timeLogRepository.findByTaskId(taskId);
    }

    public void deleteTimeLog(Long id) {
        timeLogRepository.deleteById(id);
    }
}
