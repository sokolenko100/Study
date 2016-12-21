package LikedList2;


public class LList3  implements EList
{
	@Override
	public void init(int[] tempArray)  //!
	{
		this. clear();	
		if (tempArray== null||tempArray.length==0)
		{
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < tempArray.length; i++)
		{
			this.addEnd(tempArray[i]);
		}
	}
	@Override
	public void clear()
	{
		root =null;
	}
    private Boolean isDelStart= true;
	@Override
	public int size() //!
	{
		int size =0;
	
		if (root ==null) 
		{
			size= 0;
		}
		else
		{
			Node tmp = root;
			if (root.next==root) 
			{
				size=1;
			}
			else
			{
				if(isDelStart)
				size++;
				isDelStart= true;
				while (tmp.next!=root) 
				{
					tmp=tmp.next;
					size++;
				}
			}
		}
		return size;
	}
	@Override
	public int[] toArray() //!
	{
		
		int [] array = new int[size()];
		Node tmp = root;
		for (int j = 0; j < array.length; j++) 
		{
			array[j]=tmp.data;
			tmp=tmp.next;
		}
		return array;
	}
	@Override
	public String toString() //!
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
	public void addStart(int val) //!
	{	
		
		if (root==null) 
			this.addEnd( val);
		
		Node temp = new Node(val);
		if (size() ==1)
		{
			temp.next=root;
			root.prev= temp;
			temp.prev = root;
			root.next = temp;
			root = temp;
		}
		else
		{
		    	
				temp.next =root.next.prev;
				root.next.prev=temp;
				root.prev.next=temp;
				temp.prev = root.prev;
				root =temp;
		}
	}

	@Override
	public void addEnd(int val) //!
	{
		Node temp = new Node(val);
		Node  nodeTemp = root;
		if (root==null)
		{
			root = temp;
			root.next = root;
			root.prev = root;
		}
		else
		{
			root.prev.next =temp;
			temp.prev = root.prev ;
			temp.next =root;
			root.prev =temp;
		}
	}
	@Override
	public void addPos(int pos, int val) //!
	{
		pos-=1;
		int size =  size();
		if (pos > size|| pos<0)
		{
			throw new IllegalArgumentException();
		}

		if (size ==0||size==pos)
		{
			this.addEnd( val);
			return;
		}
		if (size ==1)
		{
			this.addStart( val);
			return;
		}
		int posEl = 0;
		Node tmpNode = root;
		Node node= tmpNode;
		while (tmpNode != null)
		{
			 if( 0==pos)
			{
				this.addStart(val);
				break;
			}
			 else if (size==posEl) 
			{
				this.addEnd(val);
				break;
			}
			if (posEl==pos) 
			{
				Node tempValAdd = new Node(val);
				tempValAdd.next = node.next;
				node.next.prev = tempValAdd;
				node.next = tempValAdd;
				tempValAdd.prev=node;
				break;
			}
			node= tmpNode;
			tmpNode = tmpNode.next;
			posEl++;
		}//*/
	}

	@Override
	public int delStart()  //!
	{
		if (root ==null) 
		{
			throw new IllegalArgumentException();
		}
		isDelStart=false;
		int result = 0;
		if (root.next==root)
		{
			result = root.data;
			root=null;
		}
		else
		{
			result = root.data;
			Node prev = root.prev;
			root=root.next;
			root.prev=prev;
		}
		return result;
	}

	@Override
	public int delEnd()  //!
	{
		if (root ==null) 
		{
			throw new IllegalArgumentException();
		}
		int result = 0;
		if (root.prev==root)
		{
			result = root.data;
			root = null;
		}
		else
		{
			result = root.prev.data;
			root.prev.prev.next =root;
			root.prev =root.prev.prev;
		}
		return result;
	}

