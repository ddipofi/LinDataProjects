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

		p1 = new SLNode(SLNode.negInf, 1);
		p2 = new SLNode(SLNode.posInf, 1);

		head = p1;
		tail = p2;

		p1.right = p2;
		p2.left = p1;

		n = 0;
		h = 0;

		r = new Random();
	}

	public SLNode search(String k)
	{
		SLNode p;

		p = head;

		while (true)
		{
			while (p.right.key != SLNode.posInf && p.right.key.compareTo(k) <= 0)
			{
				keyCompare += 2;
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

	@Override
	public void add(String k)
	{
		SLNode p, q;
		int i;

		p = search(k);

		if (k.equals(p.getKey()))
		{
			p.count++;
		}
		else
		{
			q = new SLNode(k, 1);
			q.left = p;
			q.right = p.right;
			p.right.left = q;
			p.right = q;
			refChanges += 4;

			i = 0;

			while (r.nextDouble() < 0.5)
			{
				if (i >= h)
				{
					SLNode p1, p2;

					h = h + 1;

					p1 = new SLNode(SLNode.negInf, 0);
					p2 = new SLNode(SLNode.posInf, 0);

					p1.right = p2;
					p1.down = head;

					p2.left = p1;
					p2.down = tail;
					
					refChanges += 4;

					head.up = p1;
					tail.up = p2;

					head = p1;
					tail = p2;
				}

				while (p.up == null)
				{
					p = p.left;
					refChanges++;
				}

				p = p.up;
				refChanges++;

				SLNode e;

				e = new SLNode(k, 0);

				e.left = p;
				e.right = p.right;
				e.down = q;

				p.right.left = e;
				p.right = e;
				q.up = e;

				q = e;
				
				refChanges += 6;

				i = i + 1;

			}

			n = n + 1;
		}		
	}

	@Override
	public int getDistinctWords()
	{
		// How many nodes are there on the list? Each corresponds to a unique word
		//
		int count = 0; // Alternate coding:
		SLNode p = head;
		
		while (p.down != null)
		{
			p = p.down;
		}
		
		while (p.right.key != SLNode.posInf)
		{
			p = p.right;
			count++;
		}
		
		return count;
	}

	@Override
	public int getTotalWords()
	{
		// How many TOTAL words? That's the sum of the counts in each node.
		//
		int count = 0;
		SLNode p = head;
		SLNode nextBottom;
		
		while (p.down != null)
		{
			p = p.down;
		}
		
		p = p.right;
		
		while (p.right != null)
		{
			nextBottom = p.right;
			
			while (p.up != null)
			{
				count += p.count;
				p = p.up;
			}
			
			count += p.count;
			p = nextBottom;
		}
		
		return count;
	}
}
