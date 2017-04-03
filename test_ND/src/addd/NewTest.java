package addd;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	@BeforeMethod
    public void setUp() throws Exception {
        System.out.println("@BeforeMethod");
    }
 
    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("@AfterMethod");
    }
 
    @BeforeGroups
    public void beforeGroups() throws Exception {
        System.out.println("BeforeGroups");
    }
 
    @AfterGroups
    public void afterGroups() throws Exception {
        System.out.println("@AfterGroups");
    }
 
    @BeforeClass
    public void beforeClass() throws Exception {
        System.out.println("@BeforeClass");
    }
 
    @BeforeTest
    public void beforeTest() throws Exception {
        System.out.println("@BeforeTest");
    }
 
    @AfterTest
    public void afterTest() throws Exception {
        System.out.println("@AfterTest");
    }
 
    @AfterClass
    public void afterClass() throws Exception {
        System.out.println("@AfterClass");
    }
 
    @BeforeSuite
    public void beforeSuite() throws Exception {
        System.out.println("@BeforeSuite");
    }
 
    @AfterSuite
    public void afterSuite() throws Exception {
        System.out.println("@AfterSuite");
    }
 
    @Test
    public void testSum() throws Exception {
        Assert.assertEquals(5,5);
        System.out.println("@Test");
    }
}
