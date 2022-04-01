package assignment2;

import java.util.Scanner;

public class StudentInformationMain {

	public static void main(String[] args) {
		
		int select;
		int studID;
		
		StudentModel model = new StudentModel();
		StudentView view = new StudentView();
		StudentController control = new StudentController(model, view);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Student Information Database System! \r");
		System.out.println("Please select and enter number below:-");
		System.out.println("1 - Register student");
		System.out.println("2 - Retrieve student data \r");
		
		System.out.print("Enter number : ");
		select = input.nextInt();
		
		if (select == 1) {
			int id;
			String name;
			int math, science, english;
			
			System.out.println("\rPlease enter student data:-");
			System.out.print("Student ID : ");
			id = input.nextInt();
			System.out.print("Student Name : ");
			name = input.next();
			System.out.print("Math Mark : ");
			math = input.nextInt();
			System.out.print("Science Mark : ");
			science = input.nextInt();
			System.out.print("English Mark : ");
			english = input.nextInt();
			
			control.registerStudent(id, name, math, science, english);
			
			System.out.println("\rYour data has been saved!");
			
		} else if (select == 2) {
			System.out.println("You select two!");
			System.out.println("Enter studentID that you want to find : ");
			studID = input.nextInt();
			
			//Searching for studentID in the database and display the information about the student
			control.readStudentData(studID);
			
			System.out.println("\rYour data has been displayed!");
			
		} else {
			System.out.println("You should select either one or two!");
		}

	}

}
