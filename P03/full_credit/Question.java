import java.util.Scanner;


public class Question
{
	private static int nextQuestionNumber = 1;
	private final int questionNumber;
	
	private String question;
	private String[] answers;
	private int rightAnswer;
	
	public Question(String question, String[] answers, int rightAnswer)
	{
		this.question = question;	
		this.answers = answers;
		this.rightAnswer = rightAnswer;
		questionNumber = nextQuestionNumber ++;
		
		if(rightAnswer < 1 || rightAnswer > answers.length)
		{
			throw new IllegalArgumentException("Invalid... ");
		}
	}
	
	public boolean checkAnswer(int answer)
	{
		if(answer == rightAnswer)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	@Override
	public String toString()
	{
		
		
		System.out.println(questionNumber + ". " + question + "\n");
		for(int i=0;i<answers.length;i++)
		{
			System.out.println("\t" + (i+1) + ")\t" + answers[i] + "\n"); 
		}
		return "";
	}
	
}
