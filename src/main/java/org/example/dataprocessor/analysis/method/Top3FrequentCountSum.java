package org.example.dataprocessor.analysis.method;

import org.example.dataprocessor.analysis.Analysis;

import java.util.*;

public class Top3FrequentCountSum implements Analysis {
    public Double analyze(List<Integer> data) {
        if (data.isEmpty()) {
            return 0.0;
        }

        Collections.sort(data);

        int[] freq = {0, 0, 0};
        int last = data.getFirst();
        int count = 0;

        for (int x : data) {
            if (x == last) {
                count++;
            } else {
                insertTop3(freq, count);
                count = 1;
                last = x;
            }
        }
        insertTop3(freq, count);

        return (double) (freq[0] + freq[1] + freq[2]);
    }

    private static void insertTop3(int[] freq, int count) {
        for (int i = 0; i < 3; i++) {
            if (count > freq[i]) {
                for (int j = 2; j > i; j--) {
                    freq[j] = freq[j - 1];
                }
                freq[i] = count;
                break;
            }
        }
    }
}
