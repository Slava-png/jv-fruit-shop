package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface ShopDao {
    boolean contains(String fruitName);

    Fruit get(String fruitName);

    void add(String fruit);
}
