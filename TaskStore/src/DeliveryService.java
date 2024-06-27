public interface DeliveryService {

    void deliverOrder(Order order);

    void trackOrder(Order order);
}