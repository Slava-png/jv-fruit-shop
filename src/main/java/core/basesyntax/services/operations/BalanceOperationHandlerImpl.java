package core.basesyntax.services.operations;

import core.basesyntax.model.Fruit;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public void handler(Fruit fruit, int amount) {
        fruit.setQuantity(amount);
    }
}
