package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class ShopDaoImpl implements ShopDao {
    @Override
    public boolean contains(String fruitName) {
        for (Fruit fruit: Storage.getStorage()) {
            if (fruit.getName().equals(fruitName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Fruit get(String fruitName) {
        for (Fruit fruit: Storage.getStorage()) {
            if (fruit.getName().equals(fruitName)) {
                return fruit;
            }
        }
        return null;
    }

    @Override
    public void add(String fruit) {
        Storage.getStorage().add(new Fruit(fruit));
    }
}
