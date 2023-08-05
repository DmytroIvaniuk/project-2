package ua.com.javarush.ivaniuk.module2.items.animals.carnivores;

import ua.com.javarush.ivaniuk.module2.items.animals.Carnivore;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.FOX;

public class Fox extends Carnivore {
    public Fox(int x, int y) {
        super(x, y);
        setMaxSatiety(2);
        setSatiety(2);
        setSpeed(2);
        setWeight(8);
        setItemType(FOX);
    }
}
