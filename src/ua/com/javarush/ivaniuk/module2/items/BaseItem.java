package ua.com.javarush.ivaniuk.module2.items;

import lombok.Getter;
import lombok.Setter;
import ua.com.javarush.ivaniuk.module2.actions.CanDie;
import ua.com.javarush.ivaniuk.module2.utility.Coords;

@Getter
@Setter
public abstract class BaseItem implements CanDie {
    private Coords coords = new Coords();
    private double weight;
    private ItemType ItemType;
    private boolean alive = true;

    public BaseItem(int x, int y) {
        coords.setX(x);
        coords.setY(y);
    }

    public void setCoords(Coords coords) {
        this.coords.setX(coords.getX());
        this.coords.setY(coords.getY());
    }

    @Override
    public void die() {
        setAlive(false);
    }

}
