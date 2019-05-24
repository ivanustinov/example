package dao;

import entities.AbstractEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 18.09.2018
 */
public interface AbstractDAO<K extends String, T extends AbstractEntity> {

    HashMap<K, T> findAll();

    T findEntityById(K id);

    String delete(K id);

    boolean delete(T entity);

    void add(T entity);

    void clear();

    T update(T entity);
}
