package com.vinay.jobrunnrdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.jobs.annotations.Recurring;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskService {

    @Job(name = "Send Updates")
    @Recurring(id="my-recurring-job", cron = "*/2 * * * *")
    public void sendUpdates() {
        log.info("Sending recurring updates...");
    }

    public void sendConfigUpdates() {
        log.info("Sending config updates...");
    }

    public void sendConfigUpdatesToAll() {
        log.info("Sending config updates to all...");
    }
}
