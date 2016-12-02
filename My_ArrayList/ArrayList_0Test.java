package My_ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayList_0Test {


	@Test
	public void testClear()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.Clear();
		int [] arrayTemp2 = new int [0];
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}

	@Test
	public void testClear_0_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.Clear();
		int [] arrayTemp2 = new int [0];
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testClear_1_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.Clear();
		int [] arrayTemp2 = new int [0];
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testClear_2_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.Clear();
		int [] arrayTemp2 = new int [0];
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testAddStart()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.addStart(30);
		int [] arrayTemp2 = {30,1,2,3,4,5,6,7,8};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testAddStart_iniArray_0_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.addStart(30);
		int [] arrayTemp2 = {30};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testAddStart_iniArray_1_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.addStart(30);
		int [] arrayTemp2 = {30,1};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testAddStart_iniArray_2_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.addStart(30);
		int [] arrayTemp2 = {30,1,2};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testAddStart_m30()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.addStart(-30);
		int [] arrayTemp2 = {-30,1,2,3,4,5,6,7,8};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testAddEnd()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.addEnd(30);
		int [] arrayTemp2 = {1,2,3,4,5,6,7,8,30};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testAddEnd_iniArray_0_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.addEnd(30);
		int [] arrayTemp2 = {30};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testAddEnd_iniArray_1_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.addEnd(30);
		int [] arrayTemp2 = {1,30};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	
	@Test
	public void testAddEnd_iniArray_2_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.addEnd(30);
		int [] arrayTemp2 = {1,2,30};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	
	@Test
	public void testInit()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		assertArrayEquals(arrayTemp, arrayList.ToArray());
	}
	@Test
	public void testInit_0_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		assertArrayEquals(arrayTemp, arrayList.ToArray());
	}
	@Test
	public void testInit_1_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		assertArrayEquals(arrayTemp, arrayList.ToArray());
	}
	@Test
	public void testInit_2_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		assertArrayEquals(arrayTemp, arrayList.ToArray());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testInit_Exc()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp =null;
		arrayList.init(arrayTemp);
	}
	@Test
	public void testDellStart()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.DellStart();
		int [] arrayTemp2 = {2,3,4,5,6,7,8};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testDellStart_1_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.DellStart();
		int [] arrayTemp2 = {};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testDellStart_2_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.DellStart();
		int [] arrayTemp2 = {2};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDellStart_0_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.DellStart();
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDellStart_arrayIsNull()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp =null;
		arrayList.init(arrayTemp);
		arrayList.DellStart();
	}
	@Test
	public void testDellEnd() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.DellEnd();
		int [] arrayTemp2 = {1,2,3,4,5,6,7};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testDellEnd_iniArray_1_elem() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.DellEnd();
		int [] arrayTemp2 = {};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testDellEnd_iniArray_2_elem() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.DellEnd();
		int [] arrayTemp2 = {1};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDellEnd_iniArray_0_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp ={};
		arrayList.init(arrayTemp);
		arrayList.DellEnd();
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDellEnd_isiArray_null()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp =null;
		arrayList.init(arrayTemp);
	}
	@Test
	public void testToArray() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		int [] arrayTemp2 =arrayList.ToArray();
		assertArrayEquals(arrayTemp, arrayTemp2);
	}
	@Test
	public void testToArray_iniArray_0_elem() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		int [] arrayTemp2 =arrayList.ToArray();
		assertArrayEquals(arrayTemp, arrayTemp2);
	}
	@Test
	public void testToArray_iniArray_1_elem() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		int [] arrayTemp2 =arrayList.ToArray();
		assertArrayEquals(arrayTemp, arrayTemp2);
	}
	@Test
	public void testToArray_iniArray_2_elem() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		int [] arrayTemp2 =arrayList.ToArray();
		assertArrayEquals(arrayTemp, arrayTemp2);
	}
	@Test
	public void testToString() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		String arrayTemp2 =arrayList.toString();
		String arrayTempString= "1, 2, 3, 4, 5, 6, 7, 8, 9"; 
		assertEquals(arrayTempString, arrayTemp2);
	}
	@Test
	public void testToString_1_el() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		String arrayTemp2 =arrayList.toString();
		String arrayTempString= "1"; 
		assertEquals(arrayTempString, arrayTemp2);
	}
	@Test
	public void testToString_2_el() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		String arrayTemp2 =arrayList.toString();
		String arrayTempString= "1, 2"; 
		assertEquals(arrayTempString, arrayTemp2);
	}
	@Test
	public void testToString_0_el() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		String arrayTemp2 =arrayList.toString();
		String arrayTempString= ""; 
		assertEquals(arrayTempString, arrayTemp2);
	}
	
	@Test
	public void testSize() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		int arrayTemp2 =arrayList.Size();
		int arrayTempInt= 8; 
		assertEquals(arrayTempInt, arrayTemp2);
	}
	@Test
	public void testSize_1_el() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		int arrayTemp2 =arrayList.Size();
		int arrayTempInt= 1; 
		assertEquals(arrayTempInt, arrayTemp2);
	}
	@Test
	public void testSize_2_el() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		int arrayTemp2 =arrayList.Size();
		int arrayTempInt= 2; 
		assertEquals(arrayTempInt, arrayTemp2);
	}
	@Test
	public void testSize_0_el() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		int arrayTemp2 =arrayList.Size();
		int arrayTempInt= 0; 
		assertEquals(arrayTempInt, arrayTemp2);
	}
	@Test
	public void testGet() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		int arrayTemp2 =arrayList.get(2);
		int arrayTempInt= 2; 
		assertEquals(arrayTempInt, arrayTemp2);
	}
	@Test
	public void testGet_1_pos() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		int arrayTemp2 =arrayList.get(1);
		int arrayTempInt= 1; 
		assertEquals(arrayTempInt, arrayTemp2);
	}
	@Test
	public void testGet_2_pos() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		int arrayTemp2 =arrayList.get(2);
		int arrayTempInt= 2; 
		assertEquals(arrayTempInt, arrayTemp2);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testGet_posit_eqal_m4() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.get(-4);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testGet_posit_eqal_40() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.get(40);
	}
	@Test
	public void testSet()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		int [] arrayTemp2 ={1,5,3,4,5,6,7,8,9};
		arrayList.set(5,2);
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSet_0_elem_inArray()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {0};
		arrayList.init(arrayTemp);
		arrayList.set(5,0);
	}
	@Test()
	public void testSet_1_elem_inArray()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		int [] arrayTemp2 ={5};
		arrayList.set(5,1);
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test()
	public void testSet_2_elem_inArray()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		int [] arrayTemp2 ={5,2};
		arrayList.set(5,1);
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testSet_toEndPos()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		int [] arrayTemp2 ={1,2,3,4,5,6,7,8,5};
		arrayList.set(5,9);
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testSet_toStartPos()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		int [] arrayTemp2 ={5,2,3,4,5,6,7,8,9};
		arrayList.set(5,1);
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSet_toStartPos_m4()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.set(5,-4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSet_toStartPos_40()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.set(5,40);
	}
	@Test
	public void testMax()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		int arrayTemp2 =9;
		int arrayTemp3=arrayList.max();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testMax_0_elem_inArray()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.max();
	}
	@Test()
	public void testMax_1_elem_inArray()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {5};
		arrayList.init(arrayTemp);
		int arrayTemp2 =5;
		int arrayTemp3=arrayList.max();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test()
	public void testMax_2_elem_inArray()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		int arrayTemp2 =2;
		int arrayTemp3=arrayList.max();
		assertEquals(arrayTemp2, arrayTemp3);
	}
