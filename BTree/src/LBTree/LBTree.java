package LBTree;

import java.util.Iterator;


public class LBTree  implements ETree
{
	Link root = new Link();
	class Link
	{
		Node node = null;
	}
	class Node
	{
		Link left = new Link();
		Link right = new Link();
		int val;
		Link link = null;
		public Node(int val) 
		{
			this.val = val;
		}
	}
	@Override
	public void clear()
	{
		root.node =null;
	}
	@Override
	public void add(int val)
	{
		addNode( val, root);
	}
	private void addNode(int val, Link p)
	{
		if(p.node==null)
		{
			p.node = new Node(val);
			p.node.link=p;
			return;
		}
		if(val<p.node.val)
		{
			addNode( val, p.node.left);
		}
		if(val>p.node.val)
		{
			addNode( val, p.node.right);
		}
	}
	@Override
	public void init(int[] tempArray)
	{
		this. clear();	
		if (tempArray== null||tempArray.length==0)
			return;

		for (int i = 0; i < tempArray.length; i++) 
		{
			add(tempArray[i]);
		}
	}
	@Override
	public int size() 
	{
		int size =0;
		size= sizeNode(root);
		return size;
	}
	private int sizeNode(Link p)
	{
		if(p.node==null)
			return 0;

		return 1 + sizeNode(p.node.left)+sizeNode(p.node.right);
	}
	@Override
	public int nodes()
	{
		return  getNodes(root);
	}
	private int getNodes(Link p)
	{
		if(p.node==null)
		{
			return 0;	
		}
		int counter = 0;
		if(p.node.left.node!=null||p.node.right.node!=null)
		{
			counter++;
		}
		counter +=getNodes(p.node.left);
		counter +=getNodes(p.node.right);
		return counter;
	}
	@Override
	public String toString()
	{
		String result ="";
		result =ToString(root).replaceFirst(", $", "");
		return result;
	}
	private String ToString(Link p)
	{
		if(p.node ==null)
			return "";

		return ToString( p.node.left)+ p.node.val+", "+ToString(p.node.right);
	}
	@Override
	public int leaves() 
	{
		return  getLeavs(root);
	}
	private int getLeavs(Link p)
	{
		if(p.node==null)
		{
			return 0;	
		}
		int counter = 0;
		if(p.node.left.node==null&&p.node.right.node==null)
		{
			counter++;
		}
		counter +=getLeavs(p.node.left);
		counter +=getLeavs(p.node.right);
		return counter;
	}

	@Override
	public int height() 
	{
		int result =0;
		result = HeightBLTree(root);
		return result;
	}
	public int HeightBLTree(Link p)
	{
		if (p.node==null) 
		{
			return 0;
		}
		int result =0;
		int leftCount=0;
		int rightCount=0;
		leftCount= HeightBLTree(p.node.left);
		rightCount= HeightBLTree(p.node.right);
		result=1 + Math.max(leftCount, rightCount);
		return result;
	}
	@Override
	public int width() 
	{
		int [] array = new int[height()];
		int i =0;
		widthLBTree(array,root,i );
		int width = 0;
		width= max( array);
		return width;
	}
	private void widthLBTree(int [] array, Link p,int i)
	{
		if(p.node==null)
			return ;
		widthLBTree( array, p.node.left,i+1);
		array[i]++;
		widthLBTree( array, p.node.right,i+1);
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
	@Override
	public void reverse()
	{
		reverseBTree(root);
	}

	private void reverseBTree(Link p)
	{
		if(p.node.left==null||p.node.right==null)
			return ;

		Link tmp = p.node.left;
		p.node.left=p.node.right;
		p.node.right = tmp;

		reverseBTree(p.node.left);
		reverseBTree(p.node.right);
	}
	@Override
	public void del(int val)
	{
		if(root.node==null)
		{
			return;
		}
		DellNode (root, val);
	}
	////////////////////////////////////////////////////////
	// del смещением
	////////////////////////////////////////////////////////

	private void DellNode (Link p,int val)
	{
		if(p.node.val>val)
		{
			DellNode (p.node.left, val);
			return;
		}
		else if(p.node.val<val)
		{
			DellNode ( p.node.right, val);
			return;
		}
		else
		{
			if(p.node.left.node==null&&p.node.right.node==null)
			{
				p.node.link.node=null;
				return;
			}
			if(p.node.left.node==null||p.node.right.node==null)
			{
				if (p.node.left.node==null)
				{
					p.node.link.node = p.node.right.node;
				}
				else
				{
					p.node.link.node = p.node.left.node;
				}
				return;
			}
			else
			{
				Link nodeSearch=null;
				if (p.node.left.node.right.node!=null)
				{

					nodeSearch = SearchNode(p.node.left.node.right);
					nodeSearch.node.left.node=p.node.left.node;
					nodeSearch.node.right.node=p.node.right.node;
					p.node.link.node=nodeSearch.node;
				}
				else
				{
					if(p==root)
					{
						p.node.left.node.right.node= p.node.right.node;
						p.node.link.node = p.node.left.node;
					}
					p.node.link.node = p.node.left.node;
				}	
				return;
			}
		}
	}
	private Link SearchNode(Link p)
	{
		if(p.node.right.node==null)
		{
			Link temp = new Link();
			temp.node = new Node(p.node.val);
			p.node.link.node=p.node.left.node;
			return temp;
		}
		return	SearchNode(p.node.right);
	}	
	@Override
	public int[] toArray() 
	{
		int [] array = new int[size()];
		counter count = new counter();
		toArrayLB(array,root,count );
		return array;
	}
	class counter
	{
		int i = 0;
	}
	private void toArrayLB(int [] array, Link p,counter count)
	{
		if(p.node==null)
			return ;

		toArrayLB( array, p.node.left,count);
		array[count.i++]= p.node.val;
		toArrayLB( array, p.node.right,count);
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
