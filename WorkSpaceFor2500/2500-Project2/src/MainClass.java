import java.io.*;
import java.util.Scanner;

public class MainClass
{
	public static void main(String[] args) throws IOException
	{
		ListInterface[] Lists = new ListInterface[4]; // By creating the lists as
		// an array, we can iterate
		// with a subscript
		Lists[0] = new List1(); // Unsorted, insertions at beginning, no self-optimization
		Lists[1] = new List2(); // Sorted linked list
		Lists[2] = new List3(); // Unsorted, heavy-handed self-adjusting (moves repeated
		// word to the front of the list)
		Lists[3] = new List4(); // Unsorted, conservative self-adjusting (moves repeated
		// word one position towards front of list)
		//
		String[] ListNames = { "Unsorted", "Sorted", "Self-Adj (Front)", "Self-Adj (By One)" };
		//TODO add command line input
		final String FILE_NAME = "C:\\Users\\Dominic\\OneDrive\\Documents\\Classes\\LinDataSTRC\\Projects\\Project2Txts\\Hamlet.txt";
		
		for (int i = 0; i < 1; i++)
		{
			Scanner input = new Scanner(new File(FILE_NAME));
			
			while (input.hasNext())
			{
				String word = input.next();
				word = trimWord(word);
			}
			
			input.close();
		}
		
		for (int i = 0; i < 1; i++)
		{
			Scanner input = new Scanner(new File(FILE_NAME));
			long startTime = System.currentTimeMillis();
			
			while (input.hasNext())
			{
				String word = input.next();
				word = trimWord(word);
			}
			
			long parseTime = System.currentTimeMillis() - startTime;
			input.close();
			
			//TODO figure out why i need this System.out.print(parseTime);
		}
			
		for (int i = 0; i < 4; i++)
		{
			Scanner input = new Scanner(new File(FILE_NAME));
			long startTime = System.currentTimeMillis();
			
			while (input.hasNext())
			{
				String word = input.next();
				word = trimWord(word);
				
				if (word != "" && word != null)
				{
					Lists[i].add(word);
				}
				
				
				if (word == "")
				{
					int j = 9;
				}
				if (word == null)
				{
					int k = 8;
				}
				
				
			}
			
			long parseTime = System.currentTimeMillis() - startTime;
			input.close();
			
			//TODO print out various data needed
			
			
		}
	}
	
	public static String trimWord(String word)
	{
		StringBuilder sb = new StringBuilder(word);
		int lastCharIndex = 0;
		
		for (int i = 0; i < sb.length(); i++)
		{
			if (Character.isLetter(sb.charAt(i)))
			{
				lastCharIndex = i;
				break;
			}
			else
			{
				sb.deleteCharAt(i);
				i--;
			}
		}
		
		for (int i = sb.length() - 1; i > lastCharIndex; i--)
		{
			if (Character.isLetter(sb.charAt(i)))
			{
				break;
			}
			else
			{
				sb.deleteCharAt(i);
			}
		}
		
		return sb.toString();
	}
}
