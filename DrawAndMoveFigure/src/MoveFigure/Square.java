package MoveFigure;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class Square extends JPanel
{
	final int  sizeClick = 10;

	int x;
	int y;
	int height;
	int width;
	int  RightTopBottomIntend;
    int  LeftTopBottomIntend;
	int identSize = 5;
	ArrayList<NastedSquare> nastedSq = null;
	public Square(int x , int y, int width, int  height,PdrawFigure p)
	{
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		this.setLayout(null);
		this.setVisible(true);
		this.SetParams(x, y, width, height);
		nastedSq= new ArrayList<NastedSquare>();
		CreateNastedSquare(x, y, width, height,this);
	}
	
	private void CreateNastedSquare(int x , int y, int width, int  height,Square sq)
	{
		RightTopBottomIntend = width/8;
	    LeftTopBottomIntend  = width/25;
		nastedSq.add(new NastedSquare(LeftTopBottomIntend, LeftTopBottomIntend, width/10, width/10,sq));
		nastedSq.add(new NastedSquare(width/2, LeftTopBottomIntend, width/10, width/10,sq));
		nastedSq.add(new NastedSquare(width-RightTopBottomIntend, LeftTopBottomIntend, width/10, width/10,sq));
		nastedSq.add(new NastedSquare(LeftTopBottomIntend, height/2, width/10, width/10,sq));
		nastedSq.add(new NastedSquare(width-RightTopBottomIntend, height/2, width/10, width/10,sq));
		nastedSq.add(new NastedSquare(LeftTopBottomIntend, height-RightTopBottomIntend, width/10, width/10,sq));
		nastedSq.add(new NastedSquare(width/2, height-RightTopBottomIntend, width/10, width/10,sq));
		nastedSq.add(new NastedSquare(width-RightTopBottomIntend, height-RightTopBottomIntend, width/10, width/10,sq));
	}
	public void ChengesPositionNastedSquare()
	{
		RightTopBottomIntend = width/8;
	    LeftTopBottomIntend  = width/25;
		nastedSq.get(0).SetParams(LeftTopBottomIntend, LeftTopBottomIntend, width/10, width/10);
		nastedSq.get(1).SetParams(width/2, LeftTopBottomIntend, width/10, width/10);
		nastedSq.get(2).SetParams(width-RightTopBottomIntend, LeftTopBottomIntend, width/10, width/10);
		nastedSq.get(3).SetParams(LeftTopBottomIntend, height/2, width/10, width/10);
		nastedSq.get(4).SetParams(width-RightTopBottomIntend, height/2, width/10, width/10);
		nastedSq.get(5).SetParams(LeftTopBottomIntend, height-RightTopBottomIntend, width/10, width/10);
		nastedSq.get(6).SetParams(width/2, height-RightTopBottomIntend, width/10, width/10);
		nastedSq.get(7).SetParams(width-RightTopBottomIntend, height-RightTopBottomIntend, width/10, width/10);
	}
	public void SetParams(int x,int y,int width,int height)
	{
		this.setBounds(x, y, width, height);
	}
	
	public Boolean checkFocus(int posX, int posY)
	{
		Boolean result = false;

		if((this.x<=posX)&&(posX<=this.x+width)&&(this.y<=posY)&&(posY<=this.y+height))
		{
			result = true;
		}
		return result;
	}
	public Boolean checkPosition(int posX, int posY)
	{
		Boolean result = false;

		if(((this.x+sizeClick<=posX)&&(posX<=this.x+width-sizeClick))&&((this.y+sizeClick<=posY)&&(posY<=this.y+height-sizeClick)))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeLeftTopCorner(int posX, int posY)
	{
		Boolean result = false;

		if((this.x+sizeClick>=posX)&&(this.y+sizeClick>=posY)&&(posY>=this.y&&posX>=this.x))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeLeftSide(int posX, int posY)
	{
		Boolean result = false;

		if((this.x+sizeClick>=posX)&&(this.y+height-sizeClick>=posY)&&(posY>=this.y&&posX>=this.x))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeLeftBottomCorner(int posX, int posY)
	{
		Boolean result = false;

		if((this.x+sizeClick>=posX)&&(this.y+height-sizeClick<=posY)&&(posY>=this.y&&posX>=this.x))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeBottomSide(int posX, int posY)
	{
		Boolean result = false;

		if((this.x+sizeClick<=posX)&&(this.x+width-sizeClick>=posX)&&(this.y+height-sizeClick<=posY)&&(posY <=this.y+height))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeRightBottomCorner(int posX, int posY)
	{
		Boolean result = false;

		if((this.x+width-sizeClick<=posX)&&(this.y+height-sizeClick<=posY)&&(posY <=this.y+height&&posX<=this.x+width))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeRightSide(int posX, int posY)
	{
		Boolean result = false;

		if((this.x+width-sizeClick<=posX)&&(this.y+height-sizeClick>=posY)&&(this.y+sizeClick<=posY)&&(posX<=this.x+width))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeRightTopCorner(int posX, int posY)
	{
		Boolean result = false;

		if((this.x+width-sizeClick<=posX)&&(this.y+sizeClick>=posY)&&(posY>=this.y&&posX<=this.x+width))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeTopSide(int posX, int posY)
	{
		Boolean result = false;

		if((this.x+width-sizeClick>=posX)&&(this.x+sizeClick<=posX)&&(this.y+sizeClick>=posY)&&(posY>=this.y&&posX>=this.x))
		{
			result= true;
		}
		return result;
	}
	public void movePosition(int posX, int posY)
	{
		this.setBounds(x+=posX, y+=posY, width, height);
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	public void moveSizeLeftTopCorner(int posX, int posY)
	{
		this.setBounds(x-=posX, y-=posY, width+=posX, height+=posY);
	}
	public void moveSizeLeftSide(int posX, int posY)
	{
		this.setBounds(x-=posX, y, width+=posX, height);
	}
	public void moveSizeLeftBottomCorner(int posX, int posY)
	{
		this.setBounds(x-=posX, y, width+=posX, height+=posY);
	}
	public void moveSizeBottomSide(int posX, int posY)
	{
		this.setBounds(x, y, width, height+=posY);
	}
	public void moveSizeRightBottomCorner(int posX, int posY)
	{
		this.setBounds(x, y, width+=posX, height+=posY);
	}
	public void moveSizeRightSide(int posX, int posY)
	{
		this.setBounds(x, y, width+=posX, height);
	}
	public void moveSizeRightTopCorner(int posX, int posY)
	{
		this.setBounds(x, y-=posY, width+=posX, height+=posY);
	}
	public void moveSizeTopSide(int posX, int posY)
	{
		this.setBounds(x, y-=posY, width, height+=posY);
	}
}
