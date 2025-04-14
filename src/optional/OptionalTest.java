package optional;

import optional.domain.animal.Dog;
import optional.domain.animal.Pig;
import optional.domain.common.Entity;
import optional.domain.monster.Monster;
import optional.domain.monster.Zombie;
import optional.service.EntityService;

import java.util.ArrayList;
import java.util.List;

public class OptionalTest {
    private final EntityService service;

    public OptionalTest() {
        List<Entity> entities = new ArrayList<>();

        entities.add(new Dog("개",10,2,10));
        entities.add(new Pig("돼지",5,0,5));
        entities.add(new Zombie("좀비",20,5,3));
        service = new EntityService(entities);
    }
    public void start(){
        service.getEntities(Monster.class);

    }

}
