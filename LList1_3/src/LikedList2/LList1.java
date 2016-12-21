package LikedList2;

public class LList1 implements EList
{
	@Override
	public void init(int[] tempArray) 
	{
		this. clear();	
		if (tempArray== null||tempArray.length==0)
			throw new IllegalArgumentException();

		for (int i = tempArray.length -1; i>=0; i--)
		{
			this.addStart(tempArray[i]);
		}
	}
	@Override
	public void clear()
	{
		root =null;
	}

	@Override
	public int size()
	{
		int size=0;
		if(root == null)
		{
			return 0;
		}
		else
		{
			Node tmp = root;
			while (tmp!=null) 
			{

				tmp=tmp.next;
				size++;
			}			
		}
		return size;
	}
	@Override
	public int[] toArray()
	{
		int [] array = new int[size()];
		int i =0;
		Node tmp = root;
		while (tmp!=null) 
		{
			array[i]=tmp.data;
			tmp=tmp.next;
			i++;
		}
		return array;
	}
	@Override
	public String toString()
	{
		String result = "";
		int [] array = this.toArray();
		for (int i = 0; i < array.length; i++) 
		{
			if (i<array.length -1) 
			{
				result +=array[i]+", ";
			}
			else 
			{
				result +=array[i];
			}
		}
		return result;
	}


	@Override
	public void  addEnd(int val)
	{			
		if (root==null) 
		{
			this.addEnd( val);
		}
		else
		{
			Node tmp = root;	
			while (tmp.next != null)
			{
				tmp = tmp.next;
			}
			tmp.next = new Node(val);
		}
	}

	@Override
	public void addStart(int val)
	{
		Node temp = new Node(val);
		temp.next=root;
		root =temp;
	}
	@Override
	public void addPos(int pos, int val) 
	{ 
		pos-=1;
		int size=size();
		if (pos > size|| pos<0)
		{
			throw new IllegalArgumentException();
		}
		if (size ==0||size ==1||pos==0)
		{
			this.addStart(val);
			return;
		}
		else if ( size==pos)
		{
			this.addEnd(val);
			return;	
		}
		int posEl = 0;
		Node tmpNode = root;
		Node node = root;
		while (tmpNode != null)
		{

			if (posEl==pos) 
			{
				Node tempValAdd = new Node(val);
				Node tmp=node.next;
				node.next= tempValAdd;
				tempValAdd.next = tmp;
				break;
			}
			node=tmpNode;
			tmpNode = tmpNode.next;
			posEl++;
		}
	}

	@Override
	public int  delEnd() 
	{
		int result = 0;
		Node tmp = root;
		Node tempPre = null;
		while (tmp != null)
		{
			if(root.next==null)
			{
				result = root.data;
				root= null;
				break;
			}
			else if (tmp.next.next==null)
			{
				result = tmp.next.data;
				tmp.next=null;
				tempPre=tmp;
				break;
			}
			else
			{
				tempPre = tmp;
				tmp = tmp.next;
			}
		}
		return result;
	}

	@Override
	public int delStart() 
	{
		int result = 0;
		result= root.data;
		root= root.next;
		return result;
	}
	@Override
	public int delPos(int pos) 
	{
		pos-=1;
		int size =size();
		if (pos > size|| pos<0)
			throw new IllegalArgumentException();

		int zero = 0;
		int result = zero;
		if (pos ==size-1||pos == zero) 
		{
			result=	this.delEnd();
		}
		else 
		{
			Node tmp = root;
			Node tempPre = null;
			int counter =zero;
			while (tmp!=null) 
			{
				if (counter==pos)
				{
					result = tmp.data;
					tempPre.next=tmp.next;
					break;
				}
				tempPre = tmp;
				tmp = tmp.next;
				counter++;
			}
		}
		return result;
	}


	@Override
	public int get(int pos) 
	{
		pos-=1;
		if (pos > size()|| pos<0)
			throw new IllegalArgumentException();

		int result =0;
		int posEl = 0;
		Node tmpNode = root;
		while (tmpNode != null)
		{
			if (posEl==pos) 
			{
				result = tmpNode.data;
			}
			tmpNode = tmpNode.next;
			posEl++;
		}
		return result;
	}

