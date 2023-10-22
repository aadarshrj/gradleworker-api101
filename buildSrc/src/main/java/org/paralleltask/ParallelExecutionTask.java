package org.paralleltask;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.workers.WorkQueue;
import org.gradle.workers.WorkerExecutor;
import org.utilityclass.IntegerTask;
import org.utilityclass.Letter;
import org.utilityclass.PrinterWorker;

import javax.inject.Inject;


public class ParallelExecutionTask extends DefaultTask {

    private final WorkerExecutor workerExecutor;

    @Inject
    public ParallelExecutionTask(WorkerExecutor workerExecutor) {
        this.workerExecutor = workerExecutor;
    }

    @TaskAction
    void executeTask() {
        WorkQueue workQueue = workerExecutor.processIsolation();
        workQueue.submit(PrinterWorker.class, config -> {
            try {
                config.wait(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
       /* workerExecutor.submit(IntegerTask.class, config -> {
            config.setDisplayName("Integer Task");
        });

        workerExecutor.submit(Letter.class, config -> {
            config.setDisplayName("Letter Task");
        });*/
    }
}
