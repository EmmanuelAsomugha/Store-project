import java.util.Scanner;

public class Quizzer
{
	public static void main(String[] args)
	{
		try
		{
			Quiz quiz = new Quiz();
			System.out.println(quiz.takeQuiz() * 100 + "\n" + "You were Awesome!!");
			
		}
		catch(IllegalArgumentException i)
		{
			System.err.println("Bad Argument");
			System.exit(-1);
			
		}
		
	}
}
