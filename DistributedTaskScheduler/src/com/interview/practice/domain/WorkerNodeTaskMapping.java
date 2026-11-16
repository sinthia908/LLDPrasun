package com.interview.practice.domain;

import java.util.Date;

public class WorkerNodeTaskMapping {

    private String mappingId;

    private WorkerNode workerNode ;

    private Task task;

    private Date assignedAt;

    private Date completedAt;


    public WorkerNodeTaskMapping(WorkerNode workerNode,Task task){
           this.workerNode = workerNode;
           this.task = task;
    }


    public WorkerNode getWorkerNode() {
        return workerNode;
    }

    public void setWorkerNode(WorkerNode workerNode) {
        this.workerNode = workerNode;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getMappingId() {
        return mappingId;
    }

    public void setMappingId(String mappingId) {
        this.mappingId = mappingId;
    }

    public Date getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(Date assignedAt) {
        this.assignedAt = assignedAt;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }
}
