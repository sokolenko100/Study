package AVL_Tree;

public class AVLT 
{

	public static void main(String[] args) 
	{

	}

	private int Height(AVLNode p)
	{
		return p == null ? 0 : p.height;
	}

	private	int BalanceFactor(AVLNode p)
	{
		return Height(p.left) - Height(p.right);
	}

	private	AVLNode RotateRight(AVLNode p) 
	{
		AVLNode q = p.left;
		p.left = q.right;
		q.right = p;
		p.height = Math.max(Height(p.left), Height(p.right)) + 1;
		q.height = Math.max(Height(q.left), Height(q.right)) + 1;
		return q;
	}

	private	AVLNode RotateLeft(AVLNode p)
	{
		AVLNode q = p.right;
		p.right = q.left;
		q.left = p;
		p.height = Math.max(Height(p.left), Height(p.right)) + 1;
		q.height = Math.max(Height(q.left), Height(q.right)) + 1;
		return q;
	}

	AVLNode Balance(AVLNode p)
	{
		int balanceFactor = BalanceFactor(p);
		if( balanceFactor == -2 )
		{
			if( BalanceFactor(p.right) > 0 ) 
			{
				p.right = RotateRight(p.right);
			}
			return RotateLeft(p);
		}
		if( balanceFactor == 2 ) 
		{
			if( BalanceFactor(p.left) < 0 )
			{
				p.left = RotateLeft(p.left);
			}
			return RotateRight(p);
		}
		p.height = Math.max(Height(p.left), Height(p.right)) + 1;
		return p;
	}

	AVLNode Insert(AVLNode p, int val)
	{
		if( p == null)
		{
			return new AVLNode(val);
		}
		if( val < p.val ) 
		{
			p.left = Insert(p.left, val);
		} 
		else 
		{
			p.right = Insert(p.right, val);
		}
		return Balance(p);
	}

	AVLNode Findmin(AVLNode p) 
	{
		if (p == null)
		return null;
		
	      
		return  Findmin(p.left);
	}

	AVLNode RemoveMin(AVLNode p) 
	{
		if( p.left==null ) 
		{
			return p.right;
		}
		p.left = RemoveMin(p.left);
		return Balance(p);
	}


	AVLNode remove(AVLNode p, int val)
	{
		if( p == null) 
			return null;

		if( val < p.val )
		{
			p.left = remove(p.left,val);
		}
		else if( val > p.val)
		{
			p.right = remove(p.right,val);
		}
		else
		{
			AVLNode l = p.left;
			AVLNode r = p.right;
			
			if (r == null)
				return l;
			
			AVLNode min = Findmin(r);
			min.right = RemoveMin(r);
			min.left = l;
			return Balance(min);
		}
		return Balance(p);
	}

	int Count(AVLNode AVLTree )
	{
		if( AVLTree == null )
			return 0;
		
		return Math.max(Count( AVLTree.left ), Count( AVLTree.right )) + 1;
	}

	void free(AVLNode node) 
	{
		if (node == null)
			return;
		
		AVLNode  bufLeft = node.left;
		AVLNode  bufRight = node.right;

		free(bufLeft);
		free(bufRight);
	}


	AVLNode find(AVLNode tree, int val)
	{
		if (tree == null)
		{
			return null;
		}
		if (tree.val == val) 
		{
			return tree;
		}
		if( val < tree.val) 
		{
			tree.left = Insert(tree.left, val);
		} 
		else 
		{
			tree.right = Insert(tree.right, val);
		}
		return null;
	}

	public	class AVLNode
	{
		int val;
		AVLNode left;
		AVLNode right;
		AVLNode parent;
		int height;

		public AVLNode(int val)
		{
			this.val=val;
			left = null;
			right= null;
			height =1;
		}
	}
	AVLNode root = null;
}
