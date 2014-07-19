Public class Grades extends JPanel
{
		private JTextField[] testScores;
		JTextField[] grade = new JTextField[4];

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
				grade[index] = getGrade(testScores[index]);
			}

		//Border the panel.
		scoresPanel.setBorder(BorderFactory.createTitledBorder("Test Scores"));
		}

	 public JTextField getGrade()
	    {
	        JTextField grade = testScores[0];

	        for (int i = 0; i < testScores.length; i++ )
	        {

	            grade = inputBox[i];

	        }

        return grade;
    }
