package core.basesyntax.services.implementations;

import core.basesyntax.model.Fruit;
import core.basesyntax.services.Report;
import core.basesyntax.storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class ReportImpl implements Report {
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";

    @Override
    public List<String[]> createReport() {
        List<String[]> report = new ArrayList<>();
        report.add(new String[] {FRUIT, QUANTITY});

        for (int i = 0; i < Storage.storage.size(); i++) {
            Fruit fruit = Storage.storage.get(i);
            report.add(new String[] {fruit.getName(), String.valueOf(fruit.getQuantity())});
        }

        return report;
    }
}
