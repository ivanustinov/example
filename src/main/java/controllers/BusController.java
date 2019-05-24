package controllers;

import dao.BusRepository;
import entities.*;
import entities.enums.Countries;
import entities.enums.Manufacturer;
import entities.enums.Radius;
import entities.enums.Seazon;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

import static entities.enums.Countries.FINLAND;
import static entities.enums.Countries.USA;
import static entities.enums.Manufacturer.*;
import static entities.enums.Radius.*;
import static entities.enums.Seazon.SUMMER;
import static entities.enums.Seazon.WINTER;

/**
 * //TODO add comments.
 *
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 03.10.2018
 */
@Data
@Named
@SessionScoped
public class BusController implements Serializable {
    private Map<String, List<Manufacturer>> countr_manufacturer = new HashMap<>();
    private List<String> countries;
    private String country;
    private List<Manufacturer> manufacturers;
    private Manufacturer manufacturer;
    private List<Seazon> seazons = new LinkedList<>();
    private Seazon seazon;
    private ArrayList<Radius> radiuses = new ArrayList<>();
    private ArrayList<Integer> widths = new ArrayList<>();
    private Radius radius;
    private String model;
    private int width;
    private int profile_height = 60;
    private String data;
    private Double price;


    @Inject
    BusRepository busRepository;

    @PostConstruct
    public void init() {
        countries = new ArrayList<>();
        countries.add(FINLAND.toString());
        countries.add(USA.toString());

        List<Manufacturer> list = new ArrayList<>();
        list.add(NOKIAN);
        list.add(NORDMAN);
        countr_manufacturer.put(FINLAND.toString(), list);

        list = new ArrayList<>();
        list.add(BRIDGESTONE);
        list.add(COOPER);
        list.add(GOODYEAR);
        countr_manufacturer.put(USA.toString(), list);

        seazons.add(SUMMER);
        seazons.add(WINTER);

        radiuses.add(R15);
        radiuses.add(R13);
        radiuses.add(R15C);
        radiuses.add(R16);

        for (int i = 115; i < 340; ) {
            widths.add(i);
            i += 5;
        }
    }

    public void onCountryChange() {
        if (country != null && !country.equals("")) {
            manufacturers = countr_manufacturer.get(country);
        } else {
            manufacturers = new ArrayList<>();
        }
    }


    public void displayLocation() {
        FacesMessage msg = new FacesMessage(String.format("Bus created: %s %s %s %s %s/%s %s", manufacturer,
                seazon, model, width, profile_height, radius, data));
        busRepository.add(new Bus(manufacturer, seazon, radius, model, width, profile_height, price, data));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}

