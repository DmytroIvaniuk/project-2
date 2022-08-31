package ua.com.javarush.ivaniuk.module2.items.plant;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.HERB;

public class Herb extends Plant{
    public Herb(int x, int y){
        super(x,y);
        setWeight(1);
        setItemType(HERB);
    }
}
