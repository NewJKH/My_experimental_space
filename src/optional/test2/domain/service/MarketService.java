package optional.test2.domain.service;

import optional.test2.domain.product.Category;
import optional.test2.domain.product.Product;
import optional.test2.domain.product.Review;
import optional.test2.domain.user.Cart;
import optional.test2.domain.user.CartItem;
import optional.test2.domain.user.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MarketService {
    private final Map<Integer, Product> productStore = new HashMap<>();
    private final Map<Integer, User> userStore = new HashMap<>();

    private int orderSequence = 1;

    public MarketService() {
        productStore.put(1, new Product(1, Category.TOY,"키보드", 50000, null));
        productStore.put(2, new Product(2,  Category.TOY,"마우스", 30000, null));
        userStore.put(100, new User(100, 100000));
    }

    /**
     * @param userId < Optional 처리를 안하고 직접 null 처리시도
     * @param productId < Optional 처리를 하고 내부에서 null 처리 시도
     * @param ea < 갯수
     */
    public void addToCart(int userId, int productId, int ea) {
        User user = userStore.get(userId);
        if (user == null) {
            System.out.println("사용자를 찾을 수 없습니다.");
            return;
        }

        Optional<Product> productOpt = Optional.ofNullable(productStore.get(productId));
        if (productOpt.isEmpty()) {
            System.out.println("상품이 존재하지 않습니다.");
            return;
        }

        user.getCart().addItem(productId,ea);
        System.out.println("장바구니에 상품이 추가되었습니다.");
    }

    /**
     * @param userId < 유저의 정보
     * 현재 유저의 장바구니 정보를 출력 IF 만약 여기서 상품이 오래되어 장바구니에 있던 상품이 사라질 경우를 대비
     */
    public void printCart(int userId) {
        User user = userStore.get(userId);
        if (user == null) return;

        System.out.println("장바구니 목록:");
        for (CartItem cartItem : user.getCart().getItems()) {
            int productId = cartItem.getProductId();
            int qty = cartItem.getQuantity();

//            Optional<Product> productOpt = Optional.ofNullable(productStore.get(productId));
//            if (productOpt.isEmpty()) {
//                System.out.println("  (삭제된 상품) ");
//                continue;
//            }
//
//            Product product = productOpt.get();
//            System.out.println(" -"+ product.getName()+" "+qty+" "+((int) product.getPrice()));
            Optional.ofNullable(productStore.get(productId))
                    .ifPresentOrElse(
                            product -> System.out.println(" -"+ product.getName()+" "+qty+" "+((int) product.getPrice())),
                            () -> System.out.println("  (삭제된 상품) ")
                    );
        }
    }

    /**
     * @param userId < 유저의 정보
     * 상품 구매 메서드
     */
    public void processCheckout(int userId) {
        User user = userStore.get(userId);
        if (user == null) return;

        Cart cart = user.getCart();
//        int total = cart.getItems().stream()
//                .map(cartItem -> Optional.ofNullable(productStore.get(cartItem.getProductId()))
//                        .map(product -> (int) (product.getPrice() * cartItem.getQuantity()))
//                        .orElse(0))
//                .mapToInt(Integer::intValue)
//                .sum();

        int total = 0;

        for (CartItem cartItem : cart.getItems()) {
            int productId = cartItem.getProductId();
            int quantity = cartItem.getQuantity();

            Optional<Product> productOpt = Optional.ofNullable(productStore.get(productId));
            if (productOpt.isPresent()) {
                Product product = productOpt.get();
                total += (int) (product.getPrice() * quantity);
            } else {
                System.out.println(" 삭제된 상품 (productId: " + productId + ") 은 결제에서 제외되었음.");
            }
        }

        if (user.getAccount() < total) {
            System.out.println("잔액 부족. 주문 실패.");
            return;
        }

        user.setAccount(user.getAccount() - total);
        cart.clear();
        int orderId = orderSequence++;
        System.out.printf("주문 완료! 주문번호 #%d, 결제 금액 ₩%,d\n", orderId, total);
    }
    /**
     * @param userId < 작성자
     * @param productId < 물건
     * @param star < 별점
     * @param content 내용
     *
     *                테스트용이라 상품당 1개의 리뷰만 달 수 있게 설정되었습니다.
     *                즉 1개의 상품에는 1개의 리뷰만 가능 합니다
     */
    public void writeReview(int userId, int productId, int star, String content) {

        if (!userStore.containsKey(userId)) {
            System.out.println("유저가 존재하지 않습니다.");
            return;
        }
        Optional<Product> product = Optional.ofNullable(productStore.get(productId));
        product.ifPresentOrElse(p -> {
            Review review = new Review(userId, p.getId(), star, content, new Date());
            p.setReview(review);
        },()-> System.out.println("상품이 존재하지 않습니다."));
    }

    /**
     * @param productId < 상품
     */
    public void printReview(int productId) {
        Optional<Product> productOpt = Optional.ofNullable(productStore.get(productId));
        if (productOpt.isPresent()) {
            Optional<Review> r = productOpt.get().getReview();
            r.ifPresent(review -> {
                System.out.println(" 상품 : "+productId+" "+ review.getContent());
            });
        } else {
            System.out.println("리뷰가 없습니다.");
        }
    }
}
