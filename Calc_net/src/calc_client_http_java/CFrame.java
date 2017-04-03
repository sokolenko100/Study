package calc_client_http_java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CFrame extends JFrame
{
	public CFrame() throws UnknownHostException, IOException
	{
		setTitle("Cacl");
		setBounds(100, 100, 500, 500);
		setVisible(true);
		
		
		 JTextField oper1 = new JTextField();
		oper1.setBounds(0, 0, 100, 30);

		JTextField result = new JTextField();
		result.setBounds(0, 120, 100, 30);

		 JTextField operb = new JTextField();
		operb.setBounds(0, 30, 100, 30);

		 JTextField oper2 = new JTextField();
		oper2.setBounds(0, 60, 100, 30);

		JButton calc = new JButton("Calc");
		calc.setBounds(0, 90, 100, 30);
		calc.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String comand = oper1.getText() + ":" + operb.getText() + ":" + oper2.getText();
			}
		});
		add(oper1);
		add(operb);
		add(oper2);
		add(result);
		add(calc);
		repaint();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) throws IOException
	{
		new CFrame();
	}
}
