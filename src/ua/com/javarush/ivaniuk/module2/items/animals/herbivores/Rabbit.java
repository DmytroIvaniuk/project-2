package ua.com.javarush.ivaniuk.module2.items.animals.herbivores;

import ua.com.javarush.ivaniuk.module2.items.animals.Herbivore;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.RABBIT;

public class Rabbit extends Herbivore {
    public Rabbit(int x, int y) {
        super(x, y);
        setMaxSatiety(0.45);
        setSatiety(0.45);
        setSpeed(2);
        setWeight(2);
        setItemType(RABBIT);
    }
}
