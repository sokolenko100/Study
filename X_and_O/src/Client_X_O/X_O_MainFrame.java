package Client_X_O;

import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import logic_x_o_client.client;

public class X_O_MainFrame extends JFrame implements Runnable, WindowListener
{
	public static final String push = "push";
	public static final String play = "play";
	public static final String step = "step";
	public static final String exit = "exit";
	public Boolean isPlay = true;
	SelectPlaer dialog = null;
	String  gamerName = null;
	Cell [] cells = new Cell[9];
	client client = null;
	public static String type = "";
	public static void main(String [] args)
	{
		new X_O_MainFrame();
		System.out.println("Start Client");
	}

	public X_O_MainFrame()
	{
		this.setBounds(200, 100, 600, 600);
		this.setResizable(false);
		this.setLayout(new GridLayout(3,3));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamerName = JOptionPane.showInputDialog(this, "What's your name?");
		if (!gamerName.equals("")) 
		{
			client = new client("gamerName:"+gamerName);
		}
		this.setTitle(gamerName);
		this.setButton(this);
		this.setVisible(true);
		dialog = new SelectPlaer(this, gamerName,client);
		new Thread(this).start();

		
	}
	public void setButton(X_O_MainFrame  frame)
	{
		for (int i = 0; i < cells.length; i++) 
		{
			Cell cell = new Cell(i,client,gamerName,this);
			cell.visible(false);
			cells[i]=cell;
			frame.add(cell);
		}
	}
	@Override
	public void run()
	{
		while(true)
		{
			this.parse();
			try 
			{
				Thread.sleep(10);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	public void parse()
	{
		String str = "";
		if(client.answerfromserver.size()>0)
		{
			str= client.answerfromserver.get(0);
			ClearAnswerfromS();
			String [] parseArray = str.split(":");
			str="";
			if(parseArray.length>0)
			{
				switch (parseArray[0])
				{
				case "push":
				{
					String idCell = parseArray[2];
					String typeCell =parseArray[3];
					this.push(idCell,typeCell);
					break;
				}
				case "type":
				{
					X_O_MainFrame.type=parseArray[2].toLowerCase();
//					if(X_O_MainFrame.type.equals("x"))
//					{
//						play();
//					}
//					else
//					{
//						this.unvisible();
//					}
					break;
				}
				case "gamerName":
				{
					if(!gamerName.equals(parseArray[1]))
					{
						String nameg ="";
						int i = 0;
						if(dialog.listModel.size()>0)
						{
							 i =dialog.listModel.size();
						}
						if(!gamerName.equals(parseArray[1]))
						{
							nameg=parseArray[1];
							if (!dialog.listModel.contains(nameg))
							{
								dialog.listModel.add(i,nameg);
							}
						}
					}
					break;
				}
				case "play":
				{
					if(isPlay)
					{

						int	n = JOptionPane.showConfirmDialog(
								this,
								"Would you like to play",
								"Play",
								JOptionPane.YES_NO_OPTION);
						if(n==JOptionPane.NO_OPTION)
						{
							isPlay=true;
							break;
						}
						else 
						{
							isPlay=false;
						}
					}
					this.play();
					break;
				}
				case "win":
				{
					JOptionPane.showMessageDialog(this,"You win!");
					break;
				}
				case"lost":
				{
					JOptionPane.showMessageDialog(this,"You lost!");
					break;
				}
				case"draw":
				{
					JOptionPane.showMessageDialog(this,"Draw!");
					break;
				}
				case "wait":
				{
					this.unvisible();
					break;
				}
				}
			}
		}
	}
	public void ClearAnswerfromS()
	{
		client.answerfromserver.clear();
	}
	public void push(String id_str, String type)
	{
		int id = Integer.parseInt(id_str);
		for (int i = 0; i < cells.length; i++) 
		{
			if(id==cells[i].id)
			{
				cells[i].setTextButt(type);
				cells[i].visible(false);
				break;
			}
		}
		this.play();
	}
	public void play()
	{
		for (int i = 0; i < cells.length; i++) 
		{
			if(cells[i].getText().equals(""))
			{
				cells[i].visible(true);
			}
		}
	}
	public void unvisible()
	{
		for (int i = 0; i < cells.length; i++) 
		{
			cells[i].visible(false);
		}
	}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) 
	{
		try {
			client.wrtClnt.out.writeUTF(gamerName+":"+ X_O_MainFrame.exit);
			client.wrtClnt.out.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		client.exitAndClouse();		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
	}
	@Override
	public void windowIconified(WindowEvent e) {
	}
	@Override
	public void windowOpened(WindowEvent e) {
	}
}
