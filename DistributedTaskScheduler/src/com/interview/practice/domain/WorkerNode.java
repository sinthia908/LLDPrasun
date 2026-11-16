package com.interview.practice.domain;

import com.interview.practice.enums.WorkerStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WorkerNode {
    private String nodeId;
    private int availableCpu;
    private int availableMemory;
    private int processingSpeed;
    private WorkerStatus status;

    public List<WorkerNodeTaskMapping> getWorkerNodeList() {
        return workerNodeList;
    }

    public void setWorkerNodeList(List<WorkerNodeTaskMapping> workerNodeList) {
        this.workerNodeList = workerNodeList;
    }

    private List<WorkerNodeTaskMapping> workerNodeList;

    public WorkerNode(int availableCpu,int availableMemory,int processingSpeed) {
           this.nodeId = UUID.randomUUID().toString();
           this.availableCpu = availableCpu;
           this.availableMemory = availableMemory;
           this.processingSpeed = processingSpeed;
           this.workerNodeList = new ArrayList<>();
           this.status = WorkerStatus.ACTIVE;
    }

    public boolean canExecute(Task task) {

        return availableCpu >= task.getCpuRequirement()
                && availableMemory >= task.getMemoryRequirement();
    }

    public void allocateResources(Task task) {

        if (!canExecute(task)) {
            throw new IllegalStateException("Insufficient resources");
        }

        availableCpu -= task.getCpuRequirement();
        availableMemory -= task.getMemoryRequirement();
    }

    public void releaseResources(Task task) {

        availableCpu += task.getCpuRequirement();
        availableMemory += task.getMemoryRequirement();
    }

    public String getNodeId() {
        return nodeId;
    }

    public int getProcessingSpeed() {
        return processingSpeed;

    }
    public void addMapping(WorkerNodeTaskMapping workerNodeTaskMapping){
           workerNodeList.add(workerNodeTaskMapping);
    }

    public boolean hasMapping(String mappingId) {

        return workerNodeList.stream()
                .anyMatch(mapping ->
                        mapping.getMappingId().equals(mappingId));
    }


    public void removeMapping(String mappingId) {
        workerNodeList.removeIf(
                mapping -> mapping.getMappingId().equals(mappingId)
        );
    }


    public WorkerStatus getStatus() {
        return status;
    }

    public void setStatus(WorkerStatus status) {
        this.status = status;
    }

}
