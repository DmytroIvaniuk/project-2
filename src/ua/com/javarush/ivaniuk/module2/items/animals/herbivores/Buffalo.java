package ua.com.javarush.ivaniuk.module2.items.animals.herbivores;

import ua.com.javarush.ivaniuk.module2.items.animals.Herbivore;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.BUFFALO;

public class Buffalo extends Herbivore {
    public Buffalo(int x, int y) {
        super(x, y);
        setMaxSatiety(100);
        setSatiety(100);
        setSpeed(3);
        setWeight(700);
        setItemType(BUFFALO);
    }
}
