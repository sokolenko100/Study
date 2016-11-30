package HW_5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LibraryMathTest_1 {
	
	private static final double DELTA = 1e-15;
	@Test
	public void testTheDistanceOfTheProjectileFlight_In_Rad() {
		double  result = LibraryMath_1.theDistanceOfTheProjectileFlight_In_Rad(0.3, 20);
		assertEquals(23.023138568604907, result,DELTA);
	}

	@Test
	public void testTheDistanceOfTheProjectileFlight_In_Rad_eqal_0() {
		double  result = LibraryMath_1.theDistanceOfTheProjectileFlight_In_Rad(0, 20);
		assertEquals(0, result,DELTA);
	}
	
	@Test
	public void testTheDistanceOfTheProjectileFlight_In_Rad_V_eqal_0() {
		double  result = LibraryMath_1.theDistanceOfTheProjectileFlight_In_Rad(0.3, 0);
		assertEquals(0, result,DELTA);
	}
	@Test
	public void testTheDistanceOfTheProjectileFlight_In_Rad_eqal_m03() {
		double  result = LibraryMath_1.theDistanceOfTheProjectileFlight_In_Rad(-0.3, 0);
		assertEquals(-0, result,DELTA);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTheDistanceOfTheProjectileFlight_In_Rad_V_eqal_m4() {
		LibraryMath_1.theDistanceOfTheProjectileFlight_In_Rad(0.3, -4);
	}
	@Test
	public void testTheDistanceOfTheProjectileFlight_Degrees() {
		double  result = LibraryMath_1.theDistanceOfTheProjectileFlight_Degrees(17, 20);
		assertEquals(22.800933882599256, result,DELTA);
	}
	@Test
	public void testTheDistanceOfTheProjectileFlight_Degrees_eqal_0() {
		double  result = LibraryMath_1.theDistanceOfTheProjectileFlight_Degrees(0, 20);
		assertEquals(0, result,DELTA);
	}
	@Test
	public void testTheDistanceOfTheProjectileFlight_Degrees_eqal_90() {
		double  result = LibraryMath_1.theDistanceOfTheProjectileFlight_Degrees(180, 20);
		assertEquals(-9.986925986930504E-15, result,DELTA);
	}
	@Test
	public void testTheDistanceOfTheProjectileFlight_Degrees_eqal_270() {
		double  result = LibraryMath_1.theDistanceOfTheProjectileFlight_Degrees(270, 20);
		assertEquals(1.4980388980395758E-14, result,DELTA);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testTheDistanceOfTheProjectileFlight_Degrees_V_eqal_m4() {
	 LibraryMath_1.theDistanceOfTheProjectileFlight_Degrees(17, -4);

	}
	@Test
	public void testTheDistanceOfTheProjectileFlight_Degrees_() {
		double  result = LibraryMath_1.theDistanceOfTheProjectileFlight_Degrees(-17, 20);
		assertEquals(-22.800933882599256	, result,DELTA);
	}
	
//---------Second TaskTest---------
	@Test
	public void S_betwenTwoCarsTest_first() 
	{
	int result =	LibraryMath_1.S_betwenTwoCars(30, 40, 20, 3);
	assertEquals(230,result);
	}
	@Test
	public void S_betwenTwoCarsTest_V1_eq_0() 
	{
	int result =	LibraryMath_1.S_betwenTwoCars(0, 40, 20, 3);
	assertEquals(140,result);
	}
	@Test
	public void S_betwenTwoCarsTest_V2_eq_0() 
	{
	int result =	LibraryMath_1.S_betwenTwoCars(30, 0, 20, 3);
	assertEquals(110,result);
	}
	@Test
	public void S_betwenTwoCarsTest_S_eq_0() 
	{
	int result =	LibraryMath_1.S_betwenTwoCars(30, 40, 0, 3);
	assertEquals(210,result);
	}
	@Test
	public void S_betwenTwoCarsTest_t_eq_0() 
	{
	int result =	LibraryMath_1.S_betwenTwoCars(30, 40, 20, 0);
	assertEquals(20,result);
	}
	@Test(expected=IllegalArgumentException.class)
	public void S_betwenTwoCarsTest_V1_eq_m30() 
	{
	LibraryMath_1.S_betwenTwoCars(-30, 40, 20, 3);
	}
	@Test(expected=IllegalArgumentException.class)
	public void S_betwenTwoCarsTest_V2_eq_m40() 
	{
	LibraryMath_1.S_betwenTwoCars(30,-40, 20, 3);
	}
	@Test(expected=IllegalArgumentException.class)
	public void S_betwenTwoCarsTest_s_eq_m20() 
	{
	LibraryMath_1.S_betwenTwoCars(30, 40, -20, 3);
	}
	@Test(expected=IllegalArgumentException.class)
	public void S_betwenTwoCarsTest_t_eq_m3() 
	{
	LibraryMath_1.S_betwenTwoCars(-30, 40, 20, -3);
	}
	//----------Therd--------
	@Test
	public void testSetBooleanExpresion() 
	{
		int result = LibraryMath_1.setBooleanExpresion(0.3, 0.5);
		assertEquals(0,result);
	}
	@Test
	public void testSetBooleanExpresion_x_eqal_0() 
	{
		int result = LibraryMath_1.setBooleanExpresion(0.0, 0.5);
		assertEquals(0,result);
	}
	@Test
	public void testSetBooleanExpresion_y_eqal_0() 
	{
		int result = LibraryMath_1.setBooleanExpresion(0.3, 0.0);
		assertEquals(1,result);
	}
	@Test
	public void testSetBooleanExpresion_x_and_y_eqal_0() 
	{
		int result = LibraryMath_1.setBooleanExpresion(0.0, 0.0);
		assertEquals(1,result);
	}
	@Test
	public void testSetBooleanExpresion_x_eqal_m03() 
	{
		int result = LibraryMath_1.setBooleanExpresion(-0.3, 0.4);
		assertEquals(0,result);
	}
	@Test
	public void testSetBooleanExpresion_y_eqal_m04() 
	{
		int result = LibraryMath_1.setBooleanExpresion(0.3, -0.4);
		assertEquals(1,result);
	}
	@Test
	public void testAlculate_the_value_of_expression_x_eqal_1() 
	{
		double result = LibraryMath_1.alculate_the_value_of_expression(1);
		assertEquals(Double.NaN,result,DELTA);
	}
	@Test
	public void testAlculate_the_value_of_expression_x_eqal_0() 
	{
		double result = LibraryMath_1.alculate_the_value_of_expression(0);
		assertEquals(1,result,DELTA);
	}
	@Test
	public void testAlculate_the_value_of_expression_x_eqal_m04() 
	{
		double result = LibraryMath_1.alculate_the_value_of_expression(-0.4);
		assertEquals(3.4845738516112004,result,DELTA);
	}
}
