package generic;

import generic.multi.Pair;
import generic.single.Box;
import generic.test.first.controller.PaymentController;
import generic.test.second.wildcard.WildCardPractice;

import java.util.ArrayList;
import java.util.List;

public class GenericRoom {
    public void enable(){
//        single(); 제네릭
//        multi(); 복수 제네릭

//        pay();
        wildcard();
    }
    private void single(){
        Box<String> strBox = new Box<>("TEST");
        Box<Integer> intBox = new Box<>(123);

        System.out.println(" single Generic : STR BOX "+strBox.getValue());
        System.out.println(" single Generic : INT BOX "+intBox.getValue());
    }
    private void multi(){
        Pair<String,Integer> pair1 = new Pair<>("TEST PAIR ",1123);
        System.out.println(" multi Generic : KEY BOX "+pair1.getKey());
        System.out.println(" multi Generic : VAL BOX "+pair1.getValue());
    }
    private void pay(){
        PaymentController controller = new PaymentController();
        controller.pay();
    }
    private void wildcard(){
        List<Box<?>> boxs = new ArrayList<>();
        Box<?> box = new Box<>("TEST");
        Box<?> box1 = new Box<>(1);
        Box<?> box2 = new Box<>(3.5);
        boxs.add(box);
        boxs.add(box1);
        boxs.add(box2);

        WildCardPractice practice = new WildCardPractice();
        practice.cast(boxs);

    }
}
