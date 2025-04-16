package optional.test2.domain.service;

import optional.test2.domain.product.Category;
import optional.test2.domain.product.Product;
import optional.test2.domain.product.Review;
import optional.test2.repository.ProductRepository;

import java.util.Date;
import java.util.Optional;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(int productId, Category category, String name, double price){
        if ( !productRepository.hasById(productId) ) {
            System.out.println(" 이미 존재하는 상품 입니다. ");
            return;
        }

        if ( !productRepository.hasByName(name)){
            System.out.println(" 이미 존재하는 상품명 입니다.");
            return;
        }

        productRepository.addProducts(productId,new Product(productId, category, name, price,null));
        System.out.println(" 상품이 추가되었습니다. ");
    }

    public void removeProduct(int productId){
        productRepository.getProduct(productId)
                .ifPresentOrElse(
                        product -> productRepository.removeById(product.getId()),
                        ()->System.out.println(" 상품이 존재하지 않습니다. ")
                );
    }

    public void writeOrUpdateReview(int userId, int productId, int star, String content){
        Optional<Product> productOpt = productRepository.getProduct(productId);
        if (productOpt.isEmpty()){
            System.out.println(" 존재하지 않는 상품 입니다.");
            return;
        }

        Product product = productOpt.get();
        Optional<Review> reviewOpt = product.getReview();
        reviewOpt.ifPresentOrElse(
                review -> {
                    review.setStar(star);
                    review.setContent(content);
                    review.setCurrentDate(new Date());
                },
                ()->{
                    Review newReview = new Review(userId,star,content,new Date());
                    product.setReview(newReview);
                }
        );
        System.out.println(" 리뷰가 작성되었습니다.");
    }

    public void deleteReviewByProductId(int productId){
        Optional<Product> productOpt = productRepository.getProduct(productId);
        if (productOpt.isEmpty()){
            System.out.println(" 존재하지 않는 상품 입니다.");
            return;
        }

        Product product = productOpt.get();
        product.setReview(null);
        System.out.println(" 리뷰가 삭제되었습니다.");
    }

    public void printReviewByProductId(int productId) {
        Optional<Product> productOpt = productRepository.getProduct(productId);
        if (productOpt.isEmpty()) {
            System.out.println("존재하지 않는 상품입니다.");
            return;
        }

        Product product = productOpt.get();
        product.getReview().ifPresentOrElse(
                review -> {
                    System.out.println("리뷰 작성자: " + review.getUserId());
                    System.out.println("별점: " + review.getStar() + "점");
                    System.out.println("내용: " + review.getContent());
                    System.out.println("작성일: " + review.getCurrentDate());
                },
                () -> System.out.println("리뷰가 없습니다.")
        );
    }

    public void printProductById(int productId){
        productRepository.getProduct(productId)
                .ifPresentOrElse(
                        product -> System.out.println(" 상품 : "+product.getName()+" | 카테고리 :"+product.getCategory().name()),
                        ()->System.out.println(" 상품이 존재하지 않습니다. ")
                );
    }

    public void printProductByCategory(Category category){
        System.out.println(" 카테고리 : "+category.name());
        productRepository.findByCategory(category)
                .forEach(product -> System.out.println(" 상품: "+product.getName()+" 가격: "+product.getPrice()));
    }

    public void printAllProducts(){
        System.out.println(" 모든상품");
        productRepository.findAll()
                .forEach(product -> System.out.println(" 상품: "+product.getName()+" 가격: "+product.getPrice()));
    }
}
