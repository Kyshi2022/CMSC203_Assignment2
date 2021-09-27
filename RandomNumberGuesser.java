/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: This program will generate a random number from 0-99 and the user gets an infinite amount of tries to correctly guess the random number.
 * Due: 9/27/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Kyle Duong
*/

import java.util.*; //Java package that contains Scanner class

public class RandomNumberGuesser {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner (System.in); // Scanner object initialized to allow the user to input their own guesses
	    int rngNumber = RNG.rand(); // Random number that is generated between 0-99, this is produced from the RNG class and then stored inside this variable
	    int guess; // Variable to contain the user's guess
	    int lowerBound = 0; // The lower end of guesses that will change each time the user inputs a new guess
	    int higherBound = 100; // The upper end of guesses that will change each time the user inputs a new guess
	    int whileLoop = 1; // While loop set to either 0 or 1 depending if the user would like to continue playing the game again or not
	    String response; // This string holds either a "yes" or "no" response every time the user finishes a guessing game
	    String programmerName = "Kyle Duong"; // String variable that contains my name

	    System.out.println("Please enter in your first guess (0-99): ");

	    while (whileLoop == 1) {

	      guess = keyboard.nextInt();
	      
	      // if statement to check if the user's guess is greater than the random number
	      if (guess > rngNumber) {

	        if (RNG.inputValidation(guess, lowerBound, higherBound)) { // The higherBound variable number is assigned to guess if the input is valid
	          higherBound = guess;
	        }

	        else {
	        	
	          // The user must enter in another guess
	          guess = keyboard.nextInt();

	          if (guess > lowerBound && guess < higherBound) {
	            higherBound = guess;
	          }
	        }

	        System.out.println("Your total number of guesses is: " + RNG.getCount());
	        System.out.println("Your guess is too high, guess lower next time.");
	        System.out.println("Please enter your next guess somewhere between " + lowerBound + " and " + higherBound + " (0-99):");
	      }
	      
	      // if statement to check if the user's guess is less than the random number
	      else if (guess < rngNumber) {

	        if (RNG.inputValidation(guess, lowerBound, higherBound)) { // The lowerBound variable number is assigned to guess if the input is valid
	          lowerBound = guess;
	        }

	        else {
	        	
	          // The user must enter in another guess
	          guess = keyboard.nextInt();

	          if (guess > lowerBound && guess < higherBound) {
	            lowerBound = guess;
	          }
	        }

	        System.out.println("Your total number of guesses is: " + RNG.getCount());
	        System.out.println("Your guess is too low, guess higher next time.");
	        System.out.println("Please enter your next guess somewhere between " + lowerBound + " and " + higherBound + " (0-99):");
	      }

	      if (guess == rngNumber) {

	    	// The number of guesses gets reset and the user gets asked if they would like to play the game again
	        RNG.resetCount();
	        System.out.println("Congratulations, you guessed the random number correctly!");
	        System.out.println("Would you like to play again? (yes or no): ");
	        keyboard.nextLine();
	        response = keyboard.nextLine();

	        if (response.equals("yes")) {
	        	
	          // If the user responds "yes", then a new rng number is produced while the lower & upper bounds are reset to their original values
	          rngNumber = RNG.rand();
	          lowerBound = 0;
	          higherBound = 100;
	          System.out.println();
	          System.out.println("Please enter in your first guess (0-99): ");
	        }

	        else if (response.equals("no")) {
	        	
	          // If the user responds "no", then the program displays a goodbye message including the programmer's name at the bottom as well
	          System.out.println("Thank you so much for playing my guessing game!");
	          System.out.println("Programmer Name: " + programmerName);
	          whileLoop = 0;
	        }
	      }
	    }
	}
}