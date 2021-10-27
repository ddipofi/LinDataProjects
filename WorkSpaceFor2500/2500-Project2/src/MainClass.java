
public class MainClass
{
	public static void main(String[] args)
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
		final String FILE_NAME = "";
		
		//go through 2 passes
			//1. open file, read, close file
			//2. open, get parse time, close
			
		//build the four lists here, with parse time and performance metrics at end of building each list
	}
}
