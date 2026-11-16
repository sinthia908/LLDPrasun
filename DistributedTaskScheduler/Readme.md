
User submits Task
|
v
TaskScheduler
|
v
TaskQueue
|
v
WorkerSelectionStrategy
|
v
Find eligible WorkerNode
|
+--------------------+
|                    |
Worker Found         No Worker
|                    |
v                    v
Allocate CPU/Memory     Keep in Queue
|
v
Create WorkerNodeTaskMapping
|
v
Execute Task
|
v
Task COMPLETED
|
v
Release CPU/Memory
|
v
Check Pending Queue




                 TaskScheduler
                      |
          +-----------+-----------+
          |                       |
      WorkerRegistry          TaskQueue
          |                       |
      WorkerNode              Task
          |
          | 1
          |
          | N
WorkerNodeTaskMapping
|
+---- Task