/*
 * Dominic DiPofi
 * 10-30-21
 * 
 * list 1 extends baselist and adds words to linked list in order they appear
 * contains method for adding words found with find() method, as well as constructor
*/
public class List1 extends BaseList
{
	public LLNode currentNode = null;
	
	public List1() //constructor for list
	{
		super();
	}
	
	@Override
	public void add(String word) //method to add word to list
	{
		if (find(word)) //checks if word is already in list, in which case the count is incremented
		{
			currentNode.count++;
		}
		else
		{
			LLNode newNode = new LLNode(word, 1); //adds new node with word and puts it at front of list
			newNode.setNext(list);
			list = newNode;
			refChanges += 2;
		}
	}
	
	public boolean find(String word) //searches each node in the list for the current word, returning true if found
	{	
		currentNode = list;
		
		while (currentNode != null)
		{	
			keyCompare++;
			
			if (currentNode.word.equals(word))
			{
				return true;
			}
			else
			{
				currentNode = currentNode.getNext();
			}
		}
		
		return false;
	}
}
