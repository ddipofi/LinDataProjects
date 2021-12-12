/*
 * Dominic DiPofi
 * 12-10-21
 * 
 * node class to be used in BST list
 * uses simple constructor to set variables
*/
public class BSTNode
{
	protected String key; //string that contains a specific word
	protected int count;
	protected BSTNode left; //left linked node
	protected BSTNode right; //right node
	
	//constructor
	public BSTNode(String key, int count)
	{
		this.key = key;
		this.count = count;
		left = null;
		right = null;
	}
}
