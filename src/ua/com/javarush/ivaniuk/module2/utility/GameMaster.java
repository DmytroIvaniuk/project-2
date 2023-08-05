package ua.com.javarush.ivaniuk.module2.utility;

import ua.com.javarush.ivaniuk.module2.items.BaseItem;
import ua.com.javarush.ivaniuk.module2.items.IslandMap;
import ua.com.javarush.ivaniuk.module2.items.ItemType;
import ua.com.javarush.ivaniuk.module2.items.animals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static ua.com.javarush.ivaniuk.module2.items.ItemType.HERB;

public class GameMaster {
    private final static int FROM_MAX_ANIMAL_PER_LOC = 2;
    private IslandMap islandMap;

    public GameMaster(IslandMap islandMap) {
        this.islandMap = islandMap;
    }


    public void setItemsOnIsland() {
        for (int i = 0; i < islandMap.getISLAND_WIDTH(); i++) {
            for (int j = 0; j < islandMap.getISLAND_HEIGHT(); j++) {
                Map<ItemType, Integer> maxItemCount = islandMap.getLoc(i, j).getMaxItemCountMap();
                for (Map.Entry<ItemType, Integer> entry : maxItemCount.entrySet()) {
                    ItemType itemType = entry.getKey();
                    int animalCount = HERB.equals(itemType) ? entry.getValue() : entry.getValue() / FROM_MAX_ANIMAL_PER_LOC;
                    islandMap.getLoc(i, j).getItemMap().put(itemType, ItemCreator.createAnimalList(itemType, animalCount, i, j));
                }
            }
        }
    }

    public void setPlantsOnIsland() {
        for (int i = 0; i < islandMap.getISLAND_WIDTH(); i++) {
            for (int j = 0; j < islandMap.getISLAND_HEIGHT(); j++) {
                int maxPlantCount = islandMap.getLoc(i, j).getMaxPlantCount();
                islandMap.getLoc(i, j).getItemMap().put(HERB, ItemCreator.createPlantList(maxPlantCount, i, j));
            }
        }
    }

    public void breedAllAnimals() {
        for (int i = 0; i < islandMap.getISLAND_WIDTH(); i++) {
            for (int j = 0; j < islandMap.getISLAND_HEIGHT(); j++) {
                Map<ItemType, ArrayList<BaseItem>> animalMap = islandMap.getLoc(i, j).getItemMap();
                for (Map.Entry<ItemType, ArrayList<BaseItem>> entry : animalMap.entrySet()) {
                    if (entry.getKey().equals(HERB))
                        continue;
                    ArrayList<BaseItem> value = entry.getValue();
                    int countOfOneKindAnimals = value.size();
                    for (int k = value.size() - 1; k >= 0; k -= 2) {
                        if (value.get(k).isAlive() && value.size() < islandMap.getLoc(i, j).getMaxItemCount(entry.getKey()))
                            breed(value.get(k));
                    }
                }
            }
        }
    }

    public void breed(BaseItem item) {
        addAnimalOnLoc(item.getItemType(), item.getCoords().getX(), item.getCoords().getY());
        Statistics.incrementBirthCount();
    }

    public void addAnimalOnLoc(ItemType itemType, int coordX, int coordY) {
        BaseItem animal = ItemCreator.createAnimal(itemType, coordX, coordY);
        islandMap.getLoc(coordX, coordY).getItemList(itemType).add(animal);
        Statistics.incrementCurrentAnimalCount();
    }

    public void moveAndDeleteAnimals() {
        for (int i = 0; i < islandMap.getISLAND_WIDTH(); i++) {
            for (int j = 0; j < islandMap.getISLAND_HEIGHT(); j++) {
                Map<ItemType, ArrayList<BaseItem>> animalMap = islandMap.getLoc(i, j).getItemMap();
                for (Map.Entry<ItemType, ArrayList<BaseItem>> entry : animalMap.entrySet()) {
                    if (entry.getKey().equals(HERB))
                        continue;
                    ArrayList<BaseItem> value = entry.getValue();
                    for (int k = value.size() - 1; k >= 0; k--) {
                        isStarve(value.get(k));
                        if (value.get(k).isAlive())
                            changeLocation(value.get(k));
                        else {
                            value.remove(k);
                            Statistics.decrementCerrentAnimalCount();
                        }
                    }

                }
            }
        }
    }

