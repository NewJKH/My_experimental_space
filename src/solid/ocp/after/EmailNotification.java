package solid.ocp.after;

import domain.Student;

public class EmailNotification implements Notifier{
    @Override
    public void send(Student student) {
        System.out.println("이메일 전송: " + student.getName());
    }
}
