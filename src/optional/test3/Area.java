package optional.test3;

import java.util.Optional;

public class Area {
    public void test(){
        Student student = new Student(null);
        System.out.println(getSchoolEmail(student));
    }

    public String getSchoolEmail(Student student) {
        return Optional.ofNullable(student)
                .map(Student::getProfile)
                .map(Profile::getContact)
                .map(Contact::getSchoolEmail)
                .orElse("이메일 없음");
    }
}
