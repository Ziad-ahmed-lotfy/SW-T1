import java.util.Scanner;

public class ArrayMenuProgram {

    public static void displayArray(int[] arr, int size) {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }

        System.out.println("Array contents:");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] arr = new int[100];
        int size = 0;
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert number");
            System.out.println("2. Delete number");
            System.out.println("3. Get value at index");
            System.out.println("4. Display array");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    if (size == arr.length) {
                        System.out.println("Array is full!");
                        break;
                    }

                    System.out.print("Enter number to insert: ");
                    int num = input.nextInt();

                    arr[size] = num;
                    size++;

                    System.out.println("Number inserted.");
                    break;

                case 2:
                    System.out.print("Enter number to delete: ");
                    int del = input.nextInt();
                    boolean found = false;

                    for (int i = 0; i < size; i++) {
                        if (arr[i] == del) {
                            for (int j = i; j < size - 1; j++) {
                                arr[j] = arr[j + 1];
                            }
                            size--;
                            found = true;
                            System.out.println("Number deleted.");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Number not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter index: ");
                    int index = input.nextInt();

                    if (index >= 0 && index < size) {
                        System.out.println("Value at index " + index + " is: " + arr[index]);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 4:
                    displayArray(arr, size);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        input.close();
    }
}
