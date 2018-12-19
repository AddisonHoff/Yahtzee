import java.util.Random;

public class YahtzeeDie
{

	/* instance data should include a Random number generator, a numOfSides which
	contains the number of sides the die has, value which is the current value
	of the die and isFrozen	which is true if die is frozen, false if not */

	private Random r;
	private int numOfSides;
	private int value;
	private boolean isFrozen;

	/* initialize the Random object appropriately, initialize an int containing the value to 0,
	a boolean isFrozen to false and numOfSides to the argument passed in */
	public YahtzeeDie(int sides)
	{
		//your code here
		r = new Random();
		value = 0;
		isFrozen = false;
		numOfSides = sides;
	}

	/* Set the new value for the die using the Random object */
	public void rollDie()
	{
		//your code here
		value = r.nextInt(numOfSides)+1;
	}

	/* Gets the current die value */
	public int getValue()
	{
		//your code here
		return value;
	}

	/* Set the value of isFrozen to true */
	public void freezeDie()
	{
		//your code here
		isFrozen = true;
	}

	/* Set the value of isFrozen to false */
	public void unfreezeDie()
	{
		//your code here
		isFrozen = false;
	}

	/* Return true if die is frozen, false if it is unfrozen */
	public boolean isFrozen()
	{
		//your code here
		return isFrozen;
	}

}