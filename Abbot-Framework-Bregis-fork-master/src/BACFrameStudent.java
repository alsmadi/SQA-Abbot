import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class BACFrameStudent extends JFrame implements ActionListener
{
   // -----------------------------------------------------------------
   // declare variables and components accessed by more than one method
   // -----------------------------------------------------------------

   final double DEFAULT_BAC_LIMIT = 75;  // Class average

   final String[] Student_NAMES = { "Mark", "Ali", "Sara", "James", "Farrah" };
   final double[] STUDENT_GRADES = { 70, 80, 86, 92, 67 };
   final double[] STUDENTs_FINAL_GRADES = { 73, 83, 89, 95, 70 }; 
   final int NUMBER_OF_STUDENTS = Student_NAMES.length;
   final int Highest = 2; // index of biggest drink name

   private double bacLimit; 
   private Student[] SQA = new Student[NUMBER_OF_STUDENTS];

   private JTextField name;
   private JRadioButton male;
   private JRadioButton female;
   private JTextField weight;
   private JRadioButton kilograms;
   private JRadioButton pounds;
   private JRadioButton defaultBAC;
   private JRadioButton otherBAC;
   private JTextField otherValue;
   private JComboBox hours;
   private JComboBox minutes;
   private JButton submit;
   private JButton changeStudentGrades;
   private JComboBox[] students;
   private JLabel[] studentLabels;

   // -----------
   // constructor
   // -----------

   public BACFrameStudent()
   {
      // --------------------------------------
      // declare and initialize local variables
      // --------------------------------------

      // initialize array of drinks 'on tap'

      for (int i = 0; i < NUMBER_OF_STUDENTS; ++i)
      {
         SQA[i] = new Student(
            Student_NAMES[i],
            STUDENT_GRADES[i],
            STUDENTs_FINAL_GRADES[i]
         );
      }

      // declare some arrays for the combo boxes

      final String[] studentArray = { "50", "71", "62", "73", "48", "95", "56",
         "70", "80", "90", "65", "50", "71", "62", "73", "48", "95", "56",
         "70", "82", "90", "65","77" };
    //  final String[] hourArray = { "0", "1", "2", "3", "4", "5", "6",
      //   "7", "8", "9", "10", "11", "12" };
      //final String[] minuteArray = { "0", "5", "10", "15", "20", "25",
       //  "30", "35", "49", "50", "55" };

      // -------------------------------
      // create and configure components
      // -------------------------------

      JLabel banner =
         new JLabel(new ImageIcon("BACBanner.gif"), SwingConstants.CENTER);
      banner.setAlignmentX(Component.CENTER_ALIGNMENT);

      name = new JTextField(10);
      name.setMargin(new Insets(0, 3, 0, 0));
      name.setMaximumSize(name.getPreferredSize());

      male = new JRadioButton("Male");
      female = new JRadioButton("Female");

      ButtonGroup genderGroup = new ButtonGroup();
      genderGroup.add(male);
      genderGroup.add(female);
      male.setSelected(true);

      weight = new JTextField();
      weight.setMargin(new Insets(0, 3, 0, 0));

      kilograms = new JRadioButton("Kilograms");
      pounds = new JRadioButton("Pounds");

      ButtonGroup unitGroup = new ButtonGroup();
      unitGroup.add(kilograms);
      unitGroup.add(pounds);
      kilograms.setSelected(true);

      defaultBAC = new JRadioButton("Default (0.080)");
      defaultBAC.setAlignmentX(Component.LEFT_ALIGNMENT);
      otherBAC = new JRadioButton("Other");

      ButtonGroup legalLimitGroup = new ButtonGroup();
      legalLimitGroup.add(defaultBAC);
      legalLimitGroup.add(otherBAC);
      defaultBAC.setSelected(true);

      otherValue = new JTextField(5);
      otherValue.setMaximumSize(otherValue.getPreferredSize());
      otherValue.setMargin(new Insets(0, 3, 0, 0));

      students = new JComboBox[Student_NAMES.length];
      studentLabels = new JLabel[Student_NAMES.length];

      for (int i = 0; i < NUMBER_OF_STUDENTS; ++i)
      {
         students[i] = new JComboBox(studentArray);
         students[i].setMaximumSize(students[i].getPreferredSize());
         studentLabels[i] = new JLabel(Student_NAMES[i], SwingConstants.RIGHT);
      }

      // make all drink labels the same size

      for (int i = 0; i < NUMBER_OF_STUDENTS; ++i)
      {
         studentLabels[i].setPreferredSize(studentLabels[Highest].getPreferredSize());
         studentLabels[i].setMaximumSize(studentLabels[Highest].getPreferredSize());
      }
      studentLabels[Highest].setMaximumSize(studentLabels[Highest].getPreferredSize());

    //  hours = new JComboBox(hourArray);
//      hours.setMaximumSize(hours.getPreferredSize());
    //  minutes = new JComboBox(minuteArray);
  //    minutes.setMaximumSize(hours.getPreferredSize());

      changeStudentGrades = new JButton("Student Grades");
      changeStudentGrades.setAlignmentX(Component.CENTER_ALIGNMENT);
      Dimension d = students[0].getPreferredSize();
      Dimension d2 = changeStudentGrades.getPreferredSize();
      changeStudentGrades.setPreferredSize(new Dimension(d2.width, d.height));
      int maxWidth =
         students[Highest].getMaximumSize().width +
         studentLabels[Highest].getMaximumSize().width + 3;
      changeStudentGrades.setMaximumSize(new Dimension(maxWidth, d.height));

      submit = new JButton("Submit");

      // -------------
      // add listeners
      // -------------

      submit.addActionListener(this);  // do all the work here
      changeStudentGrades.addActionListener(this);

      // ------------------
      // arrange components
      // ------------------

      JPanel namePanel = new JPanel();
      namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
      namePanel.add(name);
      namePanel.setBorder(new TitledBorder(new EtchedBorder(), "Name (optional)"));

      JPanel genderPanel = new JPanel();
      genderPanel.setLayout(new BoxLayout(genderPanel, BoxLayout.Y_AXIS));
      genderPanel.add(male);
      genderPanel.add(female);
      genderPanel.setBorder(new TitledBorder(new EtchedBorder(), "Gender"));

      JPanel weightPanel = new JPanel();
      weightPanel.setLayout(new BoxLayout(weightPanel, BoxLayout.Y_AXIS));
      weightPanel.add(weight);
      weightPanel.add(kilograms);
      weightPanel.add(pounds);
      weightPanel.setBorder(new TitledBorder(new EtchedBorder(), "Weight"));

      d = weightPanel.getPreferredSize();
      d2 = namePanel.getPreferredSize();
      namePanel.setMaximumSize(new Dimension(d2.width, d.height));
      d2 = genderPanel.getPreferredSize();
      genderPanel.setMaximumSize(new Dimension(d2.width, d.height));
      weightPanel.setMaximumSize(d);

      JPanel userPanel = new JPanel();
      userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.X_AXIS));
      userPanel.add(Box.createRigidArea(new Dimension(10, 0)));
      userPanel.add(namePanel);
      userPanel.add(Box.createRigidArea(new Dimension(10, 0)));
      userPanel.add(genderPanel);
      userPanel.add(Box.createRigidArea(new Dimension(10, 0)));
      userPanel.add(weightPanel);
      userPanel.add(Box.createRigidArea(new Dimension(10, 0)));
      userPanel.setBorder(new TitledBorder(new EtchedBorder(), "User Information"));

      JPanel studentsPanel1 = new JPanel();
      studentsPanel1.setLayout(new BoxLayout(studentsPanel1, BoxLayout.Y_AXIS));
      JPanel[] tmp = new JPanel[NUMBER_OF_STUDENTS];
      for (int i = 0; i <= NUMBER_OF_STUDENTS / 2; ++i)
      {
         tmp[i] = new JPanel();
         tmp[i].setLayout(new BoxLayout(tmp[i], BoxLayout.X_AXIS));
         tmp[i].add(Box.createRigidArea(new Dimension(10, 0)));
         tmp[i].add(studentLabels[i]);
         tmp[i].add(Box.createRigidArea(new Dimension(3, 0)));
         tmp[i].add(students[i]);
         tmp[i].add(Box.createRigidArea(new Dimension(10, 0)));
         studentsPanel1.add(tmp[i]);
         studentsPanel1.add(Box.createRigidArea(new Dimension(0, 6)));
      }

      JPanel studentsPanel2 = new JPanel();
      studentsPanel2.setLayout(new BoxLayout(studentsPanel2, BoxLayout.Y_AXIS));
      for (int i = NUMBER_OF_STUDENTS / 2 + 1; i < NUMBER_OF_STUDENTS; ++i)
      {
         tmp[i] = new JPanel();
         tmp[i].setLayout(new BoxLayout(tmp[i], BoxLayout.X_AXIS));
         tmp[i].add(Box.createRigidArea(new Dimension(10, 0)));
         tmp[i].add(studentLabels[i]);
         tmp[i].add(Box.createRigidArea(new Dimension(3, 0)));
         tmp[i].add(students[i]);
         tmp[i].add(Box.createRigidArea(new Dimension(10, 0)));
         studentsPanel2.add(tmp[i]);
         studentsPanel2.add(Box.createRigidArea(new Dimension(0, 6)));
      }
      tmp[0] = new JPanel();
      tmp[0].setLayout(new BoxLayout(tmp[0], BoxLayout.X_AXIS));
      tmp[0].add(changeStudentGrades);
      studentsPanel2.add(tmp[0]);
      studentsPanel2.add(Box.createRigidArea(new Dimension(0, 6)));

      JPanel studentsPanel = new JPanel();
      studentsPanel.setLayout(new BoxLayout(studentsPanel, BoxLayout.X_AXIS));
      studentsPanel.add(studentsPanel1);
      studentsPanel.add(studentsPanel2);
      studentsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Grades calculated"));
      studentsPanel.setAlignmentY(Component.TOP_ALIGNMENT);

