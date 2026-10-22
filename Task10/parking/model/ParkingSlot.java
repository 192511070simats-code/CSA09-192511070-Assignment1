
package parking.model;

public class ParkingSlot {
    private int slotNumber;
    private Integer durationMinutes;

    public ParkingSlot(int slotNumber) {
        setSlotNumber(slotNumber);
        this.durationMinutes = 0;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        if (slotNumber <= 0) {
            throw new IllegalArgumentException(
                "Slot number must be positive"
            );
        }
        this.slotNumber = slotNumber;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        if (durationMinutes == null || durationMinutes < 0) {
            throw new IllegalArgumentException(
                "Duration cannot be negative or null"
            );
        }
        this.durationMinutes = durationMinutes;
    }
}
