package org.utilityclass;

import org.gradle.workers.WorkAction;
import org.gradle.workers.WorkParameters;

public abstract class PrinterWorker implements WorkAction<WorkParameters.None> {

    @Override
    public void execute() {

        try {
            PrinterImplementation printer = new PrinterImplementation();
            printer.printIntegers();
            printer.printLetters();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
