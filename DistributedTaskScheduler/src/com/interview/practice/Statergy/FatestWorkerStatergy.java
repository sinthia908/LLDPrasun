package com.interview.practice.Statergy;

import com.interview.practice.domain.Task;
import com.interview.practice.domain.WorkerNode;

import java.util.Comparator;
import java.util.List;

public class FatestWorkerStatergy implements WorkerSelectionStatergy{
    @Override
    public WorkerNode selectWorker(Task task, List<WorkerNode> workerNodeList) {
        return workerNodeList.stream().filter(workerNode -> workerNode.canExecute(task)).max(Comparator.comparingInt(WorkerNode::getProcessingSpeed)).orElse(null);
    }
}
