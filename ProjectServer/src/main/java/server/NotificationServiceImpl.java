package server;

import model.Flight;
import notification.Notification;
import notification.NotificationType;
import org.springframework.jms.core.JmsOperations;
import services.INotificationService;

public class NotificationServiceImpl implements INotificationService {
    private JmsOperations jmsOperations;

    public NotificationServiceImpl(JmsOperations operations) {
        jmsOperations=operations;
    }

    @Override
    public void flightsChanged(Flight flight) {
        System.out.println("Flight changed");
        Notification notif=new Notification(NotificationType.FLIGHTS_CHANGED);
        jmsOperations.convertAndSend(notif);
        System.out.println("Sent message to ActiveMQ... " +notif);
    }
}
