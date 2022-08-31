package ua.com.javarush.ivaniuk.module2.items.animals.herbivores;

import ua.com.javarush.ivaniuk.module2.items.animals.Herbivore;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.CATERPILLAR;

public class Caterpillar extends Herbivore {
    public Caterpillar(int x, int y) {
        super(x, y);
        setMaxSatiety(0);
        setSatiety(0);
        setSpeed(0);
        setWeight(0.01);
        setItemType(CATERPILLAR);
    }
}
