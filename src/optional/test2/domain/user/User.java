package optional.test2.domain.user;

public class User {
    private final int userUnique;
    private double account;
    private final Cart cart;

    public User(int userUnique, double account) {
        this.userUnique = userUnique;
        this.account = account;
        this.cart = new Cart();
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

    public Cart getCart() {
        return cart;
    }
}
