import threadasync.CookMachine;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        new GenericRoom().enable();
//        new ProMachine().boot();
        new CookMachine().start();
    }
}