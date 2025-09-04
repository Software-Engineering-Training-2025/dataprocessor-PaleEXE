package org.example.dataprocessor.analysis.method;

import org.example.dataprocessor.analysis.Analysis;

import java.util.*;

public class Top3FrequentCountSum implements Analysis {
    public Double analyze(List<Integer> data) {
        if (data.isEmpty()) {
            return 0.0;
        }
        List<Integer> top3Freq = sortFreq(count(data));

        return top3Freq.stream().mapToDouble(Integer::doubleValue).sum();
    }

    public Map<Integer, Integer> count(List<Integer> data) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer d : data) {
            freq.put(d, freq.getOrDefault(d, 0) + 1);
        }
        return freq;
    }

    public List<Integer> sortFreq(Map<Integer, Integer> freq) {
        return freq.entrySet().stream()
                .sorted((a, b) -> {
                    int cmp = b.getValue().compareTo(a.getValue());
                    if (cmp == 0) {
                        return a.getKey().compareTo(b.getKey());
                    }
                    return cmp;
                })
                .map(Map.Entry::getValue)
                .limit(3)
                .toList();
    }
}
