package ua.com.javarush.ivaniuk.module2.items.animals.herbivores;

import ua.com.javarush.ivaniuk.module2.items.animals.Herbivore;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.SHEEP;

public class Sheep extends Herbivore {
    public Sheep(int x, int y) {
        super(x, y);
        setMaxSatiety(15);
        setSatiety(15);
        setSpeed(3);
        setWeight(70);
        setItemType(SHEEP);
    }
}
