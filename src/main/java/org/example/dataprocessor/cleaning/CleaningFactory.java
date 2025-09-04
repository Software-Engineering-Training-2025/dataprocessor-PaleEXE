package org.example.dataprocessor.cleaning;

import org.example.dataprocessor.cleaning.method.RemoveNegatives;
import org.example.dataprocessor.cleaning.method.ReplaceNegativesWithZeros;
import org.example.dataprocessor.enums.CleaningType;

public class CleaningFactory {
    public static Cleaning create(CleaningType type) {
        return switch (type) {
            case REMOVE_NEGATIVES            -> new RemoveNegatives();
            case REPLACE_NEGATIVES_WITH_ZERO -> new ReplaceNegativesWithZeros();
            default                          -> throw new IllegalArgumentException("Invalid cleaning type");
        };
    }
}
