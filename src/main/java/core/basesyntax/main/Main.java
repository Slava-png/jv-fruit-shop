package core.basesyntax.main;

import core.basesyntax.dao.ShopDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.Parser;
import core.basesyntax.services.Reader;
import core.basesyntax.services.Report;
import core.basesyntax.services.Writer;
import core.basesyntax.services.implementations.ParserImpl;
import core.basesyntax.services.implementations.ReaderImpl;
import core.basesyntax.services.implementations.ReportImpl;
import core.basesyntax.services.implementations.WriterImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String readFrom = "src/main/java/resources/input.csv";

        Reader reader = new ReaderImpl();
        List<String[]> data = reader.readData(readFrom);

        Parser parser = new ParserImpl();
        List<FruitTransaction> parsedData = parser.parse(data);

        OperationStrategy operationStrategy = new OperationStrategyImpl(new ShopDaoImpl());
        operationStrategy.parseTransactions(parsedData);

        Report report = new ReportImpl();
        List<String[]> createdReport = report.createReport();

        String writeTo = "src/main/java/resources/report.csv";
        Writer writer = new WriterImpl();
        writer.writeData(createdReport, writeTo);
    }
}
