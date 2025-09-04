package org.example.dataprocessor.analysis.method;

import org.example.dataprocessor.analysis.Analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Median implements Analysis {
    public Double analyze(List<Integer> data) {
        if (data.isEmpty()) {
            return Double.NaN;
        }
        Collections.sort(data);
        int size = data.size();
        if (size % 2 == 1) {
            return data.get(size / 2).doubleValue();
        }
        int mid1 = data.get(size / 2 - 1);
        int mid2 = data.get(size / 2);
        return (mid1 + mid2) / 2.0;
    }
}
