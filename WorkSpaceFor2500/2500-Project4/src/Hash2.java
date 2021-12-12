/*
 * Dominic DiPofi
 * 12-10-21
 * 
 * hash 2 list, inherits from basehash and overrides with hash method
 * this hash method takes ASCII value of first char of word to use as hash value
*/
public class Hash2 extends BaseHash
{
	@Override
	public int hash(String word)
	{
		//gets hash value by taking ASCII value of first char of word
		return (int) word.charAt(0);
	}
}
