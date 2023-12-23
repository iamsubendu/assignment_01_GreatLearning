import java.util.Scanner;

public class MenuDrivenProgram {

      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice (1-5): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                processChoice(choice);
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                choice = 0;  // Set choice to 0 to continue the loop
            }

        } while (choice != 5);
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Check for Palindrome Number");
        System.out.println("2. Print Pattern of Stars");
        System.out.println("3. Check for Prime Number");
        System.out.println("4. Print Fibonacci Series");
        System.out.println("5. Exit");
    }

    private static void processChoice(int choice) {
        switch (choice) {
            case 1:
                checkPalindrome();
                break;
            case 2:
                printStarPattern();
                break;
            case 3:
                checkPrime();
                break;
            case 4:
                printFibonacciSeries();
                break;
            case 5:
                System.out.println("Exiting the program. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
        }
    }

    private static void checkPalindrome() {
        System.out.println("The numbers which give the same value when reversed are called palindrome numbers.Example: 121, 12321, 512215, etc.,");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = scanner.nextLine();
        try {
            int number = Integer.parseInt(input);
            System.out.println("The number provide is: " + number);
            int originalNumber = number;
            int reversedNumber = 0;
            while (number != 0) {
                int digit = number % 10;
                reversedNumber = reversedNumber * 10 + digit;
                number /= 10;
            }

            if (originalNumber == reversedNumber) {
                System.out.println("The number is a palindrome.");
            } else {
                System.out.println("The number is not a palindrome.");
            }
            scanner.close();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    private static void printStarPattern() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void checkPrime() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println("The number is prime.");
        } else {
            System.out.println("The number is not prime.");
        }
        scanner.close();
    }

    private static void printFibonacciSeries() {
        System.out.println("The series of numbers whose next number is the sum of its previous two numbers is called the Fibonacci series.The Fibonacci series  is: 0, 1, 1, 2, 3, 5, 8");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of Fibonacci series: ");
        int n = scanner.nextInt();

        int first = 0, second = 1;

        System.out.println("Fibonacci Series:");

        for (int i = 0; i < n; i++) {
            System.out.print(first + " ");

            int next = first + second;
            first = second;
            second = next;
        }

        System.out.println();
        scanner.close();
    }
}
