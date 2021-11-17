
public class SLNode
{
	protected String key;
	protected int value;
	
	//idk if i need these yet
	protected String word;
	protected int count;
	protected LLNode link;

	public SLNode up, down, left, right;
	
	//same with below stuff
	public SLNode(String word, int count) //constructor for node, needs a word and count of how many times this word has appeared in a txt file, as well as a link
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
