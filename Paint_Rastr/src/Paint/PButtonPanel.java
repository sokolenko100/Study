package Paint;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PButtonPanel  extends JPanel
{
	public PButtonPanel(PCommand cmd,PFrame frame)
	{
		this.setPreferredSize(new Dimension(100,200));
		this.setLayout(null);
		this.setVisible(true);

		JButton btn_colorCh = new JButton("ColorChooser");
		btn_colorCh.setBounds( 0, 40, 100, 50);
		btn_colorCh.addActionListener(cmd.aColor);
		this.add(btn_colorCh);
		JButton btn4 = new JButton("Width_2");
		btn4.setBounds( 0,100, 100, 50);
		btn4.addActionListener(cmd.aLine);
		this.add(btn4);
		JButton btn5 = new JButton("Width_4");
		btn5.setBounds( 0, 160, 100, 50);
		btn5.addActionListener(cmd.aLine);
		this.add(btn5);
		JButton btn6 = new JButton("Width_6");
		btn6.setBounds( 0, 220, 100, 50);
		btn6.addActionListener(cmd.aLine);
		this.add(btn6);


		JButton btn_Open = new JButton("Open");
		btn_Open.setBounds( 0, 280, 100, 50);
		btn_Open.addActionListener(cmd.aLoad);
		this.add(btn_Open);
		
		JLabel labla_save= new JLabel("Save As");
		labla_save.setBounds( 0,350, 50, 25);
		this.add(labla_save);
		JComboBox formats = new JComboBox(cmd.aSave.getFormats());
		formats.setBounds( 50, 350, 50, 25);
		formats.setActionCommand("Formats");
		formats.addActionListener(cmd.aSave);
		this.add(formats);

		frame.add(this,BorderLayout.EAST);
	}

}
