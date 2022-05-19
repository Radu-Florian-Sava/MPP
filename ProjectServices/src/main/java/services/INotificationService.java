package services;

import model.Flight;


public interface INotificationService {
    void flightsChanged(Flight flight);

}
