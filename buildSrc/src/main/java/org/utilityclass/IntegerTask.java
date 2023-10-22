package org.utilityclass;

import org.gradle.workers.WorkParameters;

import javax.inject.Inject;

public class IntegerTask implements Runnable {

    private final int timeToWait;

    @Inject
    public IntegerTask(int seconds){
        this.timeToWait = seconds;
    }


    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(timeToWait);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }
}
