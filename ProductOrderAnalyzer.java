import java.util.*;

class Order {
    String orderId;
    String customerId;
    List<String> productCodes;

    public Order(String orderId, String customerId, List<String> productCodes) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productCodes = productCodes;
    }
}

public class ProductOrderAnalyzer {
    List<Order> orderList = new ArrayList<>();
    Set<String> uniqueProducts = new HashSet<>();
    Map<String, Integer> productSalesCount = new HashMap<>();
    Map<String, Set<String>> customerProductMap = new HashMap<>();

    public void addOrder(Order order) {
        orderList.add(order);

        for (String product : order.productCodes) {
            uniqueProducts.add(product);
            productSalesCount.put(product, productSalesCount.getOrDefault(product, 0) + 1);
            customerProductMap.putIfAbsent(order.customerId, new HashSet<>());
            customerProductMap.get(order.customerId).add(product);
        }
    }

    public String getTopCustomer() {
        String topCustomer = null;
        int maxProducts = 0;

        for (Map.Entry<String, Set<String>> entry : customerProductMap.entrySet()) {
            if (entry.getValue().size() > maxProducts) {
                maxProducts = entry.getValue().size();
                topCustomer = entry.getKey();
            }
        }
        return topCustomer;
    }

    public void printReport() {
        System.out.println("\n--- REPORT ---");
        System.out.println("Total Orders: " + orderList.size());
        System.out.println("Unique Products: " + uniqueProducts);
        System.out.println("Product Sales Count:");
        for (Map.Entry<String, Integer> entry : productSalesCount.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue() + " units");
        }
        System.out.println("Top Customer (most distinct product types): " + getTopCustomer());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductOrderAnalyzer analyzer = new ProductOrderAnalyzer();

        System.out.print("Enter number of orders: ");
        int numOrders = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 1; i <= numOrders; i++) {
            System.out.println("\nOrder #" + i);

            System.out.print("Enter Order ID: ");
            String orderId = scanner.nextLine();

            System.out.print("Enter Customer ID: ");
            String customerId = scanner.nextLine();

            System.out.print("Enter number of products in this order: ");
            int numProducts = scanner.nextInt();
            scanner.nextLine(); // consume newline

            List<String> products = new ArrayList<>();
            for (int j = 1; j <= numProducts; j++) {
                System.out.print("Enter product code #" + j + ": ");
                products.add(scanner.nextLine());
            }

            Order order = new Order(orderId, customerId, products);
            analyzer.addOrder(order);
        }

        analyzer.printReport();
        scanner.close();
    }
}
