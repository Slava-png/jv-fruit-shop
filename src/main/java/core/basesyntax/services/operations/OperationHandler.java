package core.basesyntax.services.operations;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void handler(Fruit fruit, int amount);
}
