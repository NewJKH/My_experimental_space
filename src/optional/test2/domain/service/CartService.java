package optional.test2.domain.service;

import optional.test2.domain.cart.Cart;
import optional.test2.domain.product.Product;
import optional.test2.domain.user.User;
import optional.test2.repository.CartRepository;
import optional.test2.repository.ProductRepository;
import optional.test2.repository.UserRepository;

import java.util.Optional;

public class CartService {
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartService(
            UserRepository userRepository,
            CartRepository cartRepository,
            ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }


    public void addToCart(int userId, int productId, int ea) {
        Optional<User> userOpt = userRepository.getUser(userId);
        if (userOpt.isEmpty()){
            System.out.println(" 존재하지 않는 회원입니다. ");
            return;
        }

        Optional<Product> productOpt = productRepository.getProduct(productId);
        if (productOpt.isEmpty()){
            System.out.println(" 존재하지 않는 상품입니다. ");
            return;
        }

        User user = userOpt.get();
        Product product = productOpt.get();
        cartRepository.getCart(user.getUserUnique())
                .ifPresentOrElse(
                cart -> cart.addItem(product.getId(),ea),
                     () -> System.out.println(" 장바구니가 존재하지 않습니다. ")
                );
    }


    public void printCart(int userId) {
        Optional<Cart> cartOpt = cartRepository.getCart(userId);
        System.out.println("장바구니 목록:");
        cartOpt.ifPresentOrElse(
                cart-> cart.getItems().forEach(cartItem -> System.out.println("물건 번호) "+cartItem.getProductId()+" + "+cartItem.getQuantity()+" 개"))
                ,()->System.out.println(" 유저의 장비구니를 찾지못했습니다. ")
        );
    }


    public void removeFromCart(int userId, int productId){
        Optional<User> userOpt = userRepository.getUser(userId);
        if (userOpt.isEmpty()){
            System.out.println(" 존재하지 않는 회원입니다. ");
            return;
        }

        User user = userOpt.get();
        cartRepository.getCart(user.getUserUnique())
                .ifPresentOrElse(
                        cart -> {
                            cart.removeItem(productId);
                            System.out.println(" 상품이 장바구니에서 삭제되었습니다. ");
                        },
                       () -> System.out.println(" 장바구니가 존재하지 않습니다. ")
                );
    }
}
