package ua.com.javarush.ivaniuk.module2.items;

import lombok.Getter;
import ua.com.javarush.ivaniuk.module2.utility.Coords;
import ua.com.javarush.ivaniuk.module2.utility.Settings;

@Getter
public class IslandMap {
    public Location[][] locations;
    private final int ISLAND_WIDTH;
    private final int ISLAND_HEIGHT;

    public IslandMap(Settings settings) {
        ISLAND_WIDTH = settings.getIslandWidth();
        ISLAND_HEIGHT = settings.getIslandHeight();
        locations = new Location[ISLAND_WIDTH][ISLAND_HEIGHT];
        for (int i = 0; i < ISLAND_WIDTH; i++) {
            for (int j = 0; j < ISLAND_HEIGHT; j++) {
                locations[i][j] = new Location(new Coords(i, j), settings);
            }
        }
    }

    public Location getLoc(Coords coords) {
        return locations[coords.getX()][coords.getY()];
    }

    public Location getLoc(int x, int y) {
        return locations[x][y];
    }

}
