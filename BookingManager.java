import java.io.*;
import java.util.*;

public class BookingManager {
    private List<String> availableSlots = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public BookingManager() {
        availableSlots.addAll(Arrays.asList(
            "10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM"
        ));
    }

    public void showAvailableSlots() {
        System.out.println("\n🕒 Available Slots:");
        for (String slot : availableSlots) {
            boolean isBooked = bookings.stream().anyMatch(b -> b.getSlotTime().equals(slot) && b.isBooked());
            if (!isBooked) System.out.println("✅ " + slot);
        }
    }

    public void bookSlot(String name, String slot) {
        boolean isAlreadyBooked = bookings.stream().anyMatch(b -> b.getSlotTime().equals(slot) && b.isBooked());
        if (isAlreadyBooked) {
            System.out.println("❌ Sorry, slot already booked!");
        } else if (!availableSlots.contains(slot)) {
            System.out.println("❌ Invalid slot.");
        } else {
            bookings.add(new Booking(name, slot));
            System.out.println("✅ Booking successful for " + name + " at " + slot);
        }
    }

    public void cancelBooking(String name, String slot) {
        for (Booking b : bookings) {
            if (b.getUserName().equals(name) && b.getSlotTime().equals(slot) && b.isBooked()) {
                b.cancelBooking();
                System.out.println("🗑️ Booking canceled for " + slot);
                return;
            }
        }
        System.out.println("⚠️ No booking found for that slot.");
    }

    public void viewBookings() {
        System.out.println("\n📋 Current Bookings:");
        if (bookings.isEmpty()) {
            System.out.println("No bookings made yet.");
        } else {
            bookings.stream()
                    .filter(Booking::isBooked)
                    .forEach(System.out::println);
        }
    }

    public void saveBookingsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("bookings.txt"))) {
            for (Booking b : bookings) {
                if (b.isBooked()) {
                    writer.println(b.getUserName() + " - " + b.getSlotTime());
                }
            }
            System.out.println("💾 Bookings saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving bookings: " + e.getMessage());
        }
    }
}
