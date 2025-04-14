package optional.test2.domain.user;

import optional.test2.domain.product.Review;

import java.util.List;
import java.util.UUID;

public class User {
    private final UUID userUnique;
    private double money;
    private List<Review> reviews;
}
