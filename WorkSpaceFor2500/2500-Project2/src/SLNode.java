
public class SLNode
{
	public String key;
	public int count;

	public int pos;

	public SLNode up, down, left, right;

	public static String negInf = "NEG_INF";
	public static String posInf = "POS_INF";

	public SLNode(String word, int count) 
	  { 
	     key = word;
	     this.count = count;

	     up = down = left = right = null;
	  }

	public int getCount()
	{
		return count;
	}

	public String getKey()
	{
		return key;
	}

	public int setCount(int val)
	{
		int oldcount = count;
		count = val;
		return oldcount;
	}

	public boolean equals(Object o)
	{
		SLNode ent;

		try
		{
			ent = (SLNode) o;
		} catch (ClassCastException ex)
		{
			return false;
		}

		return (ent.getKey() == key) && (ent.getCount() == count);
	}

	public String toString()
	{
		return "(" + key + "," + count + ")";
	}
}
