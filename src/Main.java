import java.util.ArrayList;
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
		ArrayList<String> studentClassNames = new ArrayList<>();
		ArrayList<Double> studentGrades = new ArrayList<>();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter your name.");
		studentName = scanner.next();

		System.out.println("Please enter your age.");
		studentAge = scanner.nextInt();

		System.out.println("Please enter your gender in the format of male, female, or other.");
		studentGender = scanner.next();

		System.out.println("How many classes do you have?");
		studentNumberOfClasses = scanner.nextInt();

		//ask the student for their grade in each of their classes depending on how many classes they said they have
		//we take each grade and add it to the studentGrades arraylist
		//ask the student for their class names and add the names to a class name arraylist
		for(int i = 1; i <= studentNumberOfClasses; i++)
		{
			System.out.println("What is the name of class " + i + "?");
			String name = scanner.next();
			System.out.println("What is your grade for class " + i + "?");
			double grade = scanner.nextDouble();

			//add class names and grades to the names and grades arraylists
			studentClassNames.add(name);
			studentGrades.add(grade);
		}

		//close scanner
		scanner.close();
	}

}
