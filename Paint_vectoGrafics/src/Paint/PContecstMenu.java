package Paint;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;

public class PContecstMenu extends JMenu
{
	public PContecstMenu()
	{
	//	this.setBounds(0, 0, 750, 38);
	//	this.setBackground(Color.cyan);
	//	this.setLayout(null);
		this.setVisible(true);
		startPContecstMenu();
	}
	public  JMenu startPContecstMenu()
	{
		  JMenu viewMenu = new JMenu("Вид");
	        // меню-флажки
	        JCheckBoxMenuItem line  = new JCheckBoxMenuItem("Линейка");
	        JCheckBoxMenuItem grid  = new JCheckBoxMenuItem("Сетка");
	        JCheckBoxMenuItem navig = new JCheckBoxMenuItem("Навигация");
	        // меню-переключатели
	        JRadioButtonMenuItem one = new JRadioButtonMenuItem("Одна страница");
	        JRadioButtonMenuItem two = new JRadioButtonMenuItem("Две страницы");
	        // организуем переключатели в логическую группу
	        ButtonGroup bg = new ButtonGroup();
	        bg.add(one);
	        bg.add(two);
	        // добавим все в меню
	        viewMenu.add(line);
	        viewMenu.add(grid);
	        viewMenu.add(navig);
	        // разделитель можно создать и явно
	        viewMenu.add( new JSeparator());
	        viewMenu.add(one);
	        viewMenu.add(two);

	        return viewMenu;
	}
}
