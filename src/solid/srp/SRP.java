package solid.srp;

import domain.Student;
import solid.srp.before.MainManager;

import java.util.Optional;

public class SRP {
    public static void main(String[] args) {
        MainManager manager = new MainManager();

        Student s1 = new Student(1, "   Alice ",10,"M");
        Student s2 = new Student(2, "Bob",15,"F");

        manager.save(s1);
        manager.save(s2);

        manager.print();
        manager.saveToFile();
        manager.sendEmail(s1);

        Optional<Student> found = manager.getStudentById(2);
        found.ifPresent(
                student -> System.out.println("찾은 학생: " + student.getName())
        );
    }
}
