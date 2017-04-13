package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import logic.LogicMoveFigure;
import model.MFigure;
import view.control.PContextMenu;

public class FPanelDraw  extends JPanel implements MouseListener, MouseMotionListener
{
	PContextMenu pContextMenu= null;
	Point p = null;
	Boolean isPressed = false;
	LogicMoveFigure logicMoveFigure= null;
	public FPanelDraw(FFrame fFrame) 
	{
		setLayout(null);
		this.setPreferredSize(new Dimension(600,600));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		logicMoveFigure = new LogicMoveFigure();
		fFrame.add(this,BorderLayout.EAST);
	}

	public ArrayList<MFigure> getMemento()
	{
		ArrayList<MFigure> pp = new ArrayList<MFigure>();
		System.out.println( getComponentCount());
		for (Component cc : getComponents())
		{
			pp.add( ((Figure)cc).getMemento() );
		}
		return pp;
	}
	public void setMemento(ArrayList<MFigure> pp)
	{
		removeAll();
		for (MFigure f : pp)
		{
			add( new Figure(f) );
		}
		repaint();
	}
	public void SetPContextMenuObject(PContextMenu pContextMenu)
	{
		this.pContextMenu = pContextMenu;
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
		p = e.getPoint();
		
		if (SwingUtilities.isRightMouseButton(e))
		{
			pContextMenu.show(this, p.x, p.y);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		CreateSq(e);
	}

	public void CreateSq(MouseEvent e)
	{
			Rectangle r = null;
			int height = e.getY() - (int)p.getY();
			int width  = e.getX() - (int)p.getX();
			r = new Rectangle(p.x, p.y, width, height);
			this.add(new Figure(r));
			repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e)
	{
//		repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e) 
	{
	}
}
