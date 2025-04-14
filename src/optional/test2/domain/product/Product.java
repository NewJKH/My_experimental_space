package optional.test2.domain.product;

import java.util.Optional;

public class Product {
    private final int id;
    private Category category;
    private String name;
    private double price;
    private Review review;

    public Product(int id, Category category, String name, double price,Review review) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
