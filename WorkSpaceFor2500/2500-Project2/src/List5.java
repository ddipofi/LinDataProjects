import java.util.*;

public class List5 extends BaseList
{
	public SLNode head;
	public SLNode tail;

	public int n;

	public int h;
	public Random r;

	public List5()
	  { 
	     SLNode p1, p2;

	     p1 = new SLNode(SLNode.negInf, null);
	     p2 = new SLNode(SLNode.posInf, null);

	     head = p1;
	     tail = p2;

	     p1.right = p2;
	     p2.left = p1;

	     n = 0;
	     h = 0;

	     r = new Random();
	  }

	public int size()
	{
		return n;
	}

	public boolean isEmpty()
	{
		return (n == 0);
	}

	public SLNode search(String k)
	{
		SLNode p;

		p = head;

		while (true)
		{
			while (p.right.key != SLNode.posInf && p.right.key.compareTo(k) <= 0)
			{
				p = p.right;
			}

			if (p.down != null)
			{
				p = p.down;
			} else
				break;
		}

		return (p);
	}

	public Integer get(String k)
	{
		SLNode p;

		p = search(k);

		if (k.equals(p.getKey()))
			return (p.value);
		else
			return (null);
	}

	public SLNode insertAfterAbove(SLNode p, SLNode q, String k)
	{
		SLNode e;

		e = new SLNode(k, null);

		e.left = p;
		e.right = p.right;
		e.down = q;

		p.right.left = e;
		p.right = e;
		q.up = e;

		return (e);
	}

	public Integer put(String k, Integer v)
	{
		SLNode p, q;
		int i;

		p = search(k);

		if (k.equals(p.getKey()))
		{
			Integer old = p.value;

			p.value = v;

			return (old);
		}

		q = new SLNode(k, v);
		q.left = p;
		q.right = p.right;
		p.right.left = q;
		p.right = q;

		i = 0;

		while (r.nextDouble() < 0.5)
		{
			if (i >= h)
			{
				SLNode p1, p2;

				h = h + 1;

				p1 = new SLNode(SLNode.negInf, null);
				p2 = new SLNode(SLNode.posInf, null);

				p1.right = p2;
				p1.down = head;

				p2.left = p1;
				p2.down = tail;

				head.up = p1;
				tail.up = p2;

				head = p1;
				tail = p2;
			}

			while (p.up == null)
			{
				p = p.left;
			}

			p = p.up;

			SLNode e;

			e = new SLNode(k, null);

			e.left = p;
			e.right = p.right;
			e.down = q;

			p.right.left = e;
			p.right = e;
			q.up = e;

			q = e;

			i = i + 1;

		}

		n = n + 1;

		return (null);
	}

//	public Integer remove(String key)
//	{
//		return (null);
//	}
//
//	public void printHorizontal()
//	{
//		String s = "";
//		int i;
//
//		SLNode p;
//
//		p = head;
//
//		while (p.down != null)
//		{
//			p = p.down;
//		}
//
//		i = 0;
//		while (p != null)
//		{
//			p.pos = i++;
//			p = p.right;
//		}
//
//		p = head;
//
//		while (p != null)
//		{
//			s = getOneRow(p);
//			System.out.println(s);
//
//			p = p.down;
//		}
//	}
//
//	public String getOneRow(SLNode p)
//	{
//		String s;
//		int a, b, i;
//
//		a = 0;
//
//		s = "" + p.key;
//		p = p.right;
//
//		while (p != null)
//		{
//			SLNode q;
//
//			q = p;
//			while (q.down != null)
//				q = q.down;
//			b = q.pos;
//
//			s = s + " <-";
//
//			for (i = a + 1; i < b; i++)
//				s = s + "--------";
//
//			s = s + "> " + p.key;
//
//			a = b;
//
//			p = p.right;
//		}
//
//		return (s);
//	}
//
//	public void printVertical()
//	{
//		String s = "";
//
//		SLNode p;
//
//		p = head;
//
//		while (p.down != null)
//			p = p.down;
//
//		while (p != null)
//		{
//			s = getOneColumn(p);
//			System.out.println(s);
//
//			p = p.right;
//		}
//	}
//
//	public String getOneColumn(SLNode p)
//	{
//		String s = "";
//
//		while (p != null)
//		{
//			s = s + " " + p.key;
//
//			p = p.up;
//		}
//
//		return (s);
//	}

	
	/*
	 * 
	 * 
	 * 
	 */
	
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
