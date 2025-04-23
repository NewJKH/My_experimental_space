package solid.srp.after;

import domain.Student;

public class StudentEmailSender {
    public void sendEmail(Student student) {
        System.out.println(student.getName() + "에게 이메일 전송 중...");
        // 이메일 전송 로직 생략
    }
}
