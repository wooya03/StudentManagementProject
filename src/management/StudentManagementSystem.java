package management;

import Service.StudentService;
import Service.StudentServiceImpl;
import model.Grade;
import model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem implements StudentManagement{
    Scanner scanner;
    Student student;
    StudentService studentservice;
    public StudentManagementSystem() {
        System.out.println("[StudentManagementSystem 준비]");
        scanner = new Scanner(System.in);
        studentservice = new StudentServiceImpl();
    }

    public void execute(){
        System.out.println("[StudentManagementSystem 실행]");
        while(true){
            System.out.println("===================");
            System.out.println("1. 학생등록");
            System.out.println("2. 학생조회");
            System.out.println("3. 학생수정");
            System.out.println("4. 학생삭제");
            System.out.println("5. 시스템 종료");
            System.out.println("===================");
            System.out.println("메뉴를 선택하세요.");
            System.out.println("===================");
            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("학생 등록을 선택하셨습니다...");
                    regist();
                    break;
                case 2:
                    System.out.println("학생 조회를 선택하셨습니다...");
                    list();
                    break;
                case 3:
                    System.out.println("학생 수정을 선택하셨습니다...");
                    modify();
                    break;
                case 4:
                    System.out.println("학생 삭제를 선택하셨습니다...");
                    remove();
                    break;
                case 5:
                    System.out.println("시스템 종료를 선택하셨습니다...");
                    System.exit(0);
            }
        }
    }

    public void regist(){
        System.out.print("이름 : ");
        String name = scanner.next();
        System.out.print("학번 : ");
        String id = scanner.next();
        Grade grades;
        ArrayList<Grade> arrayList = new ArrayList<>();
        while(true){
            System.out.print("과목 : ");
            String subject = scanner.next();
            System.out.print("점수 : ");
            double score = scanner.nextDouble();
            grades = new Grade(subject, score);
            arrayList.add(grades);
            System.out.print(name + "학생의 성적 등록 [추가:1], [종료:0] : ");
            int c = scanner.nextInt();
            if(c == 0) break;
        }
        student = new Student(id, name);
        student.setGrades(arrayList);
        studentservice.regist(student);
    }

    public void list(){
        for(Student s : studentservice.list()){
         s.print();
        }
    }

    public void modify() {
        System.out.print("학번 : ");
        String id = scanner.next();
        System.out.print("[이름 수정:1] [건너뛰기:0] : ");
        String choice = scanner.next();
        Student student = new Student(id);
        if (choice.equals("1")) {
            System.out.print("이름 : ");
            String name = scanner.next();
            student.setName(name);
        }
        while (true) {
            System.out.print("[성적 재등록:1] [건너뛰기:0] : ");
            choice = scanner.next();
            if (choice.equals("1")) {
                System.out.print("과목 : ");
                String subject = scanner.next();
                System.out.print("점수 : ");
                double score = Double.valueOf(scanner.next());
                student.addGrade(new Grade(subject, score));
            } else {
                break;
            }
        }
        studentservice.modify(student);
        System.out.println("성공적으로 학생 수정이 완료되었습니다...");
    }

    public void remove(){
        System.out.print("학번 : ");
        String id = scanner.next();
        studentservice.remove(id);
    }

}
