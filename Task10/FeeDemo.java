
import parking.model.ParkingSlot;

public class FeeDemo {
    public static void main(String[] args) {
        ParkingSlot slot = new ParkingSlot(1);

        slot.setDurationMinutes(120);

        System.out.println("Slot number: " + slot.getSlotNumber());
        System.out.println("Duration: " + slot.getDurationMinutes());

        try {
            slot.setDurationMinutes(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid duration rejected");
        }
    }
}
