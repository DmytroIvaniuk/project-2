package ua.com.javarush.ivaniuk.module2.items.animals.herbivores;

import ua.com.javarush.ivaniuk.module2.items.animals.Herbivore;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.DEER;

public class Deer extends Herbivore {
    public Deer(int x, int y) {
        super(x, y);
        setMaxSatiety(50);
        setSatiety(50);
        setSpeed(4);
        setWeight(300);
        setItemType(DEER);
    }
}
