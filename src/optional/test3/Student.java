package optional.test3;

public class Student {
    private final Profile profile;

    public Student(Profile profile) {
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }
}