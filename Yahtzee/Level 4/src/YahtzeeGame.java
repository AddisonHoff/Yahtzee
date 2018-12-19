import java.util.Scanner;

public class YahtzeeGame
{
	/* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */


	/* initializes the dice and scoreboard */
	private YahtzeeScorecard scoreBoard;
	private static final int NUM_SIDES = 6;
	private YahtzeeDie one, two, three, four, five;
	Scanner s = new Scanner(System.in);
	public YahtzeeGame()
	{
		one = new YahtzeeDie(NUM_SIDES);
		two = new YahtzeeDie(NUM_SIDES);
		three = new YahtzeeDie(NUM_SIDES);
		four = new YahtzeeDie(NUM_SIDES);
		five = new YahtzeeDie(NUM_SIDES);
		scoreBoard = new YahtzeeScorecard();

		/* your code here */
	}

	/* check to see if the game is over, and while the game is not over call the method takeTurn()
	once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
	final scorecard and return the grand total */
	public int playGame()
	{
		for(int i = 0; i < 13; i++) {
			takeTurn();
		}
		scoreBoard.printScoreCard();
		return scoreBoard.getGrandTotal();

	}

	/* 	1. call rollDice()
		2. call printDice()
		3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		4. call chooseFrozen()
		5. call rollDice()
		6. call printDice()
		7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		8. call chooseFrozen()
		9. call rollDice()
		10. call printDice()
		11. call markScore()
	*/
	private void takeTurn()
	{
		rollDice();
		printDice();
		String reRoll = "Do you want to roll again? y/n";
		System.out.println(reRoll);
		String userRoll = s.nextLine();
		if (userRoll.equals("n")) {
			markScore();
		} else if(userRoll.equals("y")) {
			chooseFrozen();
			rollDice();
			printDice();
			System.out.println(reRoll);
			userRoll = s.nextLine();
			if (userRoll.equals("n")) {
				markScore();
			} else if(userRoll.equals("y")) {
				chooseFrozen();
				rollDice();
				printDice();
				markScore();
			} else markScore(); //assume no if user doesn't enter y or n

		} else markScore(); //assume no if user doesn't enter y or n
	}

	/* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
	private void rollDice()
	{
		if (!one.isFrozen()) {
			one.rollDie();
		}
		if (!two.isFrozen()) {
			two.rollDie();
		}
		if(!three.isFrozen()) {
			three.rollDie();
		}
		if(!four.isFrozen()) {
			four.rollDie();
		}
		if(!five.isFrozen()) {
			five.rollDie();
		}
		one.unfreezeDie();
		two.unfreezeDie();
		three.unfreezeDie();
		four.unfreezeDie();
		five.unfreezeDie();
	}

	/* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
	private void chooseFrozen()
	{
		System.out.println("Which dice should should be frozen 1-5 separated by spaces");
		String freezeDie = s.nextLine();
		for(int i = 0; i < freezeDie.length(); i+=2) {
			char num = freezeDie.charAt(i);
			switch (num) {
				case '1': one.freezeDie(); break;
				case '2': two.freezeDie(); break;
				case '3': three.freezeDie(); break;
				case '4': four.freezeDie(); break;
				case '5': five.freezeDie(); break;

			}
		}
	}

	/* Should print the value of all five dice separated by a tab (\t) to the console */
	private void printDice()
	{
		System.out.println(one.getValue() + "\t" + two.getValue() + "\t" + three.getValue() + "\t" + four.getValue() + "\t" + five.getValue());
	}

	/* 1. Print a scoreboard
	   2. Ask the user where they would like to mark their score.
	   3. Call appropriate function
	   4. If false is returned the user entered an invalid number, so ask the user to try again	*/
	private void markScore()
	{

		boolean didMark = false;
while (!didMark) {
	scoreBoard.printScoreCard();
	System.out.println("Where would you like to place your score?");
	System.out.println("1. Ones \t7.  3 of Kind\n" +
			"2. Twos \t8.  4 of Kind\n" +
			"3. Threes \t9.  Full House\n" +
			"4. Fours \t10. Sm Straight\n" +
			"5. Fives \t11. Lg Straight\n" +
			"6. Sixes \t12. Yahtzee\n" +
			"\t\t13. Chance");
	String userInput = s.nextLine();

	switch (userInput) {
		case "1":
			didMark = scoreBoard.markOnes(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
			break;
		case "2":
			didMark = scoreBoard.markTwos(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
			break;
		case "3":
			didMark = scoreBoard.markThrees(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
			break;
		case "4":
			didMark = scoreBoard.markFours(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
			break;
		case "5":
			didMark = scoreBoard.markFives(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
			break;
		case "6":
			didMark = scoreBoard.markSixes(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
			break;
		case "7":
			didMark = scoreBoard.markThreeOfAKind(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
			break;
		case "8":
			didMark = scoreBoard.markFourOfAKind(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
			break;
		case "9":
			didMark = scoreBoard.markFullHouse(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
			break;
		case "10":
			didMark = scoreBoard.markSmallStraight(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
			break;
		case "11":
			didMark = scoreBoard.markLargeStraight(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
			break;
		case "12":
			didMark = scoreBoard.markYahtzee(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
			break;
		case "13":
			didMark = scoreBoard.markChance(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
			break;
		default:
			System.out.println("You entered an invalid number. Please enter a valid number!");
	}

	if (!didMark){
		System.out.println("You entered an invalid entry.");
	}


}


		}

	}

