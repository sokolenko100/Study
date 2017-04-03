package LBTree;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

import org.testng.annotations.Test;

public class LBtreeTest 
{
	LBTree tree = new LBTree();
	
	@Test
	public  void testSize_null() 
	{
		int[] inArray = null;
		int ex = 0;
		tree.init(inArray);
		assertEquals(ex, tree.size());
	}

	@Test
	public  void testSize_0() 
	{
		int[] inArray = {};
		int ex = 0;
		tree.init(inArray);
		assertEquals(ex, tree.size());
	}

	@Test
	public  void testSize_1()
	{
		int[] inArray = { 3 };
		int ex = 1;
		tree.init(inArray);
		assertEquals(ex, tree.size());
	}

	@Test
	public  void testSize_2() 
	{
		int[] inArray = { 4, 3 };
		int ex = 2;
		tree.init(inArray);
		assertEquals(ex, tree.size());
	}

	@Test
	public  void testSize_Many() 
	{
		int[] inArray = { 5, 7, 4, 3, 8 };
		int ex = 5;
		tree.init(inArray);
		assertEquals(ex, tree.size());
	}

	@Test
	public  void testAdd_0() 
	{
		int[] inArray = {};
		int val = 4;
		int[] ex = { 4 };
		tree.init(inArray);
		tree.add(val);
		assertArrayEquals(ex, tree.toArray());
	}

	@Test
	public  void testAdd_1()
	{
		int[] inArray = { 4 };
		int val = 6;
		int[] ex = { 4, 6 };
		tree.init(inArray);
		tree.add(val);
		assertArrayEquals(ex, tree.toArray());
	}

	@Test
	public  void testAdd_2()
	{
		int[] inArray = { 5, 3 };
		int val = 4;
		int[] ex = { 3, 4, 5 };
		tree.init(inArray);
		tree.add(val);
		assertArrayEquals(ex, tree.toArray());
	}

	@Test
	public  void testAdd_Many()
	{
		int[] inArray = { 3, 7, 12, 9, 2 };
		int val = 4;
		int[] ex = { 2, 3, 4, 7, 9, 12 };
		tree.init(inArray);
		tree.add(val);
		assertArrayEquals(ex, tree.toArray());
	}

	@Test
	public  void testInit_Null()
	{
		int[] inArray = null;
		int[] ex = {};
		tree.init(inArray);
		assertArrayEquals(ex, tree.toArray());
	}

	@Test
	public  void testInit_0()
	{
		int[] inArray = {};
		int[] ex = {};
		tree.init(inArray);
		assertArrayEquals(ex, tree.toArray());
	}

	@Test
	public  void testInit_1() 
	{
		int[] inArray = { 5 };
		int[] ex = { 5 };
		tree.init(inArray);
		assertArrayEquals(ex, tree.toArray());
	}

	@Test
	public  void testInit_2()
	{
		int[] inArray = { 4, 3 };
		int[] ex = { 3, 4 };
		tree.init(inArray);
		assertArrayEquals(ex, tree.toArray());
	}

	@Test
	public  void testInit_Many() 
	{
		int[] inArray = { 5, 8, 3, 9, 15 };
		int[] ex = { 3, 5, 8, 9, 15 };
		tree.init(inArray);
		assertArrayEquals(ex, tree.toArray());
	}

	@Test
	public  void testToArray_Null()
	{
		int[] inArray = null;
		int[] ex = {};
		tree.init(inArray);
		assertArrayEquals(ex, tree.toArray());
	}

	@Test
	public  void testToArray_0() 
	{
		int[] inArray = {};
		int[] ex = {};
		tree.init(inArray);
		assertArrayEquals(ex, tree.toArray());
	}

	@Test
	public  void testToArray_1() 
	{
		int[] inArray = { 5 };
		int[] ex = { 5 };
		tree.init(inArray);
		assertArrayEquals(ex, tree.toArray());
	}

	@Test
	public  void testToArray_2()
	{
		int[] inArray = { 4, 3 };
		int[] ex = { 3, 4 };
		tree.init(inArray);
		assertArrayEquals(ex, tree.toArray());
	}
	@Test
	public  void testToArray_Many() 
	{
		int[] inArray = { 5, 8, 3, 9, 15 };
		int[] ex = { 3, 5, 8, 9, 15 };
		tree.init(inArray);
		assertArrayEquals(ex, tree.toArray());
	}

	@Test
	public  void testToString_Null() 
	{
		int[] inArray = null;
		String ex = "";
		tree.init(inArray);
		assertEquals(ex, tree.toString());
	}

	@Test
	public  void testToString_0() 
	{
		int[] inArray = {};
		String ex = "";
		tree.init(inArray);
		assertEquals(ex, tree.toString());
	}

