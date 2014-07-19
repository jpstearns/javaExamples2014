// LoanPhase1Test.java

import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.*;

public class LoanPhase1Test
{
    public static void main(String[] args) throws IOException
    {
        Scanner keyboard = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat( "$#,##0.00" );
        DecimalFormat pct = new DecimalFormat( "0.0%" );

		// Declare to references to Loan objects. Neither is associated with
		// a Loan object yet.
        Loan loanA, loanB;

        double rate;		// annual interest rate (as a percent)
        int years;			// years for the loan
        double amount;		// loan amount
        double monthlyPmt;	// monthly payment
        double totalPmt;	// total payment

		// Display your name
		System.out.println("[client] JARED STEARNS");

		// Create a Loan object using the no-argument constructor
		loanA = new Loan();

		// Display its details
        System.out.println( "\n[client] LOAN A (the no-argument constructor):" );
        System.out.println( "[client] Annual Interest Rate:  "
            + pct.format( loanA.getAnnualInterestRate() ) );
        System.out.println( "[client] Number of Years:       "
            + loanA.getNumberOfYears() );
        System.out.println( "[client] Loan Amount:           "
            + df.format( loanA.getLoanAmount() ) );
        System.out.println( "[client] Monthly Payment:       "
            + df.format( loanA.getMonthlyPayment() ) );
        System.out.println( "[client] Total Payment:         "
            + df.format( loanA.getTotalPayment() ) );

		// Set new values
		System.out.println("\n[client] Setting new values: 5.2, 12, 5000.00");
		System.out.println("[client] All valid fields");
		loanA.setRate( 5.2 );
		loanA.setYears( 12 );
		loanA.setLoanAmount( 5000.00 );
		System.out.print( "\n[client] calls toString:\n" + loanA.toString() );

		// Set new values
		System.out.println("\n[client] Setting new values: 30.0, 0, -5000.00");
		System.out.println("[client] All invalid fields");
		loanA.setRate( 30.0 );
		loanA.setYears( 0 );
		loanA.setLoanAmount( -5000.00 );
		System.out.print( "\n[client] calls toString:\n" + loanA.toString() );

		// Set new values
		System.out.println("\n[client] Setting new values: 15.0, 35, 15000.00");
		System.out.println("[client] 1 invalid field");
		loanA.setRate( 15.0 );
		loanA.setYears( 35 );
		loanA.setLoanAmount( 15000.00 );
		System.out.print( "\n[client] calls toString:\n" + loanA.toString() );

		// Create another Loan object using the 3-argument constructor
		System.out.println( "\n[client] LOAN B (the 3-argument constructor):" );
		System.out.println( "[client] values used: 30, 20, 200000.00");
		loanB = new Loan(30.0, 20, 200000.00);

		// Display Loan B using its toString method
        System.out.println("\n[client] calls toString:\n" + loanB.toString() );
    }
}
