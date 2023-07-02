package core.basesyntax.services;

import java.util.List;

public interface Writer {
    void writeData(List<String[]> report, String writeTo);
}
