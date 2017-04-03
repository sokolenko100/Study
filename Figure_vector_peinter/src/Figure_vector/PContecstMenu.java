package Figure_vector;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

public class PContecstMenu extends JPanel
{
	JPopupMenu popup;
	PPanelDraw pPanelDraw= null;
	public PContecstMenu(PCommand cmd,PFrame frame,PPanelDraw pPanelDraw)
	{
		this.pPanelDraw=pPanelDraw;
		this.setVisible(true);
		
		this.add(pPanelDraw);
		popup = new JPopupMenu();
		
		
		JMenuItem btn1 = new JMenuItem("ColorChooser");
		btn1.addActionListener(cmd.aColor);
		this.add(btn1);
		JMenuItem btn4 = new JMenuItem("Width_2");
		btn4.addActionListener(cmd.aLine);
		this.add(btn4);
		JMenuItem btn5 = new JMenuItem("Width_4");
		btn5.addActionListener(cmd.aLine);
		this.add(btn5);
		JMenuItem btn6 = new JMenuItem("Width_6");
		btn6.addActionListener(cmd.aLine);
		this.add(btn6);
		
		
		
		popup.add(btn1);
		popup.add(btn4);
		popup.add(btn5);
		popup.add(btn6);
		this.add(popup);

		pPanelDraw.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent event)
			{
			if (SwingUtilities.isRightMouseButton(event))
					popup.show(pPanelDraw, event.getX(), event.getY());
			}
		});
		frame.add(this);
	}
}
