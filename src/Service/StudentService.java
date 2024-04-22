package Service;
import model.Student;

import java.util.ArrayList;

public interface StudentService {
    void regist(Student student);
    ArrayList<Student> list();
    void modify(Student student);
    void remove(String id);
}
