package controllers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * //TODO add comments.
 *
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 07.10.2018
 */
@Named
@SessionScoped
public class ExperimentBean implements Serializable{
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public long timestamp() {
        return System.currentTimeMillis();
    }
}
