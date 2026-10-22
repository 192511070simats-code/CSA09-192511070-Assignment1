class Vehicle {
    protected String vehicleNo;

    Vehicle(String vehicleNo) {
        this.vehicleNo = vehicleNo;
        System.out.println("Vehicle constructor");
    }

    void display() {
        System.out.println("Vehicle number: " + vehicleNo);
    }
}

class Car extends Vehicle {
    protected String model;

    Car(String vehicleNo, String model) {
        super(vehicleNo);
        this.model = model;
        System.out.println("Car constructor");
    }

    @Override
    void display() {
        super.display();
        System.out.println("Model: " + model);
    }
}

class ElectricCar extends Car {
    private int batteryCapacity;

    ElectricCar(String vehicleNo, String model, int batteryCapacity) {
        super(vehicleNo, model);
        this.batteryCapacity = batteryCapacity;
        System.out.println("ElectricCar constructor");
    }

    @Override
    void display() {
        super.display();
        System.out.println("Battery capacity: " + batteryCapacity + " kWh");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        ElectricCar car = new ElectricCar("TN01AB1111", "EV", 60);
        System.out.println("--- Vehicle details ---");
        car.display();
    }
}
