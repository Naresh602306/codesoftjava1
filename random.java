import java.util.Random;
import java.util.Scanner;

public class random {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int totalScore = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            rounds++;
            
            System.out.println("Round " + rounds + ": Guess the number between " + minRange + " and " + maxRange + ". You have " + maxAttempts + " attempts.");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else if (guess > targetNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                    totalScore += (maxAttempts - attempts + 1);
                    break;
                }
            }
            
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber + ".");
            }
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");
        }
        
        System.out.println("Game over! You played " + rounds + " rounds with a total score of " + totalScore + ".");
        scanner.close();
    }
}
