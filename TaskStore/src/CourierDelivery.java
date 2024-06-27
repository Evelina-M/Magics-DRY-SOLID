public class CourierDelivery implements DeliveryService {
    @Override
    public void deliverOrder(Order order) {
        System.out.println("Заказ доставлен курьером: " + order);
    }

    @Override
    public void trackOrder(Order order) {
        System.out.println("Статус заказа: Доставлен курьером");
    }
}
