package MoveFigure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PdrawFigure extends JPanel implements  MouseListener,MouseMotionListener
{
	Boolean ischeckSizeLeftTopCorner = false; 
	Boolean ischeckSizeLeftSide = false; 
	Boolean ischeckSizeLeftBottomCorner= false; 
	Boolean ischeckSizeBottomSide = false; 
	Boolean ischeckSizeRightBottomCorner = false; 
	Boolean ischeckSizeRightSide = false; 
	Boolean ischeckSizeRightTopCorner = false; 
	Boolean ischeckSizeTopSide = false; 
	Boolean isCheked = false;
	Boolean isPresed = false;
	ArrayList<Square> sqlist  = null;
	int x;
	int y;
	int x2;
	int y2;
	JLabel lableX = null;
	JLabel lableY = null;
	
	Square moveSq=null;
	Square sq=null;
	public PdrawFigure(PFrame frame) 
	{
		sqlist  = new  ArrayList<Square>();
		setPreferredSize(new Dimension(600, 600));
		setLayout(null);
		lableX= new JLabel();
		lableX.setBounds(80, 580, 50, 20);
		lableY= new JLabel();
		lableY.setBounds(140, 580, 50, 20);
		this.add(lableX);
		this.add(lableY);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		this.setBackground(Color.WHITE);
		frame.add(this,BorderLayout.NORTH);
	}
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
	}
	@Override
	public void mouseClicked(MouseEvent e){} 
	@Override
	public void mouseEntered(MouseEvent e){}
	@Override
	public void mouseExited(MouseEvent e){}
	@Override
	public void mousePressed(MouseEvent e)
	{
		isPresed= true;
		
		x= e.getX();
		y= e.getY(); 
		for (Square square : sqlist)
		{
			isCheked 					 = square.checkPosition(x,y);

			ischeckSizeLeftTopCorner 	 = square.checkSizeLeftTopCorner(x, y); 
			ischeckSizeLeftSide			 = square.checkSizeLeftSide(x, y); 
			ischeckSizeLeftBottomCorner  = square.checkSizeLeftBottomCorner(x, y); 
			ischeckSizeBottomSide		 = square.checkSizeBottomSide(x, y); 
			ischeckSizeRightBottomCorner = square.checkSizeRightBottomCorner(x, y); 
			ischeckSizeRightSide 		 = square.checkSizeRightSide(x, y); 
			ischeckSizeRightTopCorner 	 = square.checkSizeRightTopCorner(x, y); 
			ischeckSizeTopSide 			 = square.checkSizeTopSide(x, y); 
			if(isCheked)
			{
				moveSq = square;
				break;
			}
			if(ischeckSizeLeftTopCorner||ischeckSizeLeftSide||ischeckSizeLeftBottomCorner||ischeckSizeBottomSide||ischeckSizeRightBottomCorner||ischeckSizeRightSide||ischeckSizeRightTopCorner||ischeckSizeTopSide)
			{
				moveSq = square;
				break;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		CreateSq(e);
		NullAllVar();
	}
	int prevX = 0;
	int prevY = 0;
	public void CreateSq(MouseEvent e)
	{
		if(isPresed)
		{
			int height=e.getY()-y;
			int width= e.getX()-x;

			if(height<0&&width<0)
			{
				height = -height;
				width =- width;
				sq = new  Square(x-width, y-height, width,height,this);
			}
			else if(width<0)
			{
				width=- width;
				sq = new  Square(x-width, y,width, height,this);
			}
			else if(height<0)
			{
				height= -height;
				sq = new  Square(x, y-height, width,height,this);
			}
			else 
			{
				sq = new  Square(x, y, width, height,this);
			}
			if(!isCheked)
			{
				sqlist.add(sq);
			}
			this.add(sq);
		}
		repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e)
	{
		if(isCheked)
		{
			x= e.getX();
			y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.movePosition(x - prevX,y - prevY );
			}
			prevX = x;
			prevY = y;
		}
		if(ischeckSizeLeftTopCorner)
		{
			x= e.getX();
			y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.moveSizeLeftTopCorner( prevX - x, prevY - y);
			}
			prevX = x;
			prevY = y;
		}
		if(ischeckSizeLeftSide)
		{
			x= e.getX();
			y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.moveSizeLeftSide( prevX - x ,y - prevY );
			}
			prevX = x;
			prevY = y;
		}
		if(ischeckSizeLeftBottomCorner)
		{
			x= e.getX();
			y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.moveSizeLeftBottomCorner( prevX - x ,y - prevY );
			}
			prevX = x;
			prevY = y;
		}
		if(ischeckSizeBottomSide)
		{
			x= e.getX();
			y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.moveSizeBottomSide(x - prevX,y - prevY );
			}
			prevX = x;
			prevY = y;
		}
		if(ischeckSizeRightBottomCorner)
		{
			x= e.getX();
			y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.moveSizeRightBottomCorner(x - prevX,y - prevY );
			}
			prevX = x;
			prevY = y;
		}
		if(ischeckSizeRightSide)
		{
			x= e.getX();
			y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.moveSizeRightSide(x - prevX,y - prevY );
			}
			prevX = x;
			prevY = y;
		}
		if(ischeckSizeRightTopCorner)
		{
			x= e.getX();
			y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.moveSizeRightTopCorner(x - prevX,prevY -y );
			}
			prevX = x;
			prevY = y;
		}
		if(ischeckSizeTopSide)
		{
			x= e.getX();
			y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.moveSizeTopSide(x - prevX,prevY -y );
			}
			prevX = x;
			prevY = y;
		}
		if(moveSq!=null)
		{
			moveSq.ChengesPositionNastedSquare();
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) 
	{
			int  getX = e.getX();
			int  getY = e.getY();

			for (Square square : sqlist) 
			{
				if(square.checkFocus(getX, getY))
	            {
					for (NastedSquare nastedSquare : square.nastedSq) 
					{
						nastedSquare.setVisible(true);
					}
	            }
				else
				{
					for (NastedSquare nastedSquare : square.nastedSq) 
					{
						nastedSquare.setVisible(false);
					}
				}
			}

		x2= e.getX();
		y2= e.getY(); 
		lableX.setText(Integer.toString(x2));
		lableY.setText(Integer.toString(y2));
	}
	private void NullAllVar()
	{
		ischeckSizeLeftTopCorner = false; 
		ischeckSizeLeftSide = false; 
		ischeckSizeLeftBottomCorner= false; 
		ischeckSizeBottomSide = false; 
		ischeckSizeRightBottomCorner = false; 
		ischeckSizeRightSide = false; 
		ischeckSizeRightTopCorner = false; 
		ischeckSizeTopSide = false;
		prevX = 0;
		prevY = 0;
		isCheked= false;
		isPresed = false;
	}

}
