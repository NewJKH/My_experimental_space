package optional.test2.domain.product;

import java.util.Date;

public class Review {
    private final int userId;

    private int star;
    private String content;
    private Date currentDate;

    public Review(int userId, int star, String content, Date currentDate) {
        this.userId = userId;
        this.star = star;
        this.content = content;
        this.currentDate = currentDate;
    }

    public int getUserId() {
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
