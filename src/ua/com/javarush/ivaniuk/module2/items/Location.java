package ua.com.javarush.ivaniuk.module2.items;

import lombok.Getter;
import lombok.Setter;
import ua.com.javarush.ivaniuk.module2.items.animals.Animal;
import ua.com.javarush.ivaniuk.module2.utility.Coords;
import ua.com.javarush.ivaniuk.module2.utility.Settings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Getter
@Setter
public class Location {
    private Coords locCoords;
    private Integer maxPlantCount;
    private ConcurrentMap<ItemType, ArrayList<BaseItem>> itemMap = new ConcurrentHashMap<>();
    private Map<ItemType, Integer> maxItemCountMap = new HashMap<>();

    public Location(Coords coords, Settings settings) {
        locCoords = coords;
        HashMap<String, Integer> maxValues = settings.getMaxValues();
        for (String name : maxValues.keySet()) {
            if ("maxHerb".equals(name))
                maxPlantCount = maxValues.get(name);
            if (name.startsWith("max"))
                maxItemCountMap.put(ItemType.valueOf(name.substring(3).toUpperCase()), maxValues.get(name));

        }
    }

    public ArrayList<BaseItem> getItemList(Animal animal) {
        return itemMap.get(animal.getItemType());
    }

    public ArrayList<BaseItem> getItemList(ItemType itemType) {
        return itemMap.get(itemType);
    }

    public boolean isAvailableToMove(Animal animal) {
        return itemMap.get(animal.getItemType()).size() < maxItemCountMap.get(animal.getItemType());
    }

    public int getMaxItemCount(Animal animal) {
        return maxItemCountMap.get(animal.getItemType());
    }

    public int getMaxItemCount(ItemType itemType) {
        return maxItemCountMap.get(itemType);
    }
}
