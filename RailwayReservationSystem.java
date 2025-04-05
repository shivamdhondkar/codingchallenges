import java.util.ArrayList;
import java.util.Scanner;

class Train {
    int trainNumber;
    String trainName;
    String source;
    String destination;
    int availableSeats;
    double fare;

    public Train(int trainNumber, String trainName, String source, String destination, int availableSeats, double fare) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.fare = fare;
    }

    public void displayTrain() {
        System.out.println("Train Number: " + trainNumber + ", Name: " + trainName + ", From: " + source + " To: " + destination + ", Seats: " + availableSeats + ", Fare: " + fare);
    }
}

class Passenger {
    int passengerId;
    String name;
    int age;
    int trainNumber;

    public Passenger(int passengerId, String name, int age, int trainNumber) {
        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
        this.trainNumber = trainNumber;
    }

    public void displayPassenger() {
        System.out.println("Passenger ID: " + passengerId + ", Name: " + name + ", Age: " + age + ", Train Number: " + trainNumber);
    }
}

public class RailwayReservationSystem {
    static ArrayList<Train> trains = new ArrayList<>();
    static ArrayList<Passenger> passengers = new ArrayList<>();
    static int passengerIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeTrains();

        while (true) {
            System.out.println("\nRailway Reservation System");
            System.out.println("1. View Available Trains");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Display Passenger Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableTrains();
                    break;
                case 2:
                    bookTicket(scanner);
                    break;
                case 3:
                    cancelTicket(scanner);
                    break;
                case 4:
                    displayPassengers();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void initializeTrains() {
        trains.add(new Train(101, "Express 1", "City A", "City B", 5, 500));
        trains.add(new Train(102, "Express 2", "City B", "City C", 3, 600));
    }

    public static void viewAvailableTrains() {
        for (Train train : trains) {
            train.displayTrain();
        }
    }

    public static void bookTicket(Scanner scanner) {
        System.out.print("Enter Train Number: ");
        int trainNumber = scanner.nextInt();
        for (Train train : trains) {
            if (train.trainNumber == trainNumber) {
                if (train.availableSeats > 0) {
                    System.out.print("Enter Passenger Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    Passenger passenger = new Passenger(passengerIdCounter++, name, age, trainNumber);
                    passengers.add(passenger);
                    train.availableSeats--;
                    System.out.println("Ticket booked successfully!");
                } else {
                    System.out.println("No available seats.");
                }
                return;
            }
        }
        System.out.println("Train not found.");
    }

    public static void cancelTicket(Scanner scanner) {
        System.out.print("Enter Passenger ID: ");
        int passengerId = scanner.nextInt();
        for (Passenger passenger : passengers) {
            if (passenger.passengerId == passengerId) {
                passengers.remove(passenger);
                for (Train train : trains) {
                    if (train.trainNumber == passenger.trainNumber) {
                        train.availableSeats++;
                        System.out.println("Ticket cancelled successfully!");
                        return;
                    }
                }
            }
        }
        System.out.println("Passenger not found.");
    }

    public static void displayPassengers() {
        for (Passenger passenger : passengers) {
            passenger.displayPassenger();
        }
    }
}
