import java.util.ArrayList;
import java.util.List;

// Car class represents a car with its attributes and progress
class Car {
    private String vinNumber;
    private String stockNumber;
    private String location;
    private String progress;

    // Constructor
    public Car(String vinNumber, String stockNumber, String location, String progress) {
        this.vinNumber = vinNumber;
        this.stockNumber = stockNumber;
        this.location = location;
        this.progress = progress;
    }

    // Getters and setters
    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    // Other methods as needed
    // ...
}

// CarDetailingCompany class manages the cars and their status
class CarDetailingCompany {
    private List<Car> cars;

    public CarDetailingCompany() {
        this.cars = new ArrayList<>();
    }

    // Add a new car to the company
    public void addCar(Car car) {
        cars.add(car);
    }

    // Retrieve a car by its VIN number
    public Car getCarByVin(String vinNumber) {
        for (Car car : cars) {
            if (car.getVinNumber().equals(vinNumber)) {
                return car;
            }
        }
        return null; // Car not found
    }

    // Update the progress of a car
    public void updateProgress(String vinNumber, String progress) {
        Car car = getCarByVin(vinNumber);
        if (car != null) {
            car.setProgress(progress);
        } else {
            System.out.println("Car not found!");
        }
    }

    // Move a car to a new location
    public void moveCar(String vinNumber, String newLocation) {
        Car car = getCarByVin(vinNumber);
        if (car != null) {
            car.setLocation(newLocation);
        } else {
            System.out.println("Car not found!");
        }
    }

    // Display the details of all cars
    public void displayAllCars() {
        for (Car car : cars) {
            System.out.println("VIN: " + car.getVinNumber());
            System.out.println("Stock Number: " + car.getStockNumber());
            System.out.println("Location: " + car.getLocation());
            System.out.println("Progress: " + car.getProgress());
            System.out.println("----------------------------------------");
        }
    }

    // Check for undetailed cars and notify
    public void notifyUndetailedCars() {
        int totalUndetailedCars = 0;
        int totalSoldUndetailedCars = 0;

        for (Car car : cars) {
            if (car.getProgress().equals("Undetailed")) {
                totalUndetailedCars++;
                if (car.getLocation().equals("Sold Units")) {
                    totalSoldUndetailedCars++;
                    System.out.println("Warning: Undetailed car with VIN " + car.getVinNumber() + " is in Sold Units!");
                }
            }
        }

        double percentageSoldUndetailedCars = (double) totalSoldUndetailedCars / totalUndetailedCars * 100;
        System.out.println("Statistics: " + percentageSoldUndetailedCars + "% of undetailed cars are in Sold Units.");
    }
}

public class SharpImageCD {
    public static void main(String[] args) {
        // Create an instance of the car detailing company
        CarDetailingCompany company = new CarDetailingCompany();

        // Create and add cars to the company
        Car car1 = new Car("VIN123", "STOCK001", "Salesmen", "In Progress");
        Car car2 = new Car("VIN456", "STOCK002", "Sold Units", "Undetailed");
        Car car3 = new Car("VIN789", "STOCK003", "Lot Ready", "Undetailed");
        Car car4 = new Car("VIN987", "STOCK004", "Salesmen", "Undetailed");
        // Add more cars as needed

        company.addCar(car1);
        company.addCar(car2);
        company.addCar(car3);
        company.addCar(car4);
        // Add more cars as needed

        // Demonstrate usage of the program
        Car searchedCar = company.getCarByVin("VIN123");
        if (searchedCar != null) {
            System.out.println("Car found!");
            System.out.println("Location: " + searchedCar.getLocation());
            System.out.println("Progress: " + searchedCar.getProgress());
        } else {
            System.out.println("Car not found!");
        }

        // Update the progress of a car
        company.updateProgress("VIN456", "In Progress");

        // Move a car to a new location
        company.moveCar("VIN123", "Lot Ready");

        // Display details of all cars
        company.displayAllCars();

        // Check for undetailed cars and notify
        company.notifyUndetailedCars();

        // Add more program functionality as needed
        // ...
    }
}

