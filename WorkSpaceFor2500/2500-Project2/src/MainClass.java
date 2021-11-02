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
		final String FILE_NAME = "\"C:\\Users\\Dominic\\OneDrive\\Documents\\Classes\\LinDataSTRC\\Projects\\Project2Txts\\Hamlet.txt\"";
		
		//go through 2 passes
			//1. open file, read, close file
			//2. open, get parse time, close
		
		for (int i = 0; i < 6; i++)
		{
			//BufferedReader reader = new BufferedReader(openFile(FILE_NAME));
			Scanner input = new Scanner(new File(FILE_NAME));
			//StringBuilder builder = new StringBuilder();
			//String line = reader.readLine();
			
			switch (i)
			{
				case 0:
					while (input.hasNextLine())
					{
						Scanner line = new Scanner(input.nextLine());
						
						while (input.hasNext());
						{
							String word = line.next();
							//TODO remove this test
							System.out.println(word);
						}
					}
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					break;
			}
			
			//closeFile(reader);
			input.close();
		}
		
		//build the four lists here, with parse time and performance metrics at end of building each list
	}
	
	public static Reader openFile(String fileName) throws IOException
	{
		return new FileReader(new File(fileName));
	}
	
	public String readWord(String line)
	{
		return "";
	}
	
	public static void closeFile(Reader reader) throws IOException
	{
		if (reader != null)
		{
			reader.close();
		}
	}
}
