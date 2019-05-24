package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * //TODO add comments.
 *
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 18.09.2018
 */

@Data
@NoArgsConstructor
public abstract class AbstractEntity {
    private String id = UUID.randomUUID().toString();
}
