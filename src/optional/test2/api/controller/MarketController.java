package optional.test2.api.controller;

import optional.test2.domain.service.MarketService;

public class MarketController {
    private final MarketService service;

    public MarketController(MarketService service) {
        this.service = service;
    }

    public void addProductToCart(int userId, int productId, int quantity) {
        service.addToCart(userId, productId, quantity);
    }

    public void showCart(int userId) {
        service.printCart(userId);
    }

    public void checkout(int userId) {
        service.processCheckout(userId);
    }
    public void findItem(int userId, int productId){
        service.findItem(userId, productId);
    }
    public void writeReview(int userId, int productId, int rating, String content) {
        service.writeReview(userId, productId, rating, content);
    }

    public void viewReview(int orderId) {
        service.printReview(orderId);
    }


}
