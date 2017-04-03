package LikedList;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

import org.testng.annotations.Test;

public class TestNG_LList
{
	// EList arrayList = new AList0();
    // EList arrayList = new AList1();
	LList1 arrayList = new LList1();
	//=========================================
	// init, size, clear, toArrray
	//=====================p====================
	@Test
	public void test_mult_many()
	{
		int [] ini = {1,2,3,4,5,6,7,8};
		arrayList.init(ini);
		assertEquals(8, arrayList.size());
		arrayList.clear();
		int [] arrayTemp2 = new int [0];
		assertArrayEquals(arrayTemp2, arrayList.toArray());
		int [] exp = {};
		int [] act0 =arrayList.toArray();
		assertArrayEquals(exp, act0);
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void test_mult_0()
	{
		int [] ini = {};
		arrayList.init(ini);
		assertEquals(0, arrayList.size());
		arrayList.clear();
		int [] arrayTemp2 = new int [0];
		assertArrayEquals(arrayTemp2, arrayList.toArray());
		int [] exp = {};
		int [] act0 =arrayList.toArray();
		assertArrayEquals(exp, act0);
	}
	@Test
	public void test_mult_1()
	{
		int [] ini = {1};
		arrayList.init(ini);
		assertEquals(1, arrayList.size());
		arrayList.clear();
		int [] arrayTemp2 = new int [0];
		assertArrayEquals(arrayTemp2, arrayList.toArray());
		int [] exp = {};
		int [] act0 =arrayList.toArray();
		assertArrayEquals(exp, act0);
	}
	@Test
	public void test_mult_2()
	{
		int [] ini = {1,2,};
		arrayList.init(ini);
		assertEquals(2, arrayList.size());
		arrayList.clear();
		int [] arrayTemp2 = new int [0];
		assertArrayEquals(arrayTemp2, arrayList.toArray());
		int [] exp = {};
		int [] act0 =arrayList.toArray();
		assertArrayEquals(exp, act0);
	}
	//=========================================
    // AddStart
	//=========================================
	@Test
	public void testAddStart()
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.addStart(30);
		int [] arrayTemp2 = {30,1,2,3,4,5,6,7,8};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testAddStart_0_elem()
	{
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.addStart(30);
	}
	@Test
	public void testAddStart_1_elem()
	{
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.addStart(30);
		int [] arrayTemp2 = {30,1};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test
	public void testAddStart_2_elem()
	{
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.addStart(30);
		int [] arrayTemp2 = {30,1,2};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test
	public void testAddStart_m30()
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.addStart(-30);
		int [] arrayTemp2 = {-30,1,2,3,4,5,6,7,8};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	//=========================================
    // AddEnd
	//=========================================
	@Test
	public void testAddEnd()
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.addEnd(30);
		int [] arrayTemp2 = {1,2,3,4,5,6,7,8,30};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testAddEnd_iniArray_0_elem()
	{
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.addEnd(30);
	}
	@Test
	public void testAddEnd_1_elem()
	{
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.addEnd(30);
		int [] arrayTemp2 = {1,30};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	
	@Test
	public void testAddEnd_2_elem()
	{
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.addEnd(30);
		int [] arrayTemp2 = {1,2,30};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	//=========================================
    //delStart
	//=========================================
	@Test
	public void testdelStart()
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.delStart();
		int [] arrayTemp2 = {2,3,4,5,6,7,8};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test
	public void testdelStart_1_elem()
	{
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.delStart();
		int [] arrayTemp2 = {};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test
	public void testdelStart_2_elem()
	{
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.delStart();
		int [] arrayTemp2 = {2};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testdelStart_0_elem()
	{
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.delStart();
	}
	//=========================================
    //delEnd
	//=========================================
	@Test
	public void testdelEnd() 
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.delEnd();
		int [] arrayTemp2 = {1,2,3,4,5,6,7};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test
	public void testdelEnd_1_elem() 
	{
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.delEnd();
		int [] arrayTemp2 = {};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test
	public void testdelEnd_2_elem() 
	{
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.delEnd();
		int [] arrayTemp2 = {1};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testdelEnd_0_elem()
	{
		int [] arrayTemp ={};
		arrayList.init(arrayTemp);
		arrayList.delEnd();
	}
	//=========================================
    //ToString
	//=========================================
	@Test
	public void testToString() 
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		String arrayTemp2 =arrayList.toString();
		String arrayTempString= "1, 2, 3, 4, 5, 6, 7, 8, 9"; 
		assertEquals(arrayTempString, arrayTemp2);
	}
	@Test
	public void testToString_1_el() 
	{
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		String arrayTemp2 =arrayList.toString();
		String arrayTempString= "1"; 
		assertEquals(arrayTempString, arrayTemp2);
	}
	@Test
	public void testToString_2_el() 
	{
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		String arrayTemp2 =arrayList.toString();
		String arrayTempString= "1, 2"; 
		assertEquals(arrayTempString, arrayTemp2);
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testToString_0_el() 
	{
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		String arrayTemp2 =arrayList.toString();
		String arrayTempString= ""; 
		assertEquals(arrayTempString, arrayTemp2);
	}
	//=========================================
    //testGet
	//=========================================
	@Test
	public void testGet() 
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		int arrayTemp2 =arrayList.get(2);
		int arrayTempInt= 2; 
		assertEquals(arrayTempInt, arrayTemp2);
	}
	@Test
	public void testGet_1_pos() 
	{
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		int arrayTemp2 =arrayList.get(1);
		int arrayTempInt= 1; 
		assertEquals(arrayTempInt, arrayTemp2);
	}
	@Test
	public void testGet_2_pos() 
	{
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		int arrayTemp2 =arrayList.get(2);
		int arrayTempInt= 2; 
		assertEquals(arrayTempInt, arrayTemp2);
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGet_posit_eqal_m4() 
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.get(-4);
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGet_posit_eqal_40() 
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.get(40);
	}
	//=========================================
    //testSet
	//=========================================
	@Test
	public void testSet()
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		int [] arrayTemp2 ={1,5,3,4,5,6,7,8,9};
		arrayList.set(2,5);
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testSet_0_elem()
	{
		int [] arrayTemp = {0};
		arrayList.init(arrayTemp);
		arrayList.set(0,5);
	}
	@Test()
	public void testSet_1_elem()
	{
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		int [] arrayTemp2 ={5};
		arrayList.set(1,5);
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test()
	public void testSet_2_elem()
	{
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		int [] arrayTemp2 ={5,2};
		arrayList.set(1,5);
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test
	public void testSet_toEndPos()
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		int [] arrayTemp2 ={1,2,3,4,5,6,7,8,5};
		arrayList.set(9,5);
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test
	public void testSet_toStartPos()
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		int [] arrayTemp2 ={5,2,3,4,5,6,7,8,9};
		arrayList.set(1,5);
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testSet_toStartPos_m4()
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.set(-4,5);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testSet_toStartPos_40()
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.set(40,5);
	}
	//=========================================
    //testMax
	//=========================================
	@Test
	public void testMax()
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		int arrayTemp2 =9;
		int arrayTemp3=arrayList.max();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testMax_0_elem()
	{
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.max();
	}
	@Test()
	public void testMax_1_elem()
	{
		int [] arrayTemp = {5};
		arrayList.init(arrayTemp);
		int arrayTemp2 =5;
		int arrayTemp3=arrayList.max();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test()
	public void testMax_2_elem()
	{
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		int arrayTemp2 =2;
		int arrayTemp3=arrayList.max();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	//=========================================
    //testMin
	//=========================================
	@Test
	public void testMin()
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		int arrayTemp2 =1;
		int arrayTemp3=arrayList.min();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testMin_0_elem()
	{
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.min();
	}
	@Test()
	public void testMin_1_elem()
	{
		int [] arrayTemp = {5};
		arrayList.init(arrayTemp);
		int arrayTemp2 =5;
		int arrayTemp3=arrayList.min();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test()
	public void testMin_2_elem()
	{
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		int arrayTemp2 =1;
		int arrayTemp3=arrayList.min();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	//=========================================
    //minPos
	//=========================================
	@Test
	public void testminPos()
	{
		int [] arrayTemp = {9,1,7,2,6,3,4};
		arrayList.init(arrayTemp);
		int arrayTemp2 =2;
		int arrayTemp3=arrayList.minPos();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testminPos_1_elem()
	{
		int [] arrayTemp = {9};
		arrayList.init(arrayTemp);
		int arrayTemp2 =1;
		int arrayTemp3=arrayList.minPos();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testminPos_2_elem()
	{
		int [] arrayTemp = {9,1};
		arrayList.init(arrayTemp);
		int arrayTemp2 =2;
		int arrayTemp3=arrayList.minPos();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testminPos_ImptyArray()
	{
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.minPos();
	}
	//=========================================
    //maxPos
	//=========================================
	@Test
	public void testmaxPos()
	{
		int [] arrayTemp = {9,1,7,2,6,3,4};
		arrayList.init(arrayTemp);
		int arrayTemp2 =1;
		int arrayTemp3=arrayList.maxPos();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testmaxPos_1_el()
	{
		int [] arrayTemp = {9};
		arrayList.init(arrayTemp);
		int arrayTemp2 =1;
		int arrayTemp3=arrayList.maxPos();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testmaxPos_2_elem()
	{
		int [] arrayTemp = {9,1};
		arrayList.init(arrayTemp);
		int arrayTemp2 =1;
		int arrayTemp3=arrayList.maxPos();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testmaxPos_empty()
	{
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.maxPos();
	}
	//=========================================
    //delPos
	//=========================================
	@Test
	public void testdelPos() 
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.delPos(4);
		int [] arrayTemp2 = {1,2,3,5,6,7,8,9};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testdelPos_0_el() 
	{
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.delPos(4);
	}
	@Test
	public void testdelPos_1_el() 
	{
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.delPos(1);
		int [] arrayTemp2 = {};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test
	public void testdelPos_2_el() 
	{
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.delPos(2);
		int [] arrayTemp2 = {1};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testdelPos_m5() 
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.delPos(-5);
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testdelPos_50() 
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.delPos(50);
	}
	
	//=========================================
    //addPos
	//=========================================
	
	@Test
	public void testaddPos() 
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.addPos(3,40);
		int [] arrayTemp2 = {1,2,40,3,4,5,6,7,8,9};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testaddPos_0_elem() 
	{
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.addPos(3,40);
	}
	@Test
	public void testaddPos_1_elem() 
	{
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.addPos(1,40);
		int [] arrayTemp2 = {40,1};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test
	public void testaddPos_2_elem() 
	{
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.addPos(1,40);
		int [] arrayTemp2 = {40,1,2};
		assertArrayEquals(arrayTemp2, arrayList.toArray());
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testaddPos_m5() 
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.addPos(-5,40);
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testaddPos_50() 
	{
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.addPos(40,50);
	}
	//=========================================
    //sort
	//=========================================
	@Test
	public void testSort()
	{
		int[] ini = { 1, 10, 2, 9, 3, 8, 4, 7, 5, 6 };
		int[] excp = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		arrayList.init(ini);
		arrayList.sort();
		assertArrayEquals(excp, arrayList.toArray());

	}
	@Test
	public void testSort_1_elem()
	{
		int[] ini = { 9 };
		int[] excp = { 9 };
		arrayList.init(ini);
		arrayList.sort();
		assertArrayEquals(excp, arrayList.toArray());

	}
	@Test
	public void testSort_2_elem()
	{
		int[] ini = { 9, 2 };
		int[] excp = { 2, 9 };
		arrayList.init(ini);
		arrayList.sort();
		assertArrayEquals(excp, arrayList.toArray());

	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testSort_empty()
	{
		int[] ini = {};
		arrayList.init(ini);
	}
	//=========================================
    //halfReverse
	//=========================================
	@Test
	public void testhalfReverse_notEven()
	{
		int[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] expec = { 4, 3, 2, 1, 5, 9, 8, 7, 6 };
		arrayList.init(ini);
		arrayList.halfReverse();
		assertArrayEquals(expec, arrayList.toArray());
	}

	@Test
	public void testhalfReverse_Even()
	{
		int[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int[] expec = { 4, 3, 2, 1, 0, 9, 8, 7, 6, 5 };
		arrayList.init(ini);
		arrayList.halfReverse();
		assertArrayEquals(expec, arrayList.toArray());
	}

	@Test
	public void testhalfReverse_1_elem() 
	{
		int[] ini = { 9 };
		int[] expec = { 9 };
		arrayList.init(ini);
		arrayList.halfReverse();
		assertArrayEquals(expec, arrayList.toArray());
	}

	@Test
	public void testhalfReverse_2_elem()
	{
		int[] ini = { 9,2};
		int[] expec = {2, 9 };
		arrayList.init(ini);
		arrayList.halfReverse();
		assertArrayEquals(expec, arrayList.toArray());
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testhalfReverse_0() 
	{
		int[] ini = {};
		arrayList.init(ini);
		arrayList.halfReverse();
	}
	//=========================================
    //reverse
	//=========================================
	@Test
	public void testreverse_notEven() 
	{
		int[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] expec = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		arrayList.init(ini);
		arrayList.reverse();
		assertArrayEquals(expec, arrayList.toArray());
	}

	@Test
	public void testreverse_Even()
	{
		int[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int[] expec = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		arrayList.init(ini);
		arrayList.reverse();
		assertArrayEquals(expec, arrayList.toArray());
	}

	@Test
	public void testreverse_1_elem() 
	{
		int[] ini = { 9 };
		int[] expec = { 9 };
		arrayList.init(ini);
		arrayList.reverse();
		assertArrayEquals(expec, arrayList.toArray());
	}

	@Test
	public void testreverse_2_elem() 
	{
		int[] ini = { 9, 2 };
		int[] expec = { 2, 9 };
		arrayList.init(ini);
		arrayList.reverse();
		assertArrayEquals(expec, arrayList.toArray());
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testreverse_0_elem() 
	{
		int[] ini = {};
		arrayList.init(ini);
		arrayList.reverse();
	}
}
