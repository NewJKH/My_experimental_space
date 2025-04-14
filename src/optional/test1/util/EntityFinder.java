package optional.test1.util;

import optional.test1.domain.common.Entity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityFinder {
    private final List<Entity> entities;

    public EntityFinder(List<Entity> entities) {
        this.entities = entities;
    }


    public Optional<List<Entity>> getEntities() {
        return entities.isEmpty()
                ? Optional.empty()
                : Optional.of(entities);
    }

    public <T extends Entity> Optional<List<T>> getEntities(Class<T> type) {
        List<T> filtered = entities.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .collect(Collectors.toList());

        return filtered.isEmpty()
                ? Optional.empty()
                : Optional.of(filtered);
    }
}

