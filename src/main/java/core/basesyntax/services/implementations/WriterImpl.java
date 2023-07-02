package core.basesyntax.services.implementations;

import com.opencsv.CSVWriter;
import core.basesyntax.services.Writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterImpl implements Writer {
    private static final char DEFAULT_SEPARATOR = ',';

    @Override
    public void writeData(List<String[]> report, String writeTo) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(writeTo),
                    DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            writer.writeAll(report);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't find file with path " + writeTo, e);
        }
    }
}
