import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import junit.extensions.abbot.*;
import abbot.tester.*;
import abbot.finder.*;

public class AbbotDrinkExample extends ComponentTestFixture {
	// ComponentTestFixture extends TestCase

	private ComponentTester tester;

	protected void setUp() {
		tester = ComponentTester.getTester(BACFrameDrink.class);
		BACFrameDrink w = new BACFrameDrink();
		showWindow(w);
	}

	public void testComboBox() throws Exception {
		enterWeight("70");
		JComboBox beer = (JComboBox) getFinder().find(
				new ComboBoxMatcher("Beer"));
		JComboBoxTester cbt = new JComboBoxTester();
		cbt.actionSelectItem(beer, "10");
		assertTrue(clickSubmit().indexOf("Too much alcohol") > -1);
	}

	public void testZeroDrink() throws Exception {
		enterWeight("80");
		assertEquals(clickSubmit(), "<html><font face=sanserif>Your BAC"
				+ " is <font size=+1>0.0<font size=-1>" + "<br>OK to drive!");
	}

	private void enterWeight(String s) throws Exception {
		JTextField weightTextField = (JTextField) getFinder().find(
				new WeightTextFieldMatcher());
		tester.actionClick(weightTextField);
		tester.keyString(s);
	}

	public static void main(String[] args) {
		TestHelper.runTests(args, AbbotDrinkExample.class);
	}

	private String clickSubmit() throws Exception {
		JButton submitButton = (JButton) getFinder().find(new Matcher() {
			public boolean matches(Component c) {
				return c instanceof JButton
						&& ((JButton) c).getText().equals("Submit");
			}
		});
		tester.actionClick(submitButton);
		JDialog dialog = (JDialog) getFinder().find(new Matcher() {
			public boolean matches(Component c) {
				return c instanceof JDialog
						&& ((JDialog) c).getTitle().equals(
								"Blood Alcohol " + "Concentration");
			}
		});
        JLabel label = (JLabel) getFinder().find(dialog, new Matcher() {
			public boolean matches(Component c) {
				return c instanceof JLabel && ((JLabel) c).getText() != null;
			}
		});
        return label.getText();
	}
}

class WeightTextFieldMatcher implements Matcher {
	public boolean matches(Component c) {
		if (!(c instanceof JTextField))
			return false;
		Container parent = c.getParent();
		if (!(parent instanceof JPanel))
			return false;
		JPanel panel = (JPanel) parent;
		Border border = panel.getBorder();
		if (!(border instanceof TitledBorder))
			return false;
		TitledBorder tb = (TitledBorder) border;
		String title = tb.getTitle();
		if (!(title.equals("Weight")))
			return false;
		return true;
	}
}