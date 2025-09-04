package org.example.dataprocessor.analysis;

import org.example.dataprocessor.analysis.method.*;
import org.example.dataprocessor.enums.AnalysisType;

public class AnalysisFactory {
    public static Analysis create(AnalysisType type) {
        return switch (type) {
            case MEAN                    -> new Mean();
            case MEDIAN                  -> new Median();
            case STD_DEV                 -> new StandardDeviation();
            case P90_NEAREST_RANK        -> new P90NearestRank();
            case TOP3_FREQUENT_COUNT_SUM -> new Top3FrequentCountSum();
            default                      -> throw new IllegalArgumentException("Unknown AnalysisType");
        };
    }
}
