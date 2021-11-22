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

	@Override
	public void add(String word)
	{
		put(word, 123);
		
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
