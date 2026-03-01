package PractiseLLD.movieBookingSystem.model;

import java.util.List;

public class Theatre {
    public long id;
    public String name;
    public String location;
    public List<Screen> screens;

    public Theatre(long id, String name, String location, List<Screen> screens) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.screens = screens;
    }

    public void addScreen(Screen screen) {
        this.screens.add(screen);
    }

    public void removeScreen(Screen screen) {
        this.screens.remove(screen);
    }

    public List<Screen> getScreens() {
        return this.screens;
    }
}
