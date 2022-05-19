package notification;

import model.Flight;

public class Notification {
    private NotificationType type;
    private Flight flight;


    public Notification() {
    }

    public Notification(NotificationType type) {

        this.type = type;
    }

    public Notification(NotificationType type, Flight flight) {
        this.type = type;
        this.flight = flight;
    }


    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Notification{ " +
                "type=" + type +
                ", user=" + flight.toString() +
                '}';
    }
}
