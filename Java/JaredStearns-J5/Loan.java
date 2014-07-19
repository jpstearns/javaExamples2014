/**
*@author		Jared Stearns <jared.patrick.stearns@gmail.com>
*				Assignment# Java5-phaseOne
*@version	7.0
*@since		2014-06-22
*
*This class will represent a Loan.
*/
import java.text.DecimalFormat;
public class Loan
{
	private double annualInterestRate;	//To hold the annual interest rate on the loan as a decimal
	private int		numberOfYears;			//To hold the number of years for the loan
	private double loanAmount;				//To hold the ammount of the loan

	/**
		Constructor-default initializes loans without paramaters
	*/
	public Loan()
	{

		annualInterestRate = 0.025;
		numberOfYears = 1;
		loanAmount = 1000;
	}

	/**
		Constructor-constructs a loan with paramaters
		@param rate the annual interest rate in decimal format
		@param years the number of years on the loan
		@param amount the amount of the loan
	*/
	public Loan(double rate, int years, double amount)
	{
		setRate(rate);
		setYears(years);
		setLoanAmount(amount);
	}

	/**
		Acessor Method getAnnualInterstRate to return the annual interest rate
		// @return The annual interest rate
	*/
	public double getAnnualInterestRate()
	{

		return annualInterestRate;
	}

	/**
		Acessor Method getNumberOfYears to return the number of years on the loan
		// @return The number of year on the loan
	*/
	public int getNumberOfYears()
	{
		return numberOfYears;
	}

	/**
		Acessor Method getLoanAmount to return the amount of the loan
		@return The amount of the load
	*/
	public double getLoanAmount()
	{
		return loanAmount;
	}

	/**
		Mutator Method settRate to assign a value to annualInterestRate
		@param rate  the annual interest rate on the loan
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


	/**
		Mutator Method setYears to assign value to the numberOfYears field
		@param years the number of years on the loan
	*/
	public void setYears(int years)
	{
		if (years > 0 && years <= 30)
			numberOfYears = years;
		else
		{
			if (numberOfYears == 0)
			numberOfYears = 1;
			System.out.println("WARNING: Invalid number of years: " + years +
			"\nCurrent value not changed: "+ numberOfYears);
		}
	}

	/**
		Mutator Method setLoanAmount to assign value to the loanAmount field
		@param amount	The total amount of the loan
	*/
	public void setLoanAmount(double amount)
	{
		if (amount > 0)
			loanAmount = amount;
		else
		{
			if (loanAmount == 0)
				loanAmount = 1000;
			else
			{
				DecimalFormat scrilla = new DecimalFormat("$#,##0.00");
				System.out.println("WARNING: Invalid loan amount: "+ scrilla.format(amount)
					+"\nCurrent value not changed: " + scrilla.format(loanAmount));
			}
		}
	}

	/**
		Method getMonthlyPayment() to calculate the monthly payment on the loan
		@return the monthly payment
	*/
	public double getMonthlyPayment()
	{
		double	monthlyInterestRate = ( annualInterestRate ) / 12;
		double 	x = ( 1 / ( 1 + monthlyInterestRate ) );
		int 		numberOfMonths = numberOfYears * 12;
		double	topHalf = loanAmount * monthlyInterestRate;
		double 	bottomHalf = 1 - ( Math.pow(x,numberOfMonths));
		double	monthlyPmt = topHalf / bottomHalf;
		return 	monthlyPmt;
	}

	/**
		Method getTotalPayment() that returns the total payment on the loan
		@return the total payment on the loan
	*/
	public double getTotalPayment()
	{
		int numberOfMonths = numberOfYears * 12;
		double monthlyPmt = getMonthlyPayment();
		double 	totalPmt = monthlyPmt * numberOfMonths;
		return 	totalPmt;
	}

	/**
		Method toString() prints the current values of the data fields
		@return current value of the data fields
	*/
	public String toString()
	{
		DecimalFormat scrilla = new DecimalFormat("$#,##0.00");
		DecimalFormat pct = new DecimalFormat( "0.0%" );

		String strA = "Annual Interest Rate:\t" + pct.format( annualInterestRate ) + "\n";
		String strB = "Number of Years:\t" + Integer.toString(numberOfYears) + "\n";
		String strC = "Loan Ammount:\t\t" + scrilla.format(loanAmount) + "\n";
		return strA + strB + strC;
	}
}

