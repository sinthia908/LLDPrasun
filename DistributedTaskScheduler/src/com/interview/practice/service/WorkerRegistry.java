package com.interview.practice.service;

import com.interview.practice.domain.WorkerNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkerRegistry {

    private Map<String,WorkerNode> workers ;

    public WorkerRegistry(){
           workers = new HashMap<>();
    }

    public WorkerNode registerWorker(
            int capacity,
            int memoryCapacity,
            int processingSpeed) {

        WorkerNode worker = new WorkerNode(
                capacity,
                memoryCapacity,
                processingSpeed
        );

        workers.put(worker.getNodeId(), worker);

        return worker;
    }

    public List<WorkerNode> getAllWorkers() {
           return new ArrayList<>(workers.values());
    }
}
