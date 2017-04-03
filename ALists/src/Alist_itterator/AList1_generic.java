package Alist_itterator;

import java.util.Iterator;

public class AList1_generic<T> implements Iterable <T>, EList<T>
{
	public AList1_generic(Class TClass)
	{
		this.TClass=TClass;
		array =(T [])java.lang.reflect.Array.newInstance(TClass, 10);
	}	
	Class TClass;
	private T [] array =null;
	int index = 0;
	 @Override
	    public Iterator<T> iterator() 
	    {
	        Iterator<T> it = new Iterator<T>() 
	        {
	            private int currentIndex = 0;

	            @Override
	            public boolean hasNext() 
	            {
	                return (currentIndex < index );//&& (array[currentIndex] != null);
	            }
	            @Override
	            public T next() {
	                return array[currentIndex++];
	            }

	            @Override
	            public void remove()
	            {
	                throw new UnsupportedOperationException();
	            }
	        };
	        return it;
	    }

	public void clear()
	{
		index = 0;
	}
	public void init(T [] temp )
	{
		if (temp==null||temp.length>array.length) 
		{
			throw new IllegalArgumentException();
		}
		clear();
		for (int i = 0; i < temp.length; i++)
		{
			array[index]=temp[i];
			index++;
		}
	}
	public <T> T [] toArray()
	{
		T [] ar2= (T [])java.lang.reflect.Array.newInstance(TClass, index);
		for (int i = 0; i <index; i++)
		{
			ar2[i]=(T) array[i];
		}
		return ar2;
	}
	public int  size()
	{
		return index;
	}
	private<T> T [] resize ()
	{
		T [] arrayTemp =(T [])java.lang.reflect.Array.newInstance(TClass, index*2);
		
		for (int i = 0; i < index; i++) 
		{
			arrayTemp[i]=(T) array[i];
		}
		return   arrayTemp;
	}
	public void addStart(T val)
	{
		if(index== array.length)
		{
			array=resize();
		}
		for (int i = index; i > 0; i--)
		{
			array[i] = array[i-1];
		}
		array[0] = val;
		index++;
	}
	public void addEnd(T val)
	{
		if(index == array.length)
		{
			array=resize();
		}
		array[index++] = val;
	}
	public<T> T  delStart()
	{
		T result ;
		if (index==0) 
		{
			throw new IllegalArgumentException();
		}
		else
		{
			result =(T) array[0];
			for (int i = 0; i <index; i++) 
			{
				array[i]=array[i+1];
			}
			array[index] =null;
			index--;
		}
		return result;
	}
	public<T> T delEnd()
	{
		T result ;
		if (index==0) 
		{
			throw new IllegalArgumentException();
		}
		else
		{

			index--;
			result=(T) array[index];
		}
		return result;
	}
	@Override
	public String toString()
	{
		String temp="";
		for (int i = 0; i < index; i++)
		{
			if (i<index -1) 
			{
				temp +=array[i]+", ";
			}
			else 
			{
				temp +=array[i];
			}
		}
		return temp;
	}
	public<T> T  get(int position)
	{  
		if (array == null) 
		{
			throw new IllegalArgumentException();
		}
		position-=1;
		T result ;
		if (position>=0&&position<=index)
		{
			result=(T) array[position];
		}
		else
		{
			throw new IllegalArgumentException(); 
		}
		return result;
	}
	public  void set(T value, int position)
	{
		position-=1;
		if (position>=0&&position<=index)
		{
			array[position]= value;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	public <T> T max()
	{
		if (array == null|| index==0) 
		{
			throw new IllegalArgumentException();
		}
		T result =(T)  array[0];
		for (int i = 1; i < index; i++) 
		{
			//if (result <array[i]) 
			if(((Comparable<T>) result).compareTo((T) array[i]) < 0)
			{
				result=(T) array[i];
			}
		}
		return result;
	}
	public <T> T min()
	{
		if (array == null||index==0) 
		{
			throw new IllegalArgumentException();
		}
		T result =(T)  array[0];
		for (int i = 1; i < index; i++) 
		{
			//if (result >array[i]) 
			if(((Comparable<T>) result).compareTo((T) array[i]) > 0)
			{
				result=(T) array[i];
			}
		}
		return result;
	}
	public int minPos()
	{
		if (array == null|| index==0) 
		{
			throw new IllegalArgumentException();
		}
		int result =0;
		for (int i = 1; i < index; i++) 
		{
		//	if (array[result]>array[i]) 
			if(((Comparable<T>) array[result]).compareTo((T) array[i]) > 0)
			{
				result=i;

			}
		}
		return result+1;
	}
	public int maxPos()
	{
		if (array == null|| index==0) 
		{
			throw new IllegalArgumentException();
		}
		int result = 0;
		for (int i = 1; i < index; i++) 
		{
		//	if (array[result]<array[i]) 
			if(((Comparable<T>) array[result]).compareTo((T) array[i]) < 0)
			{
				result=i;

			}
		}
		return result+1;
	}
	public <T> T  delPos( int position)
	{
		T result ;
		position-=1;
		if (position<0||position>=index) 
		{
			throw new IllegalArgumentException();
		}
		result=(T)  array[position];
		for (int i =position; i < array.length-1;i++ )
		{
			array[i]=array[i+1];
			if (i ==array.length-1)
			{
				array[i]=null;
			}
		}
		index--;
		return result;
	}
	public void addPos( T value,int position)
	{
		position-=1;
		if (position<0||position>index||index>=array.length) 
		{

			throw new IllegalArgumentException();
		}
		for (int i =index; i >position;i-- )
		{
			array[i]=array[i-1];
		}
		array[position]=value;
		index++;
	}
	public void sort()
	{
		if (array == null|| array.length==0) 
		{
			return;
		}
		for (int i = 0; i < index; i++) 
		{
			for (int j = 0; j < index; j++)
			{
			//	if (array[i] < array[j]) 
				if(((Comparable<T>) array[i]).compareTo((T) array[j]) < 0)

				{
				//	while (j >= 0 && array[i] < array[j])
					
					while (j >= 0 &&((Comparable<T>) array[i]).compareTo((T) array[j]) < 0)
					{
						T temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						j--;
//						if(array[i]==null||array[j]==null)
//						{
//							break;
//						}
					}
				}
			}
		}
	}
	public void reverse()
	{
		if (array == null|| index==0) 
		{
			return;
		}
		int half = 0;
		int arrLeght = index;
		if (arrLeght % 2 == 0) {
			half = arrLeght / 2;
		} else {
			half = (arrLeght / 2) + 1;
		}
		for (int i = 0; i < arrLeght / 2; i++) {
			T temp = array[i];
			array[i] = array[arrLeght - (i + 1)];
			array[arrLeght - (i + 1)] = temp;
		}
	}
	public  void halfReverse() 
	{
		if (array == null|| index==0) 
		{
			return;
		}
		int half = 0;
		int arrLeght = index;
		if (arrLeght % 2 == 0) {
			half = arrLeght / 2;
		} else {
			half = (arrLeght / 2) + 1;
		}
		for (int i = 0; i < arrLeght / 2; i++) {
			T temp = array[i];
			array[i] = array[half + i];
			array[half + i] = temp;
		}
	}
}
