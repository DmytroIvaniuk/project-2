package ua.com.javarush.ivaniuk.module2.utility;

import ua.com.javarush.ivaniuk.module2.items.BaseItem;
import ua.com.javarush.ivaniuk.module2.items.ItemType;

import java.util.Arrays;
import java.util.HashSet;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.*;

;

public interface FoodMap {
    static int chanceToEat(BaseItem hunter, BaseItem prey) {
        ItemType hunterType = hunter.getItemType();
        ItemType preyType = prey.getItemType();
        if (WOLF.equals(hunterType)) {
            return switch (preyType) {
                case HORSE, BUFFALO -> 10;
                case DEER, BOAR -> 15;
                case DUCK -> 40;
                case RABBIT, GOAT -> 60;
                case SHEEP -> 70;
                case MOUSE -> 80;
                default -> 0;
            };
        } else if (BOA.equals(hunterType)) {
            return switch (preyType) {
                case DUCK -> 10;
                case FOX -> 15;
                case RABBIT -> 20;
                case MOUSE -> 40;
                default -> 0;
            };
        } else if (FOX.equals(hunterType)) {
            return switch (preyType) {
                case CATERPILLAR -> 40;
                case DUCK -> 60;
                case RABBIT -> 70;
                case MOUSE -> 90;
                default -> 0;
            };
        } else if (BEAR.equals(hunterType)) {
            return switch (preyType) {
                case DUCK -> 10;
                case BUFFALO -> 20;
                case HORSE -> 40;
                case BOAR -> 50;
                case GOAT, SHEEP -> 70;
                case RABBIT, DEER, BOA -> 80;
                case MOUSE -> 90;
                default -> 0;
            };
        } else if (EAGLE.equals(hunterType)) {
            return switch (preyType) {
                case FOX -> 10;
                case DUCK -> 80;
                case RABBIT, MOUSE -> 90;
                default -> 0;
            };
        } else if (MOUSE.equals(hunterType)) {
            return switch (preyType) {
                case CATERPILLAR -> 90;
                case HERB -> 100;
                default -> 0;
            };
        } else if (BOAR.equals(hunterType)) {
            return switch (preyType) {
                case MOUSE -> 50;
                case CATERPILLAR -> 90;
                case HERB -> 100;
                default -> 0;
            };
        } else if (DUCK.equals(hunterType)) {
            return switch (preyType) {
                case CATERPILLAR -> 90;
                case HERB -> 100;
                default -> 0;
            };
        } else if (HERB.equals(preyType)) {
            return 100;
        }
        return 0;
    }

    static HashSet<ItemType> preyFilter(BaseItem hunter) {
        ItemType hunterType = hunter.getItemType();
        HashSet<ItemType> set = new HashSet<>();
        switch (hunterType) {
            case BEAR -> set.addAll(Arrays.asList(HORSE, BUFFALO, DEER, BOAR, DUCK, RABBIT, GOAT, SHEEP, MOUSE, BOA));
            case BOA, EAGLE -> set.addAll(Arrays.asList(FOX, DUCK, RABBIT, MOUSE));
            case FOX -> set.addAll(Arrays.asList(CATERPILLAR, DUCK, RABBIT, MOUSE));
            case WOLF -> set.addAll(Arrays.asList(HORSE, BUFFALO, DEER, BOAR, DUCK, RABBIT, GOAT, SHEEP, MOUSE));
            case BOAR -> set.addAll(Arrays.asList(MOUSE, CATERPILLAR, HERB));
            case DUCK, MOUSE -> set.addAll(Arrays.asList(CATERPILLAR, HERB));
            default -> set.add(HERB);
        }
        return set;
    }

}
