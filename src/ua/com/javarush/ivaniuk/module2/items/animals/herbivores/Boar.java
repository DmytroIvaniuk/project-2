package ua.com.javarush.ivaniuk.module2.items.animals.herbivores;

import ua.com.javarush.ivaniuk.module2.items.animals.Herbivore;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.BOAR;

public class Boar extends Herbivore {
    public Boar(int x, int y) {
        super(x, y);
        setMaxSatiety(50);
        setSatiety(50);
        setSpeed(2);
        setWeight(400);
        setItemType(BOAR);
    }
}
