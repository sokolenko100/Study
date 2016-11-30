package WebTestCalc_on_js;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class first_calc_on_js {

	static WebDriver driver = null;

	@Before
	public void SetUp() {
		driver.navigate().refresh();
	}

	@BeforeClass
	public static void start() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Eclips/workspace/HW_4/bin/WebTestCalc_on_js/Calculator/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("file:///C:/Eclips/workspace/HW_4/bin/WebTestCalc_on_js/Calculator/calc.html");
	}

	/*
	 * @Test public void test_isfirstTextbox() {
	 * 
	 * Boolean result = false; try { driver.findElement(By.id("firstNumb"));
	 * result = true; } catch (NoSuchElementException e) { result = false; }
	 * assertEquals(true, result); // driver.quit(); }
	 * 
	 * @Test public void test_isSecondTextbox() {
	 * 
	 * 
	 * driver.findElement(By.id("charOperation"));
	 * 
	 * assertEquals( ); }
	 * 
	 * @Test public void test_isTherdTextbox() {
	 * 
	 * Boolean resalt = false;
	 * 
	 * try { driver.findElement(By.id("secondNumb")); resalt = true; } catch
	 * (NoSuchElementException e) { resalt = false; } assertEquals(true,
	 * resalt); // driver.quit(); }
	 * 
	 * @Test public void test_isTextbox() {
	 * 
	 * Boolean resalt = false;
	 * 
	 * try { driver.findElement(By.id("resultCulc")); resalt = true; } catch
	 * (NoSuchElementException e) { resalt = false; } assertEquals(true,
	 * resalt); // driver.quit(); }
	 * 
	 * @Test public void test_isButton() {
	 * 
	 * Boolean resalt = false;
	 * 
	 * try { driver.findElement(By.id("button")); resalt = true; } catch
	 * (NoSuchElementException e) { resalt = false; } assertEquals(true,
	 * resalt); // driver.quit(); }
	 * 
	 * // ------
	 * 
	 * @Test public void testBtnResultClick() {
	 * 
	 * driver.findElement(By.id("button")).click(); String str =
	 * driver.findElement(By.id("firstNumb")).getAttribute( "value");
	 * assertEquals("2", str); // driver.quit(); }
	 * 
	 * @Test public void testFirstTextBox() {
	 * 
	 * WebElement element = driver.findElement(By.id("firstNumb"));
	 * element.sendKeys("f");
	 * 
	 * String str = driver.findElement(By.id("firstNumb")).getAttribute(
	 * "value"); assertEquals("f", str); // driver.quit(); }
	 * 
	 * @Test public void testSecondTextBox() {
	 * 
	 * WebElement element = driver.findElement(By.id("firstNumb"));
	 * element.sendKeys("1");
	 * 
	 * String str = driver.findElement(By.id("firstNumb")).getAttribute(
	 * "value"); assertEquals("1", str); // driver.quit(); }
	 * 
	 * @Test public void testTherdTextBox() {
	 * 
	 * WebElement element = driver.findElement(By.id("firstNumb"));
	 * element.sendKeys("2");
	 * 
	 * String str = driver.findElement(By.id("firstNumb")).getAttribute(
	 * "value"); assertEquals("2", str); // driver.quit(); }
	 * 
	 * @Test public void testFourthTextBox() {
	 * 
	 * WebElement element = driver.findElement(By.id("firstNumb"));
	 * element.sendKeys("e");
	 * 
	 * String str = driver.findElement(By.id("firstNumb")).getAttribute(
	 * "value"); assertEquals("e", str); exit(); }
	 */

	@AfterClass
	public static void exit() {
		driver.quit();
	}

	// /Real Job
	@Test
	public void testPlus() {
		start();
		driver.findElement(By.id("firstNumb")).sendKeys("7");
		driver.findElement(By.id("charOperation")).sendKeys("+");
		driver.findElement(By.id("secondNumb")).sendKeys("7");
		driver.findElement(By.id("button")).click();
		String str = driver.findElement(By.id("resultCulc")).getAttribute(
				"value");
		assertEquals("14", str);
	}

	@Test
	public void testMinus() {
		driver.findElement(By.id("firstNumb")).sendKeys("7");
		driver.findElement(By.id("charOperation")).sendKeys("-");
		driver.findElement(By.id("secondNumb")).sendKeys("7");
		driver.findElement(By.id("button")).click();
		String str = driver.findElement(By.id("resultCulc")).getAttribute(
				"value");
		assertEquals("0", str);
	}

	@Test
	public void testDiv() {
		driver.findElement(By.id("firstNumb")).sendKeys("7");
		driver.findElement(By.id("charOperation")).sendKeys("/");
		driver.findElement(By.id("secondNumb")).sendKeys("7");
		driver.findElement(By.id("button")).click();
		String str = driver.findElement(By.id("resultCulc")).getAttribute(
				"value");
		assertEquals("1", str);
	}

	@Test
	public void testMult() {
		driver.findElement(By.id("firstNumb")).sendKeys("7");
		driver.findElement(By.id("charOperation")).sendKeys("*");
		driver.findElement(By.id("secondNumb")).sendKeys("7");
		driver.findElement(By.id("button")).click();
		String str = driver.findElement(By.id("resultCulc")).getAttribute(
				"value");
		assertEquals("49", str);
		exit();
	}

}
