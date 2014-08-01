/**
*@author		 JP Stearns<https://github.com/JPStearns>
*@assignment Assignment# Java4
*@version	 7.0
*@since		 2014-06-16

This Class simulates a Loan
*/

import java.text.DecimalFormat;

public class Loan
{
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;

	/** No-argument constructor */
	public Loan()
	{
		annualInterestRate = 0.025;
		numberOfYears = 1;
		loanAmount = 1000;
	}

	/** Construct a loan with specified annual interest rate,
	  number of years and loan amount
	  @param rate The annual interest rate
	  @param years The number of years of the loan
	  @param amount The loan amount
	*/
	public Loan(double rate, int years, double amount)
	{
		// Start with default values
		annualInterestRate = 0.025;
		numberOfYears = 1;
		loanAmount = 1000;

		setRate( rate );
		setYears( years );
		setLoanAmount( amount );
	}

	/** Return annualInterestRate
	  @return The annual interest rate
	*/
	public double getAnnualInterestRate()
	{
		return annualInterestRate;
	}

	/** Return numberOfYears
	  @return Number of years for the loan
	*/
	public int getNumberOfYears()
	{
		return numberOfYears;
	}

	/** Return loanAmount
	  @return The loan amount
	*/
	public double getLoanAmount()
	{
		return loanAmount;
	}

	/** Set a new annualInterestRate
	  @param rate The annual interest rate
	*/
	public void setRate(double rate)
	{
		DecimalFormat pct = new DecimalFormat("0.0%");

		if( rate >= 0 && rate <= 25.0)
			annualInterestRate = rate / 100;
		else
			System.out.println( "WARNING: Invalid annual interest rate: "
				+ pct.format(rate / 100) + "\nCurrent value not changed: "
				+ pct.format(annualInterestRate));
	}

	/** Set a new numberOfYears
	  @param years The number of years for the loan
	*/
	public void setYears(int years)
	{
		if( years > 0 && years <= 30 )
			numberOfYears = years;
		else
			System.out.println( "WARNING: Invalid number of years: "
				+ years + "\nCurrent value not changed: "
				+ numberOfYears);
	}

	/** Set a newloanAmount
	  @param amount The loan amount
	*/
	public void setLoanAmount(double amount)
	{
		DecimalFormat df = new DecimalFormat("$#,##0.00");
		if( amount > 0 )
			loanAmount = amount;
		else
			System.out.println( "WARNING: Invalid loan amount: "
				+ df.format(amount) + "\nCurrent value not changed: "
				+ df.format(loanAmount));
	}

	/** Find monthly payment
	  @return The monthly payment on the loan
	*/
	public double getMonthlyPayment()
	{
		double monthlyInterestRate = annualInterestRate / 12;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
		  (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
		return monthlyPayment;
	}

	/** Find total payment
	  @return The total payment on the loan
	*/
	public double getTotalPayment()
	{
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;
	}

	/** Return the fields formatted
	  @return The formatted display of fields
	*/
	public String toString()
	{
		DecimalFormat pct = new DecimalFormat( "0.0%" );
		DecimalFormat df = new DecimalFormat( "$#,##0.00" );
		return(
		   "Annual interest rate: " + pct.format(annualInterestRate)
		   + "\nNumber of years:      " + numberOfYears
		   + "\nLoan Amount:          " + df.format(loanAmount)) + "\n";
	}

}
