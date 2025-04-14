package optional.test1;

import optional.test1.domain.animal.Dog;
import optional.test1.domain.animal.Pig;
import optional.test1.domain.common.Entity;
import optional.test1.domain.monster.Monster;
import optional.test1.service.EntityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
    private final EntityService service;

    public OptionalTest() {
        List<Entity> entities = new ArrayList<>();

        entities.add(new Dog("개",10,2,10));
        entities.add(new Pig("돼지",5,0,5));
        service = new EntityService(entities);
    }
    public void start(){
        Optional<List<Monster>> monsters = service.getEntities(Monster.class);

        if ( monsters.isPresent()){
            System.out.println("값이 존재");
        }else{
            System.out.println("값이 X");

        }


    }

}
