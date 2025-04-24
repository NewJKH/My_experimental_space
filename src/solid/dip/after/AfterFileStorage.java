package solid.dip.after;

public class AfterFileStorage implements AfterStorage {
    @Override
    public void save(String data) {
        System.out.println("파일에 저장: " + data);
    }
}
