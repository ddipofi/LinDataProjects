import java.io.*;
import java.util.*;

public class MainClass
{
	public static void main(String[] args) throws IOException
	{
		ListInterface[] Lists = new ListInterface[10]; // By creating the lists as
		// an array, we can iterate
		// with a subscript
		Lists[0] = new List1(); // Unsorted, insertions at beginning, no self-optimization
		Lists[1] = new List2(); // Sorted linked list
		Lists[2] = new List2a(); //sorted linked list using reference node
		Lists[3] = new List3(); // Unsorted, heavy-handed self-adjusting (moves repeated
		// word to the front of the list)
		Lists[4] = new List4(); // Unsorted, conservative self-adjusting (moves repeated
		Lists[5] = new List5(); //skip list using lanes and insert method
		Lists[6] = new Hash1(); //TODO comment
		Lists[7] = new Hash2();
		Lists[8] = new Hash3();
		Lists[9] = new BST();
		// word one position towards front of list)
		//
		String[] ListNames = { "Unsorted", "Sorted", "Sorted Modified", "Self-Adj (Front)", "Self-Adj (By One)", "Skip List", "Hash 1", "Hash 2", "Hash 3", "Binary Search Tree"}; //names of lists stored in array for later output
		String FILE_NAME; //filename to be read by program
		
		if (args.length > 0) //this detects if command line has input a specific filename, or else it uses default string value
		{
			FILE_NAME = args[0];
		}
		else
		{
			FILE_NAME = "C:\\Users\\Dominic\\OneDrive\\Documents\\Classes\\LinDataSTRC\\Projects\\Project2Txts\\War and Peace.txt";
		}
		
		double parseTime = 0.0; //declaring time to read file
		
		//created table header
		System.out.printf("%2s %-19s %16s %16s %16s %16s %16s %3s %n", "#", "     List Name     ", "    Run Time    ", "   Vocabulary   ", "  Total Words   ", "    Key Comp    ", "    Ref Chgs    ", " h ");
		System.out.printf("%2s %-19s %16s %16s %16s %16s %16s %3s %n", "--", "-------------------", "----------------", "----------------", "----------------", "----------------", "----------------", "---");
		
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
		//TODO change i back to 0
		//looping through all four lists and readings/adding words to lists
		for (int i = 9; i < 10; i++)
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
			if (i < 2)
			{
				System.out.printf("%2d %-19s %16.3f %16d %16d %16d %16d", i + 1, ListNames[i], runTime, Lists[i].getDistinctWords(), Lists[i].getTotalWords(), Lists[i].getKeyCompare(), Lists[i].getRefChanges());
			}
			else if (i == 2)
			{
				System.out.printf("%2s %-19s %16.3f %16d %16d %16d %16d", "2a", ListNames[i], runTime, Lists[i].getDistinctWords(), Lists[i].getTotalWords(), Lists[i].getKeyCompare(), Lists[i].getRefChanges());
			}
			else if (i < 6)
			{
				System.out.printf("%2d %-19s %16.3f %16d %16d %16d %16d", i, ListNames[i], runTime, Lists[i].getDistinctWords(), Lists[i].getTotalWords(), Lists[i].getKeyCompare(), Lists[i].getRefChanges());
			}
			else if (i == 6)
			{
				System.out.printf("%2s %-19s %16.3f %16d %16d %16d %16d", "H1", ListNames[i], runTime, Lists[i].getDistinctWords(), Lists[i].getTotalWords(), Lists[i].getKeyCompare(), Lists[i].getRefChanges());
			}
			else if (i == 7)
			{
				System.out.printf("%2s %-19s %16.3f %16d %16d %16d %16d", "H2", ListNames[i], runTime, Lists[i].getDistinctWords(), Lists[i].getTotalWords(), Lists[i].getKeyCompare(), Lists[i].getRefChanges());
			}
			else if (i == 8)
			{
				System.out.printf("%2s %-19s %16.3f %16d %16d %16d %16d", "H3", ListNames[i], runTime, Lists[i].getDistinctWords(), Lists[i].getTotalWords(), Lists[i].getKeyCompare(), Lists[i].getRefChanges());
			}
			else
			{
				System.out.printf("%2s %-19s %16.3f %16d %16d %16d %16d", "BT", ListNames[i], runTime, Lists[i].getDistinctWords(), Lists[i].getTotalWords(), Lists[i].getKeyCompare(), Lists[i].getRefChanges());
			}
			
			if (i != 5 && i != 9)
			{
				System.out.println();
			}
			else if (i == 5)
			{
				System.out.printf("%3d %n", ((List5) Lists[5]).h);
			}
			else
			{
				System.out.printf("%3d %n", ((BST) Lists[9]).maxH);
			}
		}
	}
	
	//TODO im one word off for all file
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
