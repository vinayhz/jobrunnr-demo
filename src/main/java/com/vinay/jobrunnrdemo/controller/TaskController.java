package com.vinay.jobrunnrdemo.controller;

import com.vinay.jobrunnrdemo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final JobScheduler jobScheduler;

    @PostMapping("/send")
    public ResponseEntity<String> sendTask() {
        jobScheduler.enqueue(taskService::sendConfigUpdates);
        return ResponseEntity.ok("Task scheduled successfully");
    }

    @PostMapping("/send-all")
    public ResponseEntity<String> sendAllTasks() {
        jobScheduler.schedule(
                Instant.now().plusSeconds(30),
                taskService::sendConfigUpdatesToAll
        );
        return ResponseEntity.ok("All tasks scheduled successfully");
    }
}
