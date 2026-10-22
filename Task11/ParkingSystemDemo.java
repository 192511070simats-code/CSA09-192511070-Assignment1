
import java.util.Arrays;

class ParkingTicket {
    private final String regNo;
    private final String type;
    private final int slotNo;
    private final int minutes;

    ParkingTicket(String regNo, String type, int slotNo, int minutes) {
        this.regNo = regNo;
        this.type = type;
        this.slotNo = slotNo;
        this.minutes = minutes;
    }

    public String getRegNo() { return regNo; }
    public String getType() { return type; }
    public int getSlotNo() { return slotNo; }
    public int getMinutes() { return minutes; }
}

class ParkingSystem {
    private final String[] slots;
    private final ParkingTicket[] tickets;
    private int count;

    ParkingSystem(int capacity) {
        slots = new String[capacity];
        tickets = new ParkingTicket[capacity];
    }

    public boolean park(String regNo, String type, int minutes) {
        if (regNo == null || regNo.isBlank()
                || minutes < 0
                || !(type.equals("Bike") || type.equals("Car")
                || type.equals("ElectricCar"))) {
            System.out.println("Invalid vehicle details");
            return false;
        }

        for (int i = 0; i < count; i++) {
            if (tickets[i].getRegNo().equals(regNo)) {
                System.out.println("Duplicate registration: " + regNo);
                return false;
            }
        }

        int free = -1;
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null) {
                free = i;
                break;
            }
        }

        if (free == -1) {
            System.out.println("Parking full");
            return false;
        }

        slots[free] = regNo;
        tickets[count++] = new ParkingTicket(regNo, type, free + 1, minutes);
        return true;
    }

    public double exit(String regNo) {
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (tickets[i].getRegNo().equals(regNo)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Ticket not found: " + regNo);
            return -1;
        }

        ParkingTicket t = tickets[index];
        double rate = switch (t.getType()) {
            case "Bike" -> 10;
            case "Car" -> 30;
            case "ElectricCar" -> 30;
            default -> 0;
        };

        int hours = (t.getMinutes() + 59) / 60;
        double fee = hours * rate;

        System.out.println(t.getType() + " " + regNo
                + " exited from slot " + t.getSlotNo()
                + "; fee Rs " + fee);

        slots[t.getSlotNo() - 1] = null;

        for (int i = index; i < count - 1; i++) {
            tickets[i] = tickets[i + 1];
        }
        tickets[--count] = null;

        return fee;
    }

    public boolean isValidSlot(int slotNo) {
        return slotNo >= 1 && slotNo <= slots.length;
    }
}

public class ParkingSystemDemo {
    public static void main(String[] args) {
        ParkingSystem system = new ParkingSystem(2);

        system.park("TN01A1", "Bike", 60);
        system.park("TN02B2", "Car", 120);

        // Last free slot / parking full
        System.out.println("Third vehicle accepted: "
                + system.park("TN03C3", "Bike", 30));

        // Invalid cases
        System.out.println("Unknown type accepted: "
                + system.park("TN04D4", "Bus", 60));
        System.out.println("Duplicate accepted: "
                + system.park("TN01A1", "Bike", 30));
        System.out.println("Slot 0 valid: " + system.isValidSlot(0));

        // Hand-calculated total: Bike Rs 10 + Car Rs 60 = Rs 70
        double total = system.exit("TN01A1");
        total += system.exit("TN02B2");
        System.out.println("Total collection: Rs " + total);

        // Zero-minute stay
        ParkingSystem zeroTest = new ParkingSystem(1);
        zeroTest.park("TN05E5", "Bike", 0);
        System.out.println("Zero-minute fee: Rs "
                + zeroTest.exit("TN05E5"));
    }
}
