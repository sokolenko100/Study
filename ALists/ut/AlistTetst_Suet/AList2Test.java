package AlistTetst_Suet;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import Alist.AList2;

public class AList2Test {

	AList2 aList = new AList2();
	@Test
	public void testResize_addStart() 
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		aList.init(arrayTemp);
		aList.addStart(0);
		int [] arrayTemp2 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		assertArrayEquals(arrayTemp2, aList.toArray());
	}
	@Test
	public void testResize_addEnd() 
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		aList.init(arrayTemp);
		aList.addEnd(31);
		int [] arrayTemp2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		assertArrayEquals(arrayTemp2, aList.toArray());
	}
}
