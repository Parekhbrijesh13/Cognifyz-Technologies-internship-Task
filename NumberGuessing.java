

import java.util.Scanner;
import java.util.Random;

public class NumberGuessing {
   
    public static void main(String args[]) {
        

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(10) + 1; // 1 to 10
        int attempts = 3;
        int guess;

        System.out.println("🎮 Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 10");
        System.out.println("You have " + attempts + " attempts.\n");

        for (int i = 1; i <= attempts; i++) {
            System.out.print("Attempt " + i + ": Enter your guess: ");
            guess = sc.nextInt();

            if (guess == numberToGuess) {
                System.out.println("🎉 Congratulations! You guessed the correct number.");
                break;
            } else if (guess > numberToGuess) {
                System.out.println("❌ Too high!");
            } else {
                System.out.println("❌ Too low!");
            }

            if (i == attempts) {
                System.out.println("\n😢 Game Over!");
                System.out.println("The correct number was: " + numberToGuess);
            }
        }

        sc.close();
    }       
}

