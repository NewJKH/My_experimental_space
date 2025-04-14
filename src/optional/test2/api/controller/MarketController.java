package optional.test2.api.controller;

import optional.test2.domain.service.MarketService;

public class MarketController {
    private MarketService service;

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

    public void writeReview(int orderId, int rating, String content) {
        service.saveReview(orderId, rating, content);
    }

    public void viewReview(int orderId) {
        service.printReview(orderId);
    }


}
