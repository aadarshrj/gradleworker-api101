package org.utilityclass;


import javax.inject.Inject;

public class Letter implements Runnable {

    private final int timeToWait;

    @Inject
    public Letter(int seconds){
        this.timeToWait = seconds;
    }

    @Override
    public void run() {
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(c + " ");
            try {
                Thread.sleep(timeToWait);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }
}