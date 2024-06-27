import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static final List<Product> PRODUCTS = new ArrayList<>();
    private static final List<Product> CART = new ArrayList<>();
    // Избегаем магические числа - используем константы
    private static double buyerBalance = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Liskov substitution principle - наследники класса Product полностью играют роль предка
        PRODUCTS.add(new Phone("Apple", "WW", "iPhone 14", 1000, 1));
        PRODUCTS.add(new Phone("Samsung", "As", "Galaxy S23", 900, 10));
        PRODUCTS.add(new Notebook("Lenovo", "Tyy", "ThinkPad X1 Carbon", 1200, 5));
        PRODUCTS.add(new Notebook("Dell", "QA", "XPS 13", 1100, 3));
        PRODUCTS.add(new DigitalWatch("Liva", "Oja", "TYU 102", 5200, 2));
        PRODUCTS.add(new DigitalWatch("Kew", "Vivi", "XPS 84", 1000, 1));
        listOfFeatures();

    }

    public static void listOfFeatures() {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Посмотреть каталог товаров");
            System.out.println("2. Фильтровать товары");
            System.out.println("3. Добавить товар в корзину");
            System.out.println("4. Удалить товар из корзины");
            System.out.println("5. Посмотреть корзину");
            System.out.println("6. Купить товар");
            System.out.println("7. Пополнить баланс");
            System.out.println("8. Посмотреть баланс");
            System.out.println("0. Выход");


            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    ProduktKatalogAnzeigen();
                    System.out.println();
                    break;
                case 2:
                    filterProducts();
                    System.out.println();
                    break;
                case 3:
                    addItemToTheShoppingCart();
                    System.out.println();
                    break;
                case 4:
                    removeProductFromShoppingCart();
                    System.out.println();
                    break;
                case 5:
                    cartAnzeigen();
                    System.out.println();
                    break;
                case 6:
                    makingOrder();
                    System.out.println();
                    break;
                case 7:
                    topBalance();
                    System.out.println();
                    break;
                case 8:
                    viewTheBalance();
                    System.out.println();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте еще раз.");
            }
        }
    }

    private static void removeProductFromShoppingCart() {
        System.out.println("Введите названия товаров, которые хотите удалить из корзины через запятую:");
        String deleteProducts = scanner.next();

        String[] deleteProductsArray = deleteProducts.split(",");

        for (String delete : deleteProductsArray) {
            Product product = null;
            for (Product t : CART) {
                if (t.getName().equals(deleteProducts)) {
                    product = t;
                    break;
                }
            }

            if (product != null) {
                CART.remove(product);
                System.out.println("Товар " + deleteProducts + " удален из корзины.");
            } else {
                System.out.println("Товар с названием " + deleteProducts + " не найден в корзине.");
            }
        }
        cartAnzeigen();
    }

    private static void viewTheBalance() {
        System.out.println("Ваш баланс: " + buyerBalance + " руб.");
    }

    private static void topBalance() {
        System.out.println("Введите сумму пополнения:");
        int amountOfTheDeposit = scanner.nextInt();
        if (amountOfTheDeposit <= 0) {
            System.out.println("Неверная сумма пополнения.");
        } else {
            buyerBalance += amountOfTheDeposit;
            System.out.println("Баланс пополнен на " + amountOfTheDeposit + " руб.");

        }
    }

    private static void filterProducts() {

        while (true) {
            System.out.println("Выберите фильтрацию:");
            System.out.println("1. По названию");
            System.out.println("2. По цене");
            System.out.println("3. По производителю");
            System.out.println("4. По характеристике");
            System.out.println("5. По количеству");
            System.out.println("0. Назад");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    filteringByName();
                    break;
                case 2:
                    filteringByCost();
                    break;
                case 3:
                    filteringByManufacturer();
                    break;
                case 4:
                    filteringByDescription();
                    break;
                case 5:
                    filteringByQuantityInStock();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте еще раз.");
            }
        }
    }

    private static void withdrawProducts(List<Product> filteredProducts) {
        if (!filteredProducts.isEmpty()) {
            System.out.println("Отфильтрованные товары:");
            for (Product product : filteredProducts) {
                System.out.println(product);

            }
        } else {
            System.out.println("Товаров, соответствующих фильтру, не найдено.");
        }
        System.out.println();
    }

    private static void filteringByName() {

        System.out.println("Введите часть названия товара:");
        String name = scanner.next();

        List<Product> filteredProducts = new ArrayList<>();

        for (Product product : PRODUCTS) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                filteredProducts.add(product);
            }
        }
        // Принцип DRY - повторяющийся список продуктов выносим в отдельный метод
        withdrawProducts(filteredProducts);
    }

    private static void filteringByCost() {

        System.out.println("Введите минимальную цену:");
        int minCost = scanner.nextInt();

        System.out.println("Введите максимальную цену:");
        int maxCost = scanner.nextInt();

        List<Product> filteredProducts = new ArrayList<>();

        for (Product product : PRODUCTS) {
            if (product.getCost() >= minCost && product.getCost() <= maxCost) {
                filteredProducts.add(product);
            }
        }
        // Принцип DRY - повторяющийся список продуктов выносим в отдельный метод
        withdrawProducts(filteredProducts);
    }

    private static void filteringByManufacturer() {

        System.out.println("Выберите производителя:");
        String manufacturer = scanner.next();

        List<Product> filteredProducts = new ArrayList<>();

        for (Product product : PRODUCTS) {
            if (product.getManufacturer().equals(manufacturer)) {
                filteredProducts.add(product);
            }
        }
        // Принцип DRY - повторяющийся список продуктов выносим в отдельный метод
        withdrawProducts(filteredProducts);
    }

    private static void filteringByDescription() {

        System.out.println("Введите название характеристики:");
        String description = scanner.next();


        List<Product> filteredProducts = new ArrayList<>();

        for (Product product : PRODUCTS) {
            if (product.getDescription().contains(description)) {

                filteredProducts.add(product);
            }
        }
        // Принцип DRY - повторяющийся список продуктов выносим в отдельный метод
        withdrawProducts(filteredProducts);
    }

    private static void filteringByQuantityInStock() {

        System.out.println("Введите минимальное количество:");
        int minQuantityInStock = scanner.nextInt();

        System.out.println("Введите максимальное количество:");
        int maxQuantityInStock = scanner.nextInt();

        List<Product> filteredProducts = new ArrayList<>();

        for (Product product : PRODUCTS) {
            if (product.getQuantityInStock() >= minQuantityInStock && product.getQuantityInStock() <= maxQuantityInStock) {
                filteredProducts.add(product);
            }
        }
        // Принцип DRY - повторяющийся список продуктов выносим в отдельный метод
        withdrawProducts(filteredProducts);
    }

    private static void ProduktKatalogAnzeigen() {
        System.out.println("Каталог товаров:");
        for (Product product : PRODUCTS) {
            System.out.println(product);
        }
    }

    private static void addItemToTheShoppingCart() {

        System.out.println("Введите название товара, который хотите добавить в корзину:");
        String nameProduct = scanner.next();
        Product productCart = findProduct(nameProduct);

        if (productCart != null && productCart.getQuantityInStock() > 0) {
            System.out.println("Введите нужное количество товара:");
            int quantityProduct = scanner.nextInt();

            if (quantityProduct > 0 && quantityProduct <= productCart.getQuantityInStock()) {
                CART.add(productCart);
                productCart.setQuantityInStock(productCart.getQuantityInStock() - quantityProduct);
                System.out.println("Товар " + nameProduct + " в количестве " + quantityProduct + " шт. добавлен в корзину.");
            } else {
                System.out.println("Недостаточно товаров в наличии.");
            }
        } else {
            System.out.println("Товар закончился.");
        }
    }

    private static void cartAnzeigen() {
        System.out.println("Товары в корзине:");
        for (Product product : CART) {
            System.out.println(product);
        }
    }

    private static void makingOrder() {
        System.out.println("Вы хотите купить товары в корзине? (да/нет)");
        String yesNo = scanner.next();

        if (yesNo.equals("да") || yesNo.equals("Да")) {
            int totalAmount = 0;
            for (Product product : CART) {
                totalAmount += product.getCost();
            }
            if (totalAmount > buyerBalance) {
                System.out.println("Недостаточно средств на балансе.");
            } else if (totalAmount == 0) {
                System.out.println("В корзине нет товаров.");
            } else {
                System.out.println("Выберите способ доставки:");
                System.out.println("1. Почта");
                System.out.println("2. Курьер");
                System.out.println("0. Назад");

                int delivery = scanner.nextInt();
                System.out.println();

                switch (delivery) {
                    case 1:
                        System.out.println("Вы выбрали доставку почтой.");
                        break;
                    case 2:
                        System.out.println("Вы выбрали доставку курьером.");
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Неверный способ доставки, попробуйте еще раз.");
                }

                System.out.println("Общая сумма покупки: " + totalAmount + " руб.");
                buyerBalance -= totalAmount;
                CART.clear();
                System.out.println("Спасибо за покупку!");
            }
        } else {
            System.out.println("Покупка отменена.");
        }
    }

    private static Product findProduct(String nameProduct) {
        for (Product product : PRODUCTS) {
            if (product.getName().equalsIgnoreCase(nameProduct)) {
                System.out.println(product);
                return product;
            }
        }
        return null;
    }


}