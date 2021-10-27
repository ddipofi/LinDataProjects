public class LLNode
{
	protected String word;
	protected int count;
	protected LLNode link;

	public LLNode(String word, int count)
	{
		this.word = word;
		this.count = count;
		link = null;
	}

	public void setWord(String word)
	{
		this.word = word;
	}

	public String getWord()
	{
		return word;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public int getCount()
	{
		return count;
	}

	public void setNext(LLNode link)
	{
		this.link = link;
	}

	public LLNode getNext()
	{
		return link;
	}
}