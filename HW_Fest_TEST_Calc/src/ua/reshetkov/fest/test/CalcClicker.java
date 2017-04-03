package ua.reshetkov.fest.test;

import java.awt.Component;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.ComponentFinder;
import org.fest.swing.core.ComponentMatcher;
import org.fest.swing.core.Robot;
import org.junit.Assert;

public enum CalcClicker {
    INSTANCE;

    private Robot robot;
    private ComponentFinder finder;

    private CalcClicker() {
        robot = BasicRobot.robotWithCurrentAwtHierarchy();
        finder = robot.finder();
    }

    public void click(int digit) throws Exception {
        String numStr = Integer.toString(digit);
        System.out.println("click() : " + digit);
        for (int i = 0; i < numStr.length(); i++) {
            CaptionMatcher matcher = new CaptionMatcher(String.valueOf(numStr.charAt(i)));
            click(matcher);
        }
    }

    public void clear() throws Exception {
        CaptionMatcher matcher = new CaptionMatcher("C");
        click(matcher);
    }

    public void plus() throws Exception {
        CaptionMatcher matcher = new CaptionMatcher("+");
        click(matcher);
    }

    public void minus() throws Exception {
        CaptionMatcher matcher = new CaptionMatcher("-");
        click(matcher);
    }

    public void multiply() throws Exception {
        CaptionMatcher matcher = new CaptionMatcher("*");
        click(matcher);
    }

    public void divide() throws Exception {
        CaptionMatcher matcher = new CaptionMatcher("/");
        click(matcher);
    }
    
    public void result() throws Exception {
        CaptionMatcher matcher = new CaptionMatcher("=");
        click(matcher);
    }


    private void click(CaptionMatcher matcher) throws Exception {
        Component tmp = null;
        long start = System.currentTimeMillis();

        while (tmp == null) {
            try {
                tmp = finder.find(matcher);
                final Component btn = tmp;
                Executors.newSingleThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        ((JButton) btn).doClick();
                    }
                });

            } catch (Exception e) {
                //e.printStackTrace();
            }
            Thread.yield();
            if (System.currentTimeMillis() - start > 1000) {
                throw new Exception("text to be thrown");
            }

        }
        Thread.sleep(100);
    }

    public void checkIntValue(int value) throws Exception {
        DisplayLabelMatcher displayLblMatcher = new DisplayLabelMatcher();

        JLabel lbl = null;
        long start = System.currentTimeMillis();

        while (true) {
            try {
                lbl = (JLabel) finder.find(displayLblMatcher);
                Assert.assertEquals(String.valueOf(value), lbl.getText());
                break;

            } catch (Throwable e) {
                // e.printStackTrace();
            }
            Thread.yield();
            if (System.currentTimeMillis() - start > 1000) {
                throw new Exception("text to be thrown");
            }

        }



    }

    private class DisplayLabelMatcher implements ComponentMatcher {

        @Override
        public boolean matches(Component component) {
            if (component != null && component instanceof JLabel) {
                if ("displayLabel".equals(((JLabel) component).getName())) {
                    return true;
                }
            }
            return false;
        }

    }


    public ComponentFinder getFinder() {
        return finder;
    }



    private class CaptionMatcher implements ComponentMatcher {
        private String caption;

        public CaptionMatcher(String caption) {
            this.setCaption(caption);
        }

        @Override
        public boolean matches(Component comp) {
            if (comp != null && comp instanceof JButton) {
                if (caption.equals(((JButton) comp).getText())) {
                    return true;
                }
            }
            return false;
        }



        public void setCaption(String caption) {
            this.caption = caption;
        }

    }

}
