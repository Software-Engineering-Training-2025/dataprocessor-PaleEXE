package org.example.dataprocessor.output;

import org.example.dataprocessor.enums.OutputType;
import org.example.dataprocessor.output.method.OutputConsole;
import org.example.dataprocessor.output.method.TextFile;

import java.io.Console;

public class OutputFactory {
    public static Output create(OutputType type) {
        return switch (type) {
            case CONSOLE   -> new OutputConsole();
            case TEXT_FILE -> new TextFile();
            default        -> throw new IllegalArgumentException("Invalid cleaning type");
        };
    }
}