///////////////////////////////////////////
	@Test
	public void testMin()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		int arrayTemp2 =1;
		int arrayTemp3=arrayList.min();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testMin_0_elem_inArray()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.min();
	}
	@Test()
	public void testMin_1_elem_inArray()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {5};
		arrayList.init(arrayTemp);
		int arrayTemp2 =5;
		int arrayTemp3=arrayList.min();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test()
	public void testMin_2_elem_inArray()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		int arrayTemp2 =1;
		int arrayTemp3=arrayList.min();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testPosMinElem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {9,1,7,2,6,3,4};
		arrayList.init(arrayTemp);
		int arrayTemp2 =2;
		int arrayTemp3=arrayList.PosMinElem();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testPosMinElem_1_el()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {9};
		arrayList.init(arrayTemp);
		int arrayTemp2 =1;
		int arrayTemp3=arrayList.PosMinElem();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testPosMinElem_2_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {9,1};
		arrayList.init(arrayTemp);
		int arrayTemp2 =2;
		int arrayTemp3=arrayList.PosMinElem();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testPosMinElem_ImptyArray()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		int arrayTemp3=arrayList.PosMinElem();
	}
/////////////////////////
	@Test
	public void testPosMaxElem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {9,1,7,2,6,3,4};
		arrayList.init(arrayTemp);
		int arrayTemp2 =1;
		int arrayTemp3=arrayList.PosMaxElem();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testPosMaxElem_1_el()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {9};
		arrayList.init(arrayTemp);
		int arrayTemp2 =1;
		int arrayTemp3=arrayList.PosMaxElem();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testPosMaxElem_2_elem()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {9,1};
		arrayList.init(arrayTemp);
		int arrayTemp2 =1;
		int arrayTemp3=arrayList.PosMaxElem();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testPosMaxElem_ImptyArray()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		int arrayTemp3=arrayList.PosMaxElem();
	}

	@Test
	public void testDelByPosition() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.DelByPosition(4);
		int [] arrayTemp2 = {1,2,3,5,6,7,8,9};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDelByPosition_0_el() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.DelByPosition(4);
	}
	@Test
	public void testDelByPosition_1_el() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.DelByPosition(1);
		int [] arrayTemp2 = {};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testDelByPosition_2_el() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.DelByPosition(2);
		int [] arrayTemp2 = {1};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDelByPosition_m5() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.DelByPosition(-5);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDelByPosition_50() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.DelByPosition(50);
	}
	
	///////////////////////////////////////
	
	@Test
	public void testAddByPosition() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.addByPosition(40,3);
		int [] arrayTemp2 = {1,2,40,3,4,5,6,7,8,9};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddByPosition_0_el() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.addByPosition(40,3);
	}
	@Test
	public void testAddByPosition_1_el() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.addByPosition(40,1);
		int [] arrayTemp2 = {40,1};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test
	public void testAddByPosition_2_el() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.addByPosition(40,1);
		int [] arrayTemp2 = {40,1,2};
		assertArrayEquals(arrayTemp2, arrayList.ToArray());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddByPosition_m5() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.addByPosition(40,-5);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddByPosition_50() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.addByPosition(40,50);
	}
