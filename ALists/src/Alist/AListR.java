package Alist;

public class AListR implements EList
{
	int [] array = new int [30];
	int start = array.length/2 ;
	int end = array.length/2;
	int startTemp =array.length;
	int endTemp = 0;

	int index;
	public void clear()
	{
		start = array.length/2;
		end = array.length/2;
		startTemp = array.length;
		endTemp = 0;
	}
	public void init(int [] temp )
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
	public int [] toArray()
	{
		int [] temp= new int [(end +endTemp)- (start+(array.length-startTemp))];
		int i = 0;
		for (int  strT=startTemp; 0!=array.length-startTemp; i++,strT++) 
		{
			temp[i]=array[strT];
		}

		for (int str=start; str <end; str++,i++)
		{
			temp[i]=array[str];
		}
		for (int endT=end; endT <temp.length-startTemp; endT++,i++)
		{
			temp[i]=array[endT];
		}
		for (int endTS=0; endTS <endTemp; endTS++,i++)
		{
			temp[i]=array[endTS];
		}
		return temp;
	}
	public int  size()
	{
		return (end +endTemp)- (start+(array.length-startTemp));
	}
	public void addStart(int val)
	{
		if (start-endTemp!=0)
		{
			array[--start]=val;
		}
		else if(end - startTemp!=0)
		{
			array[--startTemp]=val;
		}
		else if(end - startTemp==0)
		{
			createNewArray();
			addStart(val);
		}
	}
	private void createNewArray()
	{
		int [] temp = new int [array.length];
		for (int i = 0; i <temp.length; i++)
		{
			temp[i]=array[i];
		}
		array = new int [temp.length*2];

		this.init( temp );
	}

