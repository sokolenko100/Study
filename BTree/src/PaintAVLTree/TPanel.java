package PaintAVLTree;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class TPanel extends JPanel
{
	private int x =0;
	private int y =0;
	BufferedImage bi=null;
	Graphics2D gg = null;
	TCommand cmd=null;
	public TPanel(TCommand cmd, TFrame frame) 
	{
		bi = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		bi.getGraphics().fillRect(0, 0, 600, 600); // Рисование белого прямогуголника поверх BufferedImage 
		setPreferredSize(new Dimension(600, 600));
		frame.add(this);
		this.cmd = cmd;
		this.setBackground(Color.green);
		gg = (Graphics2D)bi.getGraphics();
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D graf2D=(Graphics2D)g;
		graf2D.drawImage(bi,0,0, null);
	
	}
}
