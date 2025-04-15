package optional.test3;

import java.util.Optional;

public class Area {
    public void test(){
        Contact contact = new Contact("student@sparta.kr");
        Profile profile = new Profile(contact);
        Student student = new Student(profile);

        System.out.println(getSchoolEmail(student));

        Contact contact1 = new Contact("student@sparta.ac.kr");
        Profile profile1 = new Profile(contact1);
        Student student1 = new Student(profile1);
        System.out.println(getSchoolEmail(student1));

        Student nullStudent = null;
        System.out.println(getSchoolEmail(nullStudent));
    }

    public String getSchoolEmail(Student student) {
        return Optional.ofNullable(student)
                .map(Student::getProfile)
                .map(Profile::getContact)
                .map(Contact::getSchoolEmail)
                .filter(email -> email.endsWith("@sparta.kr"))
                .orElse("스파르타 이메일이 아님");
    }
}
