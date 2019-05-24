package entities;

import entities.enums.Manufacturer;
import entities.enums.Radius;
import entities.enums.Seazon;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 18.09.2018
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Bus extends AbstractEntity {

    private double price;
    private Seazon seazon;
    private String model;
    private int width;
    private int profile_height;
    private Radius radius;
    private Manufacturer manufacturer;
    private String data;

    public Bus(Manufacturer manufacturer, Seazon seazon, Radius radius, String model,
               int width, int profile_height, double price, String data) {
        this.price = price;
        this.seazon = seazon;
        this.model = model;
        this.width = width;
        this.profile_height = profile_height;
        this.radius = radius;
        this.manufacturer = manufacturer;
        this.data = data;
    }

    public String toString() {
        return String.format("%s %s %s/%s %s %s", manufacturer, model, width, profile_height, radius, data);
    }

}
