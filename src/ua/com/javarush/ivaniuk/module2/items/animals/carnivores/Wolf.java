package ua.com.javarush.ivaniuk.module2.items.animals.carnivores;

import ua.com.javarush.ivaniuk.module2.items.animals.Carnivore;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.WOLF;

public class Wolf extends Carnivore {
    public Wolf(int x, int y) {
        super(x, y);
        setMaxSatiety(8);
        setSatiety(8);
        setSpeed(3);
        setWeight(50);
        setItemType(WOLF);
    }
}
