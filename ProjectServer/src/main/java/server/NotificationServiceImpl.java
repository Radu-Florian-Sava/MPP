package server;

import model.Flight;
import notification.Notification;
import notification.NotificationType;
import org.springframework.jms.core.JmsOperations;
import services.INotificationService;

import java.time.format.DateTimeFormatter;

public class NotificationServiceImpl implements INotificationService {
    private JmsOperations jmsOperations;

    public NotificationServiceImpl(JmsOperations operations) {
        jmsOperations = operations;
    }

    @Override
    public void flightsChanged(Flight flight) {
        System.out.println("Flight changed");
        Notification notif = new Notification(NotificationType.FLIGHTS_CHANGED, flight.getID(), flight.getDestination(),
                flight.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")), flight.getAirport(), flight.getNumberOfTickets());
        try {
            jmsOperations.convertAndSend(notif);
        } catch (Exception ex) {
            System.out.println("???????");

        }
        System.out.println("Sent message to ActiveMQ... " + notif);
    }
}
