package anonymous;

public class AnonyTest {
    public void start(){
    Animal dog = new Animal() {
        @Override
        public void bark() {
            System.out.println("멍멍");
        }
    };
    dog.bark();
    }
}
