
public abstract class BaseHash extends BaseList
{
	public List3[] hashTable = new List3[256];
	
	public int hash(String word)
	{
		return 0;
	}
	
	@Override
	public void add(String word)
	{
		int hash = hash(word);
		
		if (hashTable[hash] == null)
		{
			hashTable[hash] = new List3();
		}
		
		hashTable[hash].add(word);
	}
}
