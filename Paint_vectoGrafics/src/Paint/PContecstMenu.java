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
		  JMenu viewMenu = new JMenu("���");
	        // ����-������
	        JCheckBoxMenuItem line  = new JCheckBoxMenuItem("�������");
	        JCheckBoxMenuItem grid  = new JCheckBoxMenuItem("�����");
	        JCheckBoxMenuItem navig = new JCheckBoxMenuItem("���������");
	        // ����-�������������
	        JRadioButtonMenuItem one = new JRadioButtonMenuItem("���� ��������");
	        JRadioButtonMenuItem two = new JRadioButtonMenuItem("��� ��������");
	        // ���������� ������������� � ���������� ������
	        ButtonGroup bg = new ButtonGroup();
	        bg.add(one);
	        bg.add(two);
	        // ������� ��� � ����
	        viewMenu.add(line);
	        viewMenu.add(grid);
	        viewMenu.add(navig);
	        // ����������� ����� ������� � ����
	        viewMenu.add( new JSeparator());
	        viewMenu.add(one);
	        viewMenu.add(two);

	        return viewMenu;
	}
}
