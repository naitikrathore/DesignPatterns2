package PractiseLLD.movieBookingSystem.model;

public class Show {
    private final long id;
    private final Movie movie;
    private final Screen screen;
    private final long startTime;
    private final long duration;

    public Show(long id, Movie movie, Screen screen, long startTime) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.duration = movie.getMovieDurationInMillis();
    }

    public Movie getMovie() {
        return movie;
    }

    public long getId() {
        return id;
    }

    public Screen getScreen() {
        return screen;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getDuration() {
        return duration;
    }
}
