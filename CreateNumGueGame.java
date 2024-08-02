import java.util.Random;
import java.util.Scanner;

public class CreateNumGueGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        // Define the range and maximum attempts
        int min = 1;
        int max = 100;
        int maxAttempts = 10;

        // Generate a random number
        int targetNumber = random.nextInt(max - min + 1) + min;

        System.out.println("I have selected a number between " + min + " and " + max + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = 0;
            try {
                guess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                continue;
            }

            attempts++;

            if (guess == targetNumber) {
                hasGuessedCorrectly = true;
                break;
            } else if (guess < targetNumber) {
                System.out.println("Too low!");
            } else {

                System.out.println("Too high!");
            }

            System.out.println("You have " + (maxAttempts - attempts) + " attempts left.");
        }

        if (hasGuessedCorrectly) {
            System.out.println("Congratulations! You've guessed the number correctly in " + attempts + " attempts.");
        } else {
            System.out.println("Sorry! You've used all your attempts. The correct number was " + targetNumber + ".");
        }

        scanner.close();
        System.out.println("Thank you for playing the Number Guessing Game!");
    }
}
