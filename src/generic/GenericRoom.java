package generic;

import generic.multi.Pair;
import generic.single.Box;
import generic.test.first.controller.PaymentController;

public class GenericRoom {
    public void enable(){
//        single(); 제네릭
//        multi(); 복수 제네릭

        pay();

    }
    private void single(){
        Box<String> strBox = new Box<>("TEST");
        Box<Integer> intBox = new Box<>(123);

        System.out.println(" single Generic : STR BOX "+strBox.getValue());
        System.out.println(" single Generic : INT BOX "+intBox.getValue());
    }
    private void multi(){
        Pair<String,Integer> pair1 = new Pair<>("TEST PAIR ",1123);
        System.out.println(" single Generic : KEY BOX "+pair1.getKey());
        System.out.println(" single Generic : VAL BOX "+pair1.getValue());
    }
    private void pay(){
        PaymentController controller = new PaymentController();
        controller.pay();
    }
}
