import java.util.*;

class Product {
    private String id;
    private String name;
    private int quantity;

    public Product(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{id='" + id + "', name='" + name + "', quantity=" + quantity + "}";
    }
}

class Category implements Comparable<Category> {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{name='" + name + "'}";
    }

    @Override
    public int compareTo(Category other) {
        return this.name.compareTo(other.name);
    }
}

class Order implements Comparable<Order> {
    private String id;
    private int priority;

    public Order(String id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Order{id='" + id + "', priority=" + priority + "}";
    }
}

class Supplier {
    private String id;
    private String name;

    public Supplier(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Supplier{id='" + id + "', name='" + name + "'}";
    }
}

class Shipment {
    private String productId;
    private int quantity;

    public Shipment(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Shipment{productId='" + productId + "', quantity=" + quantity + "}";
    }
}


public class WarehouseManagementSystem {
    private Map<String, Product> products = new HashMap<>();
    private Map<String, Supplier> suppliers = new HashMap<>();
    private Set<Category> categories = new TreeSet<>();
    private Queue<Order> orders = new PriorityQueue<>();
    private List<Shipment> shipments = new ArrayList<>();

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void addSupplier(Supplier supplier) {
        suppliers.put(supplier.getId(), supplier);
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void addOrder(Order order) {
        orders.offer(order);
    }

    public void addShipment(Shipment shipment) {
        shipments.add(shipment);
    }

    public void viewProducts() {
        System.out.println("Products:");
        products.values().forEach(System.out::println);
    }

    public void viewSuppliers() {
        System.out.println("Suppliers:");
        suppliers.values().forEach(System.out::println);
    }

    public void viewCategories() {
        System.out.println("Categories:");
        categories.forEach(System.out::println);
    }

    public void viewOrders() {
        System.out.println("Orders:");
        orders.forEach(System.out::println);
    }

    public void viewShipments() {
        System.out.println("Shipments:");
        shipments.forEach(System.out::println);
    }

    public void processOrder() {
        if (!orders.isEmpty()) {
            Order order = orders.poll();
            System.out.println("Processed Order: " + order);
        } else {
            System.out.println("No orders to process.");
        }
    }

    public static void main(String[] args) {
        WarehouseManagementSystem wms = new WarehouseManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWarehouse Management System Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Add Supplier");
            System.out.println("3. Add Category");
            System.out.println("4. Add Order");
            System.out.println("5. Add Shipment");
            System.out.println("6. View Products");
            System.out.println("7. View Suppliers");
            System.out.println("8. View Categories");
            System.out.println("9. View Orders");
            System.out.println("10. View Shipments");
            System.out.println("11. Process Order");
            System.out.println("12. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String productId = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Product Quantity: ");
                    int productQuantity = scanner.nextInt();
                    wms.addProduct(new Product(productId, productName, productQuantity));
                    break;
                case 2:
                    System.out.print("Enter Supplier ID: ");
                    String supplierId = scanner.nextLine();
                    System.out.print("Enter Supplier Name: ");
                    String supplierName = scanner.nextLine();
                    wms.addSupplier(new Supplier(supplierId, supplierName));
                    break;
                case 3:
                    System.out.print("Enter Category Name: ");
                    String categoryName = scanner.nextLine();
                    wms.addCategory(new Category(categoryName));
                    break;
                case 4:
                    System.out.print("Enter Order ID: ");
                    String orderId = scanner.nextLine();
                    System.out.print("Enter Order Priority: ");
                    int orderPriority = scanner.nextInt();
                    wms.addOrder(new Order(orderId, orderPriority));
                    break;
                case 5:
                    System.out.print("Enter Shipment Product ID: ");
                    String shipmentProductId = scanner.nextLine();
                    System.out.print("Enter Shipment Quantity: ");
                    int shipmentQuantity = scanner.nextInt();
                    wms.addShipment(new Shipment(shipmentProductId, shipmentQuantity));
                    break;
                case 6:
                    wms.viewProducts();
                    break;
                case 7:
                    wms.viewSuppliers();
                    break;
                case 8:
                    wms.viewCategories();
                    break;
                case 9:
                    wms.viewOrders();
                    break;
                case 10:
                    wms.viewShipments();
                    break;
                case 11:
                    wms.processOrder();
                    break;
                case 12:
                    System.out.println("Exiting Warehouse Management System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}