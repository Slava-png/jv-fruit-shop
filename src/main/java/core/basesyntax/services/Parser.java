package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface Parser {
    List<FruitTransaction> parse(List<String[]> data);

    FruitTransaction.Operation defineOperation(String operation_type);
}
