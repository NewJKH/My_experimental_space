package optional.test1.service;

import optional.test1.domain.common.Entity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityService {
    private final List<Entity> entities;

    public EntityService(List<Entity> entities) {
        this.entities = entities;
    }


    public Optional<List<Entity>> getEntities() {
        return Optional.ofNullable(entities.isEmpty() ? null : entities);
    }


    public <T extends Entity> Optional<List<T>> getEntities(Class<T> type) {
        List<T> filtered = entities.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .collect(Collectors.toList());

        return Optional.ofNullable(filtered.isEmpty() ? null : filtered);
    }
}

