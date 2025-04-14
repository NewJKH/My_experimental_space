package optional.test2.domain.user;

public class CartItem {
    private final int productId;
    private int quantity;

    public CartItem(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int q) {
        this.quantity = q;
    }

    public void addQuantity(int q) {
        this.quantity += q;
    }
}
