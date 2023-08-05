package ua.com.javarush.ivaniuk.module2.utility;

import lombok.Getter;

@Getter

public class Statistics {
    private static Integer startAnimalCount = 0;
    private static Integer currentAnimalCount = 0;
    private static Integer starveDeathCount = 0;
    private static Integer eatenCount = 0;
    private static Integer birthCount = 0;
    private static Integer days = 0;

    public static void incrementCurrentAnimalCount() {
        currentAnimalCount++;
    }

    public static void decrementCerrentAnimalCount() {
        currentAnimalCount--;
    }

    public static int getCurrentAnimalCount() {
        return currentAnimalCount;
    }


    public static void incrementStarveDeathCount() {
        starveDeathCount++;
    }

    public static void incrementEatenCount() {
        eatenCount++;
    }

    public static void incrementBirthCount() {
        birthCount++;
    }

    public static void increaseStartAnimalCount(int count) {
        startAnimalCount += count;
    }

    public static Integer getStartAnimalCount() {
        return startAnimalCount;
    }

    public static Integer getStarveDeathCount() {
        return starveDeathCount;
    }

    public static Integer getEatenCount() {
        return eatenCount;
    }

    public static Integer getBirthCount() {
        return birthCount;
    }

    public static Integer getDiffStartEndAnimalCount() {
        return Math.abs(startAnimalCount - currentAnimalCount);
    }

    public static Integer getDays() {
        return days;
    }
    public static void incrementDays(){
        days++;
    }
}




