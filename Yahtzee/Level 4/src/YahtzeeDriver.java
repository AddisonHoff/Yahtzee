import java.util.Scanner;

public class YahtzeeDriver
{
	/*
	1. Creates a new instance of the YahtzeeGame class
	2. Calls the playGame method on the Yahtzee object
	3. Asks user if they would like to play again
	4. When the user is done playing, prints the number of games played, min, max, and average score
	*/



	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		String userInput;
		int count = 1;
		int totalScore = 0;
		int maxScore = 0;
		int minScore = 100000000;
		int avgScore = 0;
		do {
			int score;
			YahtzeeGame myGame = new YahtzeeGame();
			System.out.println("Welcome to Addison's APCSA Yahtzee Game!");
			score = myGame.playGame();
			totalScore += score;
			if (score > maxScore) {
				maxScore = score;
			}
			if (score < minScore) {
				minScore = score;
			}

			System.out.println("Want to play again? y/n");
			userInput = s.nextLine();
			count++;
		} while(userInput.equals("y"));
		avgScore = totalScore/count;
		System.out.println("Number of Games: " + count);
		System.out.println("Min Score: " + minScore);
		System.out.println("Max Score: " + maxScore);
		System.out.println("Average Score: " + avgScore);

		}
}
