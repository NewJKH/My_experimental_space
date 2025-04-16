package optional.test2.domain.user;

public class User {
    private final int userUnique;
    private double account;

    public User(int userUnique, double account) {
        this.userUnique = userUnique;
        this.account = account;
    }

    public int getUserUnique() {
        return userUnique;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }
}
