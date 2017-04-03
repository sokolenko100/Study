package Alist_itterator;

import java.util.Iterator;

public class AList2_generic<T> implements Iterable <T>, EList<T>
{


	public AList2_generic(Class TClass)
	{
		this.TClass=TClass;
		array =(T [])java.lang.reflect.Array.newInstance(TClass, 30);
		start = array.length/2 ;
		end = array.length/2;
	}
	Class TClass;
	private T [] array =null;

	int start;
	int end;
	public void clear()
	{
		start = array.length/2;
		end = array.length/2;
	}
	public void init(T [] temp )
	{
		if (temp==null||temp.length>array.length) 
		{
			throw new IllegalArgumentException();
		}
		this. clear();
		start-=(temp.length/2);
		end = start + temp.length;
		for (int i = start, j =0; j <temp.length; i++,j++)
		{
			array[i]=temp[j];
		}
	}
	public <T> T [] toArray()
	{
		T [] temp = (T [])java.lang.reflect.Array.newInstance(TClass, end-start);
		for (int i=start, j =0; j <temp.length; i++,j++)
		{
			temp[j]=(T)array[i];
		}
		return temp;
	}
	private void resize()
	{
		T [] arrayTemp = (T [])java.lang.reflect.Array.newInstance(TClass, array.length);

		for (int i = 0; i < array.length; i++) 
		{
			arrayTemp[i]=array[i];
		}
		array =(T [])java.lang.reflect.Array.newInstance(TClass, array.length*2);
		init(arrayTemp);
	}
	public int  size()
	{
		return end - start;
	}
	public void addStart(T value)
	{
		if(start==0)
		{
			this.resize();
		}
		array[--start]=value;
	}
	public void addEnd(T val)
	{
		if (end == array.length)
		{
			resize ();
		}
		array[end++] = val;
	}
	public <T> T delStart()
	{
		T result ;
		if (size()==0||start==end) 
		{
			throw new IllegalArgumentException();
		}
		else
		{
			result =(T)array[start];
			array[start]=null;
			start++;
		}
		return result;
	}
	public <T> T delEnd()
	{
		T result ;
		if (size()==0) 
		{
			throw new IllegalArgumentException();
		}
		else
		{
			result= (T)array[--end];
			array[end]=null;
			// end--;
		}
		return result;
	}
	@Override
	public String toString()
	{
		String temp="";
		for (int j=start; j <end;j++)
		{
			if (j < end - 1) 
			{
				temp +=array[j]+", ";
			}
			else 
			{
				temp +=array[j];
			}
		}
		return temp;
	}
	public <T> T  get(int position)
	{  
		if (array == null) 
		{
			throw new IllegalArgumentException();
		}
		position-=1;
		T result ;
		position+=start;
		if (position>=start&&position<=end)
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
		position+=start;
		if (position>=start&&position<=end)
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
		if (array == null|| size()==0) 
		{
			throw new IllegalArgumentException();
		}
		T result =(T) array[start];
		for (int i = start+ 1; i < end; i++) 
		{
			//if (result <array[i]) 
			if(((Comparable<T>) result).compareTo((T) array[i]) < 0)
			{
				result=(T)array[i];
			}
		}
		return result;
	}
	public <T> T min()
	{
		if (array == null||size()==0) 
		{
			throw new IllegalArgumentException();
		}
		T result =(T) array[start];
		for (int i =start + 1; i < end; i++) 
		{
			//	if (result >array[i]) 
			if(((Comparable<T>) result).compareTo((T) array[i]) > 0)
			{
				result=(T)array[i];
			}
		}
		return result;
	}
	public int minPos()
	{
		if (array == null|| size()==0) 
		{
			throw new IllegalArgumentException();
		}
		int result = start;
		for (int i = start+ 1; i < end; i++) 
		{
			//if (array[result]>array[i]) 
			if(((Comparable<T>) array[result]).compareTo((T) array[i]) > 0)
			{
				result=i;
			}
		}
		return (result+1)-start;
	}
	public int maxPos()
	{
		if (array == null|| size()==0) 
		{
			throw new IllegalArgumentException();
		}
		int result = start;
		for (int i = start+ 1; i < end; i++) 
		{
			if(((Comparable<T>) array[result]).compareTo((T) array[i]) < 0)
			{
				result=i;

			}
		}
		return (result+1)-start;
	}
	public <T>T  delPos( int position)
	{
		T result = null ;
		position-=1;
		position+=start;
		if (position<start||position>=end) 
		{
			throw new IllegalArgumentException();
		}
		for (int i =position; i < end-1;i++ )
		{
			array[i]=array[i+1];
			if (i+1 ==end-1)
			{
				result= (T)array[i+1];
				array[i+1]=null;
			}
		}
		end--;
		return result;
	}
	public void addPos(T value,int position)
	{
		position-=1;
		position+=start;
		if (position<start||position>end) 
		{
			throw new IllegalArgumentException();
		}
		for (int i =end; i >position;i-- )
		{
			array[i]=array[i-1];
		}
		array[position]=value;
		end++;
	}
	public void sort()
	{
		if (array == null|| size()==0) 
		{
			return;
		}
		for (int i = start; i < end; i++) 
		{
			for (int j = start; j < end; j++)
			{
				//				if (array[i] < array[j]) 
				if(((Comparable<T>) array[i]).compareTo((T) array[j]) < 0)
				{
					//	while (j >= 0 && array[i] < array[j])

					while (j >= 0 &&((Comparable<T>) array[i]).compareTo((T) array[j]) < 0)
					{
						T temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						j--;
						if(array[i]==null||array[j]==null)
						{
							break;
						}
					}
				}
			}
		}
	}
	public void reverse()
	{
		if (array == null|| size()==0) 
		{
			return;
		}
		int half = 0;
		int arrLeght = size();
		if (arrLeght % 2 == 0)
		{
			half = arrLeght / 2;
		} 
		else
		{
			half = (arrLeght / 2) + 1;
		}
		int tempEnd = end;
		for (int i = start; i < start+ half; i++) 
		{
			T temp = array[i];
			array[i] = array[ tempEnd-=1];
			array[tempEnd] = temp;
		}
	}
	public  void halfReverse() 
	{
		if (array == null|| size()==0) 
		{
			return;
		}
		int half = 0;
		int arrLeght = size();
		if (arrLeght % 2 == 0)
		{
			half = arrLeght / 2;
		} else 
		{
			half = (arrLeght / 2) + 1;
		}
		for (int i = start; i <start + arrLeght / 2; i++) 
		{
			T temp = array[i];
			array[i] = array[half + i];
			array[half + i] = temp;
		}
	}
	@Override
	public Iterator<T> iterator()
	{
		Iterator<T> it = new Iterator<T>() 
				{
			private int currentIndex = 0;

			@Override
			public boolean hasNext() 
			{
				return (start < end )&& (array[start] != null);
			}

			@Override
			public T next() {
				return array[start++];
			}

			@Override
			public void remove()
			{
				throw new UnsupportedOperationException();
			}
				};
				return it;
	}
}
