package ball_repulsion;

import java.util.ArrayList;

public class CheckBall  extends Thread
{
	ArrayList<Ball> balls= null;

	public CheckBall(ArrayList<Ball> balls)
	{
		this.balls =balls;
		this.start();
	}

	@Override
	public void run()
	{
		while(true)
		{
			Check();
			try
			{
				Thread.sleep(10);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	public  void Check()
	{
		if(balls.size()>1)
		{
			for (Ball b : balls)
			{
				for (Ball b2 : balls)
				{
					if( b != b2)
					{
						if(Ball.checkBall(b,b2))
						{
							if(b.flag&&b2.flag)
							{
								if(b.dx>=0)
								{
									b.dx = b.tempDX;
								}
								else if(b.dx<0)
								{
									b.dx =-b.tempDX;
								}
								if(b.dy>=0)
								{
									b.dy = b.tempDY;
								}
								else if(b.dy<0)
								{
									b.dy = - b.tempDY;
								}


								if(b2.dx>=0)
								{
									b2.dx =b2.tempDX;
								}
								else if(b2.dx<0)
								{
									b2.dx =-b2.tempDX;
								}
								if(b2.dy>=0)
								{
									b2.dy = b2.tempDY;
								}
								else if(b2.dy<0)
								{
									b2.dy = - b2.tempDY;
								}

								b.dx= - b.dx;
								b.dy= - b.dy;
								
								b2.dx= - b2.dx;
								b2.dy= - b2.dy;
								
								b2.x+=b2.dx;
								b2.y+=b2.dy;

								b.x +=b.dx;
								b.y +=b.dy;
								b.flag = false;
								b2.flag = false;
								return;
							}
							if(b.dx<0)
							{
								b.dx=-1;
							}
							else if(b.dx>0)
							{
								b.dx=1;
							}
							if(b.dy<0)
							{
								b.dy=-1;
							}
							else if(b.dy>0)
							{
								b.dy=1;
							}

							if(b2.dx<0)
							{
								b2.dx=-1;
							}
							else if(b2.dx>0)
							{
								b2.dx=1;
							}
							if(b2.dy<0)
							{
								b2.dy=-1;
							}
							else if(b2.dy>0)
							{
								b2.dy=1;
							}
							b.flag = true;
							b2.flag = true;
						}


						//						if(CheckBall.checkBall(b,b2))
						//						{
						//							
						//							if(b.dx == -1 ||b.dx == 1)
						//							{
						//								b.dx = b.tempDX;
						//							}
						//							
						//							if(b.dy == -1 ||b.dy == 1)
						//							{
						//								b.dy = b.tempDY;
						//							}
						//							if(b2.dx == -1 ||b2.dx == 1)
						//							{
						//								b2.dx = b2.tempDX;
						//							}
						//							
						//							if(b2.dy == -1 ||b2.dy == 1)
						//							{
						//								b2.dy = b2.tempDY;
						//							}
						//							if((b.dx != -1 ||b.dx != 1)&&(b.dy != -1 ||b.dy != 1)&&(b2.dx != -1 ||b2.dx != 1)&&(b2.dy != -1 ||b2.dy != 1))
						//							{
						//								int tempX= b.dx;
						//								int tempY= b.dy;
						//								b.dx=b2.dx;
						//								b.dy=b2.dy;
						//								b2.dx=tempX;
						//								b2.dy=tempY;
						//								b2.dx=-b2.dx;
						//								b2.dy=-b2.dy;
						//								b2.x+=b2.dx;
						//								b2.y+=b2.dy;
						//	
						//								b.x +=b.dx;
						//								b.y +=b.dy;
						//								return;
						//							}
						//							if(b.dx<0)
						//							{
						//								b.dx=-1;
						//							}
						//							else
						//							{
						//								b.dx=1;
						//							}
						//							if(b.dy<0)
						//							{
						//								b.dy=-1;
						//							}
						//							else
						//							{
						//								b.dy=1;
						//							}
						//							if(b2.dx<0)
						//							{
						//								b2.dx=-1;
						//							}
						//							else
						//							{
						//								b2.dx=1;
						//							}
						//							if(b2.dy<0)
						//							{
						//								b2.dy=-1;
						//							}
						//							else
						//							{
						//								b2.dy=1;
						//							}
						//
						//						}
					}
				}
			}
		}
	}
	public static boolean checkBall(Ball b,Ball b2)
	{
		int r1 = b.dimensionsBall/2;
		int r2 = b2.dimensionsBall/2;
		int bx1 = b.x+b.dx + r1;
		int by1 = b.y+b.dy + r1;
		int bx2 = b2.x +b2.dx+ r2;
		int by2 = b2.y+b2.dy + r2;
		return ((Math.pow(r1 + r2, 2))>= (Math.pow(bx2 - bx1, 2) + Math.pow(by2 - by1, 2) )) ? true : false;
	}
}
