/*
 * Dominic DiPofi
 * 11-20-21
 * 
 * list 5 extends baselist and adds words to linked list using various lanes called skiplist
 * contains method for adding words found with find() method, as well as constructor, and its own specific total/distinct methods
*/
import java.util.*;

public class List5 extends BaseList
{
	public SLNode head; //leftmost/uppermost node
	public SLNode tail; //rightmost/uppermost node
	public int n;
	public int h; //height
	public Random r;

	public List5() //basic constructor
	{
		SLNode p1, p2;
		p1 = new SLNode(SLNode.negInf, 1); //creating 2 pointers
		p2 = new SLNode(SLNode.posInf, 1);
		head = p1;
		tail = p2;
		p1.right = p2;
		p2.left = p1;
		n = 0;
		h = 0;
		r = new Random();
	}

	public SLNode search(String k) //search for specific word
	{
		SLNode p = head;

		while (true)
		{
			while (p.right.key != SLNode.posInf && p.right.key.compareTo(k) <= 0) //while k is to the right of p.right.key, keep searching right
			{
				keyCompare += 2;
				p = p.right;
			}

			if (p.down != null) //go down until one lane unless in slow lane
			{
				p = p.down;
			}
			else
			{
				break;
			}
		}

		return (p);
	}

	@Override
	public void add(String k) //add/insert method for words in .txt file
	{
		SLNode p, q;
		int i;

		p = search(k);

		if (k.equals(p.getKey())) //if word is already there
		{
			p.count++;
		}
		else
		{
			//add new node with word in where it belongs
			q = new SLNode(k, 1);
			q.left = p;
			q.right = p.right;
			p.right.left = q;
			p.right = q;
			refChanges += 4;

			i = 0;

			while (r.nextDouble() < 0.5) //determine height of new entry column via coin flip
			{
				if (i >= h) //need to increase height of list and adjust pointers to reflect that
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

				while (p.up == null) //reset p pointer
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
	public int getDistinctWords() //gets # vocabulary of list
	{
		int count = 0;
		SLNode p = head;
		
		while (p.down != null)
		{
			p = p.down;
		}
		
		while (p.right.key != SLNode.posInf) //count each node in the slow lane for total distinct words
		{
			p = p.right;
			count++;
		}
		
		return count;
	}

	@Override
	public int getTotalWords()
	{
		int count = 0;
		SLNode p = head;
		SLNode nextBottom; //bottom of the next column to the right of p
		
		while (p.down != null)
		{
			p = p.down;
		}
		
		p = p.right;
		
		while (p.right != null)
		{
			nextBottom = p.right;
			
			while (p.up != null) //count each SLNode and add its count to total count
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