	@Test
	public  void testToString_1()
	{
		int[] inArray = { 5 };
		String ex = "5";
		tree.init(inArray);
		assertEquals(ex, tree.toString());
	}

	@Test
	public  void testToString_2()
	{
		int[] inArray = { 5, 6 };
		String ex = "5, 6";
		tree.init(inArray);
		String result = tree.toString();
		assertEquals(ex, result);
	}

	@Test
	public  void testToString_Many() 
	{
		int[] inArray = { 5, 8, 3, 9, 15 };
		String ex = "3, 5, 8, 9, 15";
		tree.init(inArray);
		assertEquals(ex, tree.toString());
	}

	@Test
	public  void testCountLeafs_Null() 
	{
		int[] inArray = null;
		tree.init(inArray);
		assertEquals(0, tree.leaves());
	}

	@Test
	public  void testCountLeafs_0() 
	{
		int[] inArray = {};
		tree.init(inArray);
		assertEquals(0, tree.leaves());
	}

	@Test
	public  void testCountLeafs_1() 
	{
		int[] inArray = { 5 };
		tree.init(inArray);
		assertEquals(1, tree.leaves());
	}

	@Test
	public  void testCountLeafs_2l()
	{
		int[] inArray = { 5, 1 };
		tree.init(inArray);
		assertEquals(1, tree.leaves());
	}

	@Test
	public  void testCountLeavs_2r() {
		int[] inArray = { 1, 5 };
		tree.init(inArray);
		assertEquals(1, tree.leaves());
	}

	@Test
	public  void testCountLeavs_Many() {
		int[] inArray = { 10, 5, 15, 22, 1, 6 };
		tree.init(inArray);
		assertEquals(3, tree.leaves());
	}
	
	@Test
	public final void testCountNodes_Null() {
		int[] inArray = null;
		tree.init(inArray);
		assertEquals(0, tree.nodes());
	}

	@Test
	public final void testCountNodes_0() {
		int[] inArray = {};
		tree.init(inArray);
		assertEquals(0, tree.nodes());
	}

	@Test
	public final void testCountNodes_1() {
		int[] inArray = { 5 };
		tree.init(inArray);
		assertEquals(0, tree.nodes());
	}

	@Test
	public final void testCountNodes_2l() {
		int[] inArray = { 5, 1 };
		tree.init(inArray);
		assertEquals(1, tree.nodes());
	}

	@Test
	public final void testCountNodes_2r() {
		int[] inArray = { 1, 5 };
		tree.init(inArray);
		assertEquals(1, tree.nodes());
	}

	@Test
	public final void testCountNodes_Many() {
		int[] inArray = { 10, 5, 15, 22, 1, 6, 4 };
		tree.init(inArray);
		assertEquals(4, tree.nodes());
	}

	@Test
	public final void testWidth_Null() {
		int[] inArray = null;
		tree.init(inArray);
		assertEquals(0, tree.width());
	}

	@Test
	public final void testWidth_0() {
		int[] inArray = {};
		tree.init(inArray);
		assertEquals(0, tree.width());
	}

	@Test
	public final void testWidth_1() {
		int[] inArray = { 4 };
		tree.init(inArray);
		assertEquals(1, tree.width());
	}

	@Test
	public final void testWidth_2() {
		int[] inArray = { 4, 7 };
		tree.init(inArray);
		assertEquals(1, tree.width());
	}

	@Test
	public final void testWidth_many() {
		int[] inArray = { 10, 5, 15, 22, 1, 6, 4 };
		tree.init(inArray);
		assertEquals(3, tree.width());
	}

	@Test
	public final void testHeigth_Null() {
		int[] inArray = null;
		tree.init(inArray);
		assertEquals(0, tree.height());
	}

	@Test
	public final void testHeigth_0() {
		int[] inArray = {};
		tree.init(inArray);
		assertEquals(0, tree.height());
	}

	@Test
	public final void testHeigth_1() {
		int[] inArray = { 4 };
		tree.init(inArray);
		assertEquals(1, tree.height());
	}

	@Test
	public final void testHeigth_2() {
		int[] inArray = { 4, 7 };
		tree.init(inArray);
		assertEquals(2, tree.height());
	}

	@Test
	public final void testHeigth_many() {
		int[] inArray = { 10, 5, 15, 22, 1, 6, 4 };
		tree.init(inArray);
		assertEquals(4, tree.height());
	}
	////////////////////////////////////////////////////////
	// Test del 
	////////////////////////////////////////////////////////

