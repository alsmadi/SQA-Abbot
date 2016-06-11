/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
//import src.WholeNumberField;

//import com.elharo.swing.WholeNumberField;

import abbot.tester.ComponentTester;
import junit.extensions.abbot.ComponentTestFixture;

public class WholeNumberFieldTest extends ComponentTestFixture {

    private ComponentTester tester;
    private WholeNumberField field;
    
    protected void setUp() {
        tester = ComponentTester.getTester(WholeNumberField.class);
        field = new WholeNumberField();
        showFrame(field);
    }
    
    public void testOne() {
        tester.actionKeyString(field, "1");
        int result = field.getNumberValue();
        assertEquals(1, result);
    }
    
}