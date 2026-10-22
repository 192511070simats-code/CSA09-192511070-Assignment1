
class Vehicle {
    private final String registrationNo;

    Vehicle(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public double calculateFee() {
        return 50.0;
    }

    @Override
    public String toString() {
        return "Vehicle{registrationNo='" + registrationNo + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Vehicle)) {
            return false;
        }

        Vehicle other = (Vehicle) obj;
        return registrationNo.equals(other.registrationNo);
    }

    @Override
    public int hashCode() {
        return registrationNo.hashCode();
    }
}

class Car extends Vehicle {
    Car(String registrationNo) {
        super(registrationNo);
    }

    @Override
    public double calculateFee() {
        return 60.0;
    }
}

class ElectricCar extends Vehicle {
    ElectricCar(String registrationNo) {
        super(registrationNo);
    }

    @Override
    public double calculateFee() {
        return 40.0;
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle car = new Car("TN01AB1111");
        Vehicle electricCar = new ElectricCar("TN02CD2222");
        Vehicle anotherCar = new Car("TN01AB1111");

        System.out.println(car);
        System.out.println("Car fee: " + car.calculateFee());
        System.out.println("Electric car fee: "
                + electricCar.calculateFee());
        System.out.println("Same registration: "
                + car.equals(anotherCar));
        System.out.println("Same hash code: "
                + (car.hashCode() == anotherCar.hashCode()));
    }
}