	@Test
	public void test_del_empty() 
	{
		int[] ini = {};
		tree.init(ini);
		tree.del(50);
		int [] act = tree.toArray();
		int [] exp = {};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_root() 
	{
		int[] ini = {20};
		tree.init(ini);
		tree.del(20);
		int [] act = tree.toArray();
		int [] exp = {};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_root_1R() 
	{
		int[] ini = {20,77};
		tree.init(ini);
		tree.del(20);
		int [] act = tree.toArray();
		int [] exp = {77};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_root_1L() 
	{
		int[] ini = {20,10};
		tree.init(ini);
		tree.del(20);
		int [] act = tree.toArray();
		int [] exp = {10};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_root_1L_1R() 
	{
		int[] ini = {20,10,77};
		tree.init(ini);
		tree.del(20);
		int [] act = tree.toArray();
		int [] exp = {10,77};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_root_nullL_manyR() 
	{
		int[] ini = {1,3,2,6,5,8,7};
		tree.init(ini);
		tree.del(1);
		int [] act = tree.toArray();
		int [] exp = {2,3,5,6,7,8};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_root_nullR_manyl() 
	{
		int[] ini = {8,3,2,6,5,1,7};
		tree.init(ini);
		tree.del(8);
		int [] act = tree.toArray();
		int [] exp = {1,2,3,5,6,7};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_root_manyR_manyl_not_Rnode() 
	{
		int[] ini = {30,20,40,50,45,15,10,5,18,17};
		tree.init(ini);
		tree.del(30);
		int [] act = tree.toArray();
		int [] exp = {5, 10, 15, 17, 18, 20, 40, 45, 50};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_root_isR_node_is_Chaild() 
	{
		int[] ini = {30,20,40,50,45,15,10,25,5,28,26,18,17};
		tree.init(ini);
		tree.del(30);
		int [] act = tree.toArray();
		int [] exp = { 5, 10, 15, 17, 18, 20, 25, 26, 28, 40, 45, 50};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_root_isR_not_Chaild() 
	{
		int[] ini = {30,20,40,50,45,15,10,25,5,28,18,17};
		tree.init(ini);
		tree.del(30);
		int [] act = tree.toArray();
		int [] exp = { 5, 10, 15, 17, 18, 20, 25, 28, 40, 45, 50};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_L_nullL_end_1R_end() 
	{
		int[] ini = {30,20,40,50,45,15,18,};
		tree.init(ini);
		tree.del(15);
		int [] act = tree.toArray();
		int [] exp = {18,20,30,40,45,50};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_L_nullR_end_1L_end() 
	{
		int[] ini = {30,20,40,50,45,15,10,};
		tree.init(ini);
		tree.del(15);
		int [] act = tree.toArray();
		int [] exp = {10,20,30,40,45,50};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_L_nullR_end_nullL_end() 
	{
		int[] ini = {30,20,40,50,45,15,10};
		tree.init(ini);
		tree.del(10);
		int [] act = tree.toArray();
		int [] exp = {15,20,30,40,45,50};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_R_nullR_end_nullL_end() 
	{
		int[] ini = {30,20,40,50,45,15,10,5};
		tree.init(ini);
		tree.del(5);
		int [] act = tree.toArray();
		int [] exp = {10,15,20,30,40,45,50};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_isR_not_Chaild() 
	{
		int[] ini = {30,20,40,50,45,15,10,25,5,26,18};
		tree.init(ini);
		tree.del(20);
		int [] act = tree.toArray();
		int [] exp = {5, 10, 15, 18, 25, 26, 30, 40, 45, 50};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_isR_is_Chaild() 
	{
		int[] ini = {30,20,40,50,45,15,10,25,5,26,18,17};
		tree.init(ini);
		tree.del(20);
		int [] act = tree.toArray();
		int [] exp = {5, 10, 15, 17, 18, 25, 26, 30, 40, 45, 50};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_40_isR_not_Chaild() 
	{
		int[] ini = {30,20,40,50,45,15,10,25,5,28,18,17,35,37,36,39};
		tree.init(ini);
		tree.del(40);
		int [] act = tree.toArray();
		int [] exp = { 5, 10, 15, 17, 18, 20, 25, 28, 30, 35, 36, 37, 39, 45, 50};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_40_isR_is_Chaild() 
	{
		int[] ini = {30,20,40,50,45,15,10,25,5,28,18,17,35,37,36,39,38};
		tree.init(ini);
		tree.del(40);
		int [] act = tree.toArray();
		int [] exp = { 5, 10, 15, 17, 18, 20, 25, 28, 30, 35, 36, 37, 38, 39, 45, 50};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_many1() 
	{
		int[] ini = {50,25,40,20,11,24,30,75,100,60,45,22,43,77};
		tree.init(ini);
		tree.del(50);
		int [] act = tree.toArray();
		int [] exp = {11,20,22,24,25,30,40,43,45,60,75,77,100};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_many2() 
	{
		int[] ini = {10,20,77,11,100,24,82};
		tree.init(ini);
		tree.del(100);
		int [] act = tree.toArray();
		int [] exp = {10, 11, 20, 24, 77, 82};
		assertArrayEquals(exp, act);
	}
}
