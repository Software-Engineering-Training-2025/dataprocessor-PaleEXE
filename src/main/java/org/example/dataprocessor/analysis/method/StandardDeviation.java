package org.example.dataprocessor.analysis.method;

import org.example.dataprocessor.analysis.Analysis;

import java.util.List;

public class StandardDeviation implements Analysis {
    public Double analyze(List<Integer> data) {
        if (data.isEmpty()) {
            return Double.NaN;
        }

        double mean = data.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        double variance = data.stream()
                .mapToDouble(x -> Math.pow(x - mean, 2))
                .average()
                .orElse(0.0);

        return Math.sqrt(variance);
    }
}
