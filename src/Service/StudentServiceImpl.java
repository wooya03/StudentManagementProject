package Service;

import model.Student;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {
    ArrayList<Student> students= new ArrayList<>();
    @Override
    public void regist(Student student) {
        students.add(student);
    }

    @Override
    public ArrayList<Student> list() {
        return students;
    }

    @Override
    public void modify(Student student) {
        Student s = get(student.getId());
        if (s != null) {
            if (student.getName() != null && !student.getName().isEmpty())
                s.setName(student.getName());
            if (student.getGrades() != null && student.getGrades().size() > 0)
                s.setGrades(student.getGrades());
        }
    }

    public Student get(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void remove(String id) {
        Student s = get(id);
        students.remove(s);
    }
}
