
public class ParkingTicket {
    private String ticketNo;
    private String vehicleNo;
    private long entryTime;

    // Default constructor
    public ParkingTicket() {
        this("T000", "UNKNOWN", System.currentTimeMillis());
    }

    // Parameterized constructor
    public ParkingTicket(String ticketNo, String vehicleNo,
                         long entryTime) {
        this.ticketNo = ticketNo;
        this.vehicleNo = vehicleNo;
        this.entryTime = entryTime;
    }

    // Overloaded constructor
    public ParkingTicket(String ticketNo, String vehicleNo) {
        this(ticketNo, vehicleNo, System.currentTimeMillis());
    }

    // Copy constructor
    public ParkingTicket(ParkingTicket other) {
        this("T-COPY", other.vehicleNo, other.entryTime);
    }

    public void display() {
        System.out.println("Ticket: " + ticketNo);
        System.out.println("Vehicle: " + vehicleNo);
        System.out.println("Entry time: " + entryTime);
    }

    public static void main(String[] args) {
        ParkingTicket t1 =
                new ParkingTicket("T101", "TN01AB1111");

        ParkingTicket t2 = new ParkingTicket(t1);

        t1.display();
        System.out.println("--- Duplicate ticket ---");
        t2.display();
    }
}
