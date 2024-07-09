import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;  // Random number between 1 and 100
            int numberOfAttempts = 10;  // Limiting the number of attempts
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + numberOfAttempts + " attempts to guess it.");

            for (int i = 0; i < numberOfAttempts; i++) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += (numberOfAttempts - i);  // The fewer attempts, the higher the score
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            String userResponse = scanner.next();

            if (!userResponse.equalsIgnoreCase("yes")) {
                playAgain = false;
                System.out.println("Thank you for playing! Your final score is: " + score);
            }
        }

        scanner.close();
    }
}

