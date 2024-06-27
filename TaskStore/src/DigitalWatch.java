public class DigitalWatch extends Product implements Technik {
    // Open Closed Principle - имплементируя интерфейс Technik мы добавляем классу функциональности, не изменяя его код
    public DigitalWatch(String name, String manufacturer, String description, double cost, int quantityInStock) {
        super(name, manufacturer, description, cost, quantityInStock);
    }


    @Override
    public void standDerTechnik() {
        System.out.println("Часы работают");
    }
}
