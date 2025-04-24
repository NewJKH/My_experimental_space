package solid.dip.after;

public class AfterDBStorage implements AfterStorage{
    @Override
    public void save(String data) {
        System.out.println("DB에 저장: " + data);
    }
}
