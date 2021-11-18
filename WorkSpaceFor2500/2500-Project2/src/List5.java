import java.util.*;

public class List5 extends BaseList
{
	public SLNode head, tail;
	public int h;
	public int n;
	public Random r;
	
	public List5()
	{
		SLNode p1 = new SLNode(SLNode.negInf, null);
		SLNode p2 = new SLNode(SLNode.posInf, null);
		p1.right = p2;
		p2.left = p1;
		head = p1;
		tail = p2;
		n = 0;
		h = 1;
		r = new Random();
		//TODO is h 1 or 0 idk yet
	}
	
	public SLNode search(String k)
	{
		SLNode p = head;
		
		while (true)
		{
			while (p.right.key != SLNode.posInf && (p.right.key).compareTo(k) <= 0)
			{
				p = p.right;
			}
			
			if (p.down != null)
			{
				p = p.down;
			}
			else
			{
				break;
			}
		}
		
		return p;
	}
	
	public int get(String k)
	{
		SLNode p = search(k);
		
		if (k.equals(p.key))
		{
			return p.value;
		}
		else
		{
			return null;
		}
	}
	
	
	
	@Override
	public int getDistinctWords()
	{
		// How many nodes are there on the list? Each corresponds to a unique word
		//
		int count = 0; // Alternate coding:
		SLNode p = list; //
		while (p != null) // for (LLNode p = list; p != null; p = p.getNext()) count++;
		{ // return count;
			count++; //
			p = p.getNext(); //
		} //
		return count; //
	}

	@Override
	public int getTotalWords()
	{
		// How many TOTAL words? That's the sum of the counts in each node.
		//
		int count = 0;
		SLNode p = list;
		while (p != null)
		{
			count += p.count;
			p = p.getNext();
		}
		return count;
	}
}