    public void allEat() {
        for (int i = 0; i < islandMap.getISLAND_WIDTH(); i++) {
            for (int j = 0; j < islandMap.getISLAND_HEIGHT(); j++) {
                Map<ItemType, ArrayList<BaseItem>> animalMap = islandMap.getLoc(i, j).getItemMap();
                for (Map.Entry<ItemType, ArrayList<BaseItem>> entry : animalMap.entrySet()) {
                    if (entry.getKey().equals(HERB))
                        continue;
                    ArrayList<BaseItem> value = entry.getValue();
                    for (int k = value.size() - 1; k >= 0; k--) {
                        if (value.get(k).isAlive())
                            eat(value.get(k));
                    }

                }
            }
        }
    }


    public <T extends BaseItem> void changeLocation(T item) {
        Animal animal = (Animal) item;
        if (!animal.isAlive()) {
            return;
        }
        boolean move = false;
        Coords nextCoords = new Coords();
        Coords oldCoords = animal.getCoords();
        for (int i = 0; i < 5; i++) {
            int origin, bound;
            origin = -animal.getSpeed();
            bound = animal.getSpeed() + 1;
            ThreadLocalRandom random = ThreadLocalRandom.current();
            int randomX = random.nextInt(origin, bound);
            origin = -(animal.getSpeed() - Math.abs(randomX));
            bound = Math.abs(origin);
            int randomY = origin == bound ? 0 : random.nextInt(origin, bound);
            nextCoords.setX(animal.getCoords().getX() + randomX);
            nextCoords.setY(animal.getCoords().getY() + randomY);
            if (isInsideBounds(nextCoords, islandMap) && !sameCoords(animal, nextCoords)
                    && isLocAvailableToMove(animal, nextCoords)) {
                animal.setCoords(nextCoords);
                move = true;
                break;
            }
        }
        if (move) {
            moveAnimalToNextLoc(animal);
            removeAnimalFromPreviousLoc(animal, oldCoords);
        }
    }

    public <T extends BaseItem> void eat(T item) {
        Animal hunter = (Animal) item;
        ItemType preyType;
        List<ItemType> availableToEat = getAvailableItemsToEat(hunter);
        if (availableToEat.size() == 0) {
            hunter.starve();
            return;
        }
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int startOfRange = 1;
        int endOfRange = 101;
        int chanceToEat = random.nextInt(startOfRange, endOfRange);
        int origin = 0;
        int bound = availableToEat.size();
        int preySelect;
        preySelect = random.nextInt(origin, bound);
        preyType = availableToEat.get(preySelect);
        ArrayList<BaseItem> preyList = islandMap.getLoc(hunter.getCoords()).getItemList(preyType);
        if (preyList.size() == 0) {
            hunter.starve();
            return;
        }
        BaseItem prey = preyList.get(random.nextInt(preyList.size()));
        if (prey.isAlive() && chanceToEat <= FoodMap.chanceToEat(hunter, prey)) {
            double satiety = hunter.getSatiety() + prey.getWeight();
            hunter.setSatiety(Math.min(satiety, hunter.getMaxSatiety()));
            prey.die();
            if (!HERB.equals(preyType))
                Statistics.incrementEatenCount();
            hunter.setDaysWithoutFood(0);
        } else {
            hunter.starve();
        }
    }

    private void isStarve(BaseItem item) {
        Animal animal = (Animal) item;
        if (animal.getSatiety() == 0) {
            animal.die();
            Statistics.incrementStarveDeathCount();
        }
    }

    private List<ItemType> getAvailableItemsToEat(BaseItem animal) {
        List<ItemType> availableToEat;
        Set<ItemType> animalsOnLoc = islandMap.getLoc(animal.getCoords()).getItemMap().keySet();
        Set<ItemType> preyFilter = FoodMap.preyFilter(animal);
        availableToEat = animalsOnLoc.stream()
                .filter(preyFilter::contains)
                .collect(Collectors.toList());
        return availableToEat;
    }

    private boolean isInsideBounds(Coords coords, IslandMap islandMap) {
        return coords.getX() >= 0 && coords.getX() < islandMap.getISLAND_WIDTH() &&
                coords.getY() >= 0 && coords.getY() < islandMap.getISLAND_HEIGHT();
    }

    private void moveAnimalToNextLoc(Animal animal) {
        islandMap.getLoc(animal.getCoords()).getItemList(animal).add(animal);
    }

    private void removeAnimalFromPreviousLoc(Animal animal, Coords coords) {
        islandMap.getLoc(coords).getItemList(animal).remove(animal);
    }

    private boolean sameCoords(Animal animal, Coords coords) {
        return animal.getCoords().getX() == coords.getX() && animal.getCoords().getY() == coords.getY();
    }

    private boolean isLocAvailableToMove(Animal animal, Coords coords) {
        return islandMap.getLoc(coords).getItemList(animal).size()
                < islandMap.getLoc(coords).getMaxItemCount(animal);
    }
}
