package Alist;


public class AList0 implements EList
{
    private int [] array = new  int[0];
	public void clear()
	{
		 array = new  int[0];
	}
	
	public void addStart(int val)
	{
		 int [] temp = new int [array.length+1];
		 for (int i = 1; i < temp.length; i++) 
		 {
			 temp[i]=array[i-1];
		 }
		 temp[0] =val;
		 array=temp;
	}
	public void addEnd(int val)
	{
		 int [] temp = new int [array.length+1];
		 for (int i = 0; i < array.length; i++) 
		 {
			temp[i]=array[i];
		 }
		   temp[temp.length-1] =val;
		   array=temp;
	}
	public void init(int [] rr )
	{

		this. clear();
		if (rr== null)
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			array= new int [rr.length];
			for (int i = 0; i < rr.length; i++)
			{
				array[i]=rr[i];
			}
		}
	}
	public int delStart()
	{
		int result = 0;
		 if (array.length==0) 
		  {
				throw new IllegalArgumentException();
		  }
		 else
		 {
			 int [] temp = new int [array.length-1];
			 result = array [0];
			 for (int i = 1; i <= temp.length; i++) 
			 {
				 temp[i-1]=array[i];
			 }
			 array=temp; 
		 }
		 return result;
	}
	public int delEnd()
	{
		int result = 0;
		  if (array.length==0) 
		  {
				throw new IllegalArgumentException();
		  }
		 else
		 {
			 int [] ar2 = new int [array.length-1];
			 result = array [array.length-1];
			 for (int i = 0; i < ar2.length; i++) 
			 {
				 ar2[i]=array[i];
			 }
			 array=ar2;
		 }
		  return result;
	}

	public int [] toArray()
	{
		 int [] ar2= new int [array.length];
		 for (int i = 0; i < array.length; i++)
		 {
			ar2[i]=array[i];
		 }
		return ar2;
	}
	@Override
	public String toString()
	{
	    String temp="";
		for (int i = 0; i < array.length; i++)
		{
			if (i<array.length -1) 
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
	public int size()
	{
		return	 array.length;
	}
	public int  get(int position)
	{  
		 if (array == null) 
		 {
			throw new IllegalArgumentException();
		 }
		 position-=1;
		 int result = 0;
		 if (position>=0&&position<=array.length)
		 {
			result= array[position];
		 }
		 else
		 {
			 throw new IllegalArgumentException(); 
		 }
		 return result;
	}
	public  void set(int value, int position)
	{
		 position-=1;
		 if (position>=0&&position<=array.length)
		 {
			 array[position]= value;
		 }
		 else
		 {
				throw new IllegalArgumentException();
		 }
	}
	public int max()
	{
		 if (array == null|| array.length==0) 
		  {
				throw new IllegalArgumentException();
		  }
		 int result = array[0];
		 for (int i = 1; i < array.length; i++) 
		 {
			 if (result <array[i]) 
			 {
				 result=array[i];
			 }
		 }
			return result;
	}
	public int min()
	{
		 if (array == null|| array.length==0) 
		  {
				throw new IllegalArgumentException();
		  }
		int result = array[0];
		for (int i = 1; i < array.length; i++) 
		{
			if (result >array[i]) 
			{
				result=array[i];
			}
		}
		return result;
	}
	public int minPos()
	{
		if (array == null|| array.length==0) 
		  {
				throw new IllegalArgumentException();
		  }
		int result = array[0];
		int index=0;
		for (int i = 1; i < array.length; i++) 
		{
			if (result >array[i]) 
			{
				result=array[i];
				index=i;
			}
		}
		return index+1;
	}
	public int maxPos()
	{
		if (array == null|| array.length==0) 
		  {
				throw new IllegalArgumentException();
		  }
		int result = array[0];
		int index=0;
		for (int i = 1; i < array.length; i++) 
		{
			if (result < array[i]) 
			{
				result=array[i];
				index=i;
			}
		}
		return index+1;
	}
	public int delPos( int position)
	{
		  int result = 0;
		  position-=1;
		  if (position<0||position>=array.length) 
		  {
				throw new IllegalArgumentException();
		  }
		  
			int [] tmp= new int [array.length-1];
			
			
			for (int j = 0; j < position;j++ )
			{
				tmp[j]=array[j];
			}
			for (int i =position; i < array.length-1;i++ )
			{
				tmp[i]=array[i+1];
			}
			 array=tmp;
			 return result;
	}
	public void addPos(int value, int position)
	{
		  position-=1;
		  if (position<0||position>array.length) 
		  {
				throw new IllegalArgumentException();
		  }
		  
			int [] tmp= new int [array.length+1];
			
			
			for (int j = 0; j < position;j++ )
			{
				tmp[j]=array[j];
			}
			tmp[position]= value;
			for (int i =position+1; i < tmp.length;i++ )
			{
				tmp[i]=array[i-1];
			}
			 array=tmp;
	}
	  public void sort()
	  {
		  if (array == null|| array.length==0) 
		  {
			  return;
		  }
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if (array[i] < array[j]) {
						while (j >= 0 && array[i] < array[j]) {
							int temp = array[i];
							array[i] = array[j];
							array[j] = temp;
							j--;
						}
					}
				}
			}
	  }
	  public void reverse()
	  {
		  if (array == null|| array.length==0) 
		  {
				return;
		  }
			int half = 0;
			int arrLeght = array.length;
			if (arrLeght % 2 == 0) {
				half = arrLeght / 2;
			} else {
				half = (arrLeght / 2) + 1;
			}
			for (int i = 0; i < arrLeght / 2; i++) {
				int temp = array[i];
				array[i] = array[arrLeght - (i + 1)];
				array[arrLeght - (i + 1)] = temp;
			}
	  }
	  public  void halfReverse() 
	  {
		  if (array == null|| array.length==0) 
		  {
			  return;
		  }
			int half = 0;
			int arrLeght = array.length;
			if (arrLeght % 2 == 0) {
				half = arrLeght / 2;
			} else {
				half = (arrLeght / 2) + 1;
			}
			for (int i = 0; i < arrLeght / 2; i++) {
				int temp = array[i];
				array[i] = array[half + i];
				array[half + i] = temp;
			}
	  }
}