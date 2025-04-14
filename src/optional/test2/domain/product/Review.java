package optional.test2.domain.product;

import java.util.Date;
import java.util.UUID;

public class Review {
    private final UUID userId;
    private final int productId;

    private int star;
    private String content;
    private Date currentDate;

    public Review(UUID userId, int id, int star, String content, Date currentDate) {
        this.userId = userId;
        this.productId = id;
        this.star = star;
        this.content = content;
        this.currentDate = currentDate;
    }

    public int getProductId() {
        return productId;
    }

    public UUID getUserId() {
        return userId;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}
