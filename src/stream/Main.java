package stream;

import stream.data.DateContainer;
import stream.hard.serivce.StreamTest;

public class Main {
    public static void main(String[] args){
        new DateContainer();
        StreamTest test = new StreamTest();
        test.forLoop();
        test.improvedForLoop();
        test.streamLoop();
        test.streamWithManualSum();
    }
}
