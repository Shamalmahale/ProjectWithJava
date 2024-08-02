import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Console-based Calculator!");

        while (true) {
            double num1 = 0, num2 = 0;
            String operation;

            // Input first number
            System.out.print("Enter the first number: ");
            try {
                num1 = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                continue;
            }

            // Input second number
            System.out.print("Enter the second number: ");
            try {
                num2 = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                continue;
            }

            // Select operation
            System.out.print("Select an operation (+, -, *, /): ");
            operation = scanner.nextLine();

            double result = 0;
            boolean validOperation = true;

            switch (operation) {
                case "+":
                    result = add(num1, num2);
                    break;
                case "-":
                    result = subtract(num1, num2);
                    break;
                case "*":
                    result = multiply(num1, num2);
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error! Division by zero is not allowed.");
                        validOperation = false;
                    } else {
                        result = divide(num1, num2);
                    }
                    break;
                default:
                    System.out.println("Invalid operation! Please select a valid operation (+, -, *, /).");
                    validOperation = false;
            }

            if (validOperation) {
                System.out.printf("The result of %f %s %f is: %f\n", num1, operation, num2, result);
            }

            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String continueCalculation = scanner.nextLine().trim().toLowerCase();
            if (!continueCalculation.equals("yes")) {
                break;
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Console-based Calculator!");
    }

    // Addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Division
    public static double divide(double a, double b) {
        return a / b;
    }
}
