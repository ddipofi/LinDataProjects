
public class Hash1 extends BaseHash
{	
	@Override
	public int hash(String word)
	{
		int hash = 0;
		
		for (int i = 0; i < word.length(); i++)
		{
			hash += (int) word.charAt(i);
		}
		
		return hash & 255;
	}
}
