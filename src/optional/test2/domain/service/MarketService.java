package optional.test2.domain.service;

import optional.test2.domain.cart.Cart;
import optional.test2.domain.cart.CartItem;
import optional.test2.domain.product.Product;
import optional.test2.domain.user.User;
import optional.test2.repository.CartRepository;
import optional.test2.repository.ProductRepository;
import optional.test2.repository.UserRepository;

import java.util.Optional;

public class MarketService {
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public MarketService(
            UserRepository userRepository,
            CartRepository cartRepository,
            ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public void checkout(int userId) {
        Optional<Cart> cartOpt = cartRepository.getCart(userId);
        Optional<User> userOpt = userRepository.getUser(userId);

        if (cartOpt.isEmpty() || userOpt.isEmpty()){
            System.out.println(" 장바구니 정보가 없거나, 회원의 정보가 없습니다.");
            return;
        }
        Cart cart = cartOpt.get();
        User user = userOpt.get();

        double total = calculateTotalPrice(cart);

        if (!hasEnoughMoney(user, total)) {
            System.out.println(" 잔액 부족: 현재 잔액 " + user.getAccount() + "원");
            return;
        }

        charge(user, total);
        clearCart(userId);

        System.out.println(" 결제 완료! 남은 잔액: " + user.getAccount() + "원");
    }

    private double calculateTotalPrice(Cart cart) {
        double total = 0;
        for (CartItem item : cart.getItems()) {
            Optional<Product> productOpt = productRepository.getProduct(item.getProductId());
            if (productOpt.isEmpty()) {
                System.out.println(" 상품 ID " + item.getProductId() + " 를 찾을 수 없어 건너뜁니다.");
                continue;
            }
            total += productOpt.get().getPrice() * item.getQuantity();
        }
        return total;
    }

    private boolean hasEnoughMoney(User user, double total) {
        return user.getAccount() >= total;
    }

    private void charge(User user, double amount) {
        user.setAccount(user.getAccount() - amount);
    }

    private void clearCart(int userId) {
        cartRepository.removeAll(userId);
    }
}
