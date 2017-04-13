package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import view.Figure;

public class NastedSquare extends JPanel implements FocusListener ,MouseListener
{
	public NastedSquare(int x , int y, int width, int  height,Figure sq) 
	{
		setPreferredSize(new Dimension(width, height));
		setLayout(null);
		this.setBackground(Color.blue);
		sq.add(this);
		SetParams(x, y, width, width);
		this.addMouseListener(this);
		this.addFocusListener(this);
		setVisible(true);
	}
	@Override
	public void focusGained(FocusEvent e)
	{
	
	}
	@Override
	public void focusLost(FocusEvent e) 
	{
		
	}
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
	}
	public void SetParams(int x,int y,int width,int height)
	{
		this.setBounds(x, y, width, height);
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(Color.YELLOW);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(Color.GREEN);	
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
