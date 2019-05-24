package dao;

import entities.AbstractEntity;
import entities.Bus;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static entities.enums.Manufacturer.BRIDGESTONE;
import static entities.enums.Radius.*;
import static entities.enums.Seazon.SUMMER;
import static entities.enums.Seazon.WINTER;


/**
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 18.09.2018
 */
@Data
@ApplicationScoped
@Named
public class BusRepository implements AbstractDAO {
    private final LinkedHashMap<String, Bus> busStorage = new LinkedHashMap<>();

    @PostConstruct
    private void init() {
        Bus one = new Bus(BRIDGESTONE, SUMMER, R15C, "613V", 195, 70, 1000, "");
        Bus two = new Bus(BRIDGESTONE, SUMMER, R16, "Alenza 001", 215, 65, 900, "");
        Bus three = new Bus(BRIDGESTONE, SUMMER, R13, "B250", 165, 70, 1200, "");
        Bus four = new Bus(BRIDGESTONE, WINTER, R13, "Blizzak DM-V1", 225, 65, 1600, "");
        Bus five = new Bus(BRIDGESTONE, WINTER, R15, "Blizzak DM-V2", 205, 70, 1800, "");
        Bus six = new Bus(BRIDGESTONE, WINTER, R18, "Blizzak DM-Z3", 225, 65, 1200, "");
        busStorage.put(one.getId(), one);
        busStorage.put(two.getId(), two);
        busStorage.put(three.getId(), three);
        busStorage.put(four.getId(), four);
        busStorage.put(five.getId(), five);
        busStorage.put(six.getId(), six);

    }


    @Override
    public HashMap<String, Bus> findAll() {
        return busStorage;
    }

    @Override
    public Bus findEntityById(String id) {
        return busStorage.get(id);
    }

    @Override
    public String delete(String id) {
        busStorage.remove(id);
        return "edit-busStorage";
    }

    @Override
    public void clear() {
        busStorage.clear();
    }

    @Override
    public boolean delete(AbstractEntity entity) {
        return false;
    }


    @Override
    public void add(AbstractEntity entity) {
        Bus bus = (Bus) entity;
        busStorage.put(bus.getId(),bus);
    }

    @Override
    public AbstractEntity update(AbstractEntity entity) {
        return null;
    }
}
