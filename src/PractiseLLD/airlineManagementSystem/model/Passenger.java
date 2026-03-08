package PractiseLLD.airlineManagementSystem.model;

public class Passenger {
    private final long id;
    private final String name;
    private final String email;
    private final String passportNumber;

    public Passenger(long id, String name, String email, String passportNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passportNumber = passportNumber;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    @Override
    public String toString() {
        return "Passenger{id='" + id + "', name='" + name + "', email='" + email + "'}";
    }
}
