package Paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorChoiser extends JPanel implements ChangeListener 
{
	protected JColorChooser tcc;
	protected JLabel banner;

	public ColorChoiser() 
	{
		super(new BorderLayout());

		//Set up the banner at the top of the window
		banner = new JLabel("Welcome to the Tutorial Zone!",
				JLabel.CENTER);
		banner.setForeground(Color.yellow);
		banner.setBackground(Color.blue);
		banner.setOpaque(true);
		banner.setFont(new Font("SansSerif", Font.BOLD, 24));
		banner.setPreferredSize(new Dimension(100, 65));

		JPanel bannerPanel = new JPanel(new BorderLayout());
		bannerPanel.add(banner, BorderLayout.CENTER);
		bannerPanel.setBorder(BorderFactory.createTitledBorder("Banner"));

		//Set up color chooser for setting text color
		tcc = new JColorChooser(banner.getForeground());
		tcc.getSelectionModel().addChangeListener(this);
		tcc.setBorder(BorderFactory.createTitledBorder(
				"Choose Text Color"));

		add(bannerPanel, BorderLayout.CENTER);
		add(tcc, BorderLayout.PAGE_END);
	}

	public void stateChanged(ChangeEvent e)
	{
		Color newColor = tcc.getColor();
		banner.setForeground(newColor);
	}

}
