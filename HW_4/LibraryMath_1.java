package HW_5;

public class LibraryMath_1 {
	
	public static double theDistanceOfTheProjectileFlight_In_Rad(double aRad, int v0) 
	{ 
		if (v0<0) {
			throw new IllegalArgumentException();
		}
		double g = 9.81;
		double s = 0;
		
		// в  радианах
		  s= (Math.pow(v0, 2.0)*Math.sin(2*aRad))/g;
		  return s;
	}
	public static double theDistanceOfTheProjectileFlight_Degrees(double  Degrees, int v0) 
	{ 
		if (v0<0) {
			throw new IllegalArgumentException();
		}
		double g = 9.81;
		double Degrees_in_Rad = Math.toRadians(Degrees);
		double s = 0;

		  //в  градусах
		  s= (Math.pow(v0, 2.0)*Math.sin(2*Degrees_in_Rad))/g;
		  return s;
	}
	
	public static int S_betwenTwoCars(int first_V,int Secon_V,int s,int t) 
	{
		int result =0;
		if (first_V<0||Secon_V<0||t<0||s<0) {
			throw new IllegalArgumentException();
		}
		result =( first_V+Secon_V)*t+s;
		return result;
	}
	public static int setBooleanExpresion(Double x,Double y) 
	{
		int result = 0;
		if ((x >= 0) && (y >= 1.5 * x - 1) && (y <= x)|| (x <= 0) && (y >= -1.5 * x - 1) && (y <= -x))
		{
			result=1;
		}
		else {
			result=0;
		}
		return result;
	}
	public static double alculate_the_value_of_expression(double x) 
	{
		double result = 0;
		result=6* Math.log(Math.sqrt(Math.exp(x+1)+2*Math.exp(x)*Math.cos(x)))/Math.log(x-Math.exp(x+3)*Math.sin(x))+Math.abs(Math.cos(x)/Math.exp(Math.sin(x)));
		return result;
		
	}
}
