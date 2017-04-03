package AlistTetst_Suet;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import Alist.AList1;

public class AList1Test
{
	AList1 aList = new AList1();

	@Test
	public void testResize_addStart() 
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9,10};
		aList.init(arrayTemp);
		aList.addStart(0);
		int [] arrayTemp2 = {0,1,2,3,4,5,6,7,8,9,10};
		assertArrayEquals(arrayTemp2, aList.toArray());
	}
	@Test
	public void testResize_addEnd() 
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9,10};
		aList.init(arrayTemp);
		aList.addEnd(11);
		int [] arrayTemp2 = {1,2,3,4,5,6,7,8,9,10,11};
		assertArrayEquals(arrayTemp2, aList.toArray());
	}
}
