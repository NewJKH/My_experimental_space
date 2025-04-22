package abs;

import abs.inter.Streaming;

public class AbstractTest {
    public static void main(String[] args) {
        Streaming streaming = new Streaming();
        streaming.play(" 스트링! ");
        streaming.stop();
        streaming.nextTrack();
    }
}
