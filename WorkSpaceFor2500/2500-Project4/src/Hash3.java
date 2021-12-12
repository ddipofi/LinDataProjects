/*
 * Dominic DiPofi
 * 12-10-21
 * 
 * hash 3 list, inherits from basehash and overrides with hash method
 * this hash method is similar to hash1 but takes into account order in which the characters appear
*/
public class Hash3 extends BaseHash
{
	@Override
	public int hash(String word)
	{
		//gets hash value by adding ASCII values but also taking into account order in which the characters appear
		int hash = 0;
		
		for (int i = 0; i < word.length(); i++)
		{
			hash = (hash * 31) + word.charAt(i);
		}
		
		return hash & 255;
	}
}
