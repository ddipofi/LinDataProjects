
import java.util.Scanner;

public class CardStack
{
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		int n = userInput.nextInt();
		int m = userInput.nextInt();
		@SuppressWarnings("unchecked")
		LLStack<Integer>[][] cards;
		
		for (int i = 1; i <= n * m; i++)
		{
			String OSVString = userInput.nextLine();
			OSV.ValidateOSV(OSVString);
			int OSVInt = OSV.OSVToInt(OSVString);
			
			//add OSVInt to array or node or stack or whatever
			cards[n][m] = new LLStack();
			cards.push(OSVInt);
		}
		
		for (int i = 1; i <= n + m - 2; i++)
		{
			String flipString = userInput.nextLine();
			//add flipString to array or something to keep track
		}
		
		userInput.close();
	}
}