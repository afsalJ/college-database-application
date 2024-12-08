package service;
import java.util.*;

public class UserService {
    private Scanner sc;
    private StudentDatabaseService studentDatabaseService;

    public UserService(){
        sc = new Scanner(System.in);
        studentDatabaseService = new StudentDatabaseService();

        while(true){
            System.out.print("Operation: ");
            String operation = sc.nextLine();
            if(operation.equalsIgnoreCase("add student")){
                addStudent();
            }else if(operation.equalsIgnoreCase("update marks")){
                updateMarks();
            } else if(operation.equalsIgnoreCase("view details")){
                viewDetails();
            } else if (operation.equalsIgnoreCase("view student details")){
                viewStudentDetials();
            }else{
                System.out.println("Are you sure!(yes/No)");
                String isSureToExit = sc.nextLine();
                if(isSureToExit.equalsIgnoreCase("yes")){
                    return;
                }
            }
            System.out.println("\n\n");
        }
    }

    public void addStudent(){
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Course: ");
        String course = sc.nextLine();
        System.out.print("Year: ");
        Integer year = sc.nextInt();
        sc.nextLine();

        System.out.println(studentDatabaseService.addStudent(name, course, year));

    }

    public void updateMarks(){
        System.out.print("Student ID: ");
        Integer studentId = sc.nextInt();
        sc.nextLine();
        System.out.print("Subject Marks: ");
        String subjectMarks = sc.nextLine();
        
        System.out.println(studentDatabaseService.updateMarks(studentId, subjectMarks));
    }

    public void viewDetails(){
        studentDatabaseService.showAllStudentDetails();
    }

    public void viewStudentDetials(){
        System.out.print("Student ID: ");
        Integer studentID = sc.nextInt();
        sc.nextLine();

        studentDatabaseService.showDetails(studentID);
    }
}
