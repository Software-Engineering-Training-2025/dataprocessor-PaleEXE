package org.example.dataprocessor.output.method;

import org.example.dataprocessor.output.Output;

import java.io.FileWriter;
import java.io.IOException;

public class TextFile implements Output {
    public void write(Double result) {
        try (FileWriter writer = new FileWriter("target/result.txt")) {
            writer.write("Result = " + result);
        } catch (IOException e) {
            System.err.println(
                    "Cannot write result to file `target/result.txt` due to: "
                            + e.getMessage()
            );
        }
    }
}
