package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static List<Fruit> storage = new ArrayList<>();

    public static List<Fruit> getStorage() {
        return storage;
    }
}
