import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {
    private final Map<Product, Integer> products;

    public Cart() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public int getQuantityProduct(Product product) {
        return products.getOrDefault(product, 0);
    }

    public Set<Product> getProduct() {
        return products.keySet();
    }

    @Override
    public String toString() {
        return "Корзина{" +
                "товары=" + products +
                '}';
    }
}
