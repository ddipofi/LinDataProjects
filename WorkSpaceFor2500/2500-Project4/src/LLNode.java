/*
 * Dominic DiPofi
 * 10-30-21
 * 
 * node class to be used in various linked lists
 * uses simple constructor to set variables, as well as setter and getter for link
*/
public class LLNode
{
	protected String word;
	protected int count;
	protected LLNode link;

	public LLNode(String word, int count) //constructor for node, needs a word and count of how many times this word has appeared in a txt file, as well as a link
	{
		this.word = word;
		this.count = count;
		link = null;
	}

	public void setNext(LLNode link) //sets the link
	{
		this.link = link;
	}

	public LLNode getNext()//gets the current link
	{
		return link;
	}
}