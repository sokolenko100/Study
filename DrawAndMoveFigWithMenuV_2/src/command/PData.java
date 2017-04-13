package command;

import view.Figure;
import java.awt.Color;
import java.awt.Component;
import java.awt.KeyboardFocusManager;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.FPanelDraw;

public class PData 
{
	Color color = Color.black;
	int width =3;
	JOptionPane optionPane=null;
	JSlider slider =null;

	public PData() 
	{
		optionPane = new JOptionPane();
		slider = getSlider(optionPane);
	}
	public void SetType(int type)
	{
		Figure fig = null;
		Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();

		if(comp.getClass() == Figure.class)
		{
			fig = (Figure) comp;
		}
		if((fig != null) &&(type>0&&type<5))
		{
			fig.data.type = type;
			fig.repaint();
		}
	}
	public void SetColor()
	{
		Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
		color = JColorChooser.showDialog(null, "ColorChooser", Color.black);
		Figure fig = null;

		if(comp.getClass() == Figure.class)
		{
			fig = (Figure) comp;
		}
		if(fig != null)
		{
			fig.data.color = color;
			fig.repaint();
		}
	}
	public void SetWidth()
	{
		Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
		optionPane.setMessage(new Object[] { "Select a value: ", slider });
		optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
		optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
		optionPane.setFocusable(false);
		JDialog dialog = optionPane.createDialog(null, "My Slider");
		dialog.setFocusable(false);
		dialog.setVisible(true);
		Figure fig = null;


		if(comp.getClass() == Figure.class)
		{
			fig = (Figure) comp;
		}
		if(fig != null)
		{
			fig.data.stroke =(int)optionPane.getInputValue();
			fig.repaint();
		}
	}
	static JSlider getSlider(final JOptionPane optionPane) {
		JSlider slider = new JSlider();
		slider.setFocusable(false);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		ChangeListener changeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {
				JSlider theSlider = (JSlider) changeEvent.getSource();
				if (!theSlider.getValueIsAdjusting()) {
					optionPane.setInputValue(new Integer(theSlider.getValue()));
				}
			}
		};
		slider.addChangeListener(changeListener);
		return slider;
	}
}
