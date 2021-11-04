
public class List3 extends BaseList
{
	public LLNode currentNode = null;
	public LLNode prevNode = null;
	
	public List3()
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
				currentNode.setNext(list);
				list = currentNode;
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
		
		while (currentNode != null)
		{	
			keyCompare++;
			
			if (currentNode.getWord().equals(word))
			{
				return true;
			}
			else
			{
				prevNode = currentNode;
				currentNode = currentNode.getNext();
			}
		}
		
		return false;
	}
}