	@Override
	public int delPos(int pos)  //!
	{
		int size = size();
		if (pos > size|| pos<=0)
		{
			throw new IllegalArgumentException();
		}
		int result = 0;
		Node tmpNode = root;
		Node node= tmpNode;
		int counter = 1;
		while (tmpNode!=null) 
		{
			 if( 0==pos)
			 {
				this.delStart();
				break;
			 }
			 else if (size==pos) 
			{
				this.delEnd();
				break;
			}
			if (counter==pos) 
			{
				node.next = node.next.next;
				node.next.prev = node;
				break;
			}
			node= tmpNode;
			tmpNode = tmpNode.next;
			counter++;
		}
		return result;
	}
	@Override
	public int get(int pos)  //!
	{
		pos-=1;
		int size = size();
		if (pos >size || pos<0)
		{
			throw new IllegalArgumentException();
		}
		int result =0;
		int posEl = 0;
		Node tmpNode = root;
		while (size != posEl)
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
	public void set(int pos, int val) //!
	{
		pos-=1;
		int size= size();
		if (pos > size|| pos<0)
		{
			throw new IllegalArgumentException();
		}
		int posEl = 0;
		Node tmpNode = root;
		while (size != posEl)
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
	public int min() //!
	{
		Node tmpNode = root;
		int result = tmpNode.data;
		int size = size();
		int counter = 0;
		while (counter != size)
		{
			if (result>tmpNode.data) 
			{
				result=tmpNode.data;
			}
			tmpNode = tmpNode.next;
			counter++;
		}
		return result;
	}

	@Override
	public int max() //!
	{
		Node tmpNode = root;
		int result = tmpNode.data;
		int size = size();
		int counter = 0;
		while (counter != size)
		{
			if (result<tmpNode.data) 
			{
				result=tmpNode.data;
			}
			tmpNode = tmpNode.next;
			counter++;
		}
		return result;
	}

	@Override
	public int minPos() //!
	{
		int size = size();
		if (size==0) 
		{
			throw new IllegalArgumentException();
		}
		int counter=0;
		int index=0;
		Node tmpNode = root;
		int result = tmpNode.data;
		while (size != counter)
		{
			if (result>tmpNode.data) 
			{
				result=tmpNode.data;
				index=counter;
			}
			tmpNode = tmpNode.next;
			counter++;
		}
		return index+1;
	}

	@Override
	public int maxPos() //!
	{
		int size = size();
		if (size==0) 
		{
			throw new IllegalArgumentException();
		}
		int counter=0;
		int index=0;
		Node tmpNode = root;
		int result = tmpNode.data;
		while (size != counter)
		{
			if (result<tmpNode.data) 
			{
				result=tmpNode.data;
				index=counter;
			}
			tmpNode = tmpNode.next;
			counter++;
		}
		return index+1;
	}

	@Override
	public void sort() 
	{
		Node tmpRoot = root;
		Node  temp = root;
		int size =size();
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j <size; j++) 
			{
				if (temp.data<tmpRoot.data) 
				{
					int tempInt =tmpRoot.data;
					tmpRoot.data = temp.data;
					temp.data =tempInt;
				}
				tmpRoot = tmpRoot.next;
			}
			temp= temp.next;
			tmpRoot=temp;
		}
	}

	@Override
	public void reverse()
	{
		int size =size();
		if (size==0) 
		{
			return;
		}
		Node tmpNode = null;
		for (int i = 0; i < size; i++)
		{
			Node tmp = root;
			root = root.next;
			if (tmpNode == null)
			{
			    tmp.next=tmpNode;
			    tmp.prev=tmpNode;
			    tmp.next=tmp;
			    tmp.prev=tmp;
			    tmpNode=tmp;
				
				continue;
			}
			tmp.next = tmpNode;
			tmp.prev = tmpNode.prev;
			tmpNode.prev.next = tmp;
			tmpNode.prev = tmp;
		//	tmpNode.next = tmp;
			tmpNode=tmp;
		}
		root=tmpNode;
	}

	@Override
	public void halfReverse() 
	{
		int half = 0;
		int arrLeght = size();
		int centr =0;
		if (arrLeght % 2 == 0)
		{
			half = arrLeght / 2;
			centr= half;
		} 
		else 
		{
			half = (arrLeght / 2) + 1;
			centr= half-1;
		}
		for (int i = 0; i < centr; i++)
		{
			int  rootNumb =this.getInt(i);
			int  secondNumb = this.getInt(half+i);
			this.set(half+(i+1), rootNumb);
			this.set(i+1, secondNumb);
		}
	}
	public int getInt(int pos) 
	{
			//pos-=1;
			if (pos > size()|| pos<0)
			{
				throw new IllegalArgumentException();
			}
			int result =0;
			int posEl = 0;
			Node tmpNode = root;
			while (tmpNode != null)
			{
				if (posEl==pos) 
				{
					result = tmpNode.data;
					break;
				}
				tmpNode = tmpNode.next;
				posEl++;
			}
			return result;
	}
	////////////////////////////////////////////////////////
	// Node
	////////////////////////////////////////////////////////
	private class Node
	{
		Node prev =null;
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
	Node end =null; 
}