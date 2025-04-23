package solid.ocp;

import domain.Student;
import solid.ocp.after.EmailNotification;
import solid.ocp.after.OCPNotification;
import solid.ocp.after.PushNotification;
import solid.ocp.after.SmsNotification;

public class OCP {
    public static void main(String[] args) {
        Student s1 = new Student(1, "   Alice ",20,"M");
        OCPNotification email = new OCPNotification(new EmailNotification());
        email.notify(s1);

        OCPNotification push = new OCPNotification(new PushNotification());
        push.notify(s1);

        OCPNotification sms = new OCPNotification(new SmsNotification());
        sms.notify(s1);
    }
}
