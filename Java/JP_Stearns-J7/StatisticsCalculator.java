/**
*@author		 JP Stearns<https://github.com/JPStearns>
*@assignment Assignment# Java7
*@version	 7.0
*@since		 2014-07-013
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.JTextField;
import java.lang.*;

/*
This Class will create a GUI application to calculate statistics for an
educational instituion to detirmine student grades and averages.
*/

public class StatisticsCalculator extends JFrame
{
	final int NUMBER_OF_SCORES = 4;	//NNumber of Test Scores
	private JPanel scoresPanel;		//Test Scores Panel
	private JPanel statisticsPanel;	//Overall Grade Statistics Panel
	private JPanel buttonPanel;		//To hold the buttons

	//For the button panel
	private JButton calcButton;		//To calculate the Statistics
	private JButton resetButton;		//To reset the Data Fields

	//an Array for test scores
	JTextField[] testScores;
	double[] grade;

	//For the Statistics panel
	private JRadioButton aveargeAll;
	private JRadioButton averageDrop1;
	private JRadioButton averageDrop2;

	private JCheckBox average;
	private JCheckBox maximum;
	private JCheckBox minimum;
	private JCheckBox letterGrade;

	/**
		Constructor
	*/

	public StatisticsCalculator()
	{
		//Display a Title
		setTitle("Jared Stearns");

		//Specify the action for the Close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create a Border Layout
		setLayout(new BorderLayout());

		//Create the Custom Panels
		buildScoresPanel();
		buildStatisticsPanel();

		//Build the Button Panel
		buildButtonPanel();

		//Add the Components to the content pane
		add(scoresPanel, BorderLayout.NORTH);
		add(statisticsPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		//Pack the contents of the Window to display it.
		pack();
		setVisible(true);
	}

	private void buildButtonPanel()
	{
		//Create a panel for the buttons.
		buttonPanel = new JPanel();

		//Create a GridLayout manager with one row two columns
		//buttonPanel.setLayout(new GridLayout(1,2));

		//Create the buttons
		calcButton = new JButton("Calculate Statistics");
		resetButton = new JButton("Reset");

		//Register the Action Listeners.

		calcButton.addActionListener( new CalcButtonListener());
		//resetButton.addActionListener(new ResetButtonListener());

		//Add the Buttons to the Button Panel
		buttonPanel.add(calcButton);
		buttonPanel.add(resetButton);
	}

	private void buildScoresPanel()
	{
		//Create a panel for the test scores
		scoresPanel = new JPanel();

		//Create a GridLayout manger
		//with 1 row 4 columns.
		scoresPanel.setLayout(new GridLayout(1,4));

		//Create 4 text fields using an array
		testScores = new JTextField[4];

		for (int index = 0; index < testScores.length; index++)
			{
				testScores[index] = new JTextField(4);
				scoresPanel.add(testScores[index]);
			}

		//Border the panel.v
		scoresPanel.setBorder(BorderFactory.createTitledBorder("Test Scores"));
	}
	// get the inputs from the GUI
	public void getInputs(double grade[])
	{
    for (int j = 0; j <testScores.length; j++)
    		{
     		   grade[j] = Double.parseDouble(testScores[j].getText());
     		   System.out.println(grade[j]);
			}
	}
	private void buildStatisticsPanel()
	{
		//Create a panel for Statistics
		statisticsPanel = new JPanel();

		//Create a GridLayout manager with
		// 4 rows one column.
		statisticsPanel.setLayout(new GridLayout(7,1));

		//Create some radio buttons
		JRadioButton averageAll = new JRadioButton("Average Includes All Tests", true);
		JRadioButton averageDrop1 = new JRadioButton("Average Drops Lowest Test");
		JRadioButton averageDrop2 = new JRadioButton("Average Drops 2 Lowest Tests");

		//Group the radio buttons
		ButtonGroup averageBg = new ButtonGroup();
		averageBg.add(averageAll);
		averageBg.add(averageDrop1);
		averageBg.add(averageDrop2);

		//Make a border for the statistics panel.
		statisticsPanel.setBorder(BorderFactory.createTitledBorder("Statistics"));

		//Add the radio buttons  to the panel
		statisticsPanel.add(averageAll);
		statisticsPanel.add(averageDrop1);
		statisticsPanel.add(averageDrop2);

		//Create some check boxes
		JCheckBox average = new JCheckBox("Average");
		JCheckBox maximum = new JCheckBox("Maximum");
		JCheckBox minimum = new JCheckBox("Minimum");
		JCheckBox letterGrade= new JCheckBox("Letter Grade");

		//Add the check boxes to the panel
		statisticsPanel.add(average);
		statisticsPanel.add(maximum);
		statisticsPanel.add(minimum);
		statisticsPanel.add(letterGrade);
	}

	/*
		Private inner class to handle the user clicking calculate
	*/

	private class CalcButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			getInputs(grade);

			//Variables to hold ave, max and min
			double ave, max, min;

			//Calulate ave, max and min
			ave = getAverage(grade);
			min = getMinimum(grade);
			max = getMaximum(grade);

			//Create a DecimalFormat object to format output.
			DecimalFormat grd= new DecimalFormat("0.00");

			//Display the data to the user.
			JOptionPane.showMessageDialog(null, "Average:"+grd.format(ave)+
															"\nMaximum:"+grd.format(max)+
															"\nMinimum:"+grd.format(min));
		}
	}
	/*
		getAverage method
		@param grade
		@ return the average grade
	*/
	private double getAverage(double[] grade)
	{
		double sum = 0;	//To acumulate the sum
		double average;	//To hold the average

		for (int index = 0; index < grade.length; index++)
			sum = sum + grade[index];
		average = sum/4;

		//Set up an instance of the decimal format class to handle the average
		DecimalFormat twoPlaces = new DecimalFormat("0.00");
		average = Double.parseDouble(twoPlaces.format(average));

		return average;
	}

	private double getMinimum(double[] scores)
	{
		return 25;
	}

	private double getMaximum(double[] scores)
	{
		return 25;
	}
	public static void main(String[] args)
	{
		StatisticsCalculator gui = new StatisticsCalculator();
	}

}

