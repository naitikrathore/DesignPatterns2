package PractiseLLD.movieBookingSystem.model;

public class Movie {
    private final long id;
    private final String title;
    private final long movieDurationInMillis;

    public Movie(long id, String title, int movieDurationInMinutes) {
        this.id = id;
        this.title = title;
        this.movieDurationInMillis = movieDurationInMinutes;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getMovieDurationInMillis() {
        return movieDurationInMillis;
    }
}
