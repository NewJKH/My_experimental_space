package optional.test2.domain.user;

import java.util.List;
import java.util.UUID;

public class User {
    private final UUID userUnique;
    private double account;

    private List<Cart> cart;

    public User(UUID userUnique, double account, List<Cart> cart) {
        this.userUnique = userUnique;
        this.account = account;
        this.cart = cart;
    }

    public UUID getUserUnique() {
        return userUnique;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }
}
