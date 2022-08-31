package ua.com.javarush.ivaniuk.module2.items.animals.carnivores;

import ua.com.javarush.ivaniuk.module2.items.animals.Carnivore;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.EAGLE;

public class Eagle extends Carnivore {
    public Eagle(int x, int y) {
        super(x, y);
        setMaxSatiety(1);
        setSatiety(1);
        setSpeed(3);
        setWeight(6);
        setItemType(EAGLE);
    }
}
