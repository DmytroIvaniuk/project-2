package ua.com.javarush.ivaniuk.module2.utility;

public class PrintStatistics {
    public static void printStatistic() {
        System.out.println("***********************************");
        System.out.println("День " + Statistics.getDays() + ": ");
        System.out.println("Начальное количество животных: " + Statistics.getStartAnimalCount());
        System.out.println("Текущее количество животных: " + Statistics.getCurrentAnimalCount());
        System.out.println("Количество смертей от голода: " + Statistics.getStarveDeathCount());
        System.out.println("Количество cъеденных животных: " + Statistics.getEatenCount());
        System.out.println("Количество рожденных животных: " + Statistics.getBirthCount());
        System.out.println("Разница между текущим и начальным количеством животных: "
                + Statistics.getDiffStartEndAnimalCount());
        System.out.println("***********************************");
    }
}
