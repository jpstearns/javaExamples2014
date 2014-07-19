//Jared Stearns
//Java Programming Assignment #3
//June 13th, 2014

//This program will read in survey data from the user, and
//will organize the results in a dialog box.

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class survey
{
	//Define a function to display a histogram
	public static String stars (int num)
	{
		String sym = "*";
		String strz = "";
		int x;
		for (x=0; x<=num-1; x++) strz += sym;
		return strz;
	}

	public static void main(String[] args)
	{
		//Print Author's Name
		System.out.println("Jared Stearns\n");

		//Declare all variables and constants
		int agree = 0;
		int disagree = 0;
		int noOpinion = 0;
		int count = 0;
		int input;

		//Create a DecimalFormat object to format output
		DecimalFormat percent = new DecimalFormat("0.00%");

		// Get the User Input
		input = Integer.parseInt(JOptionPane.showInputDialog("1=Agree, 2=Disagree, 3=No Opinion, -1=Exit"));

		//Calculate the input
		while (input != -1)
		{
		count++;

		//set up a switch to test the user input with an error default
		switch (input)
				{
					case 1:
								agree++;
								break;
					case 2:
								disagree++;
								break;
					case 3:
								noOpinion++;
								break;
					default:
					{
						JOptionPane.showMessageDialog(null, "Invalid response: " + input, "Message", JOptionPane.ERROR_MESSAGE);
						count--;
					}

				}
			//parse the integer from a string
			input = Integer.parseInt(JOptionPane.showInputDialog("1=Agree, 2=Disagree, 3=No Opinion, -1=Exit"));
		}
		if (count == 0)
		{
			System.out.println("You must input data to calculate survey results.");
			System.exit(0);
		}

		//Display the results in the dialog box
		System.out.println("RESPONSE\tFREQUENCY\tPERCENT\t\tHISTOGRAM");
		System.out.println(" Agree\t\t" + agree + "\t\t" + percent.format(((double) agree/(double) count))+ "\t\t"+ stars(agree));
		System.out.println(" Disagree\t" + disagree + "\t\t" + percent.format(((double) disagree/(double) count)) + "\t\t"+stars(disagree));
		System.out.println(" No Opinion\t" + noOpinion + "\t\t" + percent.format(((double) noOpinion/(double) count)) +"\t\t"+ stars(noOpinion));

		System.exit(0);
	}
}

/*
Jared Stearns

RESPONSE        FREQUENCY       PERCENT         HISTOGRAM
 Agree          7               30.43%          *******
 Disagree       11              47.83%          ***********
 No Opinion     5               21.74%          *****
Press any key to continue . . .
*/


