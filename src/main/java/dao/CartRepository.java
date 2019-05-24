package dao;

import entities.Bus;
import lombok.Data;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 19.09.2018
 */
@Data
@SessionScoped
public class CartRepository implements Serializable {
    private final LinkedHashMap<String, Integer> cartStorage = new LinkedHashMap<>();



    public HashMap<String, Integer> findAll() {
        return cartStorage;
    }


    public void deleteEntity(String id) {
        cartStorage.remove(id);
    }

    public void delete(String id) {
        Integer count = cartStorage.get(id);
        if (count == null) {
            count = 0;
        } else if (count > 0) {
            count--;
        }
        cartStorage.put(id, count);
    }
    public int calcTotalNumber(HashMap<String, Integer> cart) {
        int totalNumber = 0;
        for (Integer count : cart.values()) {
            totalNumber += count;
        }
        return totalNumber;
    }

    public double calcTotalSumm(HashMap<String, Integer> cart, HashMap<String, Bus> list) {
        double totalSumm = 0;
        System.out.println(cart.size());
        if (cart.size() != 0) {
            for (String s : cart.keySet()) {
                int number = cart.get(s);
                double price = list.get(s).getPrice();
                totalSumm += (number * price);
            }
        }
        return totalSumm;
    }
    public void clear() {
        cartStorage.clear();
    }

    public void add(String id) {
        Integer count = cartStorage.get(id);
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        cartStorage.put(id, count);
    }

}
