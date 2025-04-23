package solid.ocp.before;

import domain.Student;

public class Notification {
    public void send(Student student,String type){
        switch (type) {
            case "email" -> System.out.println("이메일 전송: " + student.getName());
            case "sms" -> System.out.println("SMS 전송: " + student.getName());
            case "push" -> System.out.println("푸시 알림 전송: " + student.getName());
        }
    }
}
