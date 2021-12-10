
public class BST extends BaseList
{
	public BSTNode root = null;
	public BSTNode p = null;
	public BSTNode n = null;
	public BSTNode s = null;
	public int cmp = 0;
	public int vCount = 0;
	public int tCount = 0 ;
	public int h = 1;
	public int maxH = 0;
	
	public BSTNode search(String key)
	{
		p = root;
		
		while (p != null)
		{
			cmp = p.key.compareTo(key);
			keyCompare++;
			
			if (cmp == 0) return p;
			
			n = p;
			p = (cmp > 0) ? p.left : p.right;
		}
		
		return p;
	}
	
	@Override
	public void add(String word)
	{
		s = search(word);
		
		if (s == null)
		{
			if (root == null)
			{
				root = new BSTNode(word, 1);
				refChanges++;
			}
			else
			{
				BSTNode a = new BSTNode(word, 1);
				
				if (cmp > 0)
				{
					n.left = a;
					refChanges++;
				}
				else
				{
					n.right = a;
					refChanges++;
				}
			}
		}
		else
		{
			s.count++;
		}
	}
	
	public void traverse(BSTNode b)
	{	
		if (b.left != null)
		{
			vCount++;
			tCount += b.left.count;
			h++;
			traverse(b.left);
		}
		
		if (b.right != null)
		{
			vCount++;
			tCount += b.right.count;
			h++;
			traverse(b.right);
		}
		
		h--;
		
		if (h > maxH)
		{
			maxH = h;
		}
		
	}
	
	@Override
	public int getDistinctWords() //gets # vocabulary of list
	{
		vCount = 1;
		tCount = root.count;
		traverse(root);
		return vCount;
	}

	@Override
	public int getTotalWords()
	{
		return tCount;
	}
}
