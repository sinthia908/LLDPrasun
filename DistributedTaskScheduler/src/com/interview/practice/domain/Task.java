package com.interview.practice.domain;

import com.interview.practice.enums.TaskStatus;

public class Task {

    private String taskId;

    public int getCpuRequirement() {
        return cpuRequirement;
    }

    public void setCpuRequirement(int cpuRequirement) {
        this.cpuRequirement = cpuRequirement;
    }

    public double getMemoryRequirement() {
        return memoryRequirement;
    }

    public void setMemoryRequirement(double memoryRequirement) {
        this.memoryRequirement = memoryRequirement;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    private int cpuRequirement;
    private double memoryRequirement;


    private int executionTime;

    private TaskStatus taskStatus;


    public Task(int cpuRequirement,int memoryRequirement,int executionTime){
          this.cpuRequirement = cpuRequirement;
          this.memoryRequirement = memoryRequirement;
          this.executionTime = executionTime;

    }



}
