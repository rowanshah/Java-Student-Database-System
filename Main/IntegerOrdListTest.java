package library;

import java.util.Scanner;

public class IntegerOrdListTest {

    public static void main(String[] args) {
	// main for part 1 of the assignment 
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        int userChoice;
        IntegerOrdList myIntegerList = new IntegerOrdList();
        // menu defined below 
        do {
        	System.out.println("--------------------------");
        	System.out.println("Select a following option:\n");
            System.out.println("1: Insert a new node");
            System.out.println("2: Delete a node");
            System.out.println("3: Print the list");
            System.out.println("4: Exit the program");
            System.out.println("--------------------------");

            userChoice = sc.nextInt();

            switch (userChoice){
                case 1:
                	//when user wants to insert a node
                    System.out.println("Enter a value for the new node: ");
                    int newData = sc.nextInt();
                    myIntegerList.insert(newData);
                    break;
                case 2:
                	//when user wants to delete a node
                    System.out.println("Enter the value of the node you want to delete: ");
                    int deleteThis = sc.nextInt();
                    if (myIntegerList.find(deleteThis) == null){
                        System.out.println("This value is not in the list. ");
                        continue;
                    }
                    else {
                        myIntegerList.remove(deleteThis);
                    }
                    break;
                case 3:
                	//when user wants to print the list
                    System.out.println("\nThe list is the following:");
                    myIntegerList.PrintAll();
                    break;
                case 4:
                	//when user wants to exit the program
                    break;
                default:
                    System.out.println("There was an error in your input! \n");
                    break;
            }

        }while (userChoice != 4);
    }
}
