/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryzen
 */
import java.util.HashMap;
import java.util.ArrayList;

public class Flights {

    private HashMap<String, ArrayList<String>> flights;
    private Planes planes;

    public Flights() {
        this.flights = new HashMap<String, ArrayList<String>>();
        this.planes = new Planes();
    }

    public void addFlight(String planeID, String departure, String destination) {
        String travel = departure + "-" + destination;

        if (this.flights.get(planeID) == null) {
            this.flights.put(planeID, new ArrayList<String>());
        }
        this.flights.get(planeID).add(travel);
    }

    public void addPlane(String id, int capacity) {
        this.planes.addPlane(id, capacity);
    }

    public void printFlights() {
        for (String planeID : this.flights.keySet()) {
            for (String travel : this.flights.get(planeID)) {
                System.out.println(this.planes.printPlane(planeID)
                        + " (" + travel + ")");
            }
        }
    }

    public void printPlanes() {
        this.planes.printPlanes();
    }

    public void printPlaneInfo(String id) {
        System.out.println(this.planes.printPlane(id));
    }

}
