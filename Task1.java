import java.util.*;

class Task1
{
	public void guessingNumberGame()
	{
	
		Scanner obj=new Scanner(System.in);
	
		int num = 1 + (int)(Math.random() * 100);

		System.out.println("Enter The no. of rounds you would like to try:  ");
		int max=obj.nextInt();
		
		

		for(int i=0;i<max;i++)
		{

			System.out.println("Guess a Number between 1 to 100: ");
			int guess=obj.nextInt();
			System.out.println();
	
			if(guess==num)
			{	
				System.out.println("Congratulations! You have guessed the appropriate number.");
				System.out.println();
				break;
			}
			else if(guess>num && i!=max-1)
			{
				System.out.println("Your guess is greater than the appropriate number. Try Guessing, I am sure you will succeed!");
				System.out.println();
			}
			else if(guess<num && i!=max-1)
			{
				System.out.println("Your guess is smaller than the appropriate number. Try Guessing, I am sure you will succeed!");
				System.out.println();
			}
		}
	
		if(max==5)
		{
			System.out.println("I am finding you to be exhausted now. No issues, I can help you out");
			System.out.println("The Appropriate number is " + num);
			System.out.println();
		}

	}
	
	
	public static void main(String args[])
	{
		Main m=new  Main();
		m.guessingNumberGame();
	}
}
