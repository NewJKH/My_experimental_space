package optional.test2.repository;

import optional.test2.domain.product.Category;
import optional.test2.domain.product.Product;

import java.util.*;

public class ProductRepository {
    /**
     * 상품들의 저장소 ( Repository )
     */
    private final Map<Integer, Product> products;

    public ProductRepository() {
        products = new HashMap<>();
        products.put(1, new Product(1, Category.TOY,"키보드", 1000, null));
        products.put(2, new Product(2, Category.TOY,"마우스", 2000, null));
        products.put(3, new Product(3, Category.FOOD,"콜라", 3000, null));
        products.put(4, new Product(4, Category.FOOD,"사이다", 4000, null));
        products.put(5, new Product(5, Category.TOY,"PS5", 5000, null));
        products.put(6, new Product(6, Category.FOOD,"라면", 6000, null));
    }

    public void addProducts(int productId, Product product) {
        products.put(productId, product);
    }

    public Optional<Product> getProduct(int productId){
        return Optional.ofNullable(products.get(productId));
    }

    public List<Product> findAll(){
        return new ArrayList<>(products.values());
    }

    public List<Product> findByCategory(Category category){
        return products.values()
                .stream()
                .filter(product-> product.getCategory()==category)
                .toList();
    }

    public void removeById(int productId){
        products.remove(productId);
    }

    public boolean hasById(int productId){
        return products.containsKey(productId);
    }

    public boolean hasByName(String name){
        return products.values()
                .stream()
                .anyMatch(product -> product.getName().equals(name));
    }
}
