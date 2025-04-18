package stream.hard.serivce;

import stream.hard.domain.Person;

import static stream.data.DateContainer.persons;

public class StreamTest {
    public void forLoop(){
        long start = System.nanoTime();

        int sum = 0;
        int i = 0;
        for ( ; i<persons.size();i++){
            if (persons.get(i).getName().startsWith("A") && persons.get(i).getAge() > 30) {
                sum++;
            }
        }

        System.out.println("총 인원 (for-loop): " + sum);
        long end = System.nanoTime();
        System.out.println("for-loop 처리 시간: " + (end - start) / 1_000_000.0 + " ms\n");
    }
    public void improvedForLoop(){
        long start = System.nanoTime();

        int sum = 0;
        for (Person person : persons) {
            if (person.getName().startsWith("A") && person.getAge() > 30) {
                sum++;
            }
        }

        System.out.println("총 인원 (for-loop (improved)): " + sum);
        long end = System.nanoTime();
        System.out.println("for-loop(improved) 처리 시간: " + (end - start) / 1_000_000.0 + " ms\n");
    }
    public void streamLoop() {
        long start = System.nanoTime();

        long count = persons.stream()
                .filter(p -> p.getName().startsWith("A") && p.getAge() > 30)
                .count();

        System.out.println("총 인원 (stream): " + count);
        long end = System.nanoTime();
        System.out.println("stream 처리 시간: " + (end - start) / 1_000_000.0 + " ms\n");
    }
    public void streamWithManualSum(){
        long start = System.nanoTime();

        int[] sum = new int[1];

        persons.stream()
                .filter(p -> p.getName().startsWith("A") && p.getAge() > 30)
                .forEach(p -> sum[0]++);

        System.out.println("총 인원 (stream manual sum): " + sum[0]);

        long end = System.nanoTime();
        System.out.println("manualSum 처리 시간: " + (end - start) / 1_000_000.0 + " ms\n");
    }
}
