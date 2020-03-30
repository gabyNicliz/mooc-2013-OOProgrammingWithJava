/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryzen
 */
import java.util.Scanner;

public class UserInterface {

    private Flights flights;
    Scanner reader = new Scanner(System.in);

    public UserInterface() {
        this.flights = new Flights();
    }

    public void startAirportPanel() {
        while (true) {
            System.out.print("\nAirport panel\n"
                    + "--------------------\n"
                    + "\n"
                    + "Choose operation:\n"
                    + "[1] Add airplane\n"
                    + "[2] Add flight\n"
                    + "[x] Exit\n"
                    + "> ");

            String operation = this.reader.nextLine();
            if (operation.equals("x")) {
                break;

            } else if (operation.equals("1")) {
                System.out.print("Give plane ID: ");
                String planeID = this.reader.nextLine();
                System.out.print("\nGive plane capacity: ");
                int planeCapacity = Integer.parseInt(this.reader.nextLine());
                this.flights.addPlane(planeID, planeCapacity);

            } else if (operation.equals("2")) {
                System.out.print("Give plane ID: ");
                String planeID = this.reader.nextLine();
                System.out.print("Give departure airport code: ");
                String departure = this.reader.nextLine();
                System.out.print("Give destination airport code: ");
                String destination = this.reader.nextLine();
                this.flights.addFlight(planeID, departure, destination);

            }
        }
    }

    public void startFlightService() {
        while (true) {
            System.out.print("\nFlight service\n"
                    + "------------\n"
                    + "\n"
                    + "Choose operation:\n"
                    + "[1] Print planes\n"
                    + "[2] Print flights\n"
                    + "[3] Print plane info\n"
                    + "[x] Quit\n"
                    + "> ");
            String operation = this.reader.nextLine();
            if (operation.equals("x")) {
                break;
            } else if (operation.equals("1")) {
                this.flights.printPlanes();
            } else if (operation.equals("2")) {
                this.flights.printFlights();
            } else if(operation.equals("3")){
                System.out.print("Give plane ID: ");
                String planeID = this.reader.nextLine();
                this.flights.printPlaneInfo(planeID);
            }
        }
    }
}
