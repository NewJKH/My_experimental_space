package solid.dip.before;

public class BeforeUserService {
    private final BeforeFileStorage storage = new BeforeFileStorage();

    public void saveUser(String user) {
        storage.save(user);
    }
}
