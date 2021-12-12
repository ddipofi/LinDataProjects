/*
 * Dominic DiPofi
 * 10-30-21
 * 
 * list 4 extends baselist and adds words to front of llist, and repeated words are moved up one spot in llist
 * contains method for adding words found with find() method, as well as constructor
*/
public class List4 extends BaseList
{
	public LLNode currentNode = null;
	public LLNode prevNode = null;
	public LLNode pprevNode = null; //the node previous to the previous node, or twice previous
	
	public List4() //constructor for list
	{
		super();
	}
	
	@Override
	public void add(String word)
	{
		if (find(word))
		{
			currentNode.count++;
			
			if (currentNode != list) //if the current node is not the first node in the list
			{
				prevNode.setNext(currentNode.getNext());
				currentNode.setNext(prevNode);
				
				if (pprevNode != null) //if there are at least 2 nodes before the current node
				{
					pprevNode.setNext(currentNode); //set link for the previous previous node
				}
				else
				{
					list = currentNode; //list points to current node
				}
				
				refChanges += 3;
			}
		}
		else //add new node to front
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
		pprevNode = null;
		
		while (currentNode != null)
		{	
			keyCompare++;
			
			if (currentNode.word.equals(word))
			{
				return true;
			}
			else //continue searching list for word, setting the two previous nodes as well as current node
			{
				pprevNode = prevNode;
				prevNode = currentNode;
				currentNode = currentNode.getNext();
			}
		}
		
		return false;
	}
}
