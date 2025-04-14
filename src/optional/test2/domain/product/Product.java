package optional.test2.domain.product;

import java.util.Optional;

public class Product {
    private final int id;
    private String name;
    private double price;
    private Review review;

    public Product(int id, String name, double price,Review review) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Optional<Review> getReview() {
        return Optional.ofNullable(review);
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
