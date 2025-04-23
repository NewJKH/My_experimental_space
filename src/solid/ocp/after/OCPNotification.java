package solid.ocp.after;

import domain.Student;

public class OCPNotification {
    private final Notifier notifier;

    public OCPNotification(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notify(Student student) {
        notifier.send(student);
    }
}
