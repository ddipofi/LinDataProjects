import java.util.*;

public class List5 extends BaseList
{
	private SLNode head, tail;
	private int h;
	private int n;
	private Random r;
	
	public List5()
	{
		head = new SLNode(SLNode.negInf);
		tail = new SLNode(SLNode.posInf);
		head.right = tail;
		tail.left = head;
		r = new Random();
		n = 0;
		h = 1;
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
