package org.utilityclass;

public class PrinterImplementation implements Printer{
    @Override
    public void printLetters() {
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    @Override
    public void printIntegers() {
        for (int i = 1; i <= 9000; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
