package controllers;

import dao.BusRepository;
import entities.Bus;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * //TODO add comments.
 *
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 07.10.2018
 */
@Data
@Named
@SessionScoped

public class BusStorageController implements Serializable{

    private HashMap<String, Bus> products;

    @Inject
    BusRepository busRepository;

    @PostConstruct
    public void init() {
        products = busRepository.findAll();
    }
}
