package HashTable;

import model.Person;

public class HashTableLine  implements EHashTable
{
	/*
	 Реализовать хеш таблицу с двумя вариантами разрешением коллизий:  1. линейный  / 2. цепочка
	init / clear/ size / put / del / get / toArray
	 */
	final int  size= 97;
	int count=0;
	Person [] arrayHT = new Person [size];

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
		key = searhCell(key);
		arrayHT[key]= p;
		count++;
	}
	private int searhCell(int key)
	{
		int result = key;

		while (arrayHT[result]!=null) 
		{
			result++;
		}

		return result;
	}

	@Override
	public void clear() 
	{
		arrayHT = new Person [size];
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
		if(size()==0)
		{
			throw new IllegalArgumentException();
		}
		int	hashCode =p.hashCode();
		int key = hashCode%size;
		Person persn = arrayHT[key];
		while(persn.hashCode()!=hashCode)
		{
			persn = arrayHT[++key];
		}
		Person pTest= arrayHT[key];
		arrayHT[key]=null;
		count--;
		return pTest;
	}

	@Override
	public Person get(Person p) 
	{
		if(size()==0)
		{
			throw new IllegalArgumentException();
		}
		return getP(p.hashCode()) ;
	}
	private Person getP(int hashCode)
	{
		int key = hashCode%size;
		Person p = arrayHT[key];
		if(p.hashCode()!=hashCode)
		{
			while(p.hashCode()!=hashCode)
			{
				p = arrayHT[++key];
			}
		}
		return p;
	}
	public Person get(int xc)
	{
		if(size()==0)
		{
			throw new IllegalArgumentException();
		}
		int key = xc % size;
		Person p = arrayHT[key];

		if(p.hashCode()!=xc)
		{
			while(p.hashCode()!=xc)
			{
				p = arrayHT[++key];
			}
		}
		return p ; 
	}
	@Override
	public Person[] toArray()
	{
		Person [] array = new Person[count];
		int i = 0 ;
		int j = 0;
		for(;j<arrayHT.length;j++)
		{
			if(arrayHT[j]!=null)
			{
				array[i]=arrayHT[j];
				i++;
			}
		}
		return array;
	}
}
