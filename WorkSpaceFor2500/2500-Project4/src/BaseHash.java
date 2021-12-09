
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
	
	@Override
	public int getDistinctWords() //gets # vocabulary of list
	{
		int count = 0;
		
		for (int i = 0; i < 256; i++)
		{
			if (hashTable[i] != null)
			{
				count += hashTable[i].getDistinctWords();
			}
		}
		
		return count;
	}

	@Override
	public int getTotalWords()
	{
		int count = 0;
		
		for (int i = 0; i < 256; i++)
		{
			if (hashTable[i] != null)
			{
				count += hashTable[i].getTotalWords();
			}
		}
		
		return count;
	}
	
	@Override
	public long getRefChanges()
	{
		int count = 0;
		
		for (int i = 0; i < 256; i++)
		{
			if (hashTable[i] != null)
			{
				count += hashTable[i].getRefChanges();
			}
		}
		
		return count;
	}

	@Override
	public long getKeyCompare()
	{
		int count = 0;
		
		for (int i = 0; i < 256; i++)
		{
			if (hashTable[i] != null)
			{
				count += hashTable[i].getKeyCompare();
			}
		}
		
		return count;
	}
}
