package AVL_Tree;

import java.util.Iterator;

import BTree.ETree;


public class AVLTree implements ETree
{

	public static void main(String[] args)
	{
		AVLTree tree = new AVLTree();
		int val = 4;
		int[] ex = { 2, 3, 4 };
		tree.init(ex);
		tree.toString();
	}
	private int heightNode(Node p)
	{
		int result;
		if (p == null)
		{
			result = 0;
		}
		else
		{
			result=p.height;	
		}
		return  result;
	}

	private	int balanceFactor(Node p)
	{
		return heightNode(p.left) - heightNode(p.right);
	}
	private	Node rotateRight(Node p) 
	{
		if(p==null)
			return null;

		Node temp = p.left;
		p.left = temp.right;
		temp.right = p;
		p.height = Math.max(heightNode(p.left), heightNode(p.right)) + 1;
		temp.height = Math.max(heightNode(temp.left), heightNode(temp.right)) + 1;
		return temp;
	}

	private	Node rotateLeft(Node p)
	{
		if(p==null)
			return null;

		Node temp = p.right;
		p.right = temp.left;
		temp.left = p;
		p.height = Math.max(heightNode(p.left), heightNode(p.right)) + 1;
		temp.height = Math.max(heightNode(temp.left), heightNode(temp.right)) + 1;
		return temp;
	}

	private Node Balance(Node p)
	{
		if(p==null)
			return null;

		//	int balanceFactor = balanceFactor(p);
		//	if( balanceFactor <= -2 )
		if (heightNode( p.left)+1>heightNode( p.right))
		{
			if( balanceFactor(p.right) > 0 ) 
			{
				p.right = rotateRight(p.right);
			}
			return rotateLeft(p);
		}
		//if( balanceFactor >= 2 ) 
		if(heightNode( p.left)<heightNode( p.right)+1)
		{
			if( balanceFactor(p.left) < 0 )
			{
				p.left = rotateLeft(p.left);
			}
			return rotateRight(p);
		}
		p.height = Math.max(heightNode(p.left), heightNode(p.right)) + 1;
		return p;
	}
	////////////////////////////////////////////////////////
	// Add
	////////////////////////////////////////////////////////
	public void add(int val) 
	{			
		if (root==null) 
		{
			root= new Node(val);
			return;
		}
		else
		{
			this.AddNode(root, val);
		}
	}
	Node AddNode(Node p, int val)
	{
		if( p == null)
			return new Node(val);

		if( val < p.val ) 
		{
			p.left = AddNode(p.left, val);
		} 
		else 
		{
			p.right = AddNode(p.right, val);
		}
		return Balance(p);
	}
	////////////////////////////////////////////////////////
	// init
	////////////////////////////////////////////////////////
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
	////////////////////////////////////////////////////////
	// print
	////////////////////////////////////////////////////////
	public void print() 
	{
		printNode(root);
	}
	private void printNode(Node p)
	{
		if(p==null)
			return;

		this.printNode(p.left);
		System.out.print(p.val+", ");
		this.printNode(p.right);
	}
	////////////////////////////////////////////////////////
	// clear
	////////////////////////////////////////////////////////
	public void clear()
	{
		root =null;
	}
	////////////////////////////////////////////////////////
	// size
	////////////////////////////////////////////////////////
	@Override
	public int size() 
	{
		int size =0;
		size= sizeNode(root);
		return size;
	}
	private int sizeNode(Node root)
	{
		if(root ==null)
			return 0;

		return 1 +sizeNode(root.left)+sizeNode(root.right);
	}
	////////////////////////////////////////////////////////
	// nodes
	////////////////////////////////////////////////////////
	@Override
	public int nodes() 
	{
		int result = 0;
		result= Nodes( root);
		return result;
	}
	private int Nodes(Node p)
	{
		if (p==null)
			return 0;

		int count=0;

		if ((p.left!=null)|| (p.right!=null))
			count++;

		count+=Nodes( p.left);
		count+=Nodes( p.right);
		return count;
	}
	////////////////////////////////////////////////////////
	// leaves
	////////////////////////////////////////////////////////
	@Override
	public int leaves()
	{
		int result = 0;
		result= Leaves( root);
		return result;
	}
	private int Leaves(Node p)
	{
		if (p==null)
			return 0;

		int count=0;

		if ((p.left==null)&&(p.right==null))
			count++;

		count+=Leaves( p.left);
		count+=Leaves( p.right);
		return count;
	}
	////////////////////////////////////////////////////////
	// height
	////////////////////////////////////////////////////////
	@Override
	public int height()
	{
		int result =0;
		result = Height(root);
		return result;
	}
	public int Height(Node p)
	{
		if (p==null) 
		{
			return 0;
		}
		int result =0;
		int leftCount=0;
		int rightCount=0;
		leftCount= Height(p.left);
		rightCount= Height(p.right);
		result=1 + Math.max(leftCount, rightCount);
		return result;
	}
	////////////////////////////////////////////////////////
	// width
	////////////////////////////////////////////////////////
	@Override
	public int width() 
	{
		int result = 0;
		int [] array= new int[height()];
		Width(root,array,0);
		result= max( array);
		return result;
	}
	public void Width(Node p,int [] array,int level) 
	{
		if (p==null) 
			return ;
		Width( p.left, array, level+1);
		array[level]++;
		Width( p.right, array, level+1);
	}
	private int max(int [] array)
	{
		int max = 0;
		if(array.length!=0)
		{
			max= array[0];

			for (int i : array) 
			{
				if (i>max) 
				{
					max=i;
				}
			}
		}
		return max;
	}
	////////////////////////////////////////////////////////
	// reverse
	////////////////////////////////////////////////////////
	@Override
	public void reverse()
	{
		Reverse(root);
	}
	public void Reverse(Node p)
	{
		if(p.left == null ||p.right == null)
			return;

		Node tmp = p.left;
		p.left=p.right;
		p.right = tmp;

		Reverse(p.left);
		Reverse(p.right);
	}
	////////////////////////////////////////////////////////
	// del1 смещением
	////////////////////////////////////////////////////////
	private void DellNode (Node parent, Node current,int val)
	{
		if(current.val>val)
		{
			parent =current;
			DellNode ( parent,  current.left, val);
			return;
		}
		else if(current.val<val)
		{
			parent =current;
			DellNode ( parent,  current.right, val);
			return;
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
				return;
			}
			if(current.left==null||current.right==null)
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
				System.out.println();
			}
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

