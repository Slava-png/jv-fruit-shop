package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface OperationStrategy {
    void parseTransactions(List<FruitTransaction> data);
}
