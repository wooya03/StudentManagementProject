package model;

import java.util.ArrayList;

public class Student {
    private String id;
    private String name;

    private ArrayList<Grade> grades;

    public Student(String id) {
        this(id, "");
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        grades = new ArrayList<>();
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public void addGrade(String subject, double score) {
        Grade grade = new Grade(subject, score);
        grades.add(grade);
    }

    public void print() {
        System.out.println("=================================");
        System.out.println("학번 : " + id);
        System.out.println("이름 : " + name);
        System.out.print("성적 : ");
        for (Grade grade : grades) {
            System.out.print("[ " + grade.getSubject() + ": " + grade.getScore() + " ] ");
        }
        System.out.println();
        System.out.println("=================================");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }
}

