import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int MAX = 50;
        ArrayList<String> toDoList = new ArrayList<>();
        int option = 0;

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
                for (int i=0;i<MAX;i++) {
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
}
//will add a delete option to "cross off the list" later
