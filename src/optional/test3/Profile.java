package optional.test3;

public class Profile {
    private final Contact contact;

    public Profile(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }
}
