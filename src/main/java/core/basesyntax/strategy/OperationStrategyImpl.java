package core.basesyntax.strategy;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.operations.*;

import java.util.List;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private ShopDao shopDao;
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(ShopDao shopDao) {
        this.shopDao = shopDao;
        initOperationalHandlerMap();
    }

    private void initOperationalHandlerMap() {
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandlerImpl());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandlerImpl());
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
