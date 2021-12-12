/*
 * Dominic DiPofi
 * 11-20-21
 * 
 * list 2a extends baselist and adds words to linked list alphabetically using compareTo, using prev word for better searching
 * contains method for adding words found with find() method, as well as constructor
*/
public class List2a extends BaseList
{
	public LLNode currentNode = null;
	public LLNode prevNode = null;
	
	public List2a() //constructor for list
	{
		super();
	}
	
	@Override
	public void add(String word) //adds word to list
	{
		if (find(word)) //checks if word currently exists in list and increments if so
		{
			currentNode.count++;
		}
		else
		{
			LLNode newNode = new LLNode(word, 1); //adds a new node
			newNode.setNext(currentNode); //inserts new node alphabetically
			
			if (prevNode != null) //if there is a node before the current node, new node is placed in between prev and current node
			{
				prevNode.setNext(newNode);
			}
			else
			{
				list = newNode; //if there is no previous node, the list now points at the new node at the front of the list
			}
			
			refChanges += 2;
		}
	}
	
	public boolean find(String word)
	{	
		if (currentNode != null) //if there is already at least one word in the list
		{
			if (currentNode.word.compareTo(word) > 0) //if word is alphabetically before currentNode.word, start from beginning
			{
				currentNode = list;
				prevNode = null;
			} //else, prevNode stays what it was which will start searching at this word
		}
		else
		{
			currentNode = list;
			prevNode = null;
		}
		
		while (currentNode != null) //while there is at least one node in the list
		{	
			int compareValue = currentNode.word.compareTo(word); //used to sort list alphabetically
			keyCompare++;
			
			if (compareValue == 0) //if words are the same, return true
			{
				return true;
			}
			else if (compareValue < 0) //alphabetically searching for word
			{
				prevNode = currentNode;
				currentNode = currentNode.getNext();
			}
			else //word must be added
			{
				return false;
			}
		}
		
		return false;
	}
}