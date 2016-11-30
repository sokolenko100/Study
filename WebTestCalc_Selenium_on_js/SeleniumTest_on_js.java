package WebTestCalc_on_js;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest_on_js {

	// ------------existing test------------
	
	static WebDriver driver= null;
	@Before
	public void SetUp()
	{
		driver.navigate().refresh();
	}
	@AfterClass
	public static void exit() 
	{
		driver.quit();
	}
	@BeforeClass
	public static void start()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:/Eclips/workspace/HW_4/Calculator_HW_Relize/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("file:///C:/Eclips/workspace/HW_4/Calculator_HW_Relize/calcul_HW_2.html");
	}
	@Test
	public void test_isTextbox() 
	{
	      start();
		  WebElement e = driver.findElement(By.id("expression")); 
		  assertTrue(e!=null);
	}

	@Test
	public void test_is_btn0() 
	{
	 WebElement e = driver.findElement(By.id("btn0")); 
	 assertTrue(e!=null);
	}

	@Test
	public void test_is_btn1() {
		 WebElement e = driver.findElement(By.id("btn1")); 
		 assertTrue(e!=null);
	}

	@Test
	public void test_is_btn2() {
		 WebElement e = driver.findElement(By.id("btn2")); 
		 assertTrue(e!=null);
	}

	@Test
	public void test_is_btn3() {
		 WebElement e = driver.findElement(By.id("btn3")); 
		 assertTrue(e!=null);
	}

	@Test
	public void test_is_btn4() {
		 WebElement e = driver.findElement(By.id("btn4")); 
		 assertTrue(e!=null);
	}

	@Test
	public void test_is_btn5() {
		 WebElement e = driver.findElement(By.id("btn5")); 
		 assertTrue(e!=null);
	}

	@Test
	public void test_is_btn6() {
		 WebElement e = driver.findElement(By.id("btn6")); 
		 assertTrue(e!=null);
	}

	@Test
	public void test_is_btn7() {
		 WebElement e = driver.findElement(By.id("btn7")); 
		 assertTrue(e!=null);
	}

	@Test
	public void test_is_btn8() {
		 WebElement e = driver.findElement(By.id("btn8")); 
		 assertTrue(e!=null);
	}

	@Test
	public void test_is_btn9() {
		 WebElement e = driver.findElement(By.id("btn9")); 
		 assertTrue(e!=null);
	}

	@Test
	public void test_is_btnPlus() {
		 WebElement e = driver.findElement(By.id("btnPlus")); 
		 assertTrue(e!=null);
	}

	@Test
	public void test_is_btnMinus() {

		 WebElement e = driver.findElement(By.id("btnMinus")); 
		 assertTrue(e!=null);
	}

	@Test
	public void test_is_btnMult() {
		 WebElement e = driver.findElement(By.id("btnMult")); 
		 assertTrue(e!=null);
	}

	@Test
	public void test_is_btnDiv() {

		 WebElement e = driver.findElement(By.id("btnDiv")); 
		 assertTrue(e!=null);
	}

	@Test
	public void test_is_btnEq() {
		 WebElement e = driver.findElement(By.id("btnEq")); 
		 assertTrue(e!=null);
	}

	// ------------Simple test------------

	@Test
	public void testBtn0Click() {
		driver.findElement(By.id("btn0")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("0", str);
	}

	@Test
	public void testBtn_1_click() {
		driver.findElement(By.id("btn1")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("1", str);
	}

	@Test
	public void testBtn_2_click() {
		driver.findElement(By.id("btn2")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("2", str);
	}

	@Test
	public void testBtn_3_click() {
		driver.findElement(By.id("btn3")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("3", str);
	}

	@Test
	public void testBtn_4_click() {
		driver.findElement(By.id("btn4")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("4", str);
	}

	@Test
	public void testBtn_5_click() {
		driver.findElement(By.id("btn5")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("5", str);
	}

	@Test
	public void testBtn_6_click() {
		driver.findElement(By.id("btn6")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("6", str);
	}

	@Test
	public void testBtn_7_click() {
		driver.findElement(By.id("btn7")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("7", str);
	}

	@Test
	public void testBtn_8_click() {
		driver.findElement(By.id("btn8")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("8", str);
	}

	@Test
	public void testBtn_9_click() {
		driver.findElement(By.id("btn9")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("9", str);
	}

	@Test
	public void testBtn_Minus_click() {
		driver.findElement(By.id("btnMinus")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("-", str);
	}

	@Test
	public void testBtn_Mult_click() {
		driver.findElement(By.id("btnMult")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("*", str);
		exit();
	}

	@Test
	public void testBtn_Div_click() {
		driver.findElement(By.id("btnDiv")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("/", str);
	}

	@Test
	public void testBtn_Plus_click() {
		driver.findElement(By.id("btnPlus")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("+", str);
	}

	@Test
	public void testBtn_Equals_click() 
	{
		driver.findElement(By.id("btnEq")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("=", str);
	}

	// ------------Complex test------------
	@Test
	public void testBtn_0123456789_click() {
		driver.findElement(By.id("btn0")).click();
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("btn3")).click();
		driver.findElement(By.id("btn4")).click();
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btn6")).click();
		driver.findElement(By.id("btn7")).click();
		driver.findElement(By.id("btn8")).click();
		driver.findElement(By.id("btn9")).click();

		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("0123456789", str);
	}

	// ------------Real job------------
	@Test
	public void testPlus() {
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btnPlus")).click();
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btnEq")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("10", str);
	}

	@Test
	public void testMinus() {
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btnMinus")).click();
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btnEq")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("0", str);
	}

	@Test
	public void testMult() {
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btnMult")).click();
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btnEq")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("25", str);
	}

	@Test
	public void testDiv() {
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btnDiv")).click();
		driver.findElement(By.id("btn5")).click();
		driver.findElement(By.id("btnEq")).click();
		String str = driver.findElement(By.id("expression")).getAttribute(
				"value");
		assertEquals("1", str);
	}
}
