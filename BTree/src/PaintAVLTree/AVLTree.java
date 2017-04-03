package PaintAVLTree;




public class AVLTree extends Btree
{
	protected	AVLTree()
	{
		int [] arrayTemp = {30,20,40,15,35,50,10,16,60,25,45,34,22,26};
		this.init(arrayTemp);
	}
	public void init(int[] tempArray)  
	{
		this. clear();	
		if (tempArray== null||tempArray.length==0)
			return;

		for (int i = 0; i < tempArray.length; i++)
		{
			this.add(tempArray[i]);
		}
	}
	private Node leftRotation(Node p)
	{
		if(p==null)
			return null;


		Node childR= p.right;
		p.right =childR.left;
		childR.left=p;

		return childR;
	}
	private Node rightRotation(Node p)
	{
		if(p==null)
			return null;

		Node childL = p.left;
		p.left= childL.right;
		childL.right= p;

		return childL;
	}
	private int heightN(Node p)
	{
		if(p==null)
			return 0;

		return p.height;
	}
	private	 int balance(Node p) 
	{
		if (p == null)
			return 0;

		return  Height(p.left) - Height(p.right);
	}
	public void add(int val) 
	{			
		if (root==null) 
		{
			root= addNod( root,  val);
		}
		else
		{
		 addNod(root, val);
		}
	}

	private Node addNod(Node p ,int val)
	{
		if (p==null)
			return  (new Node(val));

		if(val<p.value )
		{
			p.left = addNod(p.left, val);
		}
		if(val>p.value)
		{
			p.right = addNod(p.right, val);
		}
		
		return rotate(p);
	}
	private Node rotate(Node p)
	{
		int balanceF = balance(p);

		if (balanceF==2)
		{
			if(balance(p.left)<0)
			{
				p.left = leftRotation(p.left);
			}
			return rightRotation(p);
		}
		if (balanceF==-2)
		{
			if(balance(p.right)>0)
			{
				p.right = rightRotation(p.right);
			}
			return leftRotation(p);
		}
		return p;
	}
	
	private void DellNode (Node grandparent,Node parent, Node current,int val)
	{
		if(current.value>val)
		{
			grandparent=parent;
			parent =current;
			DellNode (grandparent, parent,  current.left, val);
		}
		else if(current.value<val)
		{
			grandparent=parent;
			parent =current;
			DellNode (grandparent, parent,  current.right, val);
		}
		else
		{
			if(current.left==null&&current.right==null)
			{
				if(root==current)
				{
					root=null;
					return;
				}
				if (parent.left==current) 
				{
					parent.left=null;
				}
				else
				{
					parent.right=null;
				}
			}
			else if(current.left==null||current.right==null)
			{
				if (current.left==null)
				{
					if(root==current)
					{
						root=current.right;
						return;
					}
					if (parent.left==current) 
					{
						parent.left=current.right;
					}
					else
					{
						parent.right=current.right;
					}	
				}
				else
				{
					if(root==current)
					{
						root=current.left;
						return;
					}
					if (parent.left==current)  
					{
						parent.left=current.left;
					}
					else
					{
						parent.right=current.left;
					}
				}
			}
			else
			{
				Node nodeSearch=null;
				if (root ==current)
				{

					if (current.left.right!=null)
					{
						nodeSearch=	SearchNode(current.left.right,current.left);
						nodeSearch.left=root.left;
						nodeSearch.right=root.right;
						root=nodeSearch;
					}
					else
					{
						Node tmp = root.left;
						tmp.right=root.right;
						root=tmp;
					}
				}
				else
				{
					if (current.left.right!=null)
					{

						nodeSearch=	SearchNode(current.left.right,current.left);
						if (parent.left==current) 
						{
							nodeSearch.left=current.left;
							nodeSearch.right=current.right;
							parent.left=nodeSearch;	
						}
						else
						{
							nodeSearch.left=current.left;
							nodeSearch.right=current.right;
							parent.right=nodeSearch;	
						}
					}
					else
					{
						if (parent.left==current)
						{
							Node tmp = current.left;
							tmp.right=current.right;
							parent.left=tmp;
						}
						else
						{
							Node tmp = current.left;
							tmp.right=current.right;
							parent.right=tmp;
						}
					}	
				}
			}
			
		}
		if(grandparent.left == parent)
		{
			grandparent.left =rotate(parent);
		}
		if(grandparent.right == parent)
		{
			grandparent.right =rotate(parent);
		}
	}
	private Node SearchNode(Node p, Node parent)
	{
		if(p.right==null)
		{
			parent.right=p.left;
			return p;
		}
		parent = p;
		SearchNode( p.right,parent );
		return rotate(p);
			
	}
	@Override
	public void del(int val) 
	{
		if(root==null)
			return;

		Boolean isLeft = false;
		Node parent = null;
		Node current = root;
		Node grandparent = root;
		DellNode (grandparent, parent,  current, val);
	}
	
}
