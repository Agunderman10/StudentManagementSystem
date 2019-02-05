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
		
	}

}
