public class Booking {
    private String userName;
    private String slotTime;
    private boolean isBooked;

    public Booking(String userName, String slotTime) {
        this.userName = userName;
        this.slotTime = slotTime;
        this.isBooked = true;
    }

    public String getUserName() {
        return userName;
    }

    public String getSlotTime() {
        return slotTime;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void cancelBooking() {
        this.isBooked = false;
    }

    @Override
    public String toString() {
        return "👤 " + userName + " booked slot at " + slotTime;
    }
}
