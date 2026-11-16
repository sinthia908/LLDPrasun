package com.interview.practice.service;

import com.interview.practice.domain.Task;
import com.interview.practice.domain.WorkerNode;
import com.interview.practice.domain.WorkerNodeTaskMapping;
import com.interview.practice.enums.TaskStatus;
import com.interview.practice.enums.WorkerStatus;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TaskExecutionService {

    private final ScheduledExecutorService executorService =
            Executors.newScheduledThreadPool(10);

    private final Map<String, ScheduledFuture<?>> executions =
            new ConcurrentHashMap<>();

    private Runnable rescheduleCallback;

    public void setRescheduleCallback(Runnable callback) {
        this.rescheduleCallback = callback;
    }

    public void execute(
            Task task,
            WorkerNode worker,
            WorkerNodeTaskMapping mapping) {

        synchronized (task) {

            if (task.getTaskStatus() != TaskStatus.ASSIGNED) {
                return;
            }

            task.setTaskStatus(TaskStatus.RUNNING);
        }

        // Schedule simulated task execution
        ScheduledFuture<?> future = executorService.schedule(
                () -> completeTask(task, worker, mapping),
                task.getExecutionTime(),
                TimeUnit.SECONDS
        );

        // Store future so it can be cancelled on worker failure
        executions.put(task.getTaskId(), future);
    }

    private void completeTask(
            Task task,
            WorkerNode worker,
            WorkerNodeTaskMapping mapping) {

        synchronized (task) {

            // Ignore stale callbacks after reassignment or worker failure
            if (task.getTaskStatus() != TaskStatus.RUNNING
                    || worker.getStatus() != WorkerStatus.ACTIVE
                    || !worker.hasMapping(mapping.getMappingId())) {

                return;
            }

            // Step 1: Mark task completed
            task.setTaskStatus(TaskStatus.COMPLETED);

            // Step 2: Release CPU and memory
            worker.releaseResources(task);

            // Step 3: Remove worker-task mapping
            worker.removeMapping(mapping.getMappingId());

            // Step 4: Record completion time
            mapping.setCompletedAt(new Date());

            // Step 5: Remove execution tracking
            executions.remove(task.getTaskId());
        }

        // Step 6: Schedule pending tasks
        if (rescheduleCallback != null) {
            rescheduleCallback.run();
        }
    }

    public void cancel(String taskId) {

        ScheduledFuture<?> future = executions.remove(taskId);

        if (future != null) {
            future.cancel(false);
        }
    }

    public void shutdown() {
        executorService.shutdownNow();
    }


}