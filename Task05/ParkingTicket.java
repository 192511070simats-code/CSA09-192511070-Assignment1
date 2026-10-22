
public class ParkingTicket {
    private static int ticketCounter = 1000;

    private final int ticketNo;
    private final String vehicleNo;
    private final long entryTime;

    public ParkingTicket(String vehicleNo) {
        this.ticketNo = ++ticketCounter;
        this.vehicleNo = vehicleNo;
        this.entryTime = System.currentTimeMillis();
    }

    public static int getTicketCounter() {
        return ticketCounter;
    }

    public void display() {
        System.out.println("Ticket number: " + ticketNo);
        System.out.println("Vehicle number: " + vehicleNo);
        System.out.println("Entry time: " + entryTime);
    }

    public static void main(String[] args) {
        ParkingTicket t1 = new ParkingTicket("TN01AB1111");
        ParkingTicket t2 = new ParkingTicket("TN02CD2222");

        t1.display();
        System.out.println("---");
        t2.display();

        System.out.println("Total tickets: " + getTicketCounter());
    }
}
