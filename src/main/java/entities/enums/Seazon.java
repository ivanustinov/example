package entities.enums;

import java.util.HashMap;

/**
 * //TODO add comments.
 *
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 21.09.2018
 */
public enum Seazon {
    SUMMER, WINTER;
    private static final HashMap<Seazon, String> MAP = new HashMap<>();

    static  {
        MAP.put(SUMMER, "Лето");
        MAP.put(WINTER, "Зима");
    }

    @Override
    public String toString() {
        return MAP.get(Seazon.valueOf(this.name()));
    }
}
