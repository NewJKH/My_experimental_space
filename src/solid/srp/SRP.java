package solid.srp;

import domain.Student;
import solid.srp.after.StudentEmailSender;
import solid.srp.after.StudentFileSaver;
import solid.srp.after.StudentPrinter;
import solid.srp.after.StudentService;

public class SRP {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        StudentPrinter printer = new StudentPrinter();
        StudentFileSaver fileSaver = new StudentFileSaver();
        StudentEmailSender emailSender = new StudentEmailSender();

        Student s1 = new Student(1, "   Alice ",20,"M");
        Student s2 = new Student(2, "Bob",25,"F");

        service.save(s1);
        service.save(s2);

        printer.print(service.getAllStudents());
        fileSaver.save(service.getAllStudents());
        emailSender.sendEmail(s1);
    }
}
