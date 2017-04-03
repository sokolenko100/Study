package x_and_o;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GameSettingsForm extends JFrame {
    GameSettingsForm gameSettingsForm = this;
    public GameSettingsForm() {
        setTitle("РќР°СЃС‚СЂРѕР№РєРё РёРіСЂС‹");
        setBounds(450, 450, 240, 190);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JLabel jLabelMode = new JLabel("Р’С‹Р±РµСЂРµС‚Рµ СЂРµР¶РёРј РёРіСЂС‹:");
        add(jLabelMode);
        JRadioButton radioButtonModeTwoPlayers = new JRadioButton("Р�РіСЂРѕРє РїСЂРѕС‚РёРІ РёРіСЂРѕРєР°");
        add(radioButtonModeTwoPlayers);
        radioButtonModeTwoPlayers.setSelected(true);
        JRadioButton radioButtonModeAgainstAI = new JRadioButton("Р�РіСЂРѕРє РїСЂРѕС‚РёРІ РєРѕРјРїСЊСЋС‚РµСЂР°");
        add(radioButtonModeAgainstAI);
        JLabel jLabelAILevel = new JLabel("Р’С‹Р±РµСЂРµС‚Рµ СѓСЂРѕРІРµРЅСЊ AI:");
        add(jLabelAILevel);
        JSlider jSlider = new JSlider(0,2,0);
        add(jSlider);
        jSlider.setAlignmentX(LEFT_ALIGNMENT);
        jSlider.setVisible(false);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonModeTwoPlayers);
        buttonGroup.add(radioButtonModeAgainstAI);
        JLabel jLabelLinesCount = new JLabel("Р Р°Р·РјРµСЂ РїРѕР»СЏ (РїРѕ СѓРјРѕР»С‡Р°РЅРёСЋ 3 РЅР° 3): ");
        add(jLabelLinesCount);
        JTextField jTextFieldLinesCount = new JTextField();
        jTextFieldLinesCount.setMaximumSize(new Dimension(100, 20));
        add(jTextFieldLinesCount);
        JButton jButtonSetSettings = new JButton("РќР°С‡Р°С‚СЊ РёРіСЂСѓ!");
        add(jButtonSetSettings);
        setVisible(true);

        radioButtonModeAgainstAI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButtonModeAgainstAI.isSelected()) {
                    jSlider.setVisible(true);
                }
            }
        });

        radioButtonModeTwoPlayers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButtonModeTwoPlayers.isSelected()) {
                    jSlider.setVisible(false);
                }
            }
        });

        jButtonSetSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGameField gameField = MainGameField.getInstance();
                if (jTextFieldLinesCount.getText().isEmpty()) {
                    gameField.linesCount = 3;
                }
                else {
                    try {
                        gameField.linesCount = Integer.parseInt(jTextFieldLinesCount.getText());
                    }
                    catch (NumberFormatException ex) {
                        System.out.println("РќРµРѕР±С…РѕРґРёРјРѕ РІРІРµСЃС‚Рё С†РµР»РѕРµ С‡РёСЃР»Рѕ!");
                    }
                }
                gameField.startNewGame();
                if (radioButtonModeAgainstAI.isSelected()) {
                    gameField.gameMode = 2;
                }
                gameField.aiLevel = jSlider.getValue();
                gameSettingsForm.setVisible(false);
            }
        });
    }
}
