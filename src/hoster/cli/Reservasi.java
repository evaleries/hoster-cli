package hoster.cli;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservasi {
    private Customer customer;
    private Kamar kamar;
    private int lamaInap;
    private int denda;
    private int totalPembayaran;
    private int kurangPembayaran;
    private int totalHariTerlambat;
    private String keterangan;
    private String tanggalCheckIn;
    private String tanggalCheckOut;

    public Reservasi(Customer customer, Kamar kamar, int lamaInap, int totalPembayaran) {
        this.customer = customer;
        this.kamar = kamar;
        setLamaInap(lamaInap);
        setTotalPembayaran(totalPembayaran);
        this.setTanggalCheckIn(LocalDate.now().toString());
        this.setTanggalCheckOut(LocalDate.now().plusDays(lamaInap).toString());
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Kamar getKamar() {
        return kamar;
    }

    public void setKamar(Kamar kamar) {
        this.kamar = kamar;
    }

    public int getLamaInap() {
        return lamaInap;
    }

    public void setLamaInap(int lamaInap) {
        if (lamaInap <= 0) {
            this.lamaInap = 1;
        }
        this.tanggalCheckIn = LocalDate.now().toString();
        this.tanggalCheckOut = LocalDate.now().plusDays(lamaInap).toString();
        this.lamaInap = lamaInap;
    }

    public int getTotalHariTerlambat() {
        return totalHariTerlambat;
    }

    public int getDenda() {
        long intervalDays = ChronoUnit.DAYS.between(LocalDate.parse(tanggalCheckOut), LocalDate.now());
        if (intervalDays > 0) {
            this.denda = (int) (kamar.getHarga() * intervalDays);
            this.totalHariTerlambat = (int) intervalDays;
            return denda;
        } else {
            return denda;
        }
    }

    public void setDenda(int denda) {
        this.denda = denda;
    }

    public int getTotalPembayaran() {
        return totalPembayaran;
    }

    public int getKurangPembayaran() {
        return kurangPembayaran;
    }

    public void setKurangPembayaran(int jumlah) {
        this.kurangPembayaran = jumlah;
    }

    public void setTotalPembayaran(int totalPembayaran) {
        if (totalPembayaran < kamar.getHarga() * lamaInap) {
//            System.out.println("Jumlah uang yang dibayarkan kurang! Mohon dibayar saat proses checkout");
            kurangPembayaran = (kamar.getHarga() * lamaInap) - totalPembayaran;
        }
        this.totalPembayaran = totalPembayaran;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTanggalCheckIn() {
        return tanggalCheckIn;
    }

    public String getTanggalCheckOut() {
        return tanggalCheckOut;
    }

    public void setTanggalCheckIn(String tanggalCheckIn) {
        this.tanggalCheckIn = tanggalCheckIn;
    }

    public void setTanggalCheckOut(String tanggalCheckOut) {
        this.tanggalCheckOut = tanggalCheckOut;
    }

    @Override
    public String toString() {
        return "======[ Data Reservasi ]======\n" +
                customer.toString() + "\n" +
                kamar.toString() +
                "\nLama Inap: " + lamaInap + " malam" +
                "\nCheck In:  " + tanggalCheckIn +
                "\nCheck Out:  " + tanggalCheckIn +
                "\nDenda: Rp " + getDenda() +
                "\nTotal Pembayaran: Rp " + totalPembayaran +
                "\nBiaya Kurang: Rp " + kurangPembayaran;
    }

    public String toString(boolean minimalInfo) {
        return "[Reservasi] [Nama] " + customer.getNamaLengkap() + " | [Kode Kamar] " + kamar.getKode() + " | [Checkin] " + tanggalCheckIn + " | [Checkout] " + tanggalCheckOut + " | [Denda] Rp " + getDenda();
    }

}
