package solid.ocp.after;

import domain.Student;

public class SmsNotification implements Notifier {
    @Override
    public void send(Student student) {
        System.out.println("SMS 전송: " + student.getName());
    }
}
