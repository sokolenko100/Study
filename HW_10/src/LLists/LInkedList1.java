package LLists;

public class LInkedList1 implements EList
{
	private  int size =0;
	public static void main(String[] args) 
	{
		LInkedList1 l = new LInkedList1();
		l.Push(1);
		l.Push(2);
		l.Push(3);
		l.Push(4);
		l.Push(5);
		l.Push(6);
		l.Push(7);
		l.Push(8);
		l.Push(9);
		l.init(new int[]{1,2,3,4,5,6,7,8});
		//l.addEnd(8);
		//l.addStart(0);
		//l.addPos( 3,55);
		l.halfReverse();
		//l.delStart();
		//l.sort();
		//	l.reverse();
		l.toArray();
	}//*/
	void Push(int data)
	{
		Node temp = new Node();
		temp.data =data;
		temp.next=element;
		element =temp;
		size++;
	}
	@Override
	public void init(int[] tempArray) 
	{
		this. clear();	
		if (tempArray== null||tempArray.length==0)
		{
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < tempArray.length; i++)
		{
			Node temp = new Node();
			temp.data =tempArray[i];
			temp.next=element;
			element =temp;
			size++;
		}
	}


	@Override
	public void clear()
	{
		element =null;
		size=0;
	}

	@Override
	public int size()
	{
		return size;
	}
	@Override
	public int[] toArray()
	{
		int [] array = new int[size()];
		int i =size()-1;
		Node tmp = element;
		while (tmp!=null) 
		{
			array[i]=tmp.data;
			tmp=tmp.next;
			i--;
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
	public void addStart(int val)
	{			
		if (element==null) 
		{
			this.addEnd( val);
		}
		else
		{
			Node tmp = element;	
			while (tmp.next != null)
			{
				tmp = tmp.next;
			}
			tmp.next = new Node(val);
		}
		size++;
	}

	@Override
	public void addEnd(int val)
	{
		Node temp = new Node(val);
		temp.next=element;
		element =temp;
		size++;
	}
	@Override
	public void addPos(int pos, int val) 
	{
		/*	Node current = element; 
		Node previous = element;
		Node tempValAdd = new Node(val);
		if (element.next==null)
		{
			element.next=tempValAdd;
			element=tempValAdd;
			return;
		}

        while (current != null)
        { 
            if (current.data == pos)
            {
            	tempValAdd.next=current;
            	previous.next=tempValAdd;
            	break;
            } 
            previous = current; 
            current = current.next;
        }
		if (current ==null) 
		{
			throw new IllegalArgumentException();
		}
		//*/
		//pos-=1;
		if (pos > size()|| pos<0)
		{
			throw new IllegalArgumentException();
		}
		
		if (size() ==0||size()==pos)
		{
			this.addEnd( val);
			return;
		}
		if (size() ==1)
		{
			this.addEnd( val);
			return;
		}
		Node tempValAdd = new Node(val);
		int posEl = size()-1;
		Node tmpNode = element;
		while (tmpNode != null)
		{
			if (posEl==pos) 
			{
				tempValAdd.next = tmpNode.next;
				tmpNode.next = tempValAdd;
			}
			tmpNode = tmpNode.next;
			posEl--;
		}//*/

		size++;
	}

	@Override
	public int delStart() 
	{
		int result = 0;
		Node tmp = element;
		Node tempPre = null;
		while (tmp != null)
		{
			if(element.next==null)
			{
				result = element.data;
				element= null;
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
		size--;
		return result;
	}

	@Override
	public int delEnd() 
	{
		int result = 0;
		result= element.data;
		element= element.next;
		//element = null;
		size--;
		return result;
	}

	@Override
	public int delPos(int pos) 
	{
		//9 8 7 6 5 4 3 2 1
		if (pos > size()|| pos<=0)
		{
			throw new IllegalArgumentException();
		}
		int result = 0;
		Node tmp = element;
		Node tempPre = element;
		int testINT	 = size - (pos-1);
		Boolean flag = true; 
		int i =0;
		while (tmp!=null) 
		{
			if(element.next==null)
			{
				result = element.data;
				element= null;
				break;
			}
			else if (testINT==size||(pos-1)==1)
			{
				result = tmp.data;
				tmp=tmp.next;
				element=tmp;
				break;
			}
			else if (i==pos)
			{
				result = tmp.next.data;
				tmp.next=tmp.next.next;
				tempPre=tmp;
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
				flag=false;
				tempPre = tmp;
				tmp = tmp.next;
			}
			i++;
		}
		size--;
		return result;
	}
	@Override
	public int get(int pos) 
	{
		pos-=1;
		if (pos > size()|| pos<0)
		{
			throw new IllegalArgumentException();
		}
		int result =0;
		int posEl = size()-1;
		Node tmpNode = element;
		while (tmpNode != null)
		{
			if (posEl==pos) 
			{
				result = tmpNode.data;
			}
			tmpNode = tmpNode.next;
			posEl--;
		}
		return result;
	}

	@Override
	public void set(int pos, int val)
	{
		pos-=1;
		if (pos > size()|| pos<0)
		{
			throw new IllegalArgumentException();
		}
		int posEl = size()-1;
		Node tmpNode = element;
		while (tmpNode != null)
		{
			if (posEl==pos) 
			{
				tmpNode.data=val;
				return;
			}
			tmpNode = tmpNode.next;
			posEl--;
		}

	}

	@Override
	public int min()
	{
		Node tmpNode = element;
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
		Node tmpNode = element;
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
		int index2=size();
		int index=0;
		Node tmpNode = element;
		int result = tmpNode.data;
		while (tmpNode != null)
		{
			if (result>tmpNode.data) 
			{
				result=tmpNode.data;
				index=index2;
			}
			tmpNode = tmpNode.next;
			index2--;
		}
		return index;
	}

	@Override
	public int maxPos()
	{
		if (size()==0) 
		{
			throw new IllegalArgumentException();
		}
		int index2=size();
		int index=0;
		Node tmpNode = element;
		int result = tmpNode.data;
		while (tmpNode != null)
		{
			if (result<tmpNode.data) 
			{
				result=tmpNode.data;
				index=index2;
			}
			tmpNode = tmpNode.next;
			index2--;
		}
		return index;
	}

	@Override
	public void sort() 
	{
		Node root = element;
		Node  temp = element;
		for (int i = 0; i < size(); i++)
		{
			while (root != null)
			{
				if (temp.data<root.data) 
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
		Node tmp = element;
		element = null;
		size =0;
		while (tmp != null)
		{
			addEnd(tmp.data);
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
			Node  tempGET_first  = this.getNode(i);
			Node  tempGET_second = this.getNode(half+i);
			int  firstNumb = tempGET_first.data;
			int  secondNumb = tempGET_second.data;
			this.set(half+(i+1), firstNumb);
			this.set(i+1, secondNumb);
		}
	}
	public Node getNode(int pos) 
	{
		//pos-=1;
		if (pos > size()|| pos<0)
		{
			throw new IllegalArgumentException();
		}
		int posEl = 0;
		if (pos== size())
		{
		 posEl = size();
		}
		else
		{
			posEl = size()-1;
		}
		
		Node tmpNode = element;
		while (tmpNode != null)
		{
			if (posEl==pos) 
			{
				return  tmpNode;
			}
			tmpNode = tmpNode.next;
			posEl--;
		}
		return null;
	}
	private class Node
	{
		//Node prev =null;
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
	Node element =null; //new Node();;
}
