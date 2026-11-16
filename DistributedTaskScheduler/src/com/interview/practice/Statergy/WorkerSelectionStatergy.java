package com.interview.practice.Statergy;

import com.interview.practice.domain.Task;
import com.interview.practice.domain.WorkerNode;

import java.util.List;

public interface WorkerSelectionStatergy {

   WorkerNode selectWorker(Task task, List<WorkerNode> workerNodeList);
}