		return	SearchNode( p.right,parent );
	}
	@Override
	public void del(int val) 
	{
		if(root==null)
			return;

		Node parent = null;
		Node current = root;

		DellNode ( parent,  current, val);
	}
	////////////////////////////////////////////////////////
	// del2 поворотом
	////////////////////////////////////////////////////////
	private void DellNode2 (Node parent, Node current,int val)
	{
		if(current.val>val)
		{
			parent =current;
			DellNode ( parent,  current.left, val);
			return;
		}
		else if(current.val<val)
		{
			parent =current;
			DellNode ( parent,  current.right, val);
			return;
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
				return;
			}
			if(current.left==null||current.right==null)
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
						nodeSearch=	SearchNode2(current.left.right);
						nodeSearch.right=root.right;
						root=root.left;
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

						nodeSearch=	SearchNode2(current.left.right);
						nodeSearch.right=current.right;
						parent.left=current.left;
					}
					else
					{
						Node tmp = current.left;
						tmp.right=current.right;
						parent.left=current.left;
					}	
				}
				System.out.println();
			}
		}
	}
	private Node SearchNode2(Node p)
	{
		if(p.right==null)
		{
			return p;
		}
		return	SearchNode2(p.right);
	}
	////////////////////////////////////////////////////////
	// toString
	////////////////////////////////////////////////////////
	@Override
	public String toString()
	{
		return ToString(root).replaceFirst(", $", "");
	}
	private String ToString(Node p)
	{
		if(p ==null)
			return "";

		return ToString( p.left)+ p.val+", "+ToString( p.right);
	}
	////////////////////////////////////////////////////////
	// toArray
	////////////////////////////////////////////////////////
	@Override
	public int[] toArray() 
	{
		int [] array = new int [size()];
		Counter counter = new Counter();
		ToArray(root,array, counter);
		return array;
	}
	private class Counter
	{
		int val= 0;
	}
	public void ToArray(Node p,int [] array,Counter counter)
	{
		if(p==null)
			return;

		ToArray( p.left,array, counter);
		array[counter.val++]=p.val;
		ToArray( p.right,array, counter);
	}
	public	class Node
	{
		int val;
		Node left;
		Node right;
		int height;

		public Node(int val)
		{
			this.val=val;
		}
	}
	Node root = null;
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
