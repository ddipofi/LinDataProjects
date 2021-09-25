
import java.util.Scanner;

public class CardStack
{
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		
		//should be in loop for as many tests as there are
		int n = userInput.nextInt();
		int m = userInput.nextInt();
		userInput.nextLine();
		@SuppressWarnings("unchecked")
		LLStack<Integer>[][] cards = new LLStack[n][m];
		
		for (int i = 1; i <= n * m; i++)
		{
			String OSVString = userInput.nextLine();
			OSV.ValidateOSV(OSVString);
			int OSVInt = OSV.OSVToInt(OSVString);
			cards[n][m].push(OSVInt);
		}
		
		for (int i = 1; i <= n + m - 2; i++)
		{
			String flipString = userInput.nextLine();
			//add flipString to array or something to keep track
		}
		
		userInput.close();
	}
}