package entity;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentImp implements Student{
    private String name;
    private String course;
    private Integer year;
    private Double GPA;
    private String marks;

    public StudentImp(String name, String course, Integer year){
        this.name = name;
        this.course = course;
        this.year = year;
        this.GPA = 0d;
        this.marks = "Math (0), Science(0), English (0)";
    }

    private void updateGPA(){
        Pattern pattern = Pattern.compile("\\w+\\s*\\((\\d+)\\)");
        Double totalScore = 0d;
        Double totalSubjects = 0d;

        for(String subjectMark: marks.split(",")){
            Matcher matcher = pattern.matcher(subjectMark.trim());
            if(matcher.find()){
               Double mark = Double.parseDouble(matcher.group(1));
               if(90<=mark){
                totalScore = totalScore + 4.0;
               } else if(80<=mark){
                totalScore = totalScore + 3.7;
               } else if(70<=mark){
                totalScore = totalScore + 3.0;
               } else if(60<=mark){
                totalScore = totalScore + 2.0;
               } else if(50<=mark){
                totalScore = totalScore + 1.7;
               }
               totalSubjects++;
            }else{
                System.out.println("Marks are not valid");
                return;
            }
        }

        this.GPA = totalScore/totalSubjects;
    }

    public void showDetails(){
        System.out.println(
            "Student Name: "+this.name
            +"\nCourse: "+this.course
            +"\nYear: "+this.year
            +"\nMarks: "+this.marks
            +"\nGPA: "+new DecimalFormat("#.##").format(this.GPA)
        );
    }

    public void updateMarks(String marks){
        this.marks = marks;
        updateGPA();
    }

    public Double getGPA(){
        return GPA;
    }
}
