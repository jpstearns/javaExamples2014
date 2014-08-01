/**
*@author		JP Stearns<https://github.com/JPStearns>
*				Assignment# JavaA4
*@version	7.0
*@since		2014-06-16
*
*This Program will read in stock data from file and will
*calculate the average and total profit or loss.
*/

import java.util.Scanner;			//Needed for Scanner Class
import java.io.*;						//Needed for File Class
import java.util.regex.Pattern;	//Needed for Pattern Class
import java.text.DecimalFormat;	//Needed for Decimal Formatting


public class StockAnalysis
{
	public static void main(String args[]) throws IOException
	{

		//Print the author's name
		System.out.println("JP Stearns\n");

		//Define a new Decimal Format for money and percent ##TODO:(save to boiler plate)
		DecimalFormat money = new DecimalFormat ("$#,##0.00");
		DecimalFormat percent = new DecimalFormat("0.00%");

		//Declare all constants and variables
		int		index = 1;					//To keep track of all the individual valid transactions
		double	totalProfit = 0;			//A running total of all profit initialized to 0
		double	averageProfit;				//To hold the average profit of all the transactions
		double	profit;						//To hold profit data for each individual transactions
		boolean 	validTransaction=true;	//Initialized Boolean to test for data validity

		//Create a scanner object for keyboard input
		Scanner keyboard = new Scanner(System.in);

		//Get the File Name
		System.out.print("Enter the name of the file: ");
		String filename = keyboard.nextLine();

		//Open the File
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);

		//I am sure I just lost points for this but this space was annoying me
		System.out.println("");

		//test to see if the user read in a bogus or empty file
		boolean empty = !file.exists() || file.length()==0;
		if  (empty == true)
		{
			System.out.println("The specified file does not exist, or is empty.");
			System.exit(0);
		}

		//Read lines from the file until no more are left
		while (inputFile.hasNext())
		{
			//Assign the data read in to their respective variable locations.
			double numberOfShares =inputFile.nextDouble();	//shares
			double purchasePrice = 	inputFile.nextDouble();	//purchase price
			double purchComission = inputFile.nextDouble();	//Comission at purchase
			double salesPrice = 		inputFile.nextDouble();	//How much the stock sold for
			double salesComission = inputFile.nextDouble();	//Comission at sale

			//Call the method checkValidity
			validTransaction = checkValidity(numberOfShares, purchasePrice, purchComission, salesPrice, salesComission);

			//Calculate each individual transaction if it is valid. Print statement when invalid
			if (validTransaction == true)
 			{
 			 	profit = calcProfit(numberOfShares, purchasePrice, purchComission, salesPrice, salesComission, index);
 				index++;
 				totalProfit += profit;
			}
			else
			{
				printInvalid(numberOfShares, purchasePrice, purchComission, salesPrice, salesComission);
				System.out.println("");
			}
		}
			//Calculate the average and total profit
			averageProfit= totalProfit/(index-1);
			System.out.println("The average profit is: " +money.format(averageProfit));
			System.out.println("The total profit is: " +money.format(totalProfit));
	}

	/**
	*This method will check the validity of the purchase data read in from the file.
	*<p>
	*Note:purchasePrice is allowed to go to 0 because hey who wouldn't want free stock,
	*however, salesPrice is not allowed to go to 0 because I don't give stock away free.
	*
	*@param numberOfShares	the number of shares that were purchased
	*@param purchasePrice	the price at which these shares were purchased
	*@param purchComission	the comission percentage the broker made at the time of the purchase
	*@param salesPrice		the price at which these shares were sold
	*@param salesComission	the comission percentage the broker made at the time of sale
	*
	*@return						return true if valid purchase, false if purchase data is not valid
	*/
	public static boolean checkValidity(double numberOfShares, double purchasePrice, double purchComission, double salesPrice, double salesComission)
	{
		if (numberOfShares<=0||purchasePrice<0||salesPrice<=0||purchComission>.2||salesComission>.2||purchComission<0||salesComission<0)
			return false;
		else
			return true;
	}

	/**
	*This Method will print the statments informing the user there is invalid data in the read in file
	*
	*@param numberOfShares	the number of shares that were purchased
	*@param purchasePrice	the price at which these shares were purchased
	*@param purchComission	the comission percentage the broker made at the time of the purchase
	*@param salesPrice		the price at which these shares were sold
	*@param salesComission	the comission percentage the broker made at the time of sale
	*/
	public static void printInvalid(double numberOfShares, double purchasePrice, double purchComission, double salesPrice, double salesComission)
	{
		//Define a new Decimal Format for money and percent
		DecimalFormat money = new DecimalFormat ("$#,##0.00");
		DecimalFormat percent = new DecimalFormat("0.00%");

		if (numberOfShares <= 0)
				System.out.println("Invalid Number of Shares Purchased: " + numberOfShares);
		if (purchasePrice < 0)
				System.out.println("Invalid Purchase Price: " + money.format(purchasePrice));
		if (salesPrice <= 0)
			System.out.println("Invalid Sales Price: " +money.format(salesPrice));
		if (purchComission > 0.20 ||  purchComission < 0)
			System.out.println("Invalid Purchase Comission Percent: " +percent.format(purchComission));
		if (salesComission > 0.20 || salesComission < 0)
			System.out.println("Invalid Sales Comission Percent: " +percent.format(salesComission));
	}

	/**
	*This Method will calculate the profit for each transaction and return the data to the main method.
	*
	*@param numberOfShares	the number of shares that were purchased
	*@param purchasePrice	the price at which these shares were purchased
	*@param purchComission	the comission percentage the broker made at the time of the purchase
	*@param salesPrice		the price at which these shares were sold
	*@param salesComission	the comission percentage the broker made at the time of sale
	*@param index				this will keep track of which transaction we are working with
	*
	*@return profit			the profit for each valid transaction
	*/
	public static double calcProfit(double numberOfShares, double purchasePrice, double purchComission, double salesPrice, double salesComission, int index)
	{
		double	profit;
		double	purchaseComissionAmmount;
		double 	salesComissionAmmount;
		double	initialInvestment;
		double	totalProfit=0;

		//Define a new Decimal Format for money and percent ##TODO:(save to boiler plate)
		DecimalFormat money = new DecimalFormat ("$#,##0.00");
		DecimalFormat percent = new DecimalFormat("0.00%");

		//Calculate the profit
		purchaseComissionAmmount = (numberOfShares*purchasePrice*purchComission);
		salesComissionAmmount = (numberOfShares*salesPrice*salesComission);
		initialInvestment = (numberOfShares*purchasePrice)+purchaseComissionAmmount;
		profit = ((numberOfShares*salesPrice)-salesComissionAmmount)-initialInvestment;

		System.out.println("Valid Transaction "+index+" profit: "+money.format(profit)+"\n");
		return profit;
	}
}
/*
Run #1
JP Stearns

Enter the name of the file: stockdata.txt

Valid Transaction 1 profit: $226.31

Invalid Purchase Price: -$15.75

Valid Transaction 2 profit: $336.22

Valid Transaction 3 profit: -$144.75

Valid Transaction 4 profit: -$1,333.86

Invalid Purchase Comission Percent: 102.50%
Invalid Sales Comission Percent: 102.40%

Valid Transaction 5 profit: $1,227.89

Invalid Number of Shares Purchased: 0.0

The average profit is: $62.36
The total profit is: $311.80
Press any key to continue . . .

Run  #2
JP Stearns

Enter the name of the file: empty.txt

The specified file does not exist, or is empty.
Press any key to continue . . .
*/