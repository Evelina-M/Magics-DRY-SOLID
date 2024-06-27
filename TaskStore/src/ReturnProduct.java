import java.util.List;

public class ReturnProduct {
    private final int id;
    private final Order order;
    private final List<Product> products;
    private final String reason;
    private final String status;

    public ReturnProduct(int id, Order order, List<Product> products, String reason, String status) {
        this.id = id;
        this.order = order;
        this.products = products;
        this.reason = reason;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public List<Product> getProduct() {
        return products;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ВозвратТовара{" +
                "id=" + id +
                ", заказ=" + order +
                ", товары=" + products +
                ", причина='" + reason + '\'' +
                ", статус='" + status + '\'' +
                '}';
    }
}
