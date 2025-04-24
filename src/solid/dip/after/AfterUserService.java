package solid.dip.after;

public class AfterUserService {
    private final AfterStorage afterStorage;
    public AfterUserService(AfterStorage afterStorage) {
        this.afterStorage = afterStorage;
    }
    public void save(String data) {
        afterStorage.save(data);
    }

}
