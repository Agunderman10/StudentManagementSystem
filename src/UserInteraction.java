import java.io.*;
import java.util.*;

public class UserInteraction 
{
	private String studentName;
	private String studentUsername;
	private String studentPassword;
    private int studentAge;
    private String studentGender;
    private int studentNumberOfClasses;
    private double studentGpa = 0.00; 
    private ArrayList<String> studentClassNames = new ArrayList<>();
    private ArrayList<Double> studentGrades = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	
	public void AskUserForFunctionChoice()
	{
		int userChosenFunction = 0;
		
		do 
		{
			System.out.println("Welcome to the Student Management System built by Andrew and Lexi! Type 1 if you "
		        	+ "would like to create an account or type 2 if you would like to view or edit a current account's"
		        	+ "information.");
		    userChosenFunction = scanner.nextInt();
		    //this will crash if user inputs a string, need to fix later
	        
	        if(userChosenFunction != 1 && userChosenFunction != 2) 
	        {
	        	System.out.println("Please enter a valid option, 1 or 2.");
	        }
		}
		while(userChosenFunction != 1 && userChosenFunction != 2); 
		
		if(userChosenFunction == 1) 
	    {
	        GetInfoToCreateNewAccount();
	    }
	    else if(userChosenFunction == 2) 
	    {
	    	Login();
	    }
	}
	
	private void GetInfoToCreateNewAccount() 
	{
		System.out.println("Please enter the username for your new account.");
		studentUsername = scanner.next();
		
		System.out.println("Please enter the password for your new account. ");
		studentPassword = scanner.next();
		
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
        
        //print new account info to accounts file
        try 
    	{
    		File accountsContainerFile = new File("Accounts.txt");
    		WriteAccountInfoToFile(studentUsername + " ", studentPassword + " ", studentName + " ", studentAge + " ", 
    				studentGender + "\n", accountsContainerFile);
    	}
    	catch(IOException e) 
    	{
    		System.out.println("Unable to create account.");
    	}
        
        AfterLogin();
	}
	
	private void WriteAccountInfoToFile(String accountUsername, String accountPassword,
			String studentName, String studentAge, String studentGender, File file) throws IOException 
	{
		FileWriter fileWriter = new FileWriter(file, true);
		fileWriter.write(accountUsername);
		fileWriter.write(accountPassword);
		fileWriter.write(studentName);
		fileWriter.write(studentAge);
		fileWriter.write(studentGender);
		fileWriter.close();
	}
	
	private void Login() 
	{
		Scanner scanFile = null;
		
		try
		{
			scanFile = new Scanner(new File("Accounts.txt"));
		}
		catch(Exception e)
		{
			System.out.println("Could not find file.");
		}
		
		String username = scanFile.next();
		String password = scanFile.next();
		
		System.out.println("Please enter your username.");
		String enteredUsername = scanner.next();
		
		while(!(username.equals(enteredUsername)))
		{
			System.out.println("Incorrect username.");
			System.out.println("Please enter your username.");
			enteredUsername = scanner.next();
		}
		
		System.out.println("Please enter your password.");
		String enteredPassword = scanner.next();
		
		while(!(password.equals(enteredPassword)))
		{
			System.out.println("Incorrect password.");
			System.out.println("Please enter your password.");
			enteredPassword = scanner.next();
		}
		
		AfterLogin();
		
		scanFile.close();
	}
	
	private void AfterLogin() 
	{
		Scanner scanFile = null;
		try 
		{
			scanFile = new Scanner(new File("Accounts.txt"));
		}
		catch(Exception e) 
		{
			System.out.println("Could not find file.");
		}
		
		scanFile.next();
		scanFile.next();
		String GetStudentName = scanFile.next();
		
		System.out.println("Welcome " + GetStudentName + ". Type 1 if you would like to see your GPA or type 2 if "
				+ "you would like to see your to do list.");
		String userChoice = scanner.next();
		
		while(userChoice != "1" || userChoice != "2")
		{
			if(userChoice.equals("1")) 
			{
				GPACalculator();
				return;
			}
			else if (userChoice.equals("2"))
			{
				ToDoList();
				return;
			}
			else
			{
				System.out.println("Invalid option. Please choose a valid"
						+ " option.");
				userChoice = scanner.next();
			}
		}
	}
	
	private void GPACalculator() 
	{
        double numerator = 0;
        double denominator;
        for(int x = 0; x <= studentGrades.size() - 1; x++)
        {
            numerator = numerator + studentGrades.get(x);
            denominator = x + 1;
            studentGpa = numerator / denominator;
            System.out.println(numerator + " " + denominator);
        }
        System.out.println("Student's overall GPA is: " + studentGpa);
	}
	
	private void ToDoList() 
	{
		final int MAX = 50;
        ArrayList<String> toDoList = new ArrayList<>();
        int option = 0;
        String viewList;

        System.out.println("Would you like to view your to-do list? (yes or no)");
        viewList = scanner.next();
        if (viewList.equals("yes")) 
        {
            while (option != 3) {
                //prints out startup dialogue
                System.out.println("Welcome to your To Do list! You can enter homework assignments, upcoming tests/quizzes to study for, and more here!");
                System.out.println();
                System.out.println("Type 1 to add a new thing to your to do list.");
                System.out.println("Type 2 to print the to do list.");
                System.out.println("Type 3 to exit the program.");
                System.out.print("Enter a number: ");
                option = scanner.nextInt();

                int count = 0;
                if (option == 1) {  
                    System.out.println("Type an item that you would like to enter in your To Do list, then press enter/return to add it to the list. You can have up to 50 items in the list at a time. If you would like to stop entering items, type 'stop'.");
                    for (int i = 0; i < MAX; i++) {
                        toDoList.add(scanner.nextLine());
                        if (toDoList.get(i).equals("stop")) break;
                        count++;
                    }
                }

                if (option == 2) {
                    System.out.println("");
                    System.out.println("TO DO:");
                    System.out.println("-----------------------------");
                    for (String x : toDoList) 
                    {
                        System.out.println(x);
                    }             
                }

            }
        }
        else if (viewList.equals("no"))
        {
            System.out.println("Okay, Goodbye " + studentName + ".");  //add more to this or change it up later
        }

        //close scanner
        scanner.close();
	}
}