/*      JPanel timePanel = new JPanel();
      timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.X_AXIS));
      timePanel.add(Box.createRigidArea(new Dimension(10, 0)));
      timePanel.add(hours);
      timePanel.add(new JLabel("Hr"));
      timePanel.add(Box.createRigidArea(new Dimension(10, 0)));
      timePanel.add(minutes);
      timePanel.add(new JLabel("Min"));
      timePanel.add(Box.createRigidArea(new Dimension(10, 0)));
      timePanel.setBorder(new TitledBorder(new EtchedBorder(), "Time since last posted grade"));
      timePanel.setAlignmentY(Component.TOP_ALIGNMENT);
*/
      JPanel inputPanel = new JPanel();
      inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
      inputPanel.add(Box.createRigidArea(new Dimension(10, 0)));
      inputPanel.add(studentsPanel);
      inputPanel.add(Box.createRigidArea(new Dimension(10, 0)));
   //   inputPanel.add(timePanel);
      inputPanel.add(Box.createRigidArea(new Dimension(10, 0)));
      inputPanel.setBorder(new TitledBorder(new EtchedBorder(), "Student Information"));

      JPanel submitPanel = new JPanel();
      submitPanel.add(submit);
      submitPanel.setBorder(new TitledBorder(new EtchedBorder(),
         "Click below to calculate your total grade"));

      JPanel otherPanel = new JPanel();
      otherPanel.setLayout(new BoxLayout(otherPanel, BoxLayout.X_AXIS));
      otherPanel.add(otherBAC);
      otherPanel.add(otherValue);
      otherPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

      JPanel BACPanel = new JPanel();
      BACPanel.setLayout(new BoxLayout(BACPanel, BoxLayout.Y_AXIS));
      BACPanel.add(defaultBAC);
      BACPanel.add(otherPanel);
      BACPanel.setBorder(new TitledBorder(new EtchedBorder(), "Passing grade"));

      d = userPanel.getMaximumSize();
      d2 = BACPanel.getPreferredSize();
      BACPanel.setMaximumSize(new Dimension(d2.width, d.height));

      JPanel topPanel = new JPanel();
      topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
      topPanel.add(userPanel);
      topPanel.add(BACPanel);

      // set panel sizes

      d = topPanel.getPreferredSize();  // widest panel rules!
      int panelWidth = d.width;
      topPanel.setMaximumSize(new Dimension(panelWidth, d.height));

      d = inputPanel.getPreferredSize();
      inputPanel.setMaximumSize(new Dimension(panelWidth, d.height));
      inputPanel.setPreferredSize(new Dimension(panelWidth, d.height));

      d = submitPanel.getPreferredSize();
      submitPanel.setMaximumSize(new Dimension(panelWidth, d.height));
      submitPanel.setPreferredSize(new Dimension(panelWidth, d.height));

      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      panel.add(banner);
      panel.add(Box.createRigidArea(new Dimension(0, 10)));
      panel.add(topPanel);
      panel.add(Box.createRigidArea(new Dimension(0, 10)));
      panel.add(inputPanel);
      panel.add(Box.createRigidArea(new Dimension(0, 10)));
      panel.add(submitPanel);
      panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

      // make the panel this extended JFrame's content pane

      this.setContentPane(panel);
   }

   // -------------------------------
   // implement ActionListener method
   // -------------------------------

   public void actionPerformed(ActionEvent ae)
   {
      Object source = ae.getSource();

      if (source == changeStudentGrades)
      {
         double newSize = 0.0;

         // build an html string containing the current drink sizes

         String current = "";
         for (int i = 0; i < NUMBER_OF_STUDENTS; ++i)
            current += "&nbsp;&nbsp;&nbsp;" + SQA[i].getName() +
            " = " + SQA[i].getgrade()+ " oz<br>";

         String choice = (String)JOptionPane.showInputDialog(
            this,
            "<html><font face=sanserif>" +
            "Current student gardes:<br>" +
            current + "<br>" +
            "Change grade of which student?",
            "Change Student Grade", JOptionPane.PLAIN_MESSAGE, null,
            Student_NAMES, Student_NAMES[0]
         );

         if (choice != null)
         {
            String tmp = (String)JOptionPane.showInputDialog(
               this, "Enter the new student grade (oz) for \'" + choice + "\'"
            );
            if (tmp != null)
            {
               try
               {
                  newSize = Double.parseDouble(tmp);
               } catch (NumberFormatException nfe)
               {
                  Toolkit.getDefaultToolkit().beep();
                  JOptionPane.showMessageDialog(this,
                     "Invalid drink size",
                     "Error", JOptionPane.ERROR_MESSAGE);
                  return;             
               }
               Student.setGrade(SQA, choice, newSize);
            }
         }
         return;
      }                           

      // if reached here, must be 'Submit' button

      // determine legal BAC limit

      if (defaultBAC.isSelected())
         bacLimit = DEFAULT_BAC_LIMIT;
      else
      {
         try
         {
            bacLimit = Double.parseDouble(otherValue.getText());
         }
         catch (NumberFormatException nfe)
         {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this,
               "Invalid BAC limit",
               "Error", JOptionPane.ERROR_MESSAGE);
            return;             
         }
      }

      // get TBW (total body water volume)

      double tbw;
      if (male.isSelected())
         tbw = 0.58;
      else
         tbw = 0.49;

      // get body weight in kilograms

      double kilos = 0.0;
      try
      {
         kilos = Double.parseDouble(weight.getText());
      }
      catch (NumberFormatException nfe)
      {
         Toolkit.getDefaultToolkit().beep();
         JOptionPane.showMessageDialog(this,
            "Please enter your weight!",
            "Error", JOptionPane.ERROR_MESSAGE);
         return;
      }
      if (pounds.isSelected())
         kilos /= 2.2046; // pounds-to-kilograms conversion factor

      // get time since drinking (hours)

      double t = Integer.parseInt((String)hours.getSelectedItem()) +
                 Integer.parseInt((String)minutes.getSelectedItem()) / 60.0;

      // get total ounces of alcohol

      double grade = 0.0;
      for (int i = 0; i < NUMBER_OF_STUDENTS; ++i)
         grade +=
            Integer.parseInt((String)students[i].getSelectedItem()) *
            SQA[i].getFinalGrade();
            
      // compute BAC (blood alcohol concentration)

    
      if (grade < 50.0) grade = 50.0;

      // determine if BAC is too high

      boolean MoreThanAverage = grade > bacLimit ? true : false;

      // determine time to wait before driving (used if BAC too high)

   //   double timeToWait = (x - bacLimit) / 0.012 - t;  

      // build output message (use html codes to format)

      String message = "<html><font face=sanserif>";
      if (name.getText().length() > 0)
         message += name.getText() + ", your ";
      else
         message += "Your ";
      message += "BAC is <font size=+1>" + grade +
         "<font size=-1><br>";
      if (MoreThanAverage)
         message += "<font color=red size=+1>" +
                    "Your grade is more than average!<br>" ;
      else
         message += "Work on improving your grade";

      // OK, we're done!  Output the message, as appropriate.

      if (!MoreThanAverage)
      {
         Toolkit.getDefaultToolkit().beep();
         JOptionPane.showMessageDialog(this, message,
            "You need to improve your grade",
            JOptionPane.WARNING_MESSAGE);
      }
      else
      {
         JOptionPane.showMessageDialog(this, message,
            "Your grade is..",
             JOptionPane.INFORMATION_MESSAGE);
      }
   }
}