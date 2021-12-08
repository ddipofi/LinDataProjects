
public class BSTNode
{
	protected String key;
	protected int count;
	protected BSTNode left;
	protected BSTNode right;
	
	public BSTNode(String key, int count)
	{
		this.key = key;
		this.count = count;
		left = null;
		right = null;
	}
}
