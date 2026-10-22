
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

interface Pass {
    boolean isValid();
}

interface PricingRule {
    double calculateFee(Vehicle vehicle, LocalTime entry, LocalTime exit);
}

abstract class Vehicle {
    private final String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public abstract double carRate();
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
    }

    @Override
    public double carRate() {
        return 30;
    }
}

class EBike extends Vehicle {
    EBike(String regNo) {
        super(regNo);
    }

    @Override
    public double carRate() {
        return 0;
    }
}

class DeliveryVan extends Vehicle {
    DeliveryVan(String regNo) {
        super(regNo);
    }

    @Override
    public double carRate() {
        return 60;
    }
}

class OneDayPass implements Pass {
    private final LocalDate validDate;

    OneDayPass(LocalDate validDate) {
        this.validDate = validDate;
    }

    @Override
    public boolean isValid() {
        return LocalDate.now().equals(validDate);
    }

    public boolean isValidAt(LocalDateTime time) {
        return time.toLocalDate().equals(validDate);
    }
}


class StandardPricing implements PricingRule {
    @Override
    public double calculateFee(Vehicle vehicle,
                               LocalTime entry,
                               LocalTime exit) {
        long minutes = java.time.Duration
                .between(entry, exit).toMinutes();

        if (minutes <= 0) {
            return 0;
        }

        if (vehicle instanceof EBike) {
            return 20; // Flat e-bike fee
        }

        if (vehicle instanceof DeliveryVan) {
            long daytimeMinutes = 0;
            LocalTime current = entry;

            while (current.isBefore(exit)) {
                LocalTime nextMinute = current.plusMinutes(1);

                if (!current.isBefore(LocalTime.of(9, 0))
                        && current.isBefore(LocalTime.of(17, 0))) {
                    daytimeMinutes++;
                }

                current = nextMinute;
            }

            long nightMinutes = minutes - daytimeMinutes;

            // Daytime rate is double the car rate.
            return (daytimeMinutes / 60.0) * 60
                    + (nightMinutes / 60.0) * 30;
        }

        int hours = (int) ((minutes + 59) / 60);
        return hours * vehicle.carRate();
    }
}


class ParkingFacility {
    private final String[][] slots;

    ParkingFacility(int[] slotsPerFloor) {
        slots = new String[slotsPerFloor.length][];

        for (int i = 0; i < slotsPerFloor.length; i++) {
            slots[i] = new String[slotsPerFloor[i]];
        }
    }

    public boolean park(String regNo) {
        for (String[] floor : slots) {
            for (int i = 0; i < floor.length; i++) {
                if (floor[i] == null) {
                    floor[i] = regNo;
                    return true;
                }
            }
        }
        return false;
    }

    public int floorCount() {
        return slots.length;
    }

    public int totalSlots() {
        int total = 0;
        for (String[] floor : slots) {
            total += floor.length;
        }
        return total;
    }
}

public class ParkingSystemDemo {
    public static void main(String[] args) {
        int[] capacities = {10, 12, 8, 15, 9};
        ParkingFacility facility = new ParkingFacility(capacities);
        PricingRule pricing = new StandardPricing();

        Vehicle bike = new EBike("EB101");
        Vehicle van = new DeliveryVan("DV202");
        Vehicle car = new Car("CAR303");

        System.out.println("Floors: " + facility.floorCount());
        System.out.println("Total slots: " + facility.totalSlots());

        System.out.println("E-bike fee: Rs "
                + pricing.calculateFee(bike,
                LocalTime.of(10, 0), LocalTime.of(12, 0)));

        System.out.println("Van daytime fee: Rs "
                + pricing.calculateFee(van,
                LocalTime.of(10, 0), LocalTime.of(12, 0)));

        System.out.println("Van evening fee: Rs "
                + pricing.calculateFee(van,
                LocalTime.of(18, 0), LocalTime.of(20, 0)));

        Pass pass = new OneDayPass(LocalDate.now());
        System.out.println("One-day pass valid: " + pass.isValid());

        System.out.println("Car parked: " + facility.park(car.getRegNo()));
    }
}
