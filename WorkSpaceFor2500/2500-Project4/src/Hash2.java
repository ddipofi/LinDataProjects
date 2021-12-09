
public class Hash2 extends BaseHash
{
	@Override
	public int hash(String word)
	{
		return (int) word.charAt(0);
	}
}
