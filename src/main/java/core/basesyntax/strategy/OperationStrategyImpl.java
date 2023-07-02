package core.basesyntax.strategy;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.operations.OperationHandler;

import java.util.List;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy{
    private ShopDao shopDao;
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(ShopDao shopDao, Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.shopDao = shopDao;
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void parseTransactions(List<FruitTransaction> data) {
        for (FruitTransaction transaction: data) {
            if (!shopDao.contains(transaction.getFruit())) {
                shopDao.add(transaction.getFruit());
            }

            operationHandlerMap.get(transaction.getOperation())
                    .handler(shopDao.get(transaction.getFruit()), transaction.getQuantity());
        }
    }
}
