package optional.test2.api.controller;

import optional.test2.domain.service.CartService;
import optional.test2.domain.service.MarketService;
import optional.test2.domain.service.ProductService;
import optional.test2.domain.service.UserService;
import optional.test2.repository.CartRepository;
import optional.test2.repository.ProductRepository;
import optional.test2.repository.UserRepository;

public class MarketController {
    private final MarketService marketService;
    private final ProductService productService;
    private final CartService cartService;
    private final UserService userService;


    public MarketController() {
        CartRepository cartRepository = new CartRepository();
        ProductRepository productRepository = new ProductRepository();
        UserRepository userRepository = new UserRepository();

        marketService = new MarketService(userRepository,cartRepository,productRepository);
        cartService = new CartService(userRepository,cartRepository,productRepository);
        productService = new ProductService(productRepository);
        userService = new UserService(userRepository);
    }
    public void buyProduct(int userId, int productId, int ea){
        System.out.println(" 장바구니 담기");
        cartService.addToCart(userId,productId,ea);
    }
    public void addMoney(int userId, double amount){
        System.out.println(" 계좌에 금액 충전");
        userService.addMoneyByUserId(userId,amount);
    }
    public void checkout(int userId){
        System.out.println("결제 요청");
        marketService.checkout(userId);
    }
}