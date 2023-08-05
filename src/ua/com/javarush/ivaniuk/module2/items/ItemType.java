package ua.com.javarush.ivaniuk.module2.items;

public enum ItemType {
    BEAR("Bear"),
    BOA("Boa"),
    EAGLE("Eagle"),
    FOX("Fox"),
    WOLF("Wolf"),
    BOAR("Boar"),
    BUFFALO("Buffalo"),
    CATERPILLAR("Caterpillar"),
    DEER("Deer"),
    DUCK("Duck"),
    GOAT("Goat"),
    HORSE("Horse"),
    MOUSE("Mouse"),
    RABBIT("Rabbit"),
    SHEEP("Sheep"),
    HERB("Herb");

    private final String TITLE;

    ItemType(String title) {
        this.TITLE = title;
    }

    public String getTITLE() {
        return TITLE;
    }

}
