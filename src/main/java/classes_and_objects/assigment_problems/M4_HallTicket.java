package classes_and_objects.assigment_problems;

public class M4_HallTicket {
    String studentName;
    int seatNumber;

    public M4_HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        M4_HallTicket priya = new M4_HallTicket("Priya", 0);
        
        M4_HallTicket copy = priya;
        copy.seatNumber = 45;

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        M4_HallTicket separate = new M4_HallTicket("Priya", 45);
        System.out.println("separate == priya: " + (separate == priya));
    }
}
