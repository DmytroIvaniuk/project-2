package ua.com.javarush.ivaniuk.module2.items.animals.herbivores;

import ua.com.javarush.ivaniuk.module2.items.animals.Herbivore;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.MOUSE;

public class Mouse extends Herbivore {
    public Mouse(int x, int y) {
        super(x, y);
        setMaxSatiety(0.01);
        setSatiety(0.01);
        setSpeed(1);
        setWeight(0.05);
        setItemType(MOUSE);
    }
}
