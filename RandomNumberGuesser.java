/*
 * Class: CMSC203 
 * Instructor: Ms.Monshi
 * Description: This class will allow the user to play a guessing game with the RNG class. The user will be asked to input a number
 * then the response given will be information to deduce what the random number is. 
 * Due: 2/23/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Kevin Gomes
*/


import java.util.*; // Library containing scanner class 
public class RandomNumberGuesser {

	public static void main(String[] args) {
		/* TODO Auto-generated method stub
		 * This class will allow the user to play a guessing game. The game will give you hints about what the random number is.
		 */
		Scanner scan = new Scanner (System.in); // Scanner Var that will allow for user input 
		int randNum = RNG.rand(); // Random number generated and stored in randNum variable. Generated in RNG class
		int userGuess; // int var to hold user guesses 
		int lowGuess = 0; //lower bound of guesses that will change depending on the user input.
		int highGuess = 100; // Higher bound of guesses that will change depending on the user input
		int loopCheck = 1; // Loop variable to allow a loop to occur, will be set to 0 if the loop is to end.
		String userQues; // String to hold user input based on if they'd like to play again.
		final String PROGRAMMERNAME = "Kevin Gomes";
		
		
		System.out.println("Enter your first guess");
		do 
		{
			userGuess = scan.nextInt(); // Get user guess
			
			//Check if the user input is greater than or less than the random number 
			if (userGuess > randNum)
			{
				if (RNG.inputValidation(userGuess, lowGuess, highGuess))// Check if input is valid if it is then the upper bound is assigned to the value
				{
					highGuess = userGuess;
				}
				else 
				{
					//User must re-enter a num
					userGuess = scan.nextInt();
					if (userGuess < highGuess && userGuess > lowGuess)
					{
						highGuess = userGuess;
					}
					
				}
				System.out.println("Number of guesses is " + RNG.getCount());
				System.out.println("Your guess is too high");
				
				
				System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
			}
			
			//Check if the user input is less than the random number 
			else if (userGuess < randNum)
			{
				if (RNG.inputValidation(userGuess, lowGuess, highGuess)) // Check if the input is valid, if it is then the lower bound is assigned to the userInput 
				{
					lowGuess = userGuess;
				}
				else
					//user must re-enter a num
					userGuess = scan.nextInt();
					if (userGuess < highGuess && userGuess > lowGuess)
					{
						lowGuess = userGuess;
					}
				System.out.println("Number of guesses is " + RNG.getCount());
				System.out.println("your guess is too low");
				System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
			}
			if (userGuess == randNum)
			{
				// Reset the counter of guesses and ask if the user would like to play again. 
				RNG.resetCount();
				System.out.println("Congrats! you guessed correctly.");
				System.out.println("Try again? (yes or no)");
				scan.nextLine();
				userQues = scan.nextLine();
				
				if (userQues.equals("yes"))
				{
					//If yes, a new random number is generated and the low/high guesses are reset to default values.
					randNum = RNG.rand();
					lowGuess = 0;
					highGuess = 100;
					System.out.println();
					System.out.println("Enter your first guess");
				}
				
				else if (userQues.equals("no"))
				{
					// if no, then print to the console to thank the user and print programmer's name.
					System.out.println("Thanks for playing!");
					System.out.println("Programmer: " + PROGRAMMERNAME);
					loopCheck = 0;
					
				}
			}
		}while (loopCheck == 1);

	}

}
