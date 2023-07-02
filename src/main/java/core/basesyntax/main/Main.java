package core.basesyntax.main;

import core.basesyntax.dao.ShopDao;
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
import core.basesyntax.services.operations.*;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String readFrom = "src/main/java/resources/input.csv";
        String writeTo = "src/main/java/resources/report.csv";

        Reader reader = new ReaderImpl();
        List<String[]> data = reader.readData(readFrom);

        Parser parser = new ParserImpl();
        List<FruitTransaction> parsedData = parser.parse(data);

        ShopDao shopDao = new ShopDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandlerImpl());

        OperationStrategy operationStrategy =
                new OperationStrategyImpl(shopDao, operationHandlerMap);
        operationStrategy.parseTransactions(parsedData);

        Report report = new ReportImpl();
        List<String[]> createdReport = report.createReport();

        Writer writer = new WriterImpl();
        writer.writeData(createdReport, writeTo);
    }
}
