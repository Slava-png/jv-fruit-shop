package core.basesyntax.services.operations;

import core.basesyntax.model.Fruit;

public class SupplyOperationHandlerImpl implements OperationHandler {
    @Override
    public void handler(Fruit fruit, int amount) {
        fruit.setQuantity(fruit.getQuantity() + amount);
    }
}
