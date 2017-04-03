package foreach_timer_Kill_Ball_task2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BPanelDraw extends JPanel implements  MouseListener
{
	private int x =0;
	private int y =0;
	private int x2 =0;
	private int y2 =0;
	int id =0;
	ArrayList<Ball> pp = new ArrayList<Ball>();
	Timer timer= null;
	public BPanelDraw( BFrame frame) 
	{
		setPreferredSize(new Dimension(frame.getHeight()-120, frame.getWidth()-150));
		frame.add(this,BorderLayout.CENTER);	
		addMouseListener(this);
		setLayout(null);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		timer=new Timer(30, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				for (Ball ball : pp) 
				{
					ball.move();
				}
			}
		});
		timer.start();
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
	}	
	public  void Create_8_Ball(int x,int y, int demenPerens)
	{
		int id=pp.size();
		for (int i = 0; i < 8; i++)
		{
			Ball b = new Ball(x, y, this,id++,pp,false);
			b.dimensionsBall=demenPerens/2;
			this.add(b);
			pp.add(b);
		}
	}
	@Override
	public void mousePressed(MouseEvent e) 
	{
		x = e.getX();
		y = e.getY();
		Ball b  = new Ball(x, y,this,id++,pp,true);
		this.add(b);
		pp.add(b);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{}

	@Override
	public void mouseExited(MouseEvent arg0)
	{}
	@Override
	public void mouseReleased(MouseEvent arg0) 
	{}
}
