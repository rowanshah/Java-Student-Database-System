package library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentRecordOrdListTest {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        int userChoice = 0;
        StudentRecordOrdList myStudentDataBase = new StudentRecordOrdList();
        // menu defined below 
        do {
        	System.out.println("-------------------------------------------");
        	System.out.println("Please select one of the following options:\n");
            System.out.println("1: Insert a new student");
            System.out.println("2: Delete a student");
            System.out.println("3: Introduce a student's average mark");
            System.out.println("4: Print a student's record");
            System.out.println("5: Print records of all students");
            System.out.println("6: Exit the program");
            System.out.println("-------------------------------------------");
            try {
                userChoice = sc.nextInt();
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Choose an action (input must be an integer)");
                continue;
            }


            switch (userChoice){
                case 1:
                	String surname;
                	while(true) {
                    System.out.println("Enter surname and first name of the new student: ");
                    surname = sc.next();
              
	                    try {
	                        for(char c : surname.toCharArray()){
	                            if((int)c < 65 || (int)c > 122){
	                                throw new InputMismatchException();
	                            }
	                        }
	                        break;
	                    } catch (InputMismatchException e){
	                        sc.nextLine();
	                        System.out.println("Error: Name cannot contain symbols or numbers.");
	                   
	                    }
                    }

                    String name = sc.next();
                    try {
                        for(char c : name.toCharArray()){
                            if((int)c < 65 || (int)c > 122){
                                throw new InputMismatchException();
                            }
                        }
                    } catch (InputMismatchException e){
                        sc.nextLine();
                        System.out.println("Error: Name cannot contain symbols or numbers.");
                        break;
                    }
                    int studentNo;
                    while(true) {
	                    System.out.println("Enter student number: ");
	                    try {
	                        studentNo = sc.nextInt();
	                        if (studentNo <= 0) {
	                            sc.nextLine();
	                            System.out.println("Error: Student number cannot be zero or negative.");
	                            continue;
	                        }
	                        break;
	                    } catch (InputMismatchException e){
	                        sc.nextLine();
	                        System.out.println("Error: Entered data is not of correct type.");
	                    }
                    }
                    StudentRecord newStudent = new StudentRecord(surname, name, studentNo);
                    myStudentDataBase.insert(newStudent);
                    break;

                    case 2:
                    if (myStudentDataBase.head == null) {
                        System.out.println("List is empty.");
                        break;
                    }
                    System.out.println("Enter the surname and name of the student you wish to delete: ");
                    String deleteSurname = sc.next();
                    String deleteName = sc.next();
                    sc.nextLine();                   
    
                    StudentRecord deleteThis = new StudentRecord(deleteSurname, deleteName, 0);
                    if (myStudentDataBase.find(deleteThis) == null){
                        System.out.println("Error: The student is not in the database");
                        break;
                    }
                    else {
                        myStudentDataBase.remove(deleteThis);
                    }
                    break;

                case 3:
                    System.out.println("Enter the student's surname and first name you want to add an average mark:");
                    String addMarkSurname = sc.next();
                    String addMarkName = sc.next();
                    StudentRecord student = new StudentRecord(addMarkSurname, addMarkName, 0);
                    ListNode studentNode = myStudentDataBase.find(student);
                    if (studentNode == null) {
                        System.out.println("Error: student is not in the database");
                        break;
                    }
                    System.out.println("Enter average mark:");
                    float mark;
                    try {
                        mark = sc.nextFloat();
                        if (mark < 0) {
                            System.out.println("Error: mark needs to be greater than 0.");
                            sc.nextLine();
                            break;
                        }
                    } catch (InputMismatchException e){
                        System.out.println("Please enter a float number");
                        sc.nextLine();
                        break;

                    }
                    student = (StudentRecord) studentNode.getData();
                    student.setAverageMark(mark);
                    break;

                case 4:
                    if (myStudentDataBase.head == null) {
                        System.out.println("List is empty.");
                        break;
                    }
                    System.out.println("Enter the student's surname and first name you wish to print the record:");
                    String printThisSurname = sc.next();
                    String printThisName = sc.next();
                    StudentRecord findThis = new StudentRecord(printThisSurname, printThisName, 0);
                    Object studentPrint = myStudentDataBase.find(findThis).getData();
                    System.out.println(studentPrint.toString());
                    break;
                case 5:
                    myStudentDataBase.printAll();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Error! Incorrect input.");
                    break;
            }

        } while (userChoice != 6);
    }
}
