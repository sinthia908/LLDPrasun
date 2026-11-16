package com.interview.practice.service;

import com.interview.practice.domain.Task;
import com.interview.practice.domain.WorkerNode;
import com.interview.practice.domain.WorkerNodeTaskMapping;
import com.interview.practice.enums.TaskStatus;
import com.interview.practice.enums.WorkerStatus;

import java.util.ArrayList;
import java.util.List;

public class WorkerFailureHandler {

    private final TaskScheduler taskScheduler;
    private final TaskExecutionService taskExecutionService;

    public WorkerFailureHandler(
            TaskScheduler taskScheduler,
            TaskExecutionService taskExecutionService) {

        this.taskScheduler = taskScheduler;
        this.taskExecutionService = taskExecutionService;
    }

    public void handleWorkerFailure(WorkerNode worker) {

        // Step 1: Mark worker as failed
        worker.setStatus(WorkerStatus.FAILED);

        // Step 2: Take a snapshot of assigned mappings
        List<WorkerNodeTaskMapping> mappings =
                new ArrayList<>();

        for (WorkerNodeTaskMapping mapping : mappings) {

            Task task = mapping.getTask();

            synchronized (task) {

                // Step 3: Only reassign unfinished tasks
                if (task.getTaskStatus() == TaskStatus.RUNNING
                        || task.getTaskStatus() == TaskStatus.ASSIGNED) {

                    // Step 4: Cancel the old scheduled execution
                    taskExecutionService.cancel(task.getTaskId());

                    // Step 5: Change task status back to QUEUED
                    task.setTaskStatus(TaskStatus.QUEUED);

                    // Step 6: Remove old worker-task mapping
                    worker.removeMapping(mapping.getMappingId());

                    // Step 7: Add task back to pending queue
                    taskScheduler.enqueueForRetry(task);
                }
            }
        }

        // Step 8: Assign queued tasks to healthy workers
        taskScheduler.scheduleTasks();
    }
}