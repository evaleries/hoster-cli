package hoster.cli;

public class Customer extends Person {

    private Kamar bookingKamar;

    public Customer(String namaDepan, String namaBelakang, String email, String noKTP, String noTelepon, String jenisKelamin, String alamat, String kota, String tanggalLahir) {
        setNamaDepan(namaDepan);
        setNamaBelakang(namaBelakang);
        setEmail(email);
        setNoKTP(noKTP);
        setNoTelepon(noTelepon);
        setJenisKelamin(jenisKelamin);
        setAlamat(alamat);
        setKota(kota);
        setTanggalLahir(tanggalLahir);
    }

    public Kamar getBookingKamar() {
        return bookingKamar;
    }

    public void setBookingKamar(Kamar bookingKamar) {
        this.bookingKamar = bookingKamar;
    }
}