	@Override
	public void set(int pos, int val)
	{
		pos-=1;
		if (pos > size()|| pos<0)
			throw new IllegalArgumentException();

		int posEl = 0;
		Node tmpNode = root;
		while (tmpNode != null)
		{
			if (posEl==pos) 
			{
				tmpNode.data=val;
				return;
			}
			tmpNode = tmpNode.next;
			posEl++;
		}
	}

	@Override
	public int min()
	{
		Node tmpNode = root;
		int result = tmpNode.data;
		while (tmpNode != null)
		{
			if (result>tmpNode.data) 
			{
				result=tmpNode.data;
			}
			tmpNode = tmpNode.next;
		}
		return result;
	}

	@Override
	public int max()
	{
		Node tmpNode = root;
		int result = tmpNode.data;
		while (tmpNode != null)
		{
			if (result<tmpNode.data) 
			{
				result=tmpNode.data;
			}
			tmpNode = tmpNode.next;
		}
		return result;
	}

	@Override
	public int minPos()
	{
		if (size()==0) 
		{
			throw new IllegalArgumentException();
		}
		int index2=0;
		int index=0;
		Node tmpNode = root;
		int result = tmpNode.data;
		while (tmpNode != null)
		{
			index2++;
			if (result>=tmpNode.data) 
			{
				result=tmpNode.data;
				index=index2;
			}
			tmpNode = tmpNode.next;

		}
		return index;
	}

	@Override
	public int maxPos()
	{
		if (size()==0) 
			throw new IllegalArgumentException();

		int index2=0;
		int index=0;
		Node tmpNode = root;
		int result = tmpNode.data;
		while (tmpNode != null)
		{
			index2++;
			if (result<=tmpNode.data) 
			{
				result=tmpNode.data;
				index=index2;
			}
			tmpNode = tmpNode.next;

		}
		return index;
	}

	@Override
	public void sort() 
	{
		Node tempRoot = root;
		Node  temp = root;
		for (int i = 0; i < size(); i++)
		{
			while (tempRoot != null)
			{
				if (temp.data>tempRoot.data) 
				{
					int tempInt =tempRoot.data;
					tempRoot.data = temp.data;
					temp.data =tempInt;
				}
				tempRoot = tempRoot.next;
			}
			temp= temp.next;
			tempRoot=temp;
		}
	}

	@Override
	public void reverse()
	{
		if (size()==0) 
			return;

		Node tempNode = null;
		while (root != null)
		{
			Node tmp =root;
			root=root.next;
			tmp.next=tempNode;
			tempNode =tmp;
		}
		root=tempNode;
	}

	@Override
	public void halfReverse() 
	{
		int half = 0;
		int arrLeght = size();
		int centr =0;
		if (arrLeght % 2 == 0)
		{
			half = (arrLeght / 2)+1;
			centr= half-1;
		} 
		else 
		{
			half = (arrLeght / 2) + 2;
			centr= half-2;
		}
		//9, 8, 7, 6, 5, 4, 3, 2, 1
		for (int i = 0; i < centr; i++)
		{
			int  firstNumb = this.get(i+1);
			int  secondNumb = this.get(half+i);
			this.set(half+i, firstNumb);
			this.set(i+1, secondNumb);
		}
	}
	public int getNode(int pos) 
	{
		if (pos > size()|| pos<0)
			throw new IllegalArgumentException();

		int posEl = 0;
		if (pos== size())
		{
			posEl = size();
		}
		else
		{
			posEl = size()-1;
		}

		Node tmpNode = root;
		while (tmpNode != null)
		{
			if (posEl==pos) 
			{
				return  tmpNode.data;
			}
			tmpNode = tmpNode.next;
			posEl--;
		}
		return 0;
	}
	private class Node
	{
		Node next = null;
		int data =0;
		public Node()
		{
		}
		public Node(int data)
		{
			this.data=data;
		}
	}
	Node root =null; 
}
