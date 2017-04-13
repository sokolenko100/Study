package logic;

import view.Figure;
import view.NastedSquare;

public class LogicMoveFigure 
{
	Figure figure = null;
	int  sizeClick = 10;
	int RightTopBottomIntend = 0;
	int LeftTopBottomIntend  = 0;
	public LogicMoveFigure() 
	{
	}
	public void SetFiguresObject(Figure figure)
	{
		this.figure = figure;
	}
	public void SetNull_x_y()
	{
		prevX = 0;
		prevY = 0;
	}
	int prevX = 0;
	int prevY = 0;
	public void checkPos(int posX, int posY)
	{
		int	x = posX;
		int	y = posY; 
		if(( prevX != 0 ) && (prevY != 0))
		{
			
			if(this.checkSizeLeftTopCorner(posX, posY))
			{
				this.moveSizeLeftTopCorner(x - prevX,y - prevY );
			}
			if(this.checkSizeLeftSide(posX, posY))
			{
				this.moveSizeLeftSide( prevX - x ,y - prevY );
			}
			if(this.checkSizeLeftBottomCorner(posX, posY))
			{
				this.moveSizeLeftBottomCorner( prevX - x ,y - prevY );
			}
			if(this.checkSizeBottomSide(posX, posY))
			{
				this.moveSizeBottomSide(x - prevX,y - prevY );
			}
			if(this.checkSizeRightBottomCorner(posX, posY))
			{
				this.moveSizeRightBottomCorner(x - prevX,y - prevY );
			}
			if(this.checkSizeRightSide(posX, posY))
			{
				this.moveSizeRightSide(x - prevX,y - prevY );
			}
			if(this.checkSizeRightTopCorner(posX, posY))
			{
				this.moveSizeRightTopCorner(x - prevX,prevY -y );
			}
			if(this.checkSizeTopSide(posX, posY))
			{
				this.moveSizeTopSide(x - prevX,prevY -y );;
			}
			if(this.checkPosition(posX, posY))
			{
				this.movePosition(x - prevX,y - prevY );
			}
		}
		prevX = x;
		prevY = y;

	}
	public void SetParams(int x,int y,int width,int height)
	{
		figure.setBounds(x, y, width, height);
	}
	public Boolean checkFocus(int posX, int posY,Figure figure)
	{
		Boolean result = false;

		if((figure.getX()<=posX)&&(posX<=figure.getX()+figure.getHeight())&&(figure.getY()<=posY)&&(posY<=figure.getY()+figure.getHeight()))
		{
			result = true;
		//	CreateNastedSquare(figure.getX() , figure.getY(), figure.getWidth(),2,figure);
		}
		return result;
	}
	public Boolean checkPosition(int posX, int posY)
	{
		Boolean result = false;

		if(((figure.getX()+sizeClick<=posX)&&(posX<=figure.getX()+figure.getWidth()-sizeClick))&&((figure.getY()+sizeClick<=posY)&&(posY<=figure.getY()+figure.getHeight()-sizeClick)))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeLeftTopCorner(int posX, int posY)
	{
		Boolean result = false;

		if((figure.getX()+sizeClick>=posX)&&(figure.getY()+sizeClick>=posY)&&(posY>=figure.getY()&&posX>=figure.getX()))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeLeftSide(int posX, int posY)
	{
		Boolean result = false;

		if((figure.getX()+sizeClick>=posX)&&(figure.getY()+figure.getHeight()-sizeClick>=posY)&&(posY>=figure.getY()&&posX>=figure.getX()))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeLeftBottomCorner(int posX, int posY)
	{
		Boolean result = false;

		if((figure.getX()+sizeClick>=posX)&&(figure.getY()+figure.getHeight()-sizeClick<=posY)&&(posY>=figure.getY()&&posX>=figure.getX()))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeBottomSide(int posX, int posY)
	{
		Boolean result = false;

		if((figure.getX()+sizeClick<=posX)&&(figure.getX()+figure.getWidth()-sizeClick>=posX)&&(figure.getY()+figure.getHeight()-sizeClick<=posY)&&(posY <=figure.getY()+figure.getHeight()))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeRightBottomCorner(int posX, int posY)
	{
		Boolean result = false;

		if((figure.getX()+figure.getWidth()-sizeClick<=posX)&&(figure.getY()+figure.getHeight()-sizeClick<=posY)&&(posY <=figure.getY()+figure.getHeight()&&posX<=figure.getX()+figure.getWidth()))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeRightSide(int posX, int posY)
	{
		Boolean result = false;

		if((figure.getX()+figure.getWidth()-sizeClick<=posX)&&(figure.getY()+figure.getHeight()-sizeClick>=posY)&&(figure.getY()+sizeClick<=posY)&&(posX<=figure.getX()+figure.getWidth()))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeRightTopCorner(int posX, int posY)
	{
		Boolean result = false;

		if((figure.getX()+figure.getWidth()-sizeClick<=posX)&&(figure.getY()+sizeClick>=posY)&&(posY>=figure.getY()&&posX<=figure.getX()+figure.getWidth()))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeTopSide(int posX, int posY)
	{
		Boolean result = false;

		if((figure.getX()+figure.getWidth()-sizeClick>=posX)&&(figure.getX()+sizeClick<=posX)&&(figure.getY()+sizeClick>=posY)&&(posY>=figure.getY()&&posX>=figure.getX()))
		{
			result= true;
		}
		return result;
	}
	public void movePosition(int posX, int posY)
	{
		figure.setBounds(figure.getX() + posX, figure.getY() + posY,figure.getWidth(), figure.getHeight());
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	public void moveSizeLeftTopCorner(int posX, int posY)
	{
		figure.setBounds(figure.getX() - posX,figure.getY() - posY,figure.getWidth() + posX, figure.getHeight() + posY);
	}
	public void moveSizeLeftSide(int posX, int posY)
	{
		figure.setBounds(figure.getX() - posX, figure.getY(), figure.getWidth() + posX, figure.getHeight());
	}
	public void moveSizeLeftBottomCorner(int posX, int posY)
	{
		figure.setBounds(figure.getX() - posX, figure.getY(), figure.getWidth() + posX,figure. getHeight() + posY);
	}
	public void moveSizeBottomSide(int posX, int posY)
	{
		figure.setBounds(figure.getX(),figure.getY(),figure.getWidth() + posX,figure.getHeight() + posY);
	}
	public void moveSizeRightBottomCorner(int posX, int posY)
	{
		figure.setBounds(figure.getX(),figure.getY(),figure. getWidth() + posX, figure.getHeight() + posY);
	}
	public void moveSizeRightSide(int posX, int posY)
	{
		figure.setBounds(figure.getX(),figure.getY(), figure.getWidth() + posX,figure.getHeight());
	}
	public void moveSizeRightTopCorner(int posX, int posY)
	{
		figure.setBounds(figure.getX(),figure.getY()-posY, figure.getWidth() + posX, figure.getHeight() + posY);
	}
	public void moveSizeTopSide(int posX, int posY)
	{
		figure.setBounds(figure.getX(),figure.getY() - posY,figure.getWidth(), figure.getHeight()+posY);
	}
}