package optional.test2.domain.cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(int productId, int ea) {
        for (CartItem item : items) {
            if (item.getProductId() == productId) {
                item.addQuantity(ea);
                return;
            }
        }
        items.add(new CartItem(productId, ea));
    }

    public void removeItem(int productId) {
        items.removeIf(item -> item.getProductId() == productId);
    }

}
