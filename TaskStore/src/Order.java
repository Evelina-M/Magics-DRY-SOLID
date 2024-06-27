import java.util.List;

public class Order {
    private final int id;
    private final List<Product> product;
    private final String status;

    public Order(int id, List<Product> product, String status) {
        this.id = id;
        this.product = product;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public List<Product> getProduct() {
        return product;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Заказ{" +
                "id=" + id +
                ", товары=" + product +
                ", статус='" + status + '\'' +
                '}';
    }
}
