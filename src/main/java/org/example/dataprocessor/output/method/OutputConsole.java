package org.example.dataprocessor.output.method;

import org.example.dataprocessor.output.Output;

public class OutputConsole implements Output {
    public void write(Double result) {
        System.out.print("Result = " + result);
    }
}
