package optional.test2.api.controller;

import optional.test2.domain.service.MarketService;

public class MarketController {
    private MarketService service;

    public MarketController(MarketService service) {
        this.service = service;
    }

    public void addToCart(int userId, int productId, int quantity){

    }

}
