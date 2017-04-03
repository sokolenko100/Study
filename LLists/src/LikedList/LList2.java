package LikedList;



public class LList2  implements EList
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
		first =null;
		end =null;
	}

	@Override
	public int size() //!
	{
		int size =0;
		Node tmp = first;
		while (tmp!=null) 
		{
			tmp=tmp.next;
			size++;
		}
		return size;
	}
	@Override
	public int[] toArray() //!
	{
		int [] array = new int[size()];
		int i =0;
		Node tmp = first;
		while (tmp!=null) 
		{
			array[i]=tmp.data;
			tmp=tmp.next;
			i++;
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
		if (first==null) 
		{
			this.addEnd( val);
		}
		else
		{
		    	Node temp = new Node(val);
				first.prev =temp;
				temp.next = first;
				first =temp;
		}
	}

	@Override
	public void addEnd(int val) //!
	{
		Node temp = new Node(val);
		if (end==null)
		{
			first = temp;
			end = temp;
		}
		else
		{
			end.next =temp;
			temp.prev = end;
			end =temp;
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
		Node tmpNode = first;
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
			}
			node= tmpNode;
			tmpNode = tmpNode.next;
			posEl++;
		}//*/
	}

	@Override
	public int delStart()  //!
	{
		if (first ==null) 
		{
			throw new IllegalArgumentException();
		}
		int result = 0;
		if (first.next==null)
		{
			result = first.data;
			first=null;
			end = null;
		}
		else
		{
			result = first.data;
			first=first.next;
		}
		return result;
	}

	@Override
	public int delEnd()  //!
	{
		if (end ==null) 
		{
			throw new IllegalArgumentException();
		}
		int result = 0;
		if (end.prev==null)
		{
			result = end.data;
			end=null;
			first = null;
		}
		else
		{
			result = end.data;
			Node tmp = end.prev;
			tmp.next=null;
			end = tmp;
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
		Node tmpNode = first;
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
		if (pos > size()|| pos<0)
		{
			throw new IllegalArgumentException();
		}
		int result =0;
		int posEl = 0;
		Node tmpNode = first;
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
	public void set(int pos, int val) //!
	{
		pos-=1;
		if (pos > size()|| pos<0)
		{
			throw new IllegalArgumentException();
		}
		int posEl = 0;
		Node tmpNode = first;
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
	public int min() //!
	{
		Node tmpNode = first;
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
	public int max() //!
	{
		Node tmpNode = first;
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
	public int minPos() //!
	{
		if (size()==0) 
		{
			throw new IllegalArgumentException();
		}
		int index2=0;
		int index=0;
		Node tmpNode = first;
		int result = tmpNode.data;
		while (tmpNode != null)
		{
			if (result>tmpNode.data) 
			{
				result=tmpNode.data;
				index=index2;
			}
			tmpNode = tmpNode.next;
			index2++;
		}
		return index+1;
	}

	@Override
	public int maxPos() //!
	{
		if (size()==0) 
		{
			throw new IllegalArgumentException();
		}
		int index2=0;
		int index=0;
		Node tmpNode = first;
		int result = tmpNode.data;
		while (tmpNode != null)
		{
			if (result<tmpNode.data) 
			{
				result=tmpNode.data;
				index=index2;
			}
			tmpNode = tmpNode.next;
			index2++;
		}
		return index+1;
	}

	@Override
	public void sort() 
	{
		Node root = first;
		Node  temp = first;
		for (int i = 0; i < size(); i++)
		{
			while (root != null)
			{
				if (temp.data>root.data) 
				{
					int tempInt =root.data;
					root.data = temp.data;
					temp.data =tempInt;
				}
				root = root.next;
			}
			temp= temp.next;
			root=temp;
		}
	}

	@Override
	public void reverse()
	{
		if (size()==0) 
		{
			return;
		}
		Node tmp = first;
		first = null;
		end=null;
		while (tmp != null)
		{
			addStart(tmp.data);
			tmp = tmp.next;
		}
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
			int  firstNumb =this.getNode(i);
			int  secondNumb = this.getNode(half+i);
			this.set(half+(i+1), firstNumb);
			this.set(i+1, secondNumb);
		}
	}
	public int getNode(int pos) 
	{
			//pos-=1;
			if (pos > size()|| pos<0)
			{
				throw new IllegalArgumentException();
			}
			int result =0;
			int posEl = 0;
			Node tmpNode = first;
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
		public Node(int data)
		{
			this.data=data;
		}
	}
	Node first =null; 
	Node end =null; 
}