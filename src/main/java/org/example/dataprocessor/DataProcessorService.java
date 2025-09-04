package org.example.dataprocessor;

import org.example.dataprocessor.analysis.Analysis;
import org.example.dataprocessor.analysis.AnalysisFactory;
import org.example.dataprocessor.cleaning.Cleaning;
import org.example.dataprocessor.cleaning.CleaningFactory;
import org.example.dataprocessor.enums.AnalysisType;
import org.example.dataprocessor.enums.CleaningType;
import org.example.dataprocessor.enums.OutputType;
import org.example.dataprocessor.output.Output;
import org.example.dataprocessor.output.OutputFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class DataProcessorService {
    public double process(
            CleaningType cleaningType,
            AnalysisType analysisType,
            OutputType outputType,
            List<Integer> data
    ) {
        data = new ArrayList<>(data);

        Cleaning      cleaner  = CleaningFactory.create(cleaningType);
        Analysis      analyzer = AnalysisFactory.create(analysisType);
        Output        output   = OutputFactory.create(outputType);

        List<Integer> cleaned  = cleaner.clean(data);
        Double        result   = analyzer.analyze(cleaned);

        output.write(result);
        return result;
    }
}

