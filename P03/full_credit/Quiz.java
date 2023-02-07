import java.util.Scanner;

public class Quiz
{
	private Question[] questions;
	
	public Quiz()
	{
		loadQuiz();
	}
	
	public double takeQuiz()
	{
		double counter =0;
		Scanner in = new Scanner(System.in);
		
		for(int i=0;i<questions.length;i++)
		{
			boolean j=false;
			int ans=0;
			int wrong=0;
			int k=3;
			while(wrong < 2 || j == false)
			{
				System.out.println("You only have " + k + " attempts\n");
				System.out.println(questions[i].toString());
				
				System.out.println("Input your answer");
				ans = in.nextInt();
				
				j = questions[i].checkAnswer(ans);
				k--;
				if(j == true)
				{
					System.out.println("CORRECT!\n");
					wrong =  3;
					counter ++;
				}
				else if(wrong >= 2)
				{
					System.out.println("INCORRECT!\n");
					j = true;
				}
				else
				{
					System.out.println("INCORRECT!\n");
					wrong ++;
					
				}
				System.out.println("\n\n\n");
			}

		}
		return counter/(questions.length);
	}
	
	private void loadQuiz()
	{
		String[] options1 = {"Emmanuel","David","Sam","John"};
		String[] options2 = {"18","19","20","21"};
		questions = new Question[2];
		questions[0] = new Question("What is my name", options1, 1 );
		questions[1] = new Question("How old am I", options2, 2 );
		
	}
}
