package AList0_2_TestNG;

public class AList2 implements EList
{
	 int [] array = new int [30];
	    int start = array.length/2 ;
	    int and = array.length/2;
	    int index;
		public void clear()
		{
			 start = array.length/2;
		     and = array.length/2;
		}
	    public void init(int [] temp )
		{
	    	if (temp==null||temp.length>array.length) 
	    	{
				throw new IllegalArgumentException();
			}
		    this. clear();
		    start-=(temp.length/2);// добавил эту строку
		    and = start + temp.length;
			for (int i = start, j =0; j <temp.length; i++,j++)
			{
				array[i]=temp[j];
			}
		}
		public int [] toArray()
		{
			 int [] temp= new int [and-start];
			 for (int i=start, j =0; j <temp.length; i++,j++)
			 {
				temp[j]=array[i];
			 }
			return temp;
		}
	 public int  size()
	 {
		 return and - start;
	 }
	 public void addStart(int value)
	 {
	 if (array[0]==0)
	 {
		 array[--start]=value;
	 }
	 }
	 public void addEnd(int val)
	 {
		 if (and <array.length)
		 {
			array[and++] = val;
		 }
	 }
	 public int delStart()
		{
		 int result =0;
			 if (size()==0||start==and) 
			  {
					throw new IllegalArgumentException();
			  }
			 else
			 {
				 result =array[start];
					 array[start]=0;
					 start++;
			 }
			 return result;
		}
		public int delEnd()
		{
			 int result =0;
			 if (size()==0) 
			  {
					throw new IllegalArgumentException();
			  }
			 else
			 {
				     result= array[--and];
					 array[and]=0;
					// and--;
			 }
			 return result;
		}
		@Override
		public String toString()
		{
		    String temp="";
		    for (int j=start; j <and;j++)
			 {
				if (j < and - 1) 
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
		public int  get(int position)
		{  
			 if (array == null) 
			 {
				throw new IllegalArgumentException();
			 }
			 position-=1;
			 int result = 0;
			 position+=start;
			 if (position>=start&&position<=and)
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
			 position+=start;
			 if (position>=start&&position<=and)
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
			 if (array == null|| size()==0) 
			  {
					throw new IllegalArgumentException();
			  }
			 int result = array[start];
			 for (int i = start+ 1; i < and; i++) 
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
			 if (array == null||size()==0) 
			  {
					throw new IllegalArgumentException();
			  }
			int result = array[start];
			for (int i =start + 1; i < and; i++) 
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
			if (array == null|| size()==0) 
			  {
					throw new IllegalArgumentException();
			  }
			int result = start;
			for (int i = start+ 1; i < and; i++) 
			{
				if (array[result]>array[i]) 
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
			for (int i = start+ 1; i < and; i++) 
			{
				if (array[result]<array[i]) 
				{
					result=i;
					
				}
			}
			return (result+1)-start;
		}
		public int  delPos( int position)
		{
			int result = 0;
			  position-=1;
			  position+=start;
			  if (position<start||position>=and) 
			  {
					throw new IllegalArgumentException();
			  }
				for (int i =position; i < and-1;i++ )
				{
					array[i]=array[i+1];
					if (i+1 ==and-1)
					{
						result= array[i+1];
						array[i+1]=0;
					}
				}
				and--;
				return result;
		}
		public void addPos(int value, int position)
		{
			  position-=1;
			  position+=start;
			  if (position<start||position>and) 
			  {
					throw new IllegalArgumentException();
			  }
				for (int i =and; i >position;i-- )
				{
					array[i]=array[i-1];
				}
				array[position]=value;
				and++;
		}
		  public void sort()
		  {
			  if (array == null|| size()==0) 
			  {
				  return;
			  }
				for (int i = start; i < and; i++) 
				{
					for (int j = start; j < and; j++)
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
				int tempEnd = and;
				for (int i = start; i < start+ half; i++) 
				{
					int temp = array[i];
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
					int temp = array[i];
					array[i] = array[half + i];
					array[half + i] = temp;
				}
			}
}
