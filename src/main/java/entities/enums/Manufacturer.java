package entities.enums;

import java.util.HashMap;

/**
 * //TODO add comments.
 *
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 21.09.2018
 */
public enum Manufacturer {
    BRIDGESTONE("Bridgestone"), GOODYEAR("Goodyear"), COOPER("Cooper"), NOKIAN("Nokiahn"), NORDMAN("Nordman");
//    private static final HashMap<Manufacturer, String> MAP = new HashMap<>();

//    static {
//        MAP.put(BRIDGESTONE, "Bridgestone");
//        MAP.put(GOODYEAR, "Goodyear");
//        MAP.put(COOPER, "Cooper");
//        MAP.put(NOKIAN, "Nokian");
//        MAP.put(NORDMAN, "Nordman");
//    }

    private String string;

    Manufacturer(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
