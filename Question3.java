import java.util.*;
import java.util.stream.*;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - $" + price;
    }
}

public class ProductStreamExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200.00),
            new Product("Smartphone", "Electronics", 800.00),
            new Product("Washing Machine", "Appliances", 500.00),
            new Product("Refrigerator", "Appliances", 850.00),
            new Product("Shirt", "Clothing", 25.00),
            new Product("Jeans", "Clothing", 45.00),
            new Product("Headphones", "Electronics", 150.00),
            new Product("Microwave", "Appliances", 120.00)
        );

        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products grouped by category:");
        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ":");
            productList.forEach(System.out::println);
            System.out.println();
        });
        System.out.println("Most expensive product in each category:");
        groupedByCategory.forEach((category, productList) -> {
            Product mostExpensive = productList.stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow();
            System.out.println(category + ": " + mostExpensive);
        });
        System.out.println();

        double averagePrice = products.stream()
            .mapToDouble(Product::getPrice)
            .average()
            .orElse(0.0);
        System.out.println("Average price of all products: $" + averagePrice);
    }
}
