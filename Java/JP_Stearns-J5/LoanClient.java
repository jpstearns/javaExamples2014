/**
*@author		 JP Stearns<https://github.com/JPStearns>
*@assignment Assignment# Java5-phaseTwo
*@version	 7.0
*@since		 2014-06-28
*
This Client will read in loan data from file,
validate the data fields, and calculate monthly,
and total payments. Then it will prompt the user
in regards to their future loan analysis desires, and
display that data in a table.
*/
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import java.util.Scanner;			//Needed for Scanner Class
import java.io.*;						//Needed for File Class

public class LoanClient
{
	public static void main(String[] args)throws IOException
	{
		System.out.println("JP Stearns\n");

		//Define some new decimal formats
		DecimalFormat scrilla = new DecimalFormat("$#,##0.00");
		DecimalFormat pct = new DecimalFormat( "0.0%" );

		int index = 0;	//Declare an index varible and initialize it to 0
		int validRecord = 0; //For valid transactions
		int invalidRecord = 0; //For invalid transactions

		//Ask user for the filename,
		String filename = JOptionPane.showInputDialog(null, "Enter The File Name: ");
		if(filename == null)
			tableBuilder();
		while(filename.isEmpty())
			{
				filename = JOptionPane.showInputDialog(null, "Enter The File Name: ");
				if(filename == null)
				tableBuilder();
			}

		System.out.println("File name: "+ filename+"\n");
		File file = new File( filename );

		//Test to see if the file exists.
		boolean exists = !file.exists();
		boolean empty = file.length() == 0;
		if ( exists == true )
		{
			System.out.println("This file does not exist.\n Program Terminating");
			System.exit(0);
		}

		//Read the file in and test to see if it is empty.
		Scanner inputFile = new Scanner(file);
		if ( empty == true )
			System.out.println("There is no data stored in this file");

		//Make a new object of the Loan Class
		Loan loan = new Loan();

		//Read lines from the file until no more are left
		while ( inputFile.hasNext() )
		{
			//Asign the data read in from file to the respective memory locations
			double rate = inputFile.nextDouble(); 		 //Annual interest rate
			int years = inputFile.nextInt();			    //Number of years on the loan
			double amount = inputFile.nextDouble();	 //Amount of the loan

			//Call the mutator methods of the Loan Class
			loan.setRate(rate);
			loan.setYears(years);
			loan.setLoanAmount(amount);

			//Increment index
			index++;

			//Test to seee if the record is valid or invalid
			if (rate >= 0 && rate <= 25 && years > 0 && years <= 30 && amount > 0)
				validRecord++;
			else
				invalidRecord++;

			//Call the two string method to display the information
			System.out.print("\nRECORD " + index + ":\n" + loan.toString() + "\n");

			//Call the get monthly and total payment methods
			System.out.println("The monthly payment is:\t" + scrilla.format(loan.getMonthlyPayment()));
			System.out.println("The total payment is:\t" + scrilla.format(loan.getTotalPayment()) + "\n");
			System.out.println("------------------------------------\n");
		}

	//Display the amount of valid and invalid records.
	System.out.println("Valid records:\t " + validRecord);
	System.out.println("Invalid records: " + invalidRecord+"\n");

	//Call table builder method to display loan analysis information
	tableBuilder();

	System.exit(1);
	}

//Method to build tables
public static void tableBuilder()
	{
		int selectedOption = JOptionPane.showConfirmDialog(null,
		    "Would you like to analyze a loan at a fixed amount,\n"+
		    "with a maximum monthly payment \n"+"over a range of specified interest rates?",
		    "Setup A Loan Table",
		    	+JOptionPane.YES_NO_OPTION);
		if (selectedOption == JOptionPane.YES_OPTION)
		{
			/*	Set up a no paramater loan for a little room to breathe.
				I will call this loan1 incase I was working with a team there
				would never be confusion as to which instance of the Loan class
				one was refering to though loan could work just fine right here.
			*/
			Loan loan1 = new Loan();

			//Declare and intialize some variables
			double loanAmount = 0;
			double maxMonthlyPayment = 0;
			double highestRate = 0;
			double lowestRate = 0;

		 	//Prompt user for loan information and convert the user input to doubles
		 	//Set up the Loan Amount test for empty string and cancel option then convert to double
		 	String loanAmt = JOptionPane.showInputDialog(null, "Enter The amount on the loan: ");
		 	if (loanAmt == null || loanAmt.isEmpty())
		 	{
		 		JOptionPane.showMessageDialog(null, "Table Builder Cancelled\nProgram Terminating", "Message", JOptionPane.ERROR_MESSAGE);
		 		System.exit(2);
			}
		 	if (loanAmt != null)
		 		loanAmount = Double.parseDouble(loanAmt);
			while (loanAmount <= 0)
			{
				JOptionPane.showMessageDialog(null, "Invalid Loan Amount\nTry Again", "Message", JOptionPane.ERROR_MESSAGE);
		   	loanAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter The amount on the loan: "));
			}

			//Setup the maximum monthly payment,
			//test for empty string and cancel option then convert to double
			String monthlyPmt = JOptionPane.showInputDialog("Enther the maximum monthly payment: ");
			if (monthlyPmt == null || monthlyPmt.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Table Builder Cancelled\nProgram Terminating", "Message", JOptionPane.ERROR_MESSAGE);
				System.exit(3);
			}
			if (monthlyPmt !=  null)
		  		maxMonthlyPayment = Double.parseDouble(monthlyPmt);
		   while(maxMonthlyPayment <= 0)
		   {
		  		JOptionPane.showMessageDialog(null, "Invalid Maximum Monthly Payment\nTry Again", "Message", JOptionPane.ERROR_MESSAGE);
		  		maxMonthlyPayment = Double.parseDouble(JOptionPane.showInputDialog("Enter the maximum monthly payment: "));
			}
			//Setup the lowest anual interest rate test for empty string and cancel option then convert to double
			String lowRate = JOptionPane.showInputDialog("Enter the lowest anual interest rate: ");
			if (lowRate == null || lowRate.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Table Builder Cancelled\nProgram Terminating", "Message", JOptionPane.ERROR_MESSAGE);
				System.exit(4);
			}
			if (lowRate != null)
				lowestRate = Double.parseDouble(lowRate);
		  while(lowestRate <= 0)
		   {
				JOptionPane.showMessageDialog(null, "Invalid Lowest Anual Interest Rate\nTry Again", "Message", JOptionPane.ERROR_MESSAGE);
				lowestRate = Double.parseDouble(JOptionPane.showInputDialog("Enter the lowest annual interest rate: "));
			}

			//Setup the highest anual interest rate test for empty string and cancel option then convert to double
			String highRate = JOptionPane.showInputDialog("Enter the highest anual interest rate");
			if (highRate == null || highRate.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Table Builder Cancelled\nProgram Terminating", "Message", JOptionPane.ERROR_MESSAGE);
				System.exit(5);
			}
		   highestRate = Double.parseDouble(highRate);
			while (highestRate <= 0)
			{
				JOptionPane.showMessageDialog(null, "Invalid Highest Anual Interest Rate\nTry Again", "Message", JOptionPane.ERROR_MESSAGE);
				highestRate = Double.parseDouble(JOptionPane.showInputDialog("Enter the higest annual interest rate: "));
			}
		   //Test the validity of the interest rate input
		   if (lowestRate >= highestRate)
		   {
		  		 JOptionPane.showMessageDialog(null, "Lowest Anual Interest Rate must be less than the Highest Anual Interest Rate\n"+
	  		 											"Program Terminating", "Message", JOptionPane.ERROR_MESSAGE);
		  		 System.exit(6);
			}

		   //Print a table header
		   System.out.print("RATE\tYEARS\tMONTHLY\t   TOTAL\tINTEREST"+
		   						"\n\t\tPAYMENT\t   PAYMENT\tPAID\n"+
		   						"=================================================\n");

			//Set up a for loop to run the calculations and print the data to the table
			for (double rate = lowestRate; rate <= highestRate; rate++)
			{
				int numberOfYears = 1;
				//Utilize some methods from Loan Class
				loan1.setRate(rate);
				loan1.setLoanAmount(loanAmount);
				double monthlyPayment = loan1.getMonthlyPayment();

				//A do while loop will calculate the monthly payment nicely
				do
	 			{
					loan1.setYears(numberOfYears);
					monthlyPayment = loan1.getMonthlyPayment();
					numberOfYears++;
				} while (monthlyPayment > maxMonthlyPayment);

				//Getting some things in order before printing the table.
				numberOfYears = numberOfYears - 1;
				DecimalFormat scrilla = new DecimalFormat("$#,##0.00");
				monthlyPayment = loan1.getMonthlyPayment();
				double totalPmt = loan1.getTotalPayment();
				double intPaid = totalPmt - loanAmount;

				//Print to table
				System.out.print(rate+"%\t"+numberOfYears+"\t"+scrilla.format(monthlyPayment)+"\t   "+scrilla.format(totalPmt)+"\t"+scrilla.format(intPaid)+"\n");
			}
		}
		//If the user chose not to build a table
		else
		{
			System.out.println("Program Terminating");
			System.exit(7);
		}
		System.out.println("");
	}
}
/*
JP Stearns

File name: loandata.txt


RECORD 1:
Annual Interest Rate:   7.5%
Number of Years:        3
Loan Ammount:           $15,750.00

The monthly payment is: $489.92
The total payment is:   $17,637.23

------------------------------------

WARNING: Invalid number of years: -9
Current value not changed: 3

RECORD 2:
Annual Interest Rate:   5.4%
Number of Years:        3
Loan Ammount:           $20,500.00

The monthly payment is: $618.37
The total payment is:   $22,261.28

------------------------------------


RECORD 3:
Annual Interest Rate:   12.4%
Number of Years:        30
Loan Ammount:           $500,000.00

The monthly payment is: $5,297.52
The total payment is:   $1,907,107.47

------------------------------------

WARNING: Invalid loan amount: $0.00
Current value not changed: $500,000.00

RECORD 4:
Annual Interest Rate:   15.8%
Number of Years:        4
Loan Ammount:           $500,000.00

The monthly payment is: $14,106.20
The total payment is:   $677,097.75

------------------------------------

WARNING: Invalid annual interest rate: 30.0%
Current value not changed: 15.8%

RECORD 5:
Annual Interest Rate:   15.8%
Number of Years:        10
Loan Ammount:           $1,000.00

The monthly payment is: $16.60
The total payment is:   $1,991.50

------------------------------------


RECORD 6:
Annual Interest Rate:   8.8%
Number of Years:        15
Loan Ammount:           $9,600.00

The monthly payment is: $96.17
The total payment is:   $17,311.32

------------------------------------

Valid records:   3
Invalid records: 3

RATE    YEARS   MONTHLY    TOTAL        INTEREST
                PAYMENT    PAYMENT      PAID
=================================================
0.5%    4       $420.93    $20,204.83   $204.83
1.5%    4       $429.55    $20,618.49   $618.49
2.5%    4       $438.28    $21,037.47   $1,037.47
3.5%    4       $447.12    $21,461.76   $1,461.76
4.5%    4       $456.07    $21,891.35   $1,891.35
5.5%    4       $465.13    $22,326.22   $2,326.22
6.5%    4       $474.30    $22,766.35   $2,766.35
7.5%    4       $483.58    $23,211.75   $3,211.75
8.5%    4       $492.97    $23,662.37   $3,662.37
9.5%    5       $420.04    $25,202.23   $5,202.23
10.5%   5       $429.88    $25,792.68   $5,792.68

Press any key to continue . . .
---------------------------------------------------------------------
TEST ON INVALID INPUT FILE

JP Stearns

File name: oaisdjfoiasud

This file does not exist.
 Program Terminating
Press any key to continue . . .
---------------------------------------------------------------------
TEST ON EMPTY FILE

JP Stearns

File name: empty.txt

There is no data stored in this file
Valid records:   0
Invalid records: 0

Program Terminating
Press any key to continue . . .
********NOTE**********************************
This Only Terminated because I selected "No" on the GUI
It still allows the user option to go forward with the
table analysis of a loan at a fixed ammount.
*/