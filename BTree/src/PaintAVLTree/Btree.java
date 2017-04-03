package PaintAVLTree;

import java.util.Iterator;

public class Btree  implements ETree
{
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
	public void AddNode(Node p , int val)
	{
		if(val<p.value)
		{
			if (p.left==null)
			{
				p.left=new Node(val);
			}
			else
			{
				this.AddNode( p.left , val);
			}
		}
		else
		{
			if (p.right==null)
			{
				p.right=new Node(val);
			}
			else
			{
				this.AddNode( p.right , val);
			}
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
		System.out.print(p.value+", ");
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
		return sizeNode(root);
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
		return Nodes( root);
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
		return Leaves( root);
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
		return Height(root);
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
		int [] array= new int[height()];
		Width(root,array,0);
		
		return max( array);
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
	private void delNode (Node parent, Node current,int val)
	{
		if(current.value>val)
		{
			parent =current;
			delNode ( parent,  current.left, val);
			return;
		}
		else if(current.value<val)
		{
			parent =current;
			delNode ( parent,  current.right, val);
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

		Boolean isLeft = false;
		Node parent = null;
		Node current = root;

		delNode ( parent,  current, val);
	}
	////////////////////////////////////////////////////////
	// del2 поворотом
	////////////////////////////////////////////////////////
	private void delNodeTurn (Node parent, Node current,int val)
	{
		if(current.value>val)
		{
			parent =current;
			delNodeTurn ( parent,  current.left, val);
			return;
		}
		else if(current.value<val)
		{
			parent =current;
			delNodeTurn ( parent,  current.right, val);
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

		return ToString( p.left)+ p.value+", "+ToString( p.right);
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
		array[counter.val++]=p.value;
		ToArray( p.right,array, counter);
	}
	////////////////////////////////////////////////////////
	// Node
	////////////////////////////////////////////////////////
	protected Node root =null;
	protected class Node
	{
		Node left =null;
		Node right = null;
		int value;
		int height;
		public Node()
		{
		}
		public Node(int value)
		{
			this.value=value;
			height=1;
		}
	}
	@Override
	public Iterator<Integer> iterator()
	{
		return new myIterator( toArray());
	}
	class myIterator implements Iterator<Integer>
	{
		int [] arr = null;
		int index;
		public myIterator(int [] tmp)
		{
			arr= tmp;
			index = 0;
		}
		@Override
		public boolean hasNext() 
		{
			return index<arr.length?true:false;
		}

		@Override
		public Integer next() 
		{
			return arr[index++];
		}
	}
}
