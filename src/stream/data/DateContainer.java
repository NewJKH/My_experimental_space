package stream.data;

import stream.hard.domain.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DateContainer {
    public static List<Person> persons;
    private final int MAX_PERSON = 100;

    public DateContainer() {
        persons = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < MAX_PERSON; i++) {
            String name = generateRandomName(random);
            int age = random.nextInt(60) + 18;
            persons.add(new Person(name, age));
        }
    }

    private String generateRandomName(Random random) {
        int length = random.nextInt(5) + 5;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(i == 0 ? Character.toUpperCase(c) : c);
        }

        return sb.toString();
    }
}
