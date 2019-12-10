package hoster.cli;

public class Customer extends Person {

    private Kamar bookingKamar;

    public Kamar getBookingKamar() {
        return bookingKamar;
    }

    public void setBookingKamar(Kamar bookingKamar) {
        this.bookingKamar = bookingKamar;
    }
}
