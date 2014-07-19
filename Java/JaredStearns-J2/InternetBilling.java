//Jared Stearns
//Java -2A 06/02/2014

/*This program will calculate the ammount each
customer is to be billed for internet service of a
given month. Default Error messages will end the program
with invalid input data.*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class InternetBilling
{
	public static void main(String[] args)
		{
			System.out.println("Jared Stearns\n");

			//Declare Constants and Variables
			final double	BASE_RATEA = 9.95;
			final double	BASE_RATEB = 14.95;
			final double	BASE_RATEC = 22.95;
			final double 	OVERAGE_CHARGEA = 2.25;
			final double	OVERAGE_CHARGEB = 1.10;
			final int		MAX_HOURSA = 10;
			final int		MAX_HOURSB = 20;

			char internetPackage;		//Create Char Variable internetPackage
			String input;					//Create String input
			double hours;					//Create Double Variable hours
			double ammount = 0;			//Create Double ammount
			boolean error = false;		//Create Boolean error


			//Create a Scanner object to read input
			Scanner keyboard =	new Scanner(System.in);

			//Gather Internet Package Input
			System.out.print("Which Plan <A, B, C,> ");
			input = keyboard.nextLine();
			internetPackage = input.charAt(0);


			//Prompt the user to Input the Hours used.
			System.out.print("How many hours? ");
			hours = keyboard.nextDouble();

			//Calculate the ammount
			if (hours > 744)
				{
				System.out.println("Hours must be between 0 and 744.");
				System.out.println("You entered " +hours);
				}
			else
			{
				switch (input)
				{
					case "A":
					case "a":
					{
						if (hours > 10)
							ammount = BASE_RATEA + ((hours - MAX_HOURSA) * OVERAGE_CHARGEA);
						else
							ammount = BASE_RATEA;
						break;
					}
					case "B":
					case "b":
					{
						if (hours > 20)
							ammount = BASE_RATEB + ((hours - MAX_HOURSB) * OVERAGE_CHARGEB);
						else
							ammount = BASE_RATEB;
						break;
					}
					case "C":
					case "c":
					{
						ammount = BASE_RATEC;
						break;
					}
					default:
					{
						System.out.println("You must enter A, B, or C");
						error = true;
					}
				}
				//Print Statement pertinent information
				if (error == false)
				{
				DecimalFormat money = new DecimalFormat("$#,##0.00");
				System.out.println("The Charges Are: " + money.format(ammount));
				}
			}
	}
}

/*
Run1:
Jared Stearns

Which Plan <A, B, C,> B
How many hours? 15.5
The Charges Are: $14.95
Press any key to continue . . .

Run:2
Jared Stearns

Which Plan <A, B, C,> b
How many hours? 35.2
The Charges Are: $31.67
Press any key to continue . . .

Run:3
Jared Stearns

Which Plan <A, B, C,> C
How many hours? 35.2
The Charges Are: $22.95
Press any key to continue . . .

Run:4
Jared Stearns

Which Plan <A, B, C,> A
How many hours? 35.2
The Charges Are: $66.65
Press any key to continue . . .

Run:5
Jared Stearns

Which Plan <A, B, C,> d
How many hours? 1
You must enter A, B, or C
Press any key to continue . . .

Run:6
Jared Stearns

Which Plan <A, B, C,> c
How many hours? 850.0
Hours must be between 0 and 744.
You entered 850.0
Press any key to continue . . .
*/