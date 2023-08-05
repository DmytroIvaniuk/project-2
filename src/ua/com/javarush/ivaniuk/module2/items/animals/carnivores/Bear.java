package ua.com.javarush.ivaniuk.module2.items.animals.carnivores;

import ua.com.javarush.ivaniuk.module2.items.animals.Carnivore;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.BEAR;

public class Bear extends Carnivore {
    public Bear(int x, int y) {
        super(x, y);
        setMaxSatiety(80);
        setSatiety(80);
        setSpeed(2);
        setWeight(500);
        setItemType(BEAR);
    }
}
