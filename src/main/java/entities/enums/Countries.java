package entities.enums;

import java.util.HashMap;

/**
 * //TODO add comments.
 *
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 04.10.2018
 */
public enum Countries {
    USA("USA"), FINLAND("Finland");
    private String string;

    Countries(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;

    }
}
