
public class Hash3 extends BaseHash
{
	@Override
	public int hash(String word)
	{
		int hash = 0;
		
		for (int i = 0; i < word.length(); i++)
		{
			hash = (hash * 31) + word.charAt(i);
		}
		
		return hash & 255;
	}
}
