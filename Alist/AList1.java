package Alist;

public class AList1 implements EList
{
	   int [] array = new int [10];
	    int index = 0;
		public void clear()
		{
			  index = 0;
		}
	    public void init(int [] temp )
		{
	    	if (temp==null||temp.length>array.length) 
	    	{
				throw new IllegalArgumentException();
			}
		    	this. clear();
				for (int i = 0; i < temp.length; i++)
				{
					array[index]=temp[i];
					index++;
				}
		}
		public int [] toArray()
		{
			 int [] ar2= new int [index];
			 for (int i = 0; i <index; i++)
			 {
				ar2[i]=array[i];
			 }
			return ar2;
		}
	 public int  size()
	 {
	  return index;
	 }
	 public void addStart(int val)
	 {
	  for (int i = index; i > 0; i--)
	  {
	   array[i] = array[i-1];
	  }
	  array[0] = val;
	  index++;
	 }
	 public void addEnd(int val)
	 {
	  array[index++] = val;
	 }
	public int  delStart()
	{
		int result =0;
			 if (index==0) 
			  {
					throw new IllegalArgumentException();
			  }
			 else
			 {
				 result=  array[0];
				 for (int i = 0; i <index; i++) 
				 {
					 array[i]=array[i+1];
				 }
				 array[index] =0;
				 index--;
			 }
			 return result;
		}
		public int delEnd()
		{
			int result =0;
			  if (index==0) 
			  {
					throw new IllegalArgumentException();
			  }
			 else
			 {
				 
				 index--;
				 result= array[index];
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
		public int  get(int position)
		{  
			 if (array == null) 
			 {
				throw new IllegalArgumentException();
			 }
			 position-=1;
			 int result = 0;
			 if (position>=0&&position<=index)
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
			 if (position>=0&&position<=index)
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
			 if (array == null|| index==0) 
			  {
					throw new IllegalArgumentException();
			  }
			 int result = array[0];
			 for (int i = 1; i < index; i++) 
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
			 if (array == null||index==0) 
			  {
					throw new IllegalArgumentException();
			  }
			int result = array[0];
			for (int i = 1; i < index; i++) 
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
			if (array == null|| index==0) 
			  {
					throw new IllegalArgumentException();
			  }
			int result = 0;
			for (int i = 1; i < index; i++) 
			{
				if (array[result]>array[i]) 
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
				if (array[result]<array[i]) 
				{
					result=i;
					
				}
			}
			return result+1;
		}
		public int  delPos( int position)
		{
			int result = 0;
			  position-=1;
			  if (position<0||position>=index) 
			  {
					throw new IllegalArgumentException();
			  }
			  result= array[position];
				for (int i =position; i < array.length-1;i++ )
				{
					array[i]=array[i+1];
					if (i ==array.length-1)
					{
						array[i]=0;
					}
				}
				index--;
				return result;
		}
		public void addPos(int value, int position)
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
						if (array[i] < array[j]) 
						{
							while (j >= 0 && array[i] < array[j])
							{
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
					int temp = array[i];
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
					int temp = array[i];
					array[i] = array[half + i];
					array[half + i] = temp;
				}
			}
}
