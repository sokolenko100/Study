package ua.reshetkov.fest.test;

import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.reshetkov.calculator.Calculator;

public class CalcTests {
    private Random random = new Random();
    private CalcClicker clicker = CalcClicker.INSTANCE;

    @BeforeClass
    public static void setUpOnce() throws Exception {
        Calculator.main(null);

    }

    @Before
    public void init() throws Exception {
        clicker.clear();
    }

    @Test
    public void testPlus() throws Exception {
    	int a = random.nextInt(500);
    	System.out.println("a = " + a) ;
    	int b = random.nextInt(500);
    	System.out.println("b = " + a) ;
        clicker.click(a);
        clicker.plus();
        clicker.click(b);
        clicker.result();
        clicker.checkIntValue(a + b);
    }

    @Test
    public void testMinus() throws Exception {
        int a = random.nextInt(5000);
        int b = random.nextInt(5000);
        clicker.click(a);
        clicker.minus();
        clicker.click(b);
        clicker.result();
        clicker.checkIntValue(a - b);
    }

    @Test
    public void testMultiply() throws Exception {
        int a = random.nextInt(5000);
        int b = random.nextInt(5000);
        clicker.click(a);
        clicker.multiply();
        clicker.click(b);
        clicker.result();
        clicker.checkIntValue(a * b);
    }

    @Test
    public void testDivide() throws Exception {
        int a = random.nextInt(5000);
        int b = random.nextInt(5000);
        clicker.click(a);
        clicker.divide();
        clicker.click(b);
        clicker.result();
        clicker.checkIntValue(a / b);
    }


}
