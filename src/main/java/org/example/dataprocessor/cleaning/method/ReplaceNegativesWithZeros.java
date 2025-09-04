package org.example.dataprocessor.cleaning.method;

import org.example.dataprocessor.cleaning.Cleaning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReplaceNegativesWithZeros implements Cleaning {
    public List<Integer> clean(List<Integer> data) {
        return data
                .stream()
                .map((x) -> Math.max(x, 0))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
