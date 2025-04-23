package solid.ocp.after;

import domain.Student;

public class PushNotification implements Notifier {
    @Override
    public void send(Student student) {
        System.out.println("푸시 알림 전송: " + student.getName());
    }
}
