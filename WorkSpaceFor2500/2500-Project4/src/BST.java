/*
 * Dominic DiPofi
 * 12-10-21
 * 
 * binary search tree list, creates tree from distinct words
 * contains search, add, traverse, get distinct/total word methods
 * as well as many variables to be used in the methods
*/
public class BST extends BaseList
{
	public BSTNode root = null; //root node
	public BSTNode p = null; //pointer node
	public BSTNode n = null; //node that stores previous p value
	public BSTNode s = null; //node to store search value
	public int cmp = 0; //compareTo value
	public int vCount = 0; //distinct word count
	public int tCount = 0 ; //total word count
	public int h = 1; //BST height
	public int maxH = 0; //max height of BST
	
	public BSTNode search(String key)
	{
		//uses String key parameter to detect if key is in list
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
		//adds string word to list, or increases count if already in list
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
				
				//decides left or right node based on cmp value
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
		//travels from node to node going left then right to
		//increment counts and adjust height
		//BSTNode b is root node
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
		//gets number of distinct words in list
		vCount = 1;
		tCount = root.count;
		traverse(root);
		return vCount;
	}

	@Override
	public int getTotalWords()
	{
		//gets num of total words in list
		return tCount;
	}
}
