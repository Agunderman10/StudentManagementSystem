import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		String studentName;
		int studentAge;
		String studentGender;
		int studentNumberOfClasses;
		double studentGpa; /* can be calculated later */

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter your name.");
		studentName = scanner.next();
		
		System.out.println("Please enter your age.");
		studentAge = scanner.nextInt();
		
		System.out.println("Please enter your gender in the format of male, female, or other.");
		studentGender = scanner.next(); 
		
		System.out.println("How many classes do you have?");
		studentNumberOfClasses = scanner.nextInt();
		
		//init array that will contain the student's grades
		int[] studentGrades = new int[studentNumberOfClasses];
		
		//ask the student for their grade in each of their classes depending on how many classes they said they have
		//we take each grade and add it to the studentGrades array
		for(int i = 1; i <= studentNumberOfClasses; i++) 
		{
			System.out.println("What is your grade for class " + i + "?");
			int grade = scanner.nextInt();
			studentGrades[i - 1] = grade;
		}
	}

}
