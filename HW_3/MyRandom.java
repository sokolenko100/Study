package HW_5;
import java.util.Random;
public class MyRandom {

	public static void main(String[] args) 
	{
		// randomNumber();
	 //	random_10_Numbers();
	 //	random_from0_to10_Numbers();
     //	random_from20_to50_Numbers();
		// random_from_m10_to10_Numbers();
	//	random_Task_6();
	}
	private static void randomNumber()
	{
	Random ran = new Random();
	int tempNumb = ran.nextInt(100);
	System.out.println("случайное число = "+tempNumb);
	}
	
	private static void random_10_Numbers() 
	{
	Random ran = new Random();
	for (int i = 0; i < 10; i++)
	{
		int tempNumb = ran.nextInt(100);
		System.out.println("случайное число = "+tempNumb);
	}
	}
	private static void random_from0_to10_Numbers()
	{
		Random ran = new Random(100);
		for (int i = 0; i < 10; i++) 
		{
			int tempNumb = ran.nextInt(10);
			System.out.println("случайное число = "+tempNumb);
		}
    }
	private static void random_from20_to50_Numbers()
	{
		Random ran = new Random();
		int min =20;
		int max = 50;
		for (int i = 0; i < 10; i++) 
		{
			int tempNumb = min + ran.nextInt(max - min + 1); 
			System.out.println("случайное число = "+tempNumb);
		}
    }
	private static void random_from_m10_to10_Numbers()
	{
		Random ran = new Random();
		int min =-10;
		int max = 10;
		for (int i = 0; i < 10; i++) 
		{
			int tempNumb = min + ran.nextInt(max - min + 1); 
			System.out.println("случайное число = "+tempNumb);
		}
    }
	
	private static void random_Task_6()
	{
		Random ran = new Random();
		int min_iterat=3;
		int max_iterat=15;
		int iterat = min_iterat + ran.nextInt(max_iterat - min_iterat + 1); 
		int min =-10;
		int max = 35;
		for (int i =0; i< iterat; i++) 
		{
			int tempNumb = min + ran.nextInt(max - min + 1); 
			System.out.println("случайное число = "+tempNumb);
		}
    }
}
