//Jared Steaerns
//Assignment Java1

//This Program will determine the net profit made
//when buying and selling stock.


import java.util.Scanner;
public class Stocks
{
	public static void main(String[] args)
	{
		final double BROKER_RATE=.02;		//Name Constant BROKER_RATE

		double	netProfitLoss;				//Declare target variable NetProfitLoss
		double	netRevenue;					//Declare the overall ammount received
		double	initialTotal;				//Declare InitialTotal to hold the upfront investment
		double 	initialInvestment;		//Declare to calculate total after broker.
		double	purchaseCommission;		//Declare the Purchase Commission for the broker
		double	salesCommission;			//Declare Sales Comission
		int		sharesPurchased;			//Declare Input variable SharesPurchased
		double	pricePerShare;				//Declare Input variable PricePerShare
		double	sellingPrice;				//Declare Input variable SellingPrice
		double	salePrice;					//Declare an initial Sale Price

		System.out.println("Jared Stearns\n");
		//Create a Scanner object to read Input
		Scanner keyboard = new Scanner(System.in);

		//Get the ammount of shares purchased
		System.out.print("How many shares did you purchase? ");
		sharesPurchased = keyboard.nextInt();

		//Get the price per share purchased
		System.out.print("What was the price of each share purchased? ");
		pricePerShare = keyboard.nextDouble();
		System.out.print("\n");

		//Calculate the initial total
		initialTotal = sharesPurchased * pricePerShare;

		//Calculate purchase comission and the Total Initial Investment
		purchaseCommission = initialTotal * BROKER_RATE;
		initialInvestment = purchaseCommission + initialTotal;

		//Display pertinent information to the user
		System.out.println("Shares Purchased:			"		+ sharesPurchased);
		System.out.println("Price of Stock Per Share:		$"		+ pricePerShare);
		System.out.println("Total Stock Purchase Price:		$"		+ initialTotal);
		System.out.println("Purchase Commission Paid:		$"		+ purchaseCommission);
		System.out.println("Total Up Front Investment:		$"		+ initialInvestment);
		System.out.println("\n");

		//Get the selling price of each share
		System.out.print("What is the selling rate of each share? ");
		sellingPrice = keyboard.nextDouble();
		System.out.print("\n");

		//Calculate the stock sale price
		salePrice = sellingPrice * sharesPurchased;

		//Calculate the Sales Comission Paid and total ammount recieved
		salesCommission = salePrice * BROKER_RATE;
		netRevenue = salePrice - salesCommission;

		//Display pertinent information to the user
		System.out.println("Selling Price Per Share:		$"	+ sellingPrice);
		System.out.println("Stock Sale Price: 			$"	+ salePrice);
		System.out.println("Sales Commission paid:			$"	+ salesCommission);
		System.out.println("Total Ammount Received:			$"	+ netRevenue);
		System.out.println("\n");

		//Calculate the overall profit or loss
		netProfitLoss = netRevenue - initialInvestment;
		System.out.println("Overall Profit or Loss:			$" +netProfitLoss);
	}
}

/*
Jared Stearns

How many shares did you purchase? 1000
What was the price of each share purchased? 35.56

Shares Purchased:                       1000
Price of Stock Per Share:               $35.56
Total Stock Purchase Price:             $35560.0
Purchase Commission Paid:               $711.2
Total Up Front Investment:              $36271.2


What is the selling rate of each share? 42.75

Selling Price Per Share:                $42.75
Stock Sale Price:                       $42750.0
Sales Commission paid:                  $855.0
Total Ammount Received:                 $41895.0


Overall Profit or Loss:                 $5623.800000000003
Press any key to continue . . .
*/
/*
Jared Stearns

How many shares did you purchase? 250
What was the price of each share purchased? 56.80

Shares Purchased:                       250
Price of Stock Per Share:               $56.8
Total Stock Purchase Price:             $14200.0
Purchase Commission Paid:               $284.0
Total Up Front Investment:              $14484.0


What is the selling rate of each share? 48.50

Selling Price Per Share:                $48.5
Stock Sale Price:                       $12125.0
Sales Commission paid:                  $242.5
Total Ammount Received:                 $11882.5


Overall Profit or Loss:                 $-2601.5
Press any key to continue . . .
*/