public class Notebook extends Product implements Technik {
    // Single Responsibility Principle - класс Notebook описывает только ноутбук, а не все товары
    public Notebook(String name, String manufacturer, String description, double cost, int quantityInStock) {
        super(name, manufacturer, description, cost, quantityInStock);
    }

    @Override
    public void standDerTechnik() {
        System.out.println("Ноутбук работает");
    }
}
