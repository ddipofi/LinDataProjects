/*
 * Dominic DiPofi
 * 12-10-21
 * 
 * hash 1 list, inherits from basehash and overrides with hash method
 * this hash method adds ASCII values of word and gets remainder using & 255 for hash value
*/
public class Hash1 extends BaseHash
{	
	@Override
	public int hash(String word)
	{
		//gets hash value by adding ASCII values of word and gets remainder
		//using & 255 for hash value
		int hash = 0;
		
		for (int i = 0; i < word.length(); i++)
		{
			hash += (int) word.charAt(i);
		}
		
		return hash & 255;
	}
}
