package ua.com.javarush.ivaniuk.module2.items.animals;

import lombok.Getter;
import lombok.Setter;
import ua.com.javarush.ivaniuk.module2.items.BaseItem;

@Getter
@Setter
public abstract class Animal extends BaseItem {
    private int speed;
    private double maxSatiety;
    private double satiety;
    private int daysWithoutFood = 0;
    private final double HUNGER = 0.8;

    public Animal(int x, int y) {
        super(x, y);
    }


    public void starve() {
        setDaysWithoutFood(getDaysWithoutFood() + 1);
        setSatiety(Math.floor(getSatiety() * HUNGER));
    }

}
