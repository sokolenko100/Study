package HW_5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CharandStringTest {

	private static final double DELTA = 1e-15;

	/// test Task_2.1

	@Test
	public void intToStringTest_123()
	{
	   String expected="123";
       String result = CharandString.intToString(123);
       assertEquals(expected ,result);
	}
	@Test
	public void intToStringTest_m123()
	{
		String expected="-123";
       String result = CharandString.intToString(-123);
       assertEquals(expected ,result);
	}
	@Test
	public void intToStringTest_0() {
	   String expected="0";
       String result = CharandString.intToString(0);
       assertEquals(expected ,result);
	}
	
	/////////
	
	
	/// test Task_2.2
	
	@Test
	public void doubleToStringTest() {
       String expected="23.123";
       String result = CharandString.doubleToString(23.123);
       assertEquals(expected ,result);
	}
	
     //////
	
	
	 //test Task_2.3
		@Test
		public void StringToIntTest_0() {
	       int expected=0;
	       int result = CharandString.StringToInt("0");
	       assertEquals(expected ,result,DELTA);
		}
		@Test
		public void StringToIntTest_m23() {
	       int expected=-23;
	       int result = CharandString.StringToInt("-23");
	       assertEquals(expected ,result,DELTA);
		}
		@Test
		public void StringToIntTest_23() {
			int expected=23;
			int result = CharandString.StringToInt("23");
	       assertEquals(expected ,result,DELTA);
		}

		@Test(expected = IllegalArgumentException.class)
		public void StringToIntTest_null_E() {
	     CharandString.StringToInt(null);
		}
		@Test(expected = IllegalArgumentException.class)
		public void StringToIntTest_Empty_E() {
	     CharandString.StringToInt("");
		}
		
		////////////////////////////////////////
	
	
	 //test Task_2.4
	@Test
	public void StringToDoubleTest_0() {
       double expected=0.0;
       double result = CharandString.StringToDouble("0.0");
       assertEquals(expected ,result,DELTA);
	}
	@Test
	public void StringToDoubleTest_m23_123() {
       double expected=-23.123;
       double result = CharandString.StringToDouble("-23.123");
       assertEquals(expected ,result,DELTA);
	}
	@Test
	public void StringToDoubleTest_23() {
       double expected=23.0;
       double result = CharandString.StringToDouble("23");
       assertEquals(expected ,result,DELTA);
	}
	@Test
	public void StringToDoubleTest_23_123() {
       double expected=23.123;
       double result = CharandString.StringToDouble("23.123");
       assertEquals(expected ,result,DELTA);
	}
	@Test(expected = IllegalArgumentException.class)
	public void StringToDoubleTest_null_E() {
     CharandString.StringToDouble(null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void StringToDoubleTest_Empty_E() {
     CharandString.StringToDouble("");
	}
	

	
	@Test
	public void testDisplay_asci_cod() {
   	  String s2 = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
       String result = CharandString.Display_asci_cod();
      assertEquals(s2 ,result);
	}
	
	
	////////////////////////////////////////
	
	
	
	@Test
	public void SearchWordMinTest() {
	   String word = "qwedwed.wqeqweq,regretge:fwefwefw;fewfwerf?fwefewf!sfdfdg-dwdw?";
       int result = CharandString.SearchWordMin(word);
       assertEquals(4 ,result);
	}
	@Test(expected = IllegalArgumentException.class)
	public void SearchWordMinTest_E() {
		String ini = null;
		CharandString.SearchWordMin(ini);
	}
	@Test(expected = IllegalArgumentException.class)
	public void SearchWordMinTest_E2() {
		String ini = "";
		CharandString.SearchWordMin(ini);
	}
	///---------ReplaseThreeWord_on_$_Test---------
	
	@Test
	public void ReplaseThreeWord_on_$_Test() {
	     String []  word = {"qwedwed","wqeqweq","regretge","fwefwefw","fewfwerf","fwefewf","sfdfdg","dwdw"};
	     String []  wordTest = {"qwed$","wqeq$","regre$","fwefw$","fewfw$","fwef$","sfd$","d$"};
	     CharandString.ReplaseThreeWord_on_$(word);
         assertArrayEquals(wordTest ,word);
	}
	@Test
	public void ReplaseThreeWord_on_$_Test_1() {
		 String []  ini = {"qwedwed"};
		 String []  expec = {"qwed$"};
		  CharandString.ReplaseThreeWord_on_$(ini);
		assertArrayEquals(expec, ini);
	}

	@Test
	public void ReplaseThreeWord_on_$_Test_2() {
		 String []  ini = {"qwedwed","wqeqweq"};
		 String []  expec = {"qwed$","wqeq$"};
		 CharandString.ReplaseThreeWord_on_$(ini);
	     assertArrayEquals(expec, ini);
	}

	@Test
	public void ReplaseThreeWord_on_$_Test_0() {
		String[] ini = {};
		String[] expec = {};
		CharandString.ReplaseThreeWord_on_$(ini);
		assertArrayEquals(expec, ini);
	}

	@Test(expected = IllegalArgumentException.class)
	public void ReplaseThreeWord_on_$_Test_E() {
		String[] ini = null;
		CharandString.ReplaseThreeWord_on_$(ini);
	}
	//////end ReplaseThreeWord_on_$_Test
	
	
	/// test Task_3
	@Test
	public void addSpaceThenMarksTest_0() {
		String ini ="qwedwed.wqeqweq,regretge:fwefwefw;fewfwerf?fwefewf!sfdfdg-dwdw";
		String expec ="qwedwed. wqeqweq, regretge: fwefwefw; fewfwerf? fwefewf! sfdfdg- dwdw";
		String result =	CharandString.addSpaceThenMarks(ini);
		assertEquals(expec, result);
	}
	@Test(expected = IllegalArgumentException.class)
	public void addSpaceThenMarksTest_E() {
		String ini = null;
		CharandString.addSpaceThenMarks(ini);
	}
	@Test
	public void addSpaceThenMarksTest_empty() {
		String ini = "";
		String expec = "";
		CharandString.addSpaceThenMarks(ini);
		assertEquals(expec, ini);
	}
	
	/// test Task_4
	@Test
	public void oneCharInStringTest() {
		String ini ="qwedwed.wqeqweq,regretge:fwefwefw;fewfwerf?fwefewf!sfdfdg-dwdw";
		String expec ="qwed.,rgt:f;?!s-";
		String result =	CharandString.oneCharInString(ini);
		assertEquals(expec, result);
	}
	@Test(expected = IllegalArgumentException.class)
	public void oneCharInString_E() {
		String ini = null;
		CharandString.oneCharInString(ini);
	}
	@Test
	public void oneCharInString_empty() {
		String ini = "";
		String expec = "";
		CharandString.oneCharInString(ini);
		assertEquals(expec, ini);
	}
	
	
	/// test Task_5
	
	@Test
	public void CountWordTest() {
		String ini ="qwedwed. wqeqweq, regretge: fwefwefw; fewfwerf? fwefewf! sfdfdg- dwdw efeg";
		int result =	CharandString.CountWord(ini);
		assertEquals(9, result);
	}
	@Test(expected = IllegalArgumentException.class)
	public void CountWord_E() {
		String ini = null;
		CharandString.CountWord(ini);
	}
	@Test()
	public void CountWord_empty() {
		String ini = "";
		String expec = "";
		CharandString.CountWord(ini);
		assertEquals(expec, ini);
	}
	
	/// test Task_6
	
	@Test
	public void ReplaceStringTest() {
		String ini ="qwedwed. wqeqweq, regretge: fwefwefw";
		String expec = "qwedwqeqweq, regretge: fwefwefw";
		String result =	CharandString.ReplaceString(5,5,ini);
		assertEquals(expec, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void ReplaceStringTest_empty() {
		String ini = "";
		CharandString.ReplaceString(5,5,ini);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ReplaceStringTest_E() {
		String ini = null;
		CharandString.ReplaceString(5,5,ini);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ReplaceStringTest_E2() {
		String ini ="qwedwed. wqeqweq, regretge: fwefwefw";
	    CharandString.ReplaceString(-45,-45,ini);
	}
	/// test Task_7
	@Test
	public void PolindromStringTestNotEvenString() {
		String ini ="Hello world";
		String expec = "dlrow olleH";
		String result =	CharandString.PolindromString(ini);
		assertEquals(expec, result);
	}
	@Test
	public void PolindromStringTestEvenString() {
		String ini ="Helloworld";
		String expec = "dlrowolleH";
		String result =	CharandString.PolindromString(ini);
		assertEquals(expec, result);
	}
	@Test(expected = IllegalArgumentException.class)
	public void PolindromStringTest_empty() {
		String ini = "";
		CharandString.PolindromString(ini);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void PolindromStringTest_E() {
		String ini = null;
		CharandString.PolindromString(ini);
	}
	
	/// test Task_8
		@Test
		public void DeleteLatWordTest() {
			String ini ="Hello world eadsfewafewa";
			String expec = "Hello world";
			String result =	CharandString.DeleteLatWord(ini);
			assertEquals(expec, result);
		}

		@Test(expected = IllegalArgumentException.class)
		public void DeleteLatWordTest_empty() {
			String ini = "";
			CharandString.DeleteLatWord(ini);
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void DeleteLatWordTest_E() {
			String ini = null;
			CharandString.DeleteLatWord(ini);
		}
	
	
	
	
	
}
