
public class BST extends BaseList
{
	BSTNode root = null;
	BSTNode p = null;
	BSTNode n = null;
	BSTNode s = null;
	int cmp = 0;
	int vCount = 0;
	int tCount = 0 ;
	
	public BSTNode search(String key)
	{
		p = root;
		refChanges++;
		
		while (p != null)
		{
			cmp = p.key.compareTo(key);
			keyCompare++;
			
			if (cmp == 0) return p;
			
			n = p;
			p = (cmp > 0) ? p.left : p.right;
			refChanges += 2;
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
				}
				else
				{
					n.right = a;
				}
			}
		}
		else
		{
			s.count++;
		}
	}
	
	public void traverseV(BSTNode b)
	{	
		if (b.left != null)
		{
			vCount++;
			traverseV(b.left);
		}
		
		if (b.right != null)
		{
			vCount++;
			traverseV(b.right);
		}
	}
	
	public void traverseT(BSTNode b)
	{	
		if (b.left != null)
		{
			tCount += b.left.count;
			traverseT(b.left);
		}
		
		if (b.right != null)
		{
			tCount += b.right.count;
			traverseT(b.right);
		}
	}
	
	@Override
	public int getDistinctWords() //gets # vocabulary of list
	{
		vCount = 1;
		traverseV(root);
		return vCount;
	}

	@Override
	public int getTotalWords()
	{
		tCount = root.count;
		traverseT(root);
		return tCount;
	}
}
