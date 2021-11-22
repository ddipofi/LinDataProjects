
public class SLNode
{
	public String key;
	public Integer value;

	public int pos;

	public SLNode up, down, left, right;

	public static String negInf = "NEG_INF";
	public static String posInf = "POS_INF";

	public SLNode(String k, Integer v) 
	  { 
	     key = k;
	     value = v;

	     up = down = left = right = null;
	  }

	public Integer getValue()
	{
		return value;
	}

	public String getKey()
	{
		return key;
	}

	public Integer setValue(Integer val)
	{
		Integer oldValue = value;
		value = val;
		return oldValue;
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

		return (ent.getKey() == key) && (ent.getValue() == value);
	}

	public String toString()
	{
		return "(" + key + "," + value + ")";
	}
}
