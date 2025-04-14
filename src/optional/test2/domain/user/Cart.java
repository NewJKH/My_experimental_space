package optional.test2.domain.user;

public class Cart {
    private int productId;
    private int ea;

    public Cart(int productId, int ea) {
        this.productId = productId;
        this.ea = ea;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getEa() {
        return ea;
    }

    public void setEa(int ea) {
        this.ea = ea;
    }
}
