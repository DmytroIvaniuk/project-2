package ua.com.javarush.ivaniuk.module2;

import ua.com.javarush.ivaniuk.module2.utility.RunGame;

public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(new RunGame());
        thread.start();
    }
}
