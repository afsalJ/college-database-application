package service;

import java.util.HashMap;
import java.util.Map;

import entity.Student;
import entity.StudentImp;

public class StudentDatabaseService {
    private Map<Integer, Student> studentsDatabase;
    private Integer studentId;

    public StudentDatabaseService(){
        studentsDatabase = new HashMap<>();
        studentId = 0;
    }

    public String addStudent(String name, String course, Integer year){
        Student student = new StudentImp(name, course, year);
        studentsDatabase.put(studentId++, student);
        return "Student added successfully!";
    }

    public String updateMarks(Integer studentId, String marks){
        if(studentsDatabase.containsKey(studentId)){
            return "Student with id "+studentId+" Not found!";
        }
        Student student = studentsDatabase.get(studentId);
        student.updateMarks(marks);
        return "Marks updated successfully. CurrentGPA: "+ student.getGPA();
    }

    public void showDetails(Integer studentId){
        if(studentsDatabase.containsKey(studentId)){
            System.out.println("Student with id "+studentId+" Not found!");
        }
        studentsDatabase.get(studentId).showDetails();
    }
}