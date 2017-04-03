package PaintAVLTree;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JTextField;

public class TPainter extends AVLTree
{
	JTextField text= null;
	public TPainter()
	{
		
	}
//	public void SetTButtonPanelObject(JTextField text)
//	{
//		this.text=text;
//		text.setText(Integer.toString(p.value));
//	}
	public void toStringTree()
	{
		String tree = super.toString();
		text.setText(tree);
	}
	public void deletefromTree()
	{
		int node=0;
		try
		{
			node = Integer.parseInt(text.getText());
			super.del(node);
		} 
		catch (Exception e)
		{
			text.setText("You enter not valid number");
		}
	}
	public void reversTree()
	{
		super.reverse();
	}
	public void weightTree()
	{
		int width = super.width();
		String widthstr= "nodes - "+ width;
		text.setText(widthstr);
	}
	public void heightTree()
	{
		int height = super.height();
		String heightstr= "nodes - "+ height;
		text.setText(heightstr);
	}
	public void nodesTree()
	{
		int nodes = super.nodes();
		String nodesstr= "nodes - "+ nodes;
		text.setText(nodesstr);
	}
	public void leavsTree()
	{
		int leaves = super.leaves();
		String leavesstr= "leaves - "+ leaves;
		text.setText(leavesstr);
	}
	public void sizeTree()
	{
		int size = super.size();
		String sizestr= "size - "+ size;
		text.setText(sizestr);
	}
	public void addNodetoTree()
	{
		int node=0;
		try
		{
			node = Integer.parseInt(text.getText());
			super.add(node);
		} 
		catch (Exception e)
		{
			text.setText("You enter not valid number");
		}
	}
	public void draw(Graphics2D gg,int right)
	{
		this.drawTree(root, gg,right/2,right,1, 50);
	}
	private void drawTree(Node p,Graphics2D gg,int left,int right,int level, int dy)
	{
		if(p==null)
			return;
		
		gg.setColor(Color.BLACK);
		gg.setStroke(new BasicStroke(3));
		if (p.left!=null) 
		{
			gg.drawLine(right,level+30,right-left,level+dy);
		}
		if (p.right!=null) 
		{
			gg.drawLine(right,level+30,left+right,level+dy);
		}
		gg.drawOval(right-15, level, 30, 30); 
		gg.drawString(Integer.toString(p.value), right -7, level+20);
		drawTree( p.left, gg, left/2 , right-left, level+ dy, dy);
		drawTree( p.right, gg,left/2, left+right, level+ dy, dy);
	}
}