package dao;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 21.09.2018
 */
@Data
@ApplicationScoped
public class ImageRepository {
    private final LinkedHashMap<String, String> imageStorage = new LinkedHashMap();

    @PostConstruct
    private void init() {
        imageStorage.put("613V", "WEB-INF/images/613v.jpg");
        imageStorage.put("Alenza 001", "WEB-INF/images/alenza_001.jpg");
        imageStorage.put("B250", "WEB-INF/images/b250.jpg");
        imageStorage.put("Blizzak DM-V1", "WEB-INF/images/blizzak_dm_v1.jpg");
        imageStorage.put("Blizzak DM-V2", "WEB-INF/images/blizzak_dm_v2.jpg");
        imageStorage.put("Blizzak DM-Z3", "WEB-INF/images/blizzak_dm_v3.jpg");
    }

    public String getImage(String model) {
       return imageStorage.get(model);
    }
}
