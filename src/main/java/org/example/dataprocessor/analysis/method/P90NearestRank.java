package org.example.dataprocessor.analysis.method;

import org.example.dataprocessor.analysis.Analysis;

import java.util.Collections;
import java.util.List;

public class P90NearestRank implements Analysis {
    public Double analyze(List<Integer> data) {
        if (data.isEmpty()) {
            return Double.NaN;
        }
        Collections.sort(data);

        int n = data.size();
        int rank = (int) Math.ceil(0.90 * n);
        rank = Math.min(rank, n);

        return data.get(rank - 1).doubleValue();
    }
}
