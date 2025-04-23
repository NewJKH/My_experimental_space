package solid.srp.after;

import domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void save(Student student) {
        logic(student);
        students.add(student);
    }

    private void logic(Student student) {
        student.setName(student.getName().trim().toUpperCase());
    }

    public Optional<Student> getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
