package optional.test2.domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(int productId, int quantity) {
        for (CartItem item : items) {
            if (item.getProductId() == productId) {
                item.addQuantity(quantity);
                return;
            }
        }
        items.add(new CartItem(productId, quantity));
    }
    public Optional<CartItem> findItem(int productId) {
        return items.stream()
                .filter(item -> item.getProductId() == productId)
                .findFirst();
    }


    public void clear() {
        items.clear();
    }
}
