package ua.com.javarush.ivaniuk.module2.utility;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coords {
    private int x;
    private int y;

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coords() {
    }

}
