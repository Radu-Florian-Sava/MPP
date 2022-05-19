package client.ams;

import model.Flight;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FlightsListModel extends AbstractListModel {
    private List<Flight> flights;

    public FlightsListModel() {
        flights = new ArrayList<Flight>();
    }

    public FlightsListModel(List<Flight> flights) {
        this.flights.addAll(flights);
    }


    public int getSize() {
        return flights.size();
    }

    public Object getElementAt(int index) {
        return flights.get(index);
    }

    public void changeFlight(Flight flight) {
        int index = 0;
        for (Flight f : flights) {
            if (f.getID() == flight.getID()) {
                flights.set(index, flight);
            }
            index++;
        }
        fireContentsChanged(this, index, index + 1);
    }
}
