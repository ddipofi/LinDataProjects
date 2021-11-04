
public class List2 extends BaseList
{
	public LLNode currentNode = null;
	public LLNode prevNode = null;
	
	public List2()
	{
		super();
	}
	
	@Override
	public void add(String word)
	{
		if (find(word))
		{
			currentNode.count++;
		}
		else
		{
			LLNode newNode = new LLNode(word, 1);
			newNode.setNext(currentNode);
			
			if (prevNode != null)
			{
				prevNode.setNext(newNode);
			}
			else
			{
				list = newNode;
			}
			
			refChanges += 2;
		}
	}
	
	public boolean find(String word)
	{	
		currentNode = list;
		prevNode = null;
		
		while (currentNode != null)
		{	
			int compareValue = currentNode.getWord().compareTo(word);
			keyCompare++;
			
			if (compareValue == 0)
			{
				return true;
			}
			else if (compareValue < 0)
			{
				prevNode = currentNode;
				currentNode = currentNode.getNext();
			}
			else
			{
				return false;
			}
		}
		
		return false;
	}
}
