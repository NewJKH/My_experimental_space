package optional.test2.repository;

import optional.test2.domain.cart.Cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CartRepository {
    /**
     * 장바구니 저장소
     */
    private final Map<Integer, Cart> carts;

    public CartRepository() {
        carts = new HashMap<>();
    }

    public Optional<Cart> getCart(int userId){
        return Optional.ofNullable(carts.get(userId));
    }

    public void saveCart(int userId, Cart cart) {
        carts.put(userId, cart);
    }


    public void removeAll(int userId) {
        carts.remove(userId);
    }

}
