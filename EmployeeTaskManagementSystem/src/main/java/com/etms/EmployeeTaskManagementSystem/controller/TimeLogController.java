package com.etms.EmployeeTaskManagementSystem.controller;

import com.etms.EmployeeTaskManagementSystem.model.TimeLog;
import com.etms.EmployeeTaskManagementSystem.service.TimeLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timelogs")
public class TimeLogController {

    private final TimeLogService timeLogService;

    public TimeLogController(TimeLogService timeLogService) {
        this.timeLogService = timeLogService;
    }

    @PostMapping
    public ResponseEntity<TimeLog> createTimeLog(@RequestBody TimeLog timeLog) {
        return ResponseEntity.ok(timeLogService.createTimeLog(timeLog));
    }

    @GetMapping
    public ResponseEntity<List<TimeLog>> getAllTimeLogs() {
        return ResponseEntity.ok(timeLogService.getAllTimeLogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeLog> getTimeLogById(@PathVariable Long id) {
        return timeLogService.getTimeLogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TimeLog>> getTimeLogsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(timeLogService.getTimeLogsByUser(userId));
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<TimeLog>> getTimeLogsByTask(@PathVariable Long taskId) {
        return ResponseEntity.ok(timeLogService.getTimeLogsByTask(taskId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimeLog(@PathVariable Long id) {
        timeLogService.deleteTimeLog(id);
        return ResponseEntity.noContent().build();
    }
}
