package My_ArrayList;

public class ArrayList_0
{
    private int [] array = new  int[0];
	public void Clear()
	{
		 if (array == null) 
		  {
				throw new IllegalArgumentException();
		  }
		 array = new  int[0];
	}
	
	public void addStart(int val)
	{
		 if (array == null) 
		  {
				throw new IllegalArgumentException();
		  }
		 int [] ar2 = new int [array.length+1];
		 for (int i = 1; i < ar2.length; i++) 
		 {
			 ar2[i]=array[i-1];
		 }
		 ar2[0] =val;
		 array=ar2;
	}
	public void addEnd(int val)
	{
		 if (array == null) 
		  {
				throw new IllegalArgumentException();
		  }
		 int [] ar2 = new int [array.length+1];
		 for (int i = 0; i < array.length; i++) 
		 {
			ar2[i]=array[i];
		 }
		   ar2[ar2.length-1] =val;
		   array=ar2;
	}
	public void init(int [] rr )
	{
		 if (rr == null) 
		  {
				throw new IllegalArgumentException();
		  }
		if (rr== null || rr.length==0)
		{
			this. Clear();
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
	public void DellStart()
	{
		 if (array == null||array.length==0) 
		  {
				throw new IllegalArgumentException();
		  }
		 else
		 {
			 int [] ar2 = new int [array.length-1];
			 int del = array [0];
			 for (int i = 1; i <= ar2.length; i++) 
			 {
				 ar2[i-1]=array[i];
			 }
			 System.out.println(del);

			 array=ar2; 
		 }
	}
	public void DellEnd()
	{
		 if (array == null||array.length==0) 
		  {
				throw new IllegalArgumentException();
		  }
		 else
		 {
			 int [] ar2 = new int [array.length-1];
			 int del = array [array.length-1];
			 for (int i = 0; i < ar2.length; i++) 
			 {
				 ar2[i]=array[i];
			 }
			 System.out.println(del);
			 array=ar2;
		 }
	}

	public int [] ToArray()
	{
		 if (array == null) 
		  {
				throw new IllegalArgumentException();
		  }
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
		if (array == null) 
	    {
			throw new IllegalArgumentException();
        }
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
	public int Size()
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
		 if (array == null) 
		  {
				throw new IllegalArgumentException();
		  }
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
	public int PosMinElem()
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
	public int PosMaxElem()
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
	public void DelByPosition( int position)
	{
		if (array == null|| array.length==0) 
		  {
				throw new IllegalArgumentException();
		  }
		position-=1;
		if (position>=0&&position<array.length)
		{
			int [] ar2= new int [array.length-1];
			for (int i = 0,j=0; j < ar2.length;i++ )
			{
				 if (i==position)
				 {
					 continue;
				 }
				 ar2[j]=array[i];
				 j++;
			}
			 array=ar2;
		}
		else
		{
		throw new IllegalArgumentException();	
		}
	}
	public void addByPosition(int value, int position)
	{
		  if (array == null|| array.length==0) 
		  {
				throw new IllegalArgumentException();
		  }
		position-=1;
		if (position>=0&&position<array.length)
		{
			int [] ar2= new int [array.length+1];
			for (int i = 0,j=0; j < ar2.length;j++ )
			{
				 if (j==position)
				 {
					ar2[j]=value;
				
				 }
				 else  
				 {
					 ar2[j]=array[i];
					 i++;
				 }
			}
			 array=ar2;
		}
		else
		{
		throw new IllegalArgumentException();	
		}
	}
	  public void sort()
	  {
		  if (array == null|| array.length==0) 
		  {
				throw new IllegalArgumentException();
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
	  public void revers()
	  {
		  if (array == null|| array.length==0) 
		  {
				throw new IllegalArgumentException();
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
	  public  void halfRevers() 
	  {
		  if (array == null|| array.length==0) 
		  {
				throw new IllegalArgumentException();
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
