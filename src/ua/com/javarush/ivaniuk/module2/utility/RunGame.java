package ua.com.javarush.ivaniuk.module2.utility;

import ua.com.javarush.ivaniuk.module2.items.IslandMap;

public class RunGame implements Runnable {

    @Override
    public void run() {
        Settings settings = new Settings();
        IslandMap islandMap = new IslandMap(settings);
        GameMaster gameMaster = new GameMaster(islandMap);

        gameMaster.setItemsOnIsland();

        for (int i = 0; i < 20; i++) {
            Statistics.incrementDays();
            gameMaster.allEat();
            gameMaster.breedAllAnimals();
            gameMaster.moveAndDeleteAnimals();
            PrintStatistics.printStatistic();
            gameMaster.setPlantsOnIsland();
        }
    }

}