///////////////////////////////////////////////////////
	@Test
	public void testSort()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = { 1, 10, 2, 9, 3, 8, 4, 7, 5, 6 };
		int[] excp = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		arrayList.init(ini);
		arrayList.sort();
		assertArrayEquals(excp, arrayList.ToArray());

	}
	@Test
	public void testSort_1_el()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = { 9 };
		int[] excp = { 9 };
		arrayList.init(ini);
		arrayList.sort();
		assertArrayEquals(excp, arrayList.ToArray());

	}
	@Test
	public void testSort_2_el()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = { 9, 2 };
		int[] excp = { 2, 9 };
		arrayList.init(ini);
		arrayList.sort();
		assertArrayEquals(excp, arrayList.ToArray());

	}
	@Test(expected = IllegalArgumentException.class)
	public void testSort_Empty_array()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = {};
		int[] excp = {};
		arrayList.init(ini);
		arrayList.sort();
		assertArrayEquals(excp, arrayList.ToArray());

	}


	@Test(expected = IllegalArgumentException.class)
	public void testSort_E()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = null;
		arrayList.init(ini);
		arrayList.sort();
	}
	///////////////////////////////////////////////////////////
	
	@Test
	public void testHalfRevers_notEven()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] expec = { 4, 3, 2, 1, 5, 9, 8, 7, 6 };
		arrayList.init(ini);
		arrayList.halfRevers();
		assertArrayEquals(expec, arrayList.ToArray());
	}

	@Test
	public void testHalfRevers_Even()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int[] expec = { 4, 3, 2, 1, 0, 9, 8, 7, 6, 5 };
		arrayList.init(ini);
		arrayList.halfRevers();
		assertArrayEquals(expec, arrayList.ToArray());
	}

	@Test
	public void testHalfRevers_1_el() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = { 9 };
		int[] expec = { 9 };
		arrayList.init(ini);
		arrayList.halfRevers();
		assertArrayEquals(expec, arrayList.ToArray());
	}

	@Test
	public void testHalfRevers_2_el()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = { 9,2};
		int[] expec = {2, 9 };
		arrayList.init(ini);
		arrayList.halfRevers();
		assertArrayEquals(expec, arrayList.ToArray());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testHalfRevers_0() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = {};
		arrayList.init(ini);
		arrayList.halfRevers();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testHalfRevers_E() {
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = null;
		arrayList.init(ini);
		arrayList.halfRevers();
	}

	@Test
	public void testRevers_notEven() {
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] expec = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		arrayList.init(ini);
		arrayList.revers();
		assertArrayEquals(expec, arrayList.ToArray());
	}

	@Test
	public void testRevers_Even()
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int[] expec = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		arrayList.init(ini);
		arrayList.revers();
		assertArrayEquals(expec, arrayList.ToArray());
	}

	@Test
	public void testRevers_1() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = { 9 };
		int[] expec = { 9 };
		arrayList.init(ini);
		arrayList.revers();
		assertArrayEquals(expec, arrayList.ToArray());
	}

	@Test
	public void testRevers_2() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = { 9, 2 };
		int[] expec = { 2, 9 };
		arrayList.init(ini);
		arrayList.revers();
		assertArrayEquals(expec, arrayList.ToArray());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRevers_0() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = {};
		arrayList.init(ini);
		arrayList.revers();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRevers_E() 
	{
		ArrayList_0 arrayList = new ArrayList_0();
		int[] ini = null;
		arrayList.init(ini);

	}
}
