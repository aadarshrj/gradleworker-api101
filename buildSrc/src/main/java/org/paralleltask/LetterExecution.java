package org.paralleltask;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import org.utilityclass.Letter;
import org.gradle.workers.WorkerExecutor;

import javax.inject.Inject;

public class LetterExecution extends DefaultTask {
    @Input
    protected int timeToWait;

    @Inject
    protected WorkerExecutor getWorkerExecutor() {
        throw new UnsupportedOperationException();
    }

    @TaskAction
    public void print() {
        getWorkerExecutor().submit(Letter.class, config -> {
            config.setParams(timeToWait);
        });
    }
}
