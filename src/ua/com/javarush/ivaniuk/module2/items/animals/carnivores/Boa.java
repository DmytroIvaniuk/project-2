package ua.com.javarush.ivaniuk.module2.items.animals.carnivores;

import ua.com.javarush.ivaniuk.module2.items.animals.Carnivore;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.BOA;

public class Boa extends Carnivore {
    public Boa(int x, int y) {
        super(x, y);
        setMaxSatiety(3);
        setSatiety(3);
        setSpeed(1);
        setWeight(15);
        setItemType(BOA);
    }
}
