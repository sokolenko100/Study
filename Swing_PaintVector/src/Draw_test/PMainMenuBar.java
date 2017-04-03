package Draw_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class PMainMenuBar  extends JMenuBar
{
	JMenu menu, submenu;
	JMenuItem menuItem;
	JRadioButtonMenuItem rbMenuItem;
	JCheckBoxMenuItem cbMenuItem;

	public PMainMenuBar(PCommand cmd)
	{
		JMenu	menu = new JMenu("File");
		this.add(menu);

		//a group of JMenuItems
		JMenuItem menuItemLoad = new JMenuItem("Load",new ImageIcon("src/icon/upload.png"));
	//	menuItemLoad.addActionListener(l);
		menu.add(menuItemLoad);

		JMenuItem menuItemSave = new JMenuItem("Save",
		                         new ImageIcon("src/icon/bolt.png"));
		//	menuItemSave.addActionListener(l);
		menu.add(menuItemSave);

		menu.addSeparator();
		
		//a Widthmenu
		JMenu	menuWidth = new JMenu("Width");
		
		JMenuItem menuItemWidth_2 = new JMenuItem("Width_2", new ImageIcon("src/icon/windy.png"));
		menuItemLoad.addActionListener(cmd.aLine);
		menuWidth.add(menuItemWidth_2);

		JMenuItem menuItemWidth_4 = new JMenuItem("Width_4", new ImageIcon("src/icon/windy.png"));
		menuItemLoad.addActionListener(cmd.aLine);
		menuWidth.add(menuItemWidth_4);

		JMenuItem menuItemWidth_6 = new JMenuItem("Width_6", new ImageIcon("src/icon/windy.png"));
		menuItemLoad.addActionListener(cmd.aLine);
		menuWidth.add(menuItemWidth_6);

		menu.add(menuWidth);
		
		
		//a menuColor
		menu.addSeparator();
		JMenu	menuColor= new JMenu("Color");
		
		JMenuItem menuItemRed = new JMenuItem("Red", new ImageIcon("src/icon/art.png"));
	//	menuItemLoad.addActionListener(l);
		menuColor.add(menuItemRed);

		JMenuItem menuItemGreen = new JMenuItem("Green", new ImageIcon("src/icon/art.png"));
	//	menuItemLoad.addActionListener(l);
		menuColor.add(menuItemGreen);

		JMenuItem menuItemYellow = new JMenuItem("Yellow", new ImageIcon("src/icon/art.png"));
	//	menuItemLoad.addActionListener(l);
		menuColor.add(menuItemYellow);
		
		menu.add(menuColor);
		//a menuExit
		menu.addSeparator();
		JMenuItem exit= new JMenuItem("Exit", new ImageIcon("src/icon/x.png"));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			System.exit(0);
			}
			});
		menu.add(exit);
	
		this.setVisible(true);
	}
}
