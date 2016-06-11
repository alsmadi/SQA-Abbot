class Student
{
   private String name;
   private double grade;
   private double bonusRatio;

   Student (String name, double grade, double bonusRatio)
   {
      this.name = name;
      this.grade = grade;
      this.bonusRatio = bonusRatio;
   }

   public void setSize(double d) { grade = d; }
   public void setbonusRatio (double d) { bonusRatio  = d; }
   public String getName() { return name; }
   public double getgrade() { return grade; }
   public double getbonusRatio() { return bonusRatio; }
   public double getFinalGrade() { return grade+ bonusRatio; }

   public static void setGrade(Student[] d, String name, double grade)
   {
      for (int i = 0; i < d.length; ++i)
      {
         if (d[i].getName().equals(name))
         {
            d[i].setSize(grade);
            break;
         }
      }
   }
}