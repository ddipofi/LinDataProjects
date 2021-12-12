/*
 * Dominic DiPofi
 * 12-10-21
 * 
 * base abstract for the 3 hash lists since they use many of the same methods
 * includes List3 array, hash, add, distinct/total words, refchanges, and keycomp methods
*/
public abstract class BaseHash extends BaseList
{
	public List3[] hashTable = new List3[256]; //array containing 256 List3s
	
	public int hash(String word)
	{
		//basic hash function to be overridden by the 3 specific hash lists
		return 0;
	}
	
	@Override
	public void add(String word)
	{
		//adds word to hashTable array, index based on hash value
		//String word is word read from file after trim
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
		//gets number of distinct words in the list
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
		//gets number of total words in the list
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
		//gets number of ref changes in the list
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
		//gets number of key comps in the list
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
