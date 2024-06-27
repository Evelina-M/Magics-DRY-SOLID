public abstract class Product {
    private final String name;
    private final String manufacturer;
    private final String description;
    private final double cost;
    private int quantityInStock;

    public Product(String name, String manufacturer, String description, double cost, int quantityInStock) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.description = description;
        this.cost = cost;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }


    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "Товар{" +
                "название='" + name + '\'' +
                ", производитель='" + manufacturer + '\'' +
                ", описание='" + description + '\'' +
                ", цена=" + cost +
                ", количествоВНаличии=" + quantityInStock +
                '}';
    }


}
