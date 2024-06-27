public class Phone extends Product implements Technik, Mobile {
    // Interface Segregation Principle - применяем разные интерфейсы
    // Dependency Inversion Principle - не зависим от общей функциональности
    public Phone(String name, String manufacturer, String description, double cost, int quantityInStock) {
        super(name, manufacturer, description, cost, quantityInStock);
    }

    @Override
    public void standDerTechnik() {
        System.out.println("Телефон работает");
    }

    @Override
    public void sending() {
        System.out.println("Сообщение доставлено!");
    }
}
