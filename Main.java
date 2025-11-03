import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingManager manager = new BookingManager();

        while (true) {
            System.out.println("\n=== SMART BOOKING APP ===");
            System.out.println("1. View Available Slots");
            System.out.println("2. Book a Slot");
            System.out.println("3. Cancel a Booking");
            System.out.println("4. View My Bookings");
            System.out.println("5. Save Bookings");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    manager.showAvailableSlots();
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter slot time (e.g. 11:00 AM): ");
                    String slot = sc.nextLine();
                    manager.bookSlot(name, slot);
                    break;

                case 3:
                    System.out.print("Enter your name: ");
                    String cancelName = sc.nextLine();
                    System.out.print("Enter slot to cancel: ");
                    String cancelSlot = sc.nextLine();
                    manager.cancelBooking(cancelName, cancelSlot);
                    break;

                case 4:
                    manager.viewBookings();
                    break;

                case 5:
                    manager.saveBookingsToFile();
                    break;

                case 6:
                    System.out.println("👋 Exiting Booking App...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
