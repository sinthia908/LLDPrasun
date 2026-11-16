package com.interview.practice.service;

import com.interview.practice.Statergy.WorkerSelectionStatergy;
import com.interview.practice.domain.Task;
import com.interview.practice.domain.WorkerNode;
import com.interview.practice.domain.WorkerNodeTaskMapping;
import com.interview.practice.enums.TaskStatus;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduler {
    private WorkerRegistry workerRegistry;
    private Queue<Task> taskQueue;

    private WorkerSelectionStatergy selectionStrategy;

    private TaskExecutionService taskExecutionService;

    public TaskScheduler(
            WorkerRegistry workerRegistry,
            WorkerSelectionStatergy selectionStrategy,
            TaskExecutionService taskExecutionService) {

        this.workerRegistry = workerRegistry;
        this.selectionStrategy = selectionStrategy;
        this.taskExecutionService = taskExecutionService;
        this.taskQueue = new LinkedList<>();
    }

    public void submitTask(Task task) {

        taskQueue.offer(task);
        scheduleTasks();
    }

    public void scheduleTasks() {

        Iterator<Task> iterator = taskQueue.iterator();

        while (iterator.hasNext()) {

            Task task = iterator.next();

            WorkerNode worker = selectionStrategy.selectWorker(
                    task,
                    workerRegistry.getAllWorkers()
            );

            if (worker != null) {

                worker.allocateResources(task);

                WorkerNodeTaskMapping mapping =
                        new WorkerNodeTaskMapping(worker, task);

                worker.addMapping(mapping);

                task.setTaskStatus(TaskStatus.ASSIGNED);

                iterator.remove();

                taskExecutionService.execute(task,worker,mapping);

                // Trigger task execution
            }
        }
    }

    public void enqueueForRetry(Task task) {

        synchronized (taskQueue) {

            // Avoid adding duplicate tasks
            if (!taskQueue.contains(task)) {
                taskQueue.offer(task);
            }
        }
    }

}
