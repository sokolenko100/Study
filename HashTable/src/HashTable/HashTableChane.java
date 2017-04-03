package HashTable;

import model.Person;

public class HashTableChane implements EHashTable
{
	private class Node
	{
		Person p;
		Node next;
		public Node(Person p)
		{
			this.p = p;
		}
	}
	final int size;
	Node [] array;
	int count;
	public HashTableChane()
	{
		count = 0;
		size = 97;
		array = new Node[size];
	}

	@Override
	public void init(Person [] temp)
	{
		if(temp == null)
		{
			return;
		}
		for (int i = 0; i < temp.length; i++)
		{
			put(temp[i]);
		}
	}
	@Override
	public void put(Person p) 
	{
		int hashCode = p.hashCode();
		int key = hashCode%size;
		putCell(key,p);
		count++;
	}
	private void putCell(int key,Person p)
	{
		if (array[key]==null)
		{
			array[key]=new Node(p);
		}
		else
		{
			Node node = array[key];
			if(node.next== null)
			{
				node= new Node(p);
			}
			else
			{
				while(node.next!=null)
				{
					node = node.next;
					if(node==null)
					{
						node= new Node(p);
						break;
					}
				}
			}

		}
	}

	@Override
	public void clear() 
	{
		array =new Node[size];
		count = 0;
	}

	@Override
	public int size() 
	{
		return count;
	}

	@Override
	public Person del(Person p)
	{
		return delP(p);
	}
	public Person delP(Person p)
	{
		int hashCode= p.hashCode();
		int key = hashCode%size;
		Node node = null;
		Person pers = null;
		if (array[key] !=null)
		{
			node = array[key];
		}
		if(node!=null)
		{
			
			if(node.next ==null)
			{
				pers = array[key].p; 
				array[key]=null;
			}
			else
			{
				while (node.next!=null)
				{
					node = node.next;
					if(node.p.hashCode()==hashCode)
					{
						pers=node.p;
						node = node.next;
						break;
					}
				}
			}
		}
		return pers;
	}

	@Override
	public Person get(Person p) 
	{
		return get(p.hashCode()) ;
	}
	private Person get(int hashCode)
	{
		int key = hashCode%size;
		Node node = array[key];

		while(node.p.hashCode()!=hashCode)
		{
			node = node.next;
			if(node.p.hashCode()==hashCode)
			{
				break;
			}
		}

		return node.p;
	}

	@Override
	public Person[] toArray()
	{
		Person [] arrayP = new Person[count];
		int i = 0 ;
		int j = 0;
		for(;j<array.length;j++)
		{
			if(array[j]!=null)
			{
				Node node = array[j];
				if(node.p!=null)
				{
					arrayP[i]=node.p;
					i++;
				}
				while(node.next!=null)
				{
					arrayP[i]=node.next.p;
					node = node.next;
					i++;
				}
			}
		}
		return arrayP;
	}

}
