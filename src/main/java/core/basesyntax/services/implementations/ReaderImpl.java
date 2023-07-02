package core.basesyntax.services.implementations;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import core.basesyntax.services.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReaderImpl implements Reader {
    @Override
    public List<String[]> readData(String readFrom) {
        List<String[]> data;

        try {
            CSVReader reader = new CSVReader(new FileReader(readFrom));
            data = reader.readAll();
            reader.close();
        } catch (IOException | CsvException e) {
            throw new RuntimeException("There is no such file as " + readFrom, e);
        }
        return data;
    }
}
