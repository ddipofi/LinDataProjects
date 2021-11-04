
public class List4 extends BaseList
{
	public LLNode currentNode = null;
	public LLNode prevNode = null;
	public LLNode pprevNode = null;
	
	public List4()
	{
		super();
	}
	
	@Override
	public void add(String word)
	{
		if (find(word))
		{
			currentNode.count++;
			
			if (currentNode != list)
			{
				prevNode.setNext(currentNode.getNext());
				currentNode.setNext(prevNode);
				
				if (pprevNode != null)
				{
					pprevNode.setNext(currentNode);
				}
				
				refChanges += 3;
			}
		}
		else
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
			
			if (currentNode.getWord().equals(word))
			{
				return true;
			}
			else
			{
				pprevNode = prevNode;
				prevNode = currentNode;
				currentNode = currentNode.getNext();
			}
		}
		
		return false;
	}
}
