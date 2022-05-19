package services;

import notification.Notification;

public interface NotificationSubscriber {
    void notificationReceived(Notification notification);
}
