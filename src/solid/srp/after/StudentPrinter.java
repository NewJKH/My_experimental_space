package solid.srp.after;

import domain.Student;

import java.util.List;

public class StudentPrinter {
    public void print(List<Student> students) {
        System.out.println(" 학생 목록 ");
        for (Student s : students) {
            System.out.println("ID: " + s.getId() + ", 이름: " + s.getName());
        }
    }
}
