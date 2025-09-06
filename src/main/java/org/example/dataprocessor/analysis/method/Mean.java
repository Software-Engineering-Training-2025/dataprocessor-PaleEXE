package org.example.dataprocessor.analysis.method;

import org.example.dataprocessor.analysis.Analysis;

import java.util.List;


public class Mean implements Analysis {
    public Double analyze(List<Integer> data) {
        if (data.isEmpty()) {
            return Double.NaN;
        }
        int sum = data.stream().reduce(0, Integer::sum);
        return (double) sum / data.size();
    }
}
