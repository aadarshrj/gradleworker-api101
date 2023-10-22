package org.utilityclass;

import org.gradle.workers.WorkParameters;

public interface Printer extends WorkParameters {
    void printLetters();
    void printIntegers();
}
