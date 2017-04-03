package test2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BallTest
{
	BFrame frame=new BFrame();

	@Test
	public void Yconst_Xplus_test() 
	{
		Ball b1 = new Ball(10, 30, frame.pPanelDraw, frame.pPanelDraw.pp);
		Ball b2 = new Ball(80, 30, frame.pPanelDraw, frame.pPanelDraw.pp);
		frame.pPanelDraw.pp.add(b1);
		frame.pPanelDraw.pp.add(b2);
		frame.pPanelDraw.add(b1);
		frame.pPanelDraw.add(b2);
		
		b1.dx=-6;
		b1.dy=0;
		b1.tempDX=b1.dx;
		b1.tempDY=b1.dy;
		
		b2.dx=-6;
		b2.dy=0;
		b2.tempDX=b2.dx;
		b2.tempDY=b2.dy;
		
		for (int i = 0; i <30; i++) 
		{
			b1.move();
			b2.move();
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		assertEquals(25, b1.x,5);
		assertEquals(75, b2.x,5);
		frame.pPanelDraw.pp.remove(b1);
		frame.pPanelDraw.pp.remove(b2);
	}
	@Test
	public void Yconst_Xmin_test() 
	{
		Ball b1 = new Ball(600, 30, frame.pPanelDraw, frame.pPanelDraw.pp);
		Ball b2 = new Ball(670, 30, frame.pPanelDraw, frame.pPanelDraw.pp);
		frame.pPanelDraw.pp.add(b1);
		frame.pPanelDraw.pp.add(b2);
		frame.pPanelDraw.add(b1);
		frame.pPanelDraw.add(b2);
		
		b1.dx=4;
		b1.dy=0;
		b2.dx=4;
		b2.dy=0;
		for (int i = 0; i <10; i++) 
		{
			b1.move();
			b2.move();
		}
		assertEquals(615, b1.x,15);
		assertEquals(680, b2.x,15);
		frame.pPanelDraw.pp.remove(b1);
		frame.pPanelDraw.pp.remove(b2);
	}
	@Test
	public void Yplus_Xconst_test() 
	{

		Ball b1 = new Ball(60, 30, frame.pPanelDraw, frame.pPanelDraw.pp);
		Ball b2 = new Ball(60, 30, frame.pPanelDraw, frame.pPanelDraw.pp);
		frame.pPanelDraw.pp.add(b1);
		frame.pPanelDraw.pp.add(b2);
		frame.pPanelDraw.add(b1);
		frame.pPanelDraw.add(b2);
		
		b1.dx=0;
		b1.dy=-4;
		b2.dx=0;
		b2.dy=4;
		for (int i = 0; i <12; i++) 
		{
			b1.move();
			b2.move();
		}
		assertEquals(500, b1.x,15);
		assertEquals(560, b2.x,15);
		frame.pPanelDraw.pp.remove(b1);
		frame.pPanelDraw.pp.remove(b2);
	}
	@Test
	public void Yminus_Xconst_test() 
	{
		Ball b1 = new Ball(60, 20, frame.pPanelDraw, frame.pPanelDraw.pp);
		Ball b2 = new Ball(60, 70, frame.pPanelDraw, frame.pPanelDraw.pp);
		frame.pPanelDraw.pp.add(b1);
		frame.pPanelDraw.pp.add(b2);
		frame.pPanelDraw.add(b1);
		frame.pPanelDraw.add(b2);
		
		b1.dx=0;
		b1.dy=-4;
		b2.dx=0;
		b2.dy=-4;
		for (int i = 0; i <20; i++) 
		{
			b1.move();
			b2.move();
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		assertEquals(45, b1.y,5);
		assertEquals(106, b2.y,5);
		frame.pPanelDraw.pp.remove(b1);
		frame.pPanelDraw.pp.remove(b2);
	}
}