	public void addEnd(int val)
	{
		if (end <array.length)
		{
			array[end++] = val;
		}
		else if(endTemp - start!=0)
		{
			array[endTemp++]=val;
		}
		else if(endTemp - start==0)
		{
			createNewArray();
			addEnd(val);
		}
	}
	public int delStart()
	{
		int result =0;
		if (size()==0||start==end) 
		{
			throw new IllegalArgumentException();
		}
		else
		{
			if(startTemp!=array.length)
			{
				result= array[++startTemp];
				array[endTemp]=0;
			}
			else
			{
				result =array[start];
				array[start]=0;
				start++;
			}
		}
		return result;
	}
	public int delEnd()
	{
		int result =0;
		if (size()==0||start==end) 
		{
			throw new IllegalArgumentException();
		}
		else
		{
			if(endTemp!=0)
			{
				result= array[--endTemp];
				array[endTemp]=0;
			}
			else
			{
				result= array[--end];
				array[end]=0;
			}

		}
		return result;
	}
	@Override
	public String toString()
	{
		String temp="";

		for (int  strT=startTemp; 0!=array.length-startTemp; strT++) 
		{
			temp+=array[strT]+", ";
		}

		for (int str=start; str <end; str++)
		{
			temp+=array[str]+", ";
		}
		for (int endT=end; endT <array.length-startTemp; endT++)
		{
			temp+=array[endT]+", ";
		}
		for (int endTS=0; endTS <endTemp; endTS++)
		{
			temp+=array[endTS]+", ";
		}
		return temp.replaceFirst(", "+"$","");
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
		if (position>=start+(array.length-startTemp)&&position<=end+endTemp+(array.length-startTemp))
		{
			for (int  strT=startTemp; 0!=array.length-startTemp; strT++) 
			{
				if(position-startTemp==0)
				{
					result= array[position];
					break;
				}
			}

			if(position>=start&&position<=end)
			{
				result= array[position];

			}
			for (int  endT=endTemp; endT<start; endT++) 
			{
				if(position-endT +endTemp==0)
				{
					result= array[endT];
					break;
				}
			}
		}
		else
		{
			throw new IllegalArgumentException(); 
		}
		return result;
	}
	public  void set(int val, int position)
	{
		position-=1;
		position+=start;
		if (position>=start&&position<=end+endTemp+(array.length-startTemp))
		{
			for (int  strT=startTemp; 0!=array.length-startTemp; strT++) 
			{
				if(position-startTemp==0)
				{
					array[position]=val;
					break;
				}
			}

			if(position>=start&&position<=end)
			{
				array[position]=val;				
			}
			for (int  endT=endTemp; endT<start; endT++) 
			{
				if(position-(endT + endTemp)==0)
				{
					array[position]=val;
					break;
				}
			}
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
		int result = 0;
		for (int  strT=startTemp; 0!=array.length-startTemp; strT++) 
		{
			if(array[strT]>result)
			{
				result=array[strT];
			}
		}
		for (int str=start; str <end; str++)
		{
			if(array[str]>result)
			{
				result=array[str];
			}
		}
		for (int endT=end; endT <array.length-startTemp; endT++)
		{
			if(array[endT]>result)
			{
				result=array[endT];
			}
		}
		for (int endTS=0; endTS <endTemp; endTS++)
		{
			if(array[endTS]>result)
			{
				result=array[endTS];
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
		for (int  strT=startTemp; 0!=array.length-startTemp; strT++) 
		{
			if(array[strT]<result)
			{
				result=array[strT];
			}
		}

		for (int str=start; str <end; str++)
		{
			if(array[str]<result)
			{
				result=array[str];
			}
		}
		for (int endT=end; endT <array.length-startTemp; endT++)
		{
			if(array[endT]<result)
			{
				result=array[endT];
			}
		}
		for (int endTS=0; endTS <endTemp; endTS++)
		{
			if(array[endTS]<result)
			{
				result=array[endTS];
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
		for (int  strT=startTemp; 0!=array.length-startTemp; strT++) 
		{
			if(array[strT]<array[result])
			{
				result=strT;
			}
		}
		for (int str=start; str <end; str++)
		{
			if(array[str]<array[result])
			{
				result=str;
			}
		}
		for (int endT=end; endT <array.length-startTemp; endT++)
		{
			if(array[endT]<array[result])
			{
				result=endT;
			}
		}
		for (int endTS=0; endTS <endTemp; endTS++)
		{
			if(array[endTS]<array[result])
			{
				result=endTS;
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
		for (int  strT=startTemp; 0!=array.length-startTemp; strT++) 
		{
			if(array[strT]>array[result])
			{
				result=strT;
			}
		}
		for (int str=start; str <end; str++)
		{
			if(array[str]>array[result])
			{
				result=str;
			}
		}
		for (int endT=end; endT <array.length-startTemp; endT++)
		{
			if(array[endT]>array[result])
			{
				result=endT;
			}
		}
		for (int endTS=0; endTS <endTemp; endTS++)
		{
			if(array[endTS]>array[result])
			{
				result=endTS;
			}
		}
		return (result+1)-start+(array.length-startTemp);
	}
	public int  delPos( int position)
	{
		int result = 0;
		position-=1;
		position+=start;
		if (position<start||position>=end+endTemp+(array.length-startTemp)) 
		{
			throw new IllegalArgumentException();
		}
		if (position>=start+(array.length-startTemp)&&position<=end+endTemp)
		{
			for (int  strT=startTemp,i =position; 0!=array.length-startTemp; strT++) 
			{
				array[strT]=array[strT+1];
				if (strT+1 ==array.length-1)
				{
					result= array[strT+1];
					array[strT+1]=0;
				}
				startTemp--;
				return result;
			}
			if(position>=start&&position<=end)
			{
				for (int i =position; i < end-1;i++ )
				{
					array[i]=array[i+1];
					if (i+1 ==end-1)
					{
						result= array[i+1];
						array[i+1]=0;

					}
				}
				end--;
				return result;
			}
			if(endTemp>0)
			{
				int endT = end- start;
				position=position-endT;
				for (int  i=position; position<endTemp; i++) 
				{
					array[i]=array[i+1];
					if (i+1 ==endTemp-1)
					{
						result= array[i+1];
						array[i+1]=0;
					}
				}
				endTemp--;
				return result;
			}

		}
		else
		{
			throw new IllegalArgumentException();
		}
		return result;
	}
	private void AddPosition(int value, int position)
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
	public void addPos(int value, int position)
	{
		position-=1;
		position+=start;
		if (position<start||position>end+endTemp) 
		{
			throw new IllegalArgumentException();
		}
		if (position>=start&&position<=end+endTemp+(array.length-startTemp))
		{
			if(0!=array.length-startTemp)
			{
				int  j=startTemp;
				for (;j< position+startTemp;j++) 
				{
					if (startTemp-1==end)
					{
						createNewArray();
						AddPosition( value,  position);
						return;
					}
					array[1+j]=array[j];
				}
				array[position+j]=value;
				startTemp--;
				return;
			}
			if (position>=start||position>end) 
			{
				for (int i =end; i >position;i-- )
				{
					array[i]=array[i-1];
				}
				array[position]=value;
				end++;
				return;
			}
		
			if(endTemp>0)
			{
				if((end- start) +endTemp<position)
				{
					int endT = end- start;
					position=position-endT;	
					
					if (endTemp+1==start)
					{
						createNewArray();
						AddPosition(value, position);
						return;
					}
					for (int i =endTemp; i >position;i-- )
					{
						array[i+1]=array[i];
					}
					array[position]=value;
					endTemp++;
				}
			}
		}
	}
	public void sort()
	{
		if (array == null|| size()==0) 
		{
			return;
		}
		if(array.length!=startTemp ||endTemp!=0)
		{
			createNewArray();	
		}
		for (int i = start; i < end; i++) 
		{
			for (int j = start; j < end; j++)
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
		if(array.length!=startTemp ||endTemp!=0)
		{
			createNewArray();	
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
		if(array.length!=startTemp ||endTemp!=0)
		{
			createNewArray();	
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
