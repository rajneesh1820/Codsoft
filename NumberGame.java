import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        
        int totalAttempts = 0;
        int totalRounds = 0;
        
        boolean playAgain = true;
        
        while (playAgain) {
            totalRounds++;
            System.out.println("Round " + totalRounds);
            
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            
            System.out.println("Guess the number between " + lowerBound + " and " + upperBound);
            
            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                }
            }
            
            if (attempts == maxAttempts) {
                System.out.println("Out of attempts! The secret number was " + secretNumber);
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }
        
        double averageAttempts = (double) totalAttempts / totalRounds;
        System.out.println("Game over. You played " + totalRounds + " rounds with an average of " + averageAttempts + " attempts per round.");
        
        scanner.close();
    }
}