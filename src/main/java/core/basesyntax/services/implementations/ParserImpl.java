package core.basesyntax.services.implementations;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.Parser;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int INFORMATION_LINE = 0;

    @Override
    public List<FruitTransaction> parse(List<String[]> data) {
        data.remove(INFORMATION_LINE);

        return data.stream()
                .map(t -> new FruitTransaction(defineOperation(t[OPERATION_TYPE_INDEX]),
                        t[FRUIT_INDEX], Integer.parseInt(t[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }

    @Override
    public FruitTransaction.Operation defineOperation(String operationType) {
        FruitTransaction.Operation[] operations = FruitTransaction.Operation.values();

        for (FruitTransaction.Operation operation: operations) {
            if (operationType.equals(operation.getOperation())) {
                return operation;
            }
        }
        throw new RuntimeException("There is no such operation in our shop as " + operationType);
    }
}
