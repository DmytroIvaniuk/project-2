package ua.com.javarush.ivaniuk.module2.items.animals.herbivores;

import ua.com.javarush.ivaniuk.module2.items.animals.Herbivore;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.GOAT;

public class Goat extends Herbivore {
    public Goat(int x, int y) {
        super(x, y);
        setMaxSatiety(10);
        setSatiety(10);
        setSpeed(3);
        setWeight(60);
        setItemType(GOAT);
    }
}
