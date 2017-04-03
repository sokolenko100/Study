package ball_test_repulsion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BallTest
{
	BMain main = new BMain();
	@Test
	public void  Y0_Xplus_test() 
	{
		
		Ball b1 = new Ball(10, 30,main.pp );
		Ball b2 = new Ball(100, 30,main.pp );

		b1.dx=-4;
		b1.dy=0;
		b2.dx=-4;
		b2.dy=0;
		for (int i = 0; i <12; i++) 
		{
			b1.move();
			b2.move();
		}
		assertEquals(35, b1.x,5);
		assertEquals(55, b2.x,5);
	}
	@Test
	public void  Y0_Xmin_test() 
	{
		
		Ball b1 = new Ball(500, 30,main.pp );
		Ball b2 = new Ball(540, 30,main.pp );

		b1.dx=4;
		b1.dy=0;
		b2.dx=4;
		b2.dy=0;
		for (int i = 0; i <12; i++) 
		{
			b1.move();
			b2.move();
		}
		assertEquals(35, b1.x,5);
		assertEquals(55, b2.x,5);
	}
}
