package ua.com.javarush.ivaniuk.module2.items.animals.herbivores;

import ua.com.javarush.ivaniuk.module2.items.animals.Herbivore;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.DUCK;

public class Duck extends Herbivore {
    public Duck(int x, int y) {
        super(x, y);
        setMaxSatiety(0.15);
        setSatiety(0.15);
        setSpeed(4);
        setWeight(1);
        setItemType(DUCK);
    }
}
