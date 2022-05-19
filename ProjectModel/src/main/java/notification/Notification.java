package notification;

import java.io.Serializable;

public class Notification implements Serializable {
    private NotificationType type;
    private int ID;
    private String destination;
    private String randomNumbers;
    private String airport;
    private int numberOfTickets;

    public Notification(NotificationType type, int ID, String destination, String randomNumbers, String airport, int numberOfTickets) {
        this.type = type;
        this.ID = ID;
        this.destination = destination;
        this.randomNumbers = randomNumbers;
        this.airport = airport;
        this.numberOfTickets = numberOfTickets;
    }

    public Notification() {
    }

    public Notification(NotificationType type) {
        this.type = type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getRandomNumbers() {
        return randomNumbers;
    }

    public void setRandomNumbers(String randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public void setFlight(int ID, String destination, String randomNumbers, String airport, int numberOfTickets) {
        this.ID = ID;
        this.destination = destination;
        this.randomNumbers = randomNumbers;
        this.airport = airport;
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "type=" + type +
                ", ID=" + ID +
                ", destination='" + destination + '\'' +
                ", randomNumbers='" + randomNumbers + '\'' +
                ", airport='" + airport + '\'' +
                ", numberOfTickets=" + numberOfTickets +
                '}';
    }
}
