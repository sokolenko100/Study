package Client_Socet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ChatFrame extends JFrame implements WindowListener
{
	private static final long serialVersionUID = 1L;

	JTextField	   chat_txt;
	ChatConnection con= null;
	KeyActListener aKey	= new KeyActListener();
	JLabel	   lbl_resp;
	String strLogin = "";
	Boolean flag = true;
	String NAme ="";
	public ChatFrame()
	{
		NAme= JOptionPane.showInputDialog("ВВедите логин:");
		strLogin+= NAme +"  Conected";
		con = new ChatConnection();
		setBounds(100, 100, 350, 70);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		chat_txt = new JTextField();
		chat_txt.setBounds(0, 0, 100, 20);
		add(chat_txt);
		chat_txt.addKeyListener(aKey);
		addWindowListener(this);
		lbl_resp = new JLabel();
		lbl_resp.setBounds(100, 0, 300, 20);
		add(lbl_resp);
		setVisible(true);
		listenOutStream();
	}

	private void listenOutStream()
	{
		while (true)
		{
			String line;
			try
			{
				if(flag) 
				{
					con.out.writeUTF(strLogin);
					con.out.flush();
					flag=false;
				}
				Thread.sleep(200);
				line = con.in.readUTF();
				lbl_resp.setText("");
				lbl_resp.setText("Message "  +line);
				line="";
			} catch (IOException e)
			{
				e.printStackTrace();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	class KeyActListener implements KeyListener
	{
		@SuppressWarnings("static-access")
		@Override
		public void keyPressed(KeyEvent e)
		{
			if (e.getKeyCode() == e.VK_ENTER )
			{
				String line = chat_txt.getText();
				try
				{
					con.out.writeUTF(line);
					con.out.flush();
				} catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e)
		{

		}

		@Override
		public void keyTyped(KeyEvent e)
		{

		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println();
	}

	@Override
	public void windowClosed(WindowEvent arg0) 
	{
		System.out.println();

	}

	@Override
	public void windowClosing(WindowEvent arg0) 
	{
		strLogin="";
		strLogin+= NAme +"  disConected";
		try {
			con.out.writeUTF(strLogin);
			con.out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {


	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println();
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
}
