package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.JRootPane;

import model.MFigure;
import model.RMdata;


public class Figure extends JPanel implements  Serializable, FocusListener, MouseListener, MouseMotionListener
{
	public	RMdata data = null;
	int dx = 0;
	int dy = 0;
	public Rectangle r;
	private int SizeNestedSquare = 10;
	public MFigure getMemento()
	{
		MFigure fm = new MFigure();
		fm.color = data.color.getRGB();
		fm.type = data.type;
		fm.stroke = data.stroke;
		fm.rect = getBounds();
		return fm;
	}
	public Figure(MFigure fm)
	{
		setLayout(null);
		setBounds(fm.rect);
		this.setBackground(Color.WHITE);
		data = new RMdata();
		data.color = new Color(fm.color);
		data.type = fm.type;
		data.stroke = fm.stroke;
	}
	public Figure(Rectangle r )
	{
		if(r.width < 0)
		{
			r.x += r.width;
			r.width = Math.abs(r.width);
		}
		if(r.height < 0)
		{
			r.y += r.height;
			r.height = Math.abs(r.height);
		}
		this.r = r;
		setLayout(null);
		setBounds(r);
		CreateNastedSquare(this.getX() , this.getX(), this.getWidth(), this.getHeight());
		this.setBackground(Color.WHITE);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addFocusListener(this);
		data = new RMdata();
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		gg.setStroke(new BasicStroke(data.stroke));
		gg.setColor( data.color );
		switch (data.type)
		{
		case 1: gg.drawLine(5, 5, getWidth() - 10, getHeight() - 10); 	         break;
		case 2: gg.drawRect(5, 5, getWidth() - 10, getHeight() - 10);			 break;
		case 3: gg.drawRoundRect(5, 5, getWidth() - 5, getHeight() - 5, 30, 30); break;	
		case 4: gg.drawOval(5, 5, getWidth() - 10, getHeight() - 10);    		 break;
		}		
	}
	private void CreateNastedSquare(int x , int y, int width, int  height)
	{
		int	RightTopBottomIntend = getWidth()/15;
		int	LeftTopBottomIntend  = getWidth()/25;
		this.add(new NestedSquare(new Rectangle( LeftTopBottomIntend, LeftTopBottomIntend, SizeNestedSquare, SizeNestedSquare),Side.WestNorth));
		this.add(new NestedSquare(new Rectangle(width/2, LeftTopBottomIntend, SizeNestedSquare, SizeNestedSquare),Side.North));
		this.add(new NestedSquare(new Rectangle(width-RightTopBottomIntend, LeftTopBottomIntend, SizeNestedSquare, SizeNestedSquare),Side.EastNorth));
		this.add(new NestedSquare(new Rectangle(LeftTopBottomIntend, height/2, SizeNestedSquare, SizeNestedSquare),Side.West));
		this.add(new NestedSquare(new Rectangle(width-RightTopBottomIntend, height/2, SizeNestedSquare, SizeNestedSquare),Side.East));
		this.add(new NestedSquare(new Rectangle(LeftTopBottomIntend, height-RightTopBottomIntend, SizeNestedSquare, SizeNestedSquare),Side.WestSouth));
		this.add(new NestedSquare(new Rectangle(width/2, height-RightTopBottomIntend, SizeNestedSquare, SizeNestedSquare),Side.South));
		this.add(new NestedSquare(new Rectangle(width-RightTopBottomIntend, height-RightTopBottomIntend, SizeNestedSquare, SizeNestedSquare),Side.SouthEast));
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		dx = e.getX();
		dy = e.getY();
		requestFocus();
	}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		int x = (int) r.getX();
		int y = (int) r.getY();
		x += e.getX() - dx;
		y += e.getY() - dy;
		r.setLocation(x, y);
		setBounds(r);
	}
	@Override
	public void mouseMoved(MouseEvent e){}
	@Override
	public void focusGained(FocusEvent e)
	{
		Component []  squares = getComponents();
		for (int i = 0; i < squares.length; i++) 
		{
			NestedSquare square = (NestedSquare) squares[i];
			square.setVisible(true);
		}
	}
	@Override
	public void focusLost(FocusEvent e) 
	{
		if(e.getOppositeComponent() != null)
		{
			if ((e.getOppositeComponent().getClass() == JRootPane.class))//&&e.getOppositeComponent().getClass()==JButton.class)
			{
				requestFocusInWindow();
			}
		}
		Component []  squares = getComponents();
		for (int i = 0; i < squares.length; i++) 
		{
			NestedSquare square = (NestedSquare) squares[i];
			square.setVisible(false);
		}
	}
	private void moveMarks()
	{
		int width = getWidth();
		int height = getHeight();
		int size = 10;
		NestedSquare mrk = null;
		int positionOfMark = 1;
		int index = 0;
		Component[] marks = getComponents();
		while(index < getComponentCount() )
		{
			mrk = (NestedSquare) marks[index];
			switch (positionOfMark)
			{
			case 1:
				mrk.r.x = 0;
				mrk.r.y = 0;
				mrk.setBounds(mrk.r.x, mrk.r.y, size, size);
				break;
			case 2:					
				mrk.r.x = (width - size) / 2;
				mrk.r.y = 0;
				mrk.setBounds(mrk.r.x, mrk.r.y, size, size);
				break;

			case 3:
				mrk.r.x = width - size;
				mrk.r.y = 0;
				mrk.setBounds(mrk.r.x, mrk.r.y, size, size);
				break;

			case 4:
				mrk.r.x = 0;
				mrk.r.y = (height - size) / 2;
				mrk.setBounds(mrk.r.x, mrk.r.y, size, size);
				break;

			case 5:
				mrk.r.x = width - size;
				mrk.r.y = (height - size) / 2;
				mrk.setBounds(mrk.r.x, mrk.r.y, size, size);
				break;

			case 6:
				mrk.r.x = 0;
				mrk.r.y = height - size;
				mrk.setBounds(mrk.r.x, mrk.r.y, size, size);
				break;

			case 7:
				mrk.r.x = (width - size) / 2;
				mrk.r.y = height - size;
				mrk.setBounds(mrk.r.x, mrk.r.y, size, size);
				break;

			case 8:					
				mrk.r.x = width - size;
				mrk.r.y = height - size;
				mrk.setBounds(mrk.r.x, mrk.r.y, size, size);
				break;

			default:
				break;
			}
			positionOfMark++;
			index++;
		}
		repaint();
	}
	public void widerRight(int newx)
	{
		r.setSize(newx, (int) r.getHeight());
		setBounds(r);
	}
	public void longerBottom(int newy)
	{
		r.setSize((int) r.getWidth(), newy);
		setBounds(r);
	}
	public void longerTop( int newy)
	{
		int newheight = (int) (r.getHeight() - newy);
		int y = (int) (r.getY() + newy);

		r.setBounds((int) r.getX(), y, (int) r.getWidth(), newheight);

		setBounds(r);
	}
	public void widerLeft(int newx)
	{
		int newWider = (int) (r.getWidth() - newx);
		int x = (int) (r.getX() + newx);

		r.setBounds(x, (int) r.getY(), newWider, (int)r.getHeight());

		setBounds(r);
	}
	class NestedSquare extends JPanel implements  MouseMotionListener
	{
		int dx = 0;
		int dy = 0;

		public Rectangle r;
		Side side = null;
		public NestedSquare(Rectangle r, Side side)
		{
			this.side=side;
			this.r=r;
			setLayout(null);
			setBounds(r);
			this.setVisible(false);
			this.addMouseMotionListener(this);
			this.setBackground(Color.RED);
		}
		@Override
		public void paint(Graphics g)
		{
			super.paint(g);
		}

		private void Resize(int newx, int newy)
		{
			switch (this.side)
			{
			case WestNorth: 			widerLeft(newx);    longerTop(newy);    break;
			case West: 					widerLeft(newx);					    break;
			case WestSouth: 			widerLeft(newx);    longerBottom(newy);	break;
			case South: 				longerBottom(newy);					    break;
			case SouthEast: 			widerRight(newx);  	longerBottom(newy); break;
			case East: 					widerRight(newx); 						break;
			case EastNorth: 			widerRight(newx);	longerTop(newy);	break;
			case North: 				longerTop(newy); 						break;

			default:															break;
			}
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			int newx = getX() + e.getX();
			int newy = getY() + e.getY();
			Resize(newx, newy);	
			moveMarks();	
			repaint();
		}
		@Override
		public void mouseMoved(MouseEvent e) {
		}
	}
	enum Side
	{
		WestNorth,
		West,
		WestSouth,
		South,
		SouthEast,
		East,
		EastNorth,
		North;
	}
}
