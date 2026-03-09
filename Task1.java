import java.util.Scanner;

public class ClothesStore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Product[] store = new Product[50];
        int count = 0;
        int choice;

        do {
            System.out.println("\n=== Clothes Store Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Search Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Buy Product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    if (count < store.length) {
                        System.out.print("Enter clothes type: ");
                        String type = input.nextLine();
                        System.out.print("Enter price: ");
                        double price = input.nextDouble();
                        System.out.print("Enter quantity: ");
                        int quantity = input.nextInt();
                        input.nextLine();
                        store[count] = new Product(type, price, quantity);
                        count++;
                        System.out.println("Product added successfully.");
                    } else {
                        System.out.println("Store is full.");
                    }
                    break;

                case 2:
                    if (count == 0) System.out.println("No products available.");
                    else {
                        System.out.println("\n--- Product List ---");
                        for (int i = 0; i < count; i++) {
                            System.out.println("Product #" + (i + 1));
                            store[i].display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter product type to search: ");
                    String searchType = input.nextLine();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (store[i].type.equalsIgnoreCase(searchType)) {
                            found = true;
                            System.out.println("\nProduct Found:");
                            store[i].display();
                            break;
                        }
                    }
                    if (!found) System.out.println("Product not found.");
                    break;

                case 4:
                    System.out.print("Enter product type to delete: ");
                    String deleteType = input.nextLine();
                    boolean deleted = false;
                    for (int i = 0; i < count; i++) {
                        if (store[i].type.equalsIgnoreCase(deleteType)) {
                            for (int j = i; j < count - 1; j++) store[j] = store[j + 1];
                            store[count - 1] = null;
                            count--;
                            deleted = true;
                            System.out.println("Product deleted successfully.");
                            break;
                        }
                    }
                    if (!deleted) System.out.println("Product not found.");
                    break;

                case 5:
                    System.out.print("Enter product type to buy: ");
                    String buyType = input.nextLine();
                    boolean bought = false;
                    for (int i = 0; i < count; i++) {
                        if (store[i].type.equalsIgnoreCase(buyType)) {
                            bought = true;
                            if (store[i].quantity > 0) {
                                store[i].quantity--;
                                System.out.println("You bought 1 " + store[i].type);
                                System.out.println("Remaining stock: " + store[i].quantity);
                            } else {
                                System.out.println("Sorry, this product is OUT OF STOCK.");
                            }
                            break;
                        }
                    }
                    if (!bought) System.out.println("Product not found.");
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        input.close();
    }
}

class Product {
    String type;
    double price;
    int quantity;

    Product(String type, double price, int quantity) {
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    void display() {
        System.out.println("Type: " + type);
        System.out.println("Price: $" + price);
        System.out.println("Number of Items: " + quantity);
        if (quantity == 0) System.out.println("Status: Out of Stock");
        else System.out.println("Status: In Stock");
        System.out.println("-----------------------");
    }
}
