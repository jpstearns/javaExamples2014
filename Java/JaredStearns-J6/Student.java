/**
*@author		 Jared Stearns <jared.patrick.stearns@gmail.com>
*@assignment Assignment# Java5-phaseTwo
*@version	 7.0
*@since		 2014-07-03
*

This Class will represent a student in an educational institution
*/
import javax.swing.JOptionPane;
public class Student
{
    private String name;
    private int grade;

	/**
		One Paramater Constructor to intialize the student
		@param newName the name of the student
	*/
    public Student( String newName )
    {
		grade = 0;			//Initialize Grade to 0
      name = newName;	//Set name = to newName
    }
	/**
		Two Paramater Constructor to build the student
		@param newName the name of the student
		@param newGrade the student's grade
	*/
    public Student(String newName, int newGrade )
    {
		setGrade(newGrade);
		name = newName;
    }
	/**
		Mutator Mehtod setGrade to assign a value to Grade
		@param newGrade the student's grade in the class
	*/
    public void setGrade( int newGrade )
    {
		//Test the validity of the user input for newGrade
		if ( newGrade < 0 || newGrade > 100 )
		{
			JOptionPane.showMessageDialog(null, "Invalid Grade Input Program Terminating", "Message", JOptionPane.ERROR_MESSAGE);
		 	System.exit(0);
		}
		grade = newGrade;
    }

	/**
		Acessor Method getGrade to return the student's grade
		// @return the Student's Grade
	*/
    public int getGrade()
    {
		return grade;
    }

	/**
		Acessor Method getName to return the student's name
		// @return the Student's Name
	*/
    public String getName()
    {
		return name;
    }

	/**
			Method toString() prints the current values of the data fields
			@return current value of the data fields
	*/
    public String toString()
    {
		String toString1 = "Name: "+name+"\nGrade: "+grade;
		return toString1;
    }
}