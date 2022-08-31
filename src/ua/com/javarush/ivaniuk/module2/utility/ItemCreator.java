package ua.com.javarush.ivaniuk.module2.utility;

import ua.com.javarush.ivaniuk.module2.items.BaseItem;
import ua.com.javarush.ivaniuk.module2.items.ItemType;
import ua.com.javarush.ivaniuk.module2.items.animals.carnivores.*;
import ua.com.javarush.ivaniuk.module2.items.animals.herbivores.*;
import ua.com.javarush.ivaniuk.module2.items.plant.Herb;
import ua.com.javarush.ivaniuk.module2.items.plant.Plant;

import java.util.ArrayList;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.HERB;
import static ua.com.javarush.ivaniuk.module2.utility.Statistics.incrementCurrentAnimalCount;

public class ItemCreator {
    public static BaseItem createAnimal(ItemType itemType, int coordX, int coordY) {
        BaseItem item = null;
        switch (itemType) {
            case WOLF -> {
                item = new Wolf(coordX, coordY);
                incrementCurrentAnimalCount();
            }
            case BEAR -> {
                item = new Bear(coordX, coordY);
                incrementCurrentAnimalCount();
            }
            case BOA -> {
                item = new Boa(coordX, coordY);
                incrementCurrentAnimalCount();
            }
            case EAGLE -> {
                item = new Eagle(coordX, coordY);
                incrementCurrentAnimalCount();
            }
            case FOX -> {
                item = new Fox(coordX, coordY);
                incrementCurrentAnimalCount();
            }
            case BOAR -> {
                item = new Boar(coordX, coordY);
                incrementCurrentAnimalCount();
            }
            case BUFFALO -> {
                item = new Buffalo(coordX, coordY);
                incrementCurrentAnimalCount();
            }
            case CATERPILLAR -> {
                item = new Caterpillar(coordX, coordY);
                incrementCurrentAnimalCount();
            }
            case DEER -> {
                item = new Deer(coordX, coordY);
                incrementCurrentAnimalCount();
            }
            case DUCK -> {
                item = new Duck(coordX, coordY);
                incrementCurrentAnimalCount();
            }
            case GOAT -> {
                item = new Goat(coordX, coordY);
                incrementCurrentAnimalCount();
            }
            case HORSE -> {
                item = new Horse(coordX, coordY);
                incrementCurrentAnimalCount();
            }
            case MOUSE -> {
                item = new Mouse(coordX, coordY);
                incrementCurrentAnimalCount();
            }
            case RABBIT -> {
                item = new Rabbit(coordX, coordY);
                incrementCurrentAnimalCount();
            }
            case SHEEP -> {
                item = new Sheep(coordX, coordY);
                incrementCurrentAnimalCount();
            }
            case HERB -> {
                item = new Herb(coordX, coordY);

            }
        }
        return item;
    }

    public static ArrayList<BaseItem> createAnimalList(ItemType itemType, int count, int coordX, int coordY) {
        ArrayList<BaseItem> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(createAnimal(itemType, coordX, coordY));
        }
        if (!HERB.equals(itemType))
            Statistics.increaseStartAnimalCount(list.size());
        return list;
    }

    public static ArrayList<BaseItem> createPlantList(int count, int coordX, int coordY) {
        ArrayList<BaseItem> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(createPlant(coordX, coordY));
        }
        return list;
    }

    public static Plant createPlant(int x, int y) {
        return new Herb(x, y);
    }


}
