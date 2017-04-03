package AListsTest_Iter_Generic;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import Alist_itterator.AList1_generic;

public class AList_itterator_Test 
{
	//AList2_generic<Integer> arrayList = new AList2_generic(Integer.class);
	AList1_generic<Integer> arrayList = new AList1_generic(Integer.class);
	@Test
	public void testclear()
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.clear();
		Integer [] arrayTemp2 = new Integer [0];
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}

	@Test
	public void testclear_0_elem()
	{
		Integer [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.clear();
		Integer [] arrayTemp2 = new Integer [0];
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testclear_1_elem()
	{
		Integer [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.clear();
		Integer [] arrayTemp2 = new Integer [0];
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testclear_2_elem()
	{
		Integer [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.clear();
		Integer [] arrayTemp2 = new Integer [0];
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testAddStart()
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.addStart(30);
		Integer [] arrayTemp2 = {30,1,2,3,4,5,6,7,8};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testAddStart_iniArray_0_elem()
	{
		Integer [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.addStart(30);
		Integer [] arrayTemp2 = {30};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testAddStart_iniArray_1_elem()
	{
		Integer [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.addStart(30);
		Integer [] arrayTemp2 = {30,1};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testAddStart_iniArray_2_elem()
	{
		Integer [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.addStart(30);
		Integer [] arrayTemp2 = {30,1,2};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testAddStart_m30()
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.addStart(-30);
		Integer [] arrayTemp2 = {-30,1,2,3,4,5,6,7,8};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testAddEnd()
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.addEnd(30);
		Integer [] arrayTemp2 = {1,2,3,4,5,6,7,8,30};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testAddEnd_iniArray_0_elem()
	{
		Integer [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.addEnd(30);
		Integer [] arrayTemp2 = {30};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testAddEnd_iniArray_1_elem()
	{
		Integer [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.addEnd(30);
		Integer [] arrayTemp2 = {1,30};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}

	@Test
	public void testAddEnd_iniArray_2_elem()
	{
		Integer [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.addEnd(30);
		Integer [] arrayTemp2 = {1,2,30};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}

	@Test
	public void testInit()
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp, arrayTemp3);
	}
	@Test
	public void testInit_0_elem()
	{
		Integer [] arrayTemp = {};
		arrayList.init(arrayTemp);
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp, arrayTemp3);
	}
	@Test
	public void testInit_1_elem()
	{
		Integer [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp, arrayTemp3);
	}
	@Test
	public void testInit_2_elem()
	{
		Integer [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp, arrayTemp3);
	}
	@Test(expected= IllegalArgumentException.class)
	public void testInit_Exc()
	{
		Integer [] arrayTemp =null;
		arrayList.init(arrayTemp);
		arrayTemp = new Integer [0];
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp, arrayTemp3);
	}
	@Test
	public void testdelStart()
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.delStart();
		Integer [] arrayTemp2 = {2,3,4,5,6,7,8};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testdelStart_1_elem()
	{
		Integer [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.delStart();
		Integer [] arrayTemp2 = {};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testdelStart_2_elem()
	{
		Integer [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.delStart();
		Integer [] arrayTemp2 = {2};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testdelStart_0_elem()
	{
		Integer [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.delStart();
	}
	@Test(expected = IllegalArgumentException.class)
	public void testdelStart_arrayIsNull()
	{
		Integer [] arrayTemp =null;
		arrayList.init(arrayTemp);
	}
	@Test
	public void testdelEnd() 
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		arrayList.delEnd();
		Integer [] arrayTemp2 = {1,2,3,4,5,6,7};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);	}
	@Test
	public void testdelEnd_iniArray_1_elem() 
	{
		Integer [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.delEnd();
		Integer [] arrayTemp2 = {};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);	}
	@Test
	public void testdelEnd_iniArray_2_elem() 
	{
		Integer [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.delEnd();
		Integer [] arrayTemp2 = {1};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);	}

	@Test(expected = IllegalArgumentException.class)
	public void testdelEnd_iniArray_0_elem()
	{
		Integer [] arrayTemp ={};
		arrayList.init(arrayTemp);
		arrayList.delEnd();
	}
	@Test(expected= IllegalArgumentException.class)
	public void testdelEnd_isiArray_null()
	{
		Integer [] arrayTemp =null;
		arrayList.init(arrayTemp);
	}
	@Test
	public void testtoArray() 
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		Integer [] arrayTemp2 =arrayList.toArray();
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);	}
	@Test
	public void testtoArray_iniArray_0_elem() 
	{
		Integer [] arrayTemp = {};
		arrayList.init(arrayTemp);
		Integer [] arrayTemp2 =arrayList.toArray();
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);	}
	@Test
	public void testtoArray_iniArray_1_elem() 
	{
		Integer [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		Integer [] arrayTemp2 =arrayList.toArray();
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);	}
	@Test
	public void testtoArray_iniArray_2_elem() 
	{
		Integer [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		Integer [] arrayTemp2 =arrayList.toArray();
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);	}
	@Test
	public void testToString() 
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		String arrayTemp2 =arrayList.toString();
		String arrayTempString= "1, 2, 3, 4, 5, 6, 7, 8, 9"; 
		assertEquals(arrayTempString, arrayTemp2);
	}
	@Test
	public void testToString_1_el() 
	{
		Integer [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		String arrayTemp2 =arrayList.toString();
		String arrayTempString= "1"; 
		assertEquals(arrayTempString, arrayTemp2);
	}
	@Test
	public void testToString_2_el() 
	{
		Integer [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		String arrayTemp2 =arrayList.toString();
		String arrayTempString= "1, 2"; 
		assertEquals(arrayTempString, arrayTemp2);
	}
	@Test
	public void testToString_0_el() 
	{
		Integer [] arrayTemp = {};
		arrayList.init(arrayTemp);
		String arrayTemp2 =arrayList.toString();
		String arrayTempString= ""; 
		assertEquals(arrayTempString, arrayTemp2);
	}

	@Test
	public void testdelEnd_many() 
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =arrayList.delEnd();
		Integer arrayTempInteger= 8; 
		assertEquals(arrayTempInteger, arrayTemp2);
	}
	@Test
	public void testdelEnd_1_el() 
	{
		Integer [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =arrayList.delEnd();
		Integer arrayTempInteger= 1; 
		assertEquals(arrayTempInteger, arrayTemp2);
	}
	@Test
	public void testdelEnd_2_el() 
	{
		Integer [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =arrayList.delEnd();
		Integer arrayTempInteger= 2; 
		assertEquals(arrayTempInteger, arrayTemp2);
	}
	@Test(expected= IllegalArgumentException.class)
	public void testdelEnd_0_el() 
	{
		Integer [] arrayTemp = {};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =arrayList.delEnd();
		Integer arrayTempInteger= 0; 
		assertEquals(arrayTempInteger, arrayTemp2);
	}
	@Test
	public void testGet() 
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =arrayList.get(2);
		Integer arrayTempInteger= 2; 
		assertEquals(arrayTempInteger, arrayTemp2);
	}
	@Test
	public void testGet_1_pos() 
	{
		Integer [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =arrayList.get(1);
		Integer arrayTempInteger= 1; 
		assertEquals(arrayTempInteger, arrayTemp2);
	}
	@Test
	public void testGet_2_pos() 
	{
		Integer [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =arrayList.get(2);
		Integer arrayTempInteger= 2; 
		assertEquals(arrayTempInteger, arrayTemp2);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testGet_posit_eqal_m4() 
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.get(-4);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testGet_posit_eqal_40() 
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.get(40);
	}
	@Test
	public void testSet()
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		Integer [] arrayTemp2 ={1,5,3,4,5,6,7,8,9};
		arrayList.set(5,2);
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		for (Integer integer : arrayList) {
			arrayTemp3[i]=integer;
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSet_0_elem_inArray()
	{
		Integer [] arrayTemp = {0};
		arrayList.init(arrayTemp);
		arrayList.set(5,0);
	}
	@Test()
	public void testSet_1_elem_inArray()
	{
		Integer [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		Integer [] arrayTemp2 ={5};
		arrayList.set(5,1);
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		for (Integer integer : arrayList) {
			arrayTemp3[i]=integer;
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);	}
	@Test()
	public void testSet_2_elem_inArray()
	{
		Integer [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		Integer [] arrayTemp2 ={5,2};
		arrayList.set(5,1);
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		for (Integer integer : arrayList) {
			arrayTemp3[i]=integer;
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);	}
	@Test
	public void testSet_toEndPos()
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		Integer [] arrayTemp2 ={1,2,3,4,5,6,7,8,5};
		arrayList.set(5,9);
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		for (Integer integer : arrayList) {
			arrayTemp3[i]=integer;
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testSet_toStartPos()
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		Integer [] arrayTemp2 ={5,2,3,4,5,6,7,8,9};
		arrayList.set(5,1);
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		for (Integer integer : arrayList) {
			arrayTemp3[i]=integer;
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSet_toStartPos_m4()
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.set(5,-4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSet_toStartPos_40()
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.set(5,40);
	}
	@Test
	public void testMax()
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =9;
		Integer arrayTemp3=arrayList.max();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testMax_0_elem_inArray()
	{
		Integer [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.max();
	}
	@Test()
	public void testMax_1_elem_inArray()
	{
		Integer [] arrayTemp = {5};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =5;
		Integer arrayTemp3=arrayList.max();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test()
	public void testMax_2_elem_inArray()
	{
		Integer [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =2;
		Integer arrayTemp3=arrayList.max();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	///////////////////////////////////////////
	@Test
	public void testMin()
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =1;
		Integer arrayTemp3=arrayList.min();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testMin_0_elem_inArray()
	{
		Integer [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.min();
	}
	@Test()
	public void testMin_1_elem_inArray()
	{
		Integer [] arrayTemp = {5};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =5;
		Integer arrayTemp3=arrayList.min();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test()
	public void testMin_2_elem_inArray()
	{
		Integer [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =1;
		Integer arrayTemp3=arrayList.min();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testminPos()
	{
		Integer [] arrayTemp = {9,1,7,2,6,3,4};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =2;
		Integer arrayTemp3=arrayList.minPos();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testminPos_1_el()
	{
		Integer [] arrayTemp = {9};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =1;
		Integer arrayTemp3=arrayList.minPos();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testminPos_2_elem()
	{
		Integer [] arrayTemp = {9,1};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =2;
		Integer arrayTemp3=arrayList.minPos();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testminPos_ImptyArray()
	{
		Integer [] arrayTemp = {};
		arrayList.init(arrayTemp);
		Integer arrayTemp3=arrayList.minPos();
	}
	/////////////////////////
	@Test
	public void testmaxPos()
	{
		Integer [] arrayTemp = {9,1,7,2,6,3,4};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =1;
		Integer arrayTemp3=arrayList.maxPos();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testmaxPos_1_el()
	{
		Integer [] arrayTemp = {9};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =1;
		Integer arrayTemp3=arrayList.maxPos();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testmaxPos_2_elem()
	{
		Integer [] arrayTemp = {9,1};
		arrayList.init(arrayTemp);
		Integer arrayTemp2 =1;
		Integer arrayTemp3=arrayList.maxPos();
		assertEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testmaxPos_ImptyArray()
	{
		Integer [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.maxPos();
	}

	@Test
	public void testdelPos() 
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.delPos(4);
		Integer [] arrayTemp2 = {1,2,3,5,6,7,8,9};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		for (Integer integer : arrayList) {
			arrayTemp3[i]=integer;
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testdelPos_0_el() 
	{
		Integer [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.delPos(4);
	}
	@Test
	public void testdelPos_1_el() 
	{
		Integer [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.delPos(1);
		Integer [] arrayTemp2 = {};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		for (Integer integer : arrayList) {
			arrayTemp3[i]=integer;
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testdelPos_2_el() 
	{
		Integer [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.delPos(2);
		Integer [] arrayTemp2 = {1};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		for (Integer integer : arrayList) {
			arrayTemp3[i]=integer;
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testdelPos_m5() 
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.delPos(-5);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testdelPos_50() 
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.delPos(50);
	}

	///////////////////////////////////////

	@Test
	public void testaddPos() 
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.addPos(40,3);
		Integer [] arrayTemp2 = {1,2,40,3,4,5,6,7,8,9};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		for (Integer integer : arrayList) {
			arrayTemp3[i]=integer;
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddPos_0_el() 
	{
		Integer [] arrayTemp = {};
		arrayList.init(arrayTemp);
		arrayList.addPos(40,3);
	}
	@Test
	public void testaddPos_1_el() 
	{
		Integer [] arrayTemp = {1};
		arrayList.init(arrayTemp);
		arrayList.addPos(40,1);
		Integer [] arrayTemp2 = {40,1};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		for (Integer integer : arrayList) {
			arrayTemp3[i]=integer;
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test
	public void testaddPos_2_el() 
	{
		Integer [] arrayTemp = {1,2};
		arrayList.init(arrayTemp);
		arrayList.addPos(40,1);
		Integer [] arrayTemp2 = {40,1,2};
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		for (Integer integer : arrayList) {
			arrayTemp3[i]=integer;
			i++;
		}
		assertArrayEquals(arrayTemp2, arrayTemp3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddPos_m5() 
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.addPos(40,-5);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddPos_50() 
	{
		Integer [] arrayTemp = {1,2,3,4,5,6,7,8,9};
		arrayList.init(arrayTemp);
		arrayList.addPos(40,50);
	}
	///////////////////////////////////////////////////////
	@Test
	public void testSort()
	{
		Integer[] ini = { 1, 10, 2, 9, 3, 8, 4, 7, 5, 6 };
		Integer[] excp = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		arrayList.init(ini);
		arrayList.sort();
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		for (Integer integer : arrayList) {
			arrayTemp3[i]=integer;
			i++;
		}
		assertArrayEquals(excp, arrayTemp3);
	}
	@Test
	public void testSort_1_el()
	{
		Integer[] ini = { 9 };
		Integer[] excp = { 9 };
		arrayList.init(ini);
		arrayList.sort();
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		for (Integer integer : arrayList) {
			arrayTemp3[i]=integer;
			i++;
		}
		assertArrayEquals(excp, arrayTemp3);	

	}
	@Test
	public void testSort_2_el()
	{
		Integer[] ini = { 9, 2 };
		Integer[] excp = { 2, 9 };
		arrayList.init(ini);
		arrayList.sort();
		assertArrayEquals(excp, arrayList.toArray());

	}
	@Test
	public void testSort_Empty_array()
	{
		Integer[] ini = {};
		Integer[] excp = {};
		arrayList.init(ini);
		arrayList.sort();
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(excp, arrayTemp3);	
	}

	@Test(expected= IllegalArgumentException.class)
	public void testSort_E()
	{
		Integer[] ini = null;
		arrayList.init(ini);
		arrayList.sort();
	}

	@Test
	public void testhalfReverse_notEven()
	{
		Integer[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Integer[] expec = { 4, 3, 2, 1, 5, 9, 8, 7, 6 };
		arrayList.init(ini);
		arrayList.halfReverse();
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(expec, arrayTemp3);		}

	@Test
	public void testhalfReverse_Even()
	{
		Integer[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		Integer[] expec = { 4, 3, 2, 1, 0, 9, 8, 7, 6, 5 };
		arrayList.init(ini);
		arrayList.halfReverse();
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(expec, arrayTemp3);		}

	@Test
	public void testhalfReverse_1_el() 
	{
		Integer[] ini = { 9 };
		Integer[] expec = { 9 };
		arrayList.init(ini);
		arrayList.halfReverse();
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(expec, arrayTemp3);		}

	@Test
	public void testhalfReverse_2_el()
	{
		Integer[] ini = { 9,2};
		Integer[] expec = {2, 9 };
		arrayList.init(ini);
		arrayList.halfReverse();
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(expec, arrayTemp3);		}

	@Test
	public void testhalfReverse_0() 
	{
		Integer[] ini = {};
		arrayList.init(ini);
		arrayList.halfReverse();
	}

	@Test(expected= IllegalArgumentException.class)
	public void testhalfReverse_E() 
	{
		Integer[] ini = null;
		arrayList.init(ini);
		arrayList.halfReverse();
	}

	@Test
	public void testreverse_notEven() {
		Integer[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Integer[] expec = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		arrayList.init(ini);
		arrayList.reverse();
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(expec, arrayTemp3);		}

	@Test
	public void testreverse_Even()
	{
		Integer[] ini = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		Integer[] expec = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		arrayList.init(ini);
		arrayList.reverse();
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(expec, arrayTemp3);		}

	@Test
	public void testreverse_1() 
	{
		Integer[] ini = { 9 };
		Integer[] expec = { 9 };
		arrayList.init(ini);
		arrayList.reverse();
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(expec, arrayTemp3);		}

	@Test
	public void testreverse_2() 
	{
		Integer[] ini = { 9, 2 };
		Integer[] expec = { 2, 9 };
		arrayList.init(ini);
		arrayList.reverse();
		Integer [] arrayTemp3 = new Integer [arrayList.size()];
		int i =0;
		Iterator<Integer> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			arrayTemp3[i]=iter.next();
			i++;
		}
		assertArrayEquals(expec, arrayTemp3);	
	}

	@Test
	public void testreverse_0() 
	{
		Integer[] ini = {};
		arrayList.init(ini);
		arrayList.reverse();
	}

	@Test(expected= IllegalArgumentException.class)
	public void testreverse_E() 
	{
		Integer[] ini = null;
		arrayList.init(ini);
	}
}
