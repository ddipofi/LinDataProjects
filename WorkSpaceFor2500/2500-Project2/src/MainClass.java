import java.io.*;
import java.util.*;

public class MainClass
{
	public static void main(String[] args) throws IOException
	{
		ListInterface[] Lists = new ListInterface[6]; // By creating the lists as
		// an array, we can iterate
		// with a subscript
		Lists[0] = new List1(); // Unsorted, insertions at beginning, no self-optimization
		Lists[1] = new List2(); // Sorted linked list
		Lists[2] = new List2a(); //sorted linked list using reference node
		Lists[3] = new List3(); // Unsorted, heavy-handed self-adjusting (moves repeated
		// word to the front of the list)
		Lists[4] = new List4(); // Unsorted, conservative self-adjusting (moves repeated
		Lists[5] = new List5(); //skip list using lanes and insert method
		// word one position towards front of list)
		//
		String[] ListNames = { "Unsorted", "Sorted", "Sorted Modified", "Self-Adj (Front)", "Self-Adj (By One)", "Skip List"}; //names of lists stored in array for later output
		String FILE_NAME; //filename to be read by program
		
		if (args.length > 0) //this detects if command line has input a specific filename, or else it uses default string value
		{
			FILE_NAME = args[0];
		}
		else
		{
			FILE_NAME = "C:\\Users\\Dominic\\OneDrive\\Documents\\Classes\\LinDataSTRC\\Projects\\Project2Txts\\Hamlet.txt";
		}
		
		double parseTime = 0.0; //declaring time to read file
		
		//created table header
		System.out.printf("%2s %-17s %16s %16s %16s %16s %16s %3s %n", "#", "    List Name    ", "    Run Time    ", "   Vocabulary   ", "  Total Words   ", "    Key Comp    ", "    Ref Chgs    ", " h ");
		System.out.printf("%2s %-17s %16s %16s %16s %16s %16s %3s %n", "--", "-----------------", "----------------", "----------------", "----------------", "----------------", "----------------", "---");
		
		//initial read of program to fill buffers
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
		
		//second pass through program, recording run time without adding words to list
		for (int i = 0; i < 1; i++)
		{
			Scanner input = new Scanner(new File(FILE_NAME));
			long startTime = System.currentTimeMillis();
			
			while (input.hasNext())
			{
				String word = input.next();
				word = trimWord(word);
			}
			
			parseTime = (System.currentTimeMillis() - startTime) / 1000.0;
			input.close();
		}
		
		//looping through all four lists and readings/adding words to lists
		for (int i = 0; i < 6; i++)
		{
			Scanner input = new Scanner(new File(FILE_NAME));
			long startTime = System.currentTimeMillis();
			
			//scans every word and trims punctuation with trimWord method
			while (input.hasNext())
			{
				String word = input.next();
				word = trimWord(word);
				
				if (word != "") //if word, after trimming, is not an empty string, add it to the current list
				{
					Lists[i].add(word);
				}
			}
			
			double runTime = ((System.currentTimeMillis() - startTime) / 1000.0) - parseTime; //time it took to read and add to list, subtracting the overhead/parse time
			input.close();
			
			//formatting for table
			System.out.printf("%2d %-17s %16.3f %16d %16d %16d %16d", i + 1, ListNames[i], runTime, Lists[i].getDistinctWords(), Lists[i].getTotalWords(), Lists[i].getKeyCompare(), Lists[i].getRefChanges());
			
			if (i != 5)
			{
				System.out.println();
			}
		}
		System.out.printf("%3d %n", ((List5) Lists[5]).h);
	}
	
	public static String trimWord(String word)
	{
		//using stringbuilder to easily delete characters
		StringBuilder sb = new StringBuilder(word);
		
		//checking the front of the string for punctuation, removing any
		for (int i = 0; i < sb.length(); i++)
		{
			if (Character.isLetterOrDigit(sb.charAt(i)))
			{
				break; //if it detects a letter, that means there is no more front punctuation and it moves to next loop
			}
			else
			{
				sb.deleteCharAt(i);
				i--;
			}
		}
		
		//checking for rear punctuation, deleting any
		for (int i = sb.length() - 1; i >= 0; i--)
		{
			if (Character.isLetterOrDigit(sb.charAt(i)))
			{
				break;
			}
			else
			{
				sb.deleteCharAt(i);
			}
		}
		
		String trimmedWord = sb.toString(); //convert stringbuilder back to string to add to list
		return trimmedWord.toLowerCase();
	}
}
