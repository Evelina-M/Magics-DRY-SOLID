public class PostalDelivery implements DeliveryService {
    @Override
    public void deliverOrder(Order order) {
        System.out.println("Заказ доставлен почтой: " + order);
    }

    @Override
    public void trackOrder(Order order) {
        System.out.println("Статус заказа: Доставлен почтой");
    }
}
