package optional.test1;

import optional.test1.domain.animal.Animal;
import optional.test1.domain.animal.Dog;
import optional.test1.domain.animal.Pig;
import optional.test1.domain.common.Entity;
import optional.test1.util.EntityFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
    private final EntityFinder finder;

    public OptionalTest() {
        List<Entity> entities = new ArrayList<>();

        entities.add(new Dog("개",10,2,10));
        entities.add(new Pig("돼지",5,0,5));
        finder = new EntityFinder(entities);
    }
    public void start(){
        Optional<List<Animal>> animal = finder.getEntities(Animal.class);

        if ( animal.isPresent()){
            System.out.println("값이 존재");
        }else{
            System.out.println("값이 X");
        }
    }

}
