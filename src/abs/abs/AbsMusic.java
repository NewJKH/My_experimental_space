package abs.abs;

abstract class AbsMusic {
    protected String currentTrack;

    public void play(String track) {
        this.currentTrack = track;
        System.out.println(track + " 재생 시작");
    }

    public void stop() {
        System.out.println(currentTrack + " 정지");
        currentTrack = null;
    }

    abstract void nextTrack();
}
