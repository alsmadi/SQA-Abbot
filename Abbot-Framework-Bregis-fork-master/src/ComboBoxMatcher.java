import java.awt.*;
import javax.swing.*;

import abbot.finder.Matcher;

public class ComboBoxMatcher implements Matcher {

	private String name;
	public ComboBoxMatcher(String n) {
		name = n;
	}

	public boolean matches(Component c) {
		if (!(c instanceof JComboBox))
			return false;
		Container parent = c.getParent();
		if (!(parent instanceof JPanel))
			return false;
		JPanel panel = (JPanel) parent;
		Component[] carray = panel.getComponents();
		for (int i = 0; i < carray.length; i++) {
			if (!(carray[i] instanceof JLabel))
				continue;
			JLabel label = (JLabel) carray[i];
			if (label.getText().equals(name))
				return true;
			else
				return false;
		}
		return false;
	}
}