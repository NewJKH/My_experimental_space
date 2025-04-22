package abs.inter;

public class Streaming extends BasePlayer implements Playable {
    @Override
    public void play(String track) {
        super.currentTrack = track;
        System.out.println(super.currentTrack + " 재생 시작");
    }

    @Override
    public void stop() {
        System.out.println(super.currentTrack + " 정지");
    }

    @Override
    public void nextTrack() {
        System.out.println(" 다음 트랙~ ! ");
    }
}
