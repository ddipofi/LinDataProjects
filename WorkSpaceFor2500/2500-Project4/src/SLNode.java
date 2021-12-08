
public class SLNode
{
	public String key;
	public int count;
	public int pos;
	public SLNode up, down, left, right;
	public static String negInf = "NEG_INF"; //string for left sentinel node
	public static String posInf = "POS_INF"; //for right sentinel

	public SLNode(String word, int count) //basic constructor
	  { 
	     key = word;
	     this.count = count;
	     up = down = left = right = null;
	  }

	public int getCount() //gets count
	{
		return count;
	}

	public String getKey() //gets word
	{
		return key;
	}

	public int setCount(int val) //sets count
	{
		int oldcount = count;
		count = val;
		
		return oldcount;
	}
}
