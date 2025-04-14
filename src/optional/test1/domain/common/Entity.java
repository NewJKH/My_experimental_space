package optional.test1.domain.common;

import java.util.Optional;

public interface Entity {
    String getName();
    double getHealth();
    double getDamage();
    double getSpeed();
    Optional<Entity> getEntity();
}
