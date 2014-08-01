/**
*@author		 JP Stearns<https://github.com/JPStearns>
*@assignment Assignment: Java6
*@version	 7.0
*@since		 2014-07-06
*
This Client will accept user input regarding students of a class
and will calculate and return different aspects in regards
to the way the students performed.
*/
import java.util.Scanner;
import java.text.*;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/**
 Class to demonstrate the Student class
*/
public class StudentClient
{
    public static void main( String[] args )
    {
        System.out.println( "JP Stearns\n" );

        Scanner kb = new Scanner( System.in );

        System.out.print( "How many students? " );
        int howMany = kb.nextInt();

        // Create the Student array; call it roster
        Student[] roster = new Student[howMany];

        // Leave these lines alone. Write methods below.
        // Call a method to fill the array of Students
        fillArray( roster );

        // Call a method to display the roster (name & grade)
        System.out.println("\nStudents:");
        display( roster );

        // Call a method to show the name(s) of the
        // Student(s) with the highest grade
        showMax( roster );

        // Call a method to find the average grade.
        showAvg( roster );

        // Call a method to determine and show the
        // letter grade for each student.
        showLetterGrade( roster );

        // Call a method to sort an array of Students
        // by name. Then redisplay it.
        System.out.println("\nAlphabetical listing:");
        sortName( roster );
        display( roster );

        // Call a method to sort an array of Students
        // by grade, high to low. Then redisplay it.
        System.out.println("\nStudents by grade, high to low");
        sortGrade( roster );
        display( roster );

    }
	//A method to fill the Student Array with Names and Grades
    public static void fillArray( Student[] std )
    {

		 for(int index = 0; index < std.length; index++)
		 {
		 	String newName = JOptionPane.showInputDialog("Enter the student's Name: ");							//to hold the user input for Name
		 	int newGrade = Integer.parseInt(JOptionPane.showInputDialog("Enter the student's Grade: "));		//to hold the user input for Grade

		 	while (newGrade > 100 || newGrade <0)
		 		newGrade = Integer.parseInt(JOptionPane.showInputDialog("ERROR: Invalid Grade Input\nPlese Enter Valid Grade: "));
		 	std[index]= new Student(newName, newGrade);
		}
    }

	//The display method will use the toString method from the Student Class to display the roster information
    public static void display( Student[] std )
    {
		 for (int index = 0; index < std.length  ; index++)
		 System.out.println(std[index].toString());
    }

	//The showMax method will use the getGrade method from the Student Class to find and display the highest grades.
    public static void showMax( Student[] std )
    {
		System.out.println("\nStudent<s> with the highest grade.");
		int max = std[0].getGrade();		//The max variable is initialized with the first Grade value in the Student Array

		for (int index = 1; index < std.length; index++)
		{
			if ( std[index].getGrade() > max)
				max = std[index].getGrade();
		}
		//This for loop will print the student(s) information if they have the highest grade.
		for (int index = 0; index < std.length; index++)
		{
			if ( std[index].getGrade()== max)
				System.out.println(std[index].toString());
		}

    }

	//The showAvg method will calculate the average grade and display it to the user
    public static void showAvg( Student[] std )
    {
		double sum = 0;	//The sum variable will accumulate the student's scores.
		double average;	//The average variable will hold the average score for the class

		for(int index = 0; index < std.length; index++)
		{
			sum = sum + std[index].getGrade();
		}
			average = sum / std.length;
			DecimalFormat onePlace = new DecimalFormat("0.0");
			average = Double.parseDouble(onePlace.format(average));
			System.out.println("\nThe Class Average is: "+average);
    }

	/*The showLetterGrade method will assign the integer value
	  stored in Grade to a Char value, and will display the letter grades
	  for each of the students.*/
    public static void showLetterGrade( Student[] std )
    {
		System.out.println("\nLetter Grades: ");
		char letterGrade;	//to hold each student's letter grade

		for (int index = 0; index < std.length; index++)
		{
			if (std[index].getGrade()>=90)
				letterGrade = 'A';
			else if (std[index].getGrade() >= 80)
				letterGrade = 'B';
			else if (std[index].getGrade() >= 70)
				letterGrade = 'C';
			else if (std[index].getGrade() >= 60)
				letterGrade = 'D';
			else
				letterGrade = 'F';
			System.out.println(std[index].getName()+": "+letterGrade);
		}
    }

	//The sortName method will use the (rather lame) Bubble Sorting Technique
	//to organize the student's names in alphabetical order.
   public static void sortName( Student[] std )
    {
		 int j;
		 int tempInt;
		 boolean flag = true; //set flag to true to begin first pass
		 String tempStr = null;	 //Holding Variable
		 while(flag)
		 {
			 flag = false;		//set flag to false awaiting a possible swap
			 for (j = 0; j < std.length-1; j++)
			 {
				 if((std[j].getName()).compareTo(std[j+1].getName()) > 0)
				 {
					 tempStr = std[j].getName();
					 tempInt = std[j].getGrade();
					 std[j] = std[j+1];
					 String newName = tempStr;
					 int newGrade = tempInt;
					 std[j+1]= new Student(newName, newGrade);
					 flag = true;
				 }
			 }
		 }
	 }

	//The sortGrade method will utilize the Bubble Sort technique to
	//organize the Student Array by highest grade to lowest grade.
    public static void sortGrade( Student[] std )
   {
		int j;
		int tempInt;
		boolean flag = true; //set flag to true to begin first pass
		String tempStr = null;	 //Holding Variable

		do
		{
			flag = false;
			for (j = 0; j < std.length - 1; j++)
			{
				if( std[j].getGrade() < std[j+1].getGrade())
				{
					tempStr = std[j].getName();
					tempInt = std[j].getGrade();
					std[j] = std[j+1];
					String newName = tempStr;
					int newGrade = tempInt;
					std[j+1]= new Student(newName, newGrade);
					flag = true;
				}
			}
		}while (flag);
	}
}

/*
JP Stearns

How many students? 5

Students:
Name: Hogg, Ima
Grade: 76
Name: Too, Yew R
Grade: 98
Name: Frisbee, Iona
Grade: 82
Name: Lynn, Amanda
Grade: 98
Name: Bird, Earl E
Grade: 87

Student<s> with the highest grade.
Name: Too, Yew R
Grade: 98
Name: Lynn, Amanda
Grade: 98

The Class Average is: 88.2

Letter Grades:
Hogg, Ima: C
Too, Yew R: A
Frisbee, Iona: B
Lynn, Amanda: A
Bird, Earl E: B

Alphabetical listing:
Name: Bird, Earl E
Grade: 87
Name: Frisbee, Iona
Grade: 82
Name: Hogg, Ima
Grade: 76
Name: Lynn, Amanda
Grade: 98
Name: Too, Yew R
Grade: 98

Students by grade, high to low
Name: Lynn, Amanda
Grade: 98
Name: Too, Yew R
Grade: 98
Name: Bird, Earl E
Grade: 87
Name: Frisbee, Iona
Grade: 82
Name: Hogg, Ima
Grade: 76
Press any key to continue . . .
*/