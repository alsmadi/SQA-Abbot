import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import junit.extensions.abbot.*;
import abbot.tester.*;
import abbot.finder.*;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class AbbotStudentExample extends ComponentTestFixture {
	// ComponentTestFixture extends TestCase

	private ComponentTester tester;

	protected void setUp() {
		tester = ComponentTester.getTester(BACFrameStudent.class);
		BACFrameStudent w = new BACFrameStudent();
		showWindow(w);
	}

	public void testComboBox() throws Exception {
		enterWeight("70");
		JComboBox Sara = (JComboBox) getFinder().find(
				new ComboBoxMatcher("Sara"));
		JComboBoxTester cbt = new JComboBoxTester();
		cbt.actionSelectItem(Sara, "10");
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

