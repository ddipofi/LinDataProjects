
public class List1 extends BaseList
{
	public LLNode currentNode = null;
	
	public List1()
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
			newNode.setNext(list);
			list = newNode;
			refChanges += 2;
		}
	}
	
	public boolean find(String word)
	{	
		currentNode = list;
		
		while (currentNode != null)
		{	
			keyCompare++;
			
			if (currentNode.getWord().equals(word))
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
