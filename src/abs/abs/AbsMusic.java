package abs.abs;

abstract class AbsMusic {
    protected String currentTrack;

    public final void start(String track){
        play(track);
        stop();
        nextTrack();
    }

    private void play(String track) {
        this.currentTrack = track;
        System.out.println(track + " 재생 시작");
    }

    private void stop() {
        System.out.println(currentTrack + " 정지");
        currentTrack = null;
    }

    abstract void nextTrack();
}
