/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import junit.extensions.abbot.*;
import abbot.tester.*;
import abbot.finder.*;
import java.awt.*;


/**
 *
 * @author IAlsmadi
 */
public class GUI_Test1 extends ComponentTestFixture {
    
    public GUI_Test1() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    private ComponentTester tester;

	protected void setUp() {
		tester = ComponentTester.getTester(BACFrameStudent.class);
		BACFrameStudent w = new BACFrameStudent();
		showWindow(w);
	}
    @Before
   
    
    @After
    public void tearDown() {
    }
public void test1() {
        JButton b1 = new JButton("Button 1");
        b1.setEnabled(false);
        
        assertEquals("Button 1", b1.getText());
        
    }

public void test2(){
    JMenuBar menuBar= new JMenuBar();
    JMenuItem item1 = new JMenuItem();
        JMenuItem item2 = new JMenuItem();
        JMenuItem item3 = new JMenuItem();
        menuBar.add(item1);
        menuBar.add(item2);
        assertEquals(0, menuBar.getComponentIndex(item1));
        assertEquals(1, menuBar.getComponentIndex(item2));
        assertEquals(-1, menuBar.getComponentIndex(item3));
}

public void test3(){
    JRadioButton radio = new JRadioButton("yes");
	assertTrue(radio.isShowing());
	radio.doClick();
	assertTrue(radio.isSelected());
	
}

public void test4(){
    String testString = "test string";
	JTextField tf =new JTextField(testString);
        assertEquals(tf.getText(),"test string");
}
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
/*    
    private int count = 0;
public void testRepeatedFire() {
ArrowButton arrow = new ArrowButton(0,0,0);
ActionListener al = new ActionListener() {
  public void actionPerformed(ActionEvent ev) {
  ++count;
  }
  };
  arrow.addActionListener(al);
  showFrame(arrow);
  Dimension size = arrow.getSize();
  // Hold the button down for 5 seconds
  tester.mousePress(arrow);
  tester.actionDelay(5000);
  tester.mouseRelease();
  assertTrue("Didn't get any repeated events", count > 1);
  }

*/
   /*     //@Test
        public void test1(){
          JTextField textField = BACFrameStudent.findByName("myTextField", JTextField.class);
  abbotFixture.robot.focus(textField);
  ComponentTester tester = ComponentTester.getTester(textField);
  tester.actionKeyString("someText");
  textField.selectAll();
  // do something with textField
  assertTrue(Strings.isEmpty(textField.getText()));   
        } */

}
