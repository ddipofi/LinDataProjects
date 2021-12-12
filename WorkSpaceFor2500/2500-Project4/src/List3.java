/*
 * Dominic DiPofi
 * 10-30-21
 * 
 * list 3 extends baselist and adds words to front linked list, moves repeated words to front
 * contains method for adding words found with find() method, as well as constructor
*/
public class List3 extends BaseList
{
	public LLNode currentNode = null;
	public LLNode prevNode = null;
	
	public List3() //constructor for list
	{
		super();
	}
	
	@Override
	public void add(String word)
	{
		if (find(word)) //find word, if found, must move the node containing this word to the front of the list
		{
			currentNode.count++;
			
			if (currentNode != list) //if node isn't already at the front, move it to the front
			{
				prevNode.setNext(currentNode.getNext());
				currentNode.setNext(list);
				list = currentNode;
				refChanges += 3;
			}
		}
		else //else, new node is added to the beginning of the list
		{
			LLNode newNode = new LLNode(word, 1);
			newNode.setNext(list);
			list = newNode;
			refChanges += 2;
		}
	}
	
	public boolean find(String word)
	{	
		currentNode = list;
		prevNode = null;
		
		while (currentNode != null) //similar find method to list 1, but must have previous node so links stay intact
		{	
			keyCompare++;
			
			if (currentNode.word.equals(word))
			{
				return true;
			}
			else
			{
				prevNode = currentNode; //previous node is set
				currentNode = currentNode.getNext(); //current node changes to the next node in the list
			}
		}
		
		return false;
	}
}
