package ua.com.javarush.ivaniuk.module2.items.animals.herbivores;

import ua.com.javarush.ivaniuk.module2.items.animals.Herbivore;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.HORSE;

public class Horse extends Herbivore {
    public Horse(int x, int y) {
        super(x, y);
        setMaxSatiety(60);
        setSatiety(60);
        setSpeed(4);
        setWeight(400);
        setItemType(HORSE);
    }
}
