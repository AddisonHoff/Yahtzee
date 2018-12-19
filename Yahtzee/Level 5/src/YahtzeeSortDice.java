public class YahtzeeSortDice
{
	int first;
	int second;
	int third;
	int fourth;
	int fifth;

	/* constructor: initializes the private data by sorting the order of the dice */
	public YahtzeeSortDice(int a, int b, int c, int d, int e)
	{
		//Initialize values 1-5 to parameters, doesn't matter how, b/c we sort them below
		first = a;
		second = b;
		third = c;
		fourth = d;
		fifth = e;
		// int that we use to check values throughout if statements
		int swithNum;

		//For loop allows switchNum to run through every statement/number
		for (int i = 0; i < 4; i++)
		{
			if (second < first)
			{
				swithNum = first;
				first = second;
				second = swithNum;
			}

			if (third < second)
			{
				swithNum = second;
				second = third;
				third = swithNum;
			}

			if (fourth < third)
			{
				swithNum = third;
				third = fourth;
				fourth = swithNum;
			}

			if (fifth < fourth)
			{
				swithNum = fourth;
				fourth = fifth;
				fifth = swithNum;
			}
		}






	}

	/* returns the minimum of the five numbers */
	public int getFirst()
	{
		return first;
	}

	/* returns the second smallest of the five number */
	public int getSecond()
	{
		return second;
	}

	/* returns the middle of the five numbers */
	public int getThird()
	{
		return third;
	}

	/* returns the second largest of the five numbers */
	public int getFourth()
	{
		return fourth;
	}

	/* returns the biggest of the five numbers */
	public int getFifth()
	{
		return fifth;
	}
}