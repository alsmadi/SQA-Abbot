/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import junit.extensions.abbot.ComponentTestFixture;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IAlsmadi
 */
public class GUI_Test extends ComponentTestFixture {
    
    public GUI_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    public void test1() {
        JButton b1 = new JButton("Button 1 (disabled)");
        b1.setEnabled(false);
        JButton b2 = new JButton("Button 2 (enabled)");
        JPanel pane = new JPanel();
        pane.setBorder(new TitledBorder(getName() + "enabled"));
        pane.add(b1);
        pane.add(b2);
        JPanel pane2 = new JPanel();
        pane2.setBorder(new TitledBorder(getName() + "disabled"));
        pane2.setEnabled(false);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(pane, BorderLayout.NORTH);
        content.add(pane2);

        Frame frame = showFrame(content);

      //  java.util.List list = AWT.disableHierarchy(frame);
        assertTrue("1st pane is enabled", pane.isEnabled());
        
    }
    public void test2() {
        JButton b1 = new JButton("Button 1 (disabled)");
        b1.setEnabled(false);
        JButton b2 = new JButton("Button 2 (enabled)");
        JPanel pane = new JPanel();
        pane.setBorder(new TitledBorder(getName() + "enabled"));
        pane.add(b1);
        pane.add(b2);
        JPanel pane2 = new JPanel();
        pane2.setBorder(new TitledBorder(getName() + "disabled"));
        pane2.setEnabled(false);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(pane, BorderLayout.NORTH);
        content.add(pane2);

        Frame frame = showFrame(content);

     
        assertTrue("2nd pane should be disabled", !pane2.isEnabled());
       
    }
    public void test3() {
        JButton b1 = new JButton("Button 1 (disabled)");
        b1.setEnabled(false);
        JButton b2 = new JButton("Button 2 (enabled)");
        JPanel pane = new JPanel();
        pane.setBorder(new TitledBorder(getName() + "enabled"));
        pane.add(b1);
        pane.add(b2);
        JPanel pane2 = new JPanel();
        pane2.setBorder(new TitledBorder(getName() + "disabled"));
        pane2.setEnabled(false);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(pane, BorderLayout.NORTH);
        content.add(pane2);

        Frame frame = showFrame(content);

      
        assertTrue("frame should be re-enabled", frame.isEnabled());
    }
    public void test4() {
        JButton b1 = new JButton("Button 1 (disabled)");
        b1.setEnabled(false);
        JButton b2 = new JButton("Button 2 (enabled)");
        JPanel pane = new JPanel();
        pane.setBorder(new TitledBorder(getName() + "enabled"));
        pane.add(b1);
        pane.add(b2);
        JPanel pane2 = new JPanel();
        pane2.setBorder(new TitledBorder(getName() + "disabled"));
        pane2.setEnabled(false);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(pane, BorderLayout.NORTH);
        content.add(pane2);

        Frame frame = showFrame(content);

     
        assertTrue("content should be disabled", !content.isEnabled());
        
    }
public void test5() {
        JButton b1 = new JButton("Button 1 (disabled)");
        b1.setEnabled(false);
        JButton b2 = new JButton("Button 2 (enabled)");
        JPanel pane = new JPanel();
        pane.setBorder(new TitledBorder(getName() + "enabled"));
        pane.add(b1);
        pane.add(b2);
        JPanel pane2 = new JPanel();
        pane2.setBorder(new TitledBorder(getName() + "disabled"));
        pane2.setEnabled(false);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(pane, BorderLayout.NORTH);
        content.add(pane2);

        Frame frame = showFrame(content);

      
        assertTrue("1st button should be disabled", !b1.isEnabled());
        assertTrue("2nd button should be disabled", !b2.isEnabled());
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
