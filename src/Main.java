import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
    	
    	UserInteraction userInteraction = new UserInteraction();
        String studentName;
        int studentAge;
        String studentGender;
        int studentNumberOfClasses;
        double studentGpa = 0.00; 
        ArrayList<String> studentClassNames = new ArrayList<>();
        ArrayList<Double> studentGrades = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Student Management System built by Andrew and Lexi! Type 1 if you "
        		+ "would like to create an account, type 2 if you would like to edit a current account's "
        		+ "information, or type 3 if you would like to view your grades or gpa.");

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

        //GPA Calculator
        double numerator = 0;
        double denominator;
        for(int x = 0; x <= studentGrades.size()-1; x++)
        {
            numerator = numerator + studentGrades.get(x);
            denominator = x + 1;
            studentGpa = numerator / denominator;
            System.out.println(numerator + " " + denominator);
        }
        System.out.println("Student's overall GPA is: " + studentGpa);

        //To Do List
        Scanner input = new Scanner(System.in);
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
                option = input.nextInt();

                int count = 0;
                if (option == 1) {  
                    System.out.println("Type an item that you would like to enter in your To Do list, then press enter/return to add it to the list. You can have up to 50 items in the list at a time. If you would like to stop entering items, type 'stop'.");
                    for (int i = 0; i < MAX; i++) {
                        toDoList.add(input.nextLine());
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
            System.out.println("Okay, Goodbye.");  //add more to this or change it up later
        }

        //close scanner
        scanner.close();
    }

}
