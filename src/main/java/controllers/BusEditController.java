package controllers;

import dao.BusRepository;
import entities.Bus;
import entities.enums.Manufacturer;
import lombok.Data;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static entities.enums.Manufacturer.*;


/**
 * //TODO add comments.
 *
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 06.10.2018
 */
@Data
@Named
@SessionScoped
public class BusEditController implements Serializable {
    private Bus bus;
    private String id;
    private List<Manufacturer> manufacturers = new ArrayList<>();

    @Inject
    BusRepository busRepository;

    public void init() {
        this.bus = busRepository.findEntityById(id);
        manufacturers.add(BRIDGESTONE);
        manufacturers.add(COOPER);
        manufacturers.add(GOODYEAR);
        manufacturers.add(NOKIAN);
        manufacturers.add(NORDMAN);
    }

    public void save() {
        busRepository.add(bus);
        FacesMessage msg = new FacesMessage(String.format("Changed: %s %s %s %s %s/%s %s", bus.getManufacturer(),
                bus.getSeazon(), bus.getModel(), bus.getWidth(), bus.getProfile_height(), bus.getRadius(), bus.getData()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
