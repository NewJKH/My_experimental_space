package solid.srp.before;

import domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainManager {
    // 학생들의 정보
    private final List<Student> students;

    public MainManager() {
        students = new ArrayList<>();
    }

    // 책임 1: 학생 저장 (비즈니스 로직)
    public void save(Student student) {
        System.out.println("입력받은 학생 로직 처리 중...");
        student.setName(student.getName().trim().toUpperCase());
        students.add(student);
        saveToFile();
    }

    // 책임 2: 화면 출력
    public void print() {
        System.out.println("=== 학생 목록 출력 ===");
        for (Student student : students) {
            System.out.println("ID: " + student.getId() + ", 이름: " + student.getName());
        }
    }

    // 책임 3: 파일 저장
    public void saveToFile() {
        System.out.println("학생 데이터를 파일로 저장 중...");
    }

    // 책임 4: 이메일 전송
    public void sendEmail(Student student) {
        System.out.println(student.getName() + "에게 이메일 전송 중...");
    }

    // 책임 5: 특정 학생 조회
    public Optional<Student> getStudentById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }
}

