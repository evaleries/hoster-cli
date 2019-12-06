package hoster.cli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class Dataset
 * Ditujukan untuk menyimpan data dalam memory.
 */
public class Dataset implements DataSetInterface {
    private List<Karyawan> listKaryawan = new ArrayList<Karyawan>();
    private List<Customer> listCustomer = new ArrayList<Customer>();
    private List<KamarDeluxe> listKamarDeluxe = new ArrayList<KamarDeluxe>();
    private List<KamarDouble> listKamarDouble = new ArrayList<KamarDouble>();
    private List<KamarSingle> listKamarSingle = new ArrayList<KamarSingle>();
    private List<Kamar> listKamarKosong = new ArrayList<Kamar>();
    private List<Kamar> listKamarTerpakai = new ArrayList<Kamar>();
    private List<Reservasi> listReservasi = new ArrayList<Reservasi>();
    private List<Inventaris> listInventaris = new ArrayList<Inventaris>();
    private HashMap<String, String> accounts = new HashMap<String, String>();

    public HashMap<String, String> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<String, String> accounts) {
        this.accounts = accounts;
    }

    @Override
    public List<Karyawan> getListKaryawan() {
        return listKaryawan;
    }

    public void setListKaryawan(List<Karyawan> listKaryawan) {
        this.listKaryawan = listKaryawan;
    }

    @Override
    public void addKaryawan(Karyawan karyawan) {
        this.listKaryawan.add(karyawan);
    }

    @Override
    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(List<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }

    @Override
    public void addCustomer(Customer customer) {
        this.listCustomer.add(customer);
    }

    public List<KamarDeluxe> getListKamarDeluxe() {
        return listKamarDeluxe;
    }

    public void setListKamarDeluxe(List<KamarDeluxe> listKamarDeluxe) {
        this.listKamarDeluxe = listKamarDeluxe;
    }

    public void addKamarDeluxe(KamarDeluxe kamar) {
        this.listKamarDeluxe.add(kamar);
        this.listKamarKosong.add(kamar);
    }

    public List<KamarDouble> getListKamarDouble() {
        return listKamarDouble;
    }

    public void setListKamarDouble(List<KamarDouble> listKamarDouble) {
        this.listKamarDouble = listKamarDouble;
    }

    public void addKamarDouble(KamarDouble kamar) {
        this.listKamarDouble.add(kamar);
        this.listKamarKosong.add(kamar);
    }

    public List<KamarSingle> getListKamarSingle() {
        return listKamarSingle;
    }

    public void setListKamarSingle(List<KamarSingle> listKamarSingle) {
        this.listKamarSingle = listKamarSingle;
    }

    public void addKamarSingle(KamarSingle kamar) {
        this.listKamarSingle.add(kamar);
        this.listKamarKosong.add(kamar);
    }

    @Override
    public List<Reservasi> getListReservasi() {
        return listReservasi;
    }

    public void setListReservasi(List<Reservasi> listReservasi) {
        this.listReservasi = listReservasi;
    }

    @Override
    public void addReservasi(Reservasi reservasi) {
        this.listReservasi.add(reservasi);
        this.listKamarTerpakai.add(reservasi.getKamar());
        this.listKamarKosong.remove(reservasi.getKamar());
    }

    @Override
    public void removeReservasi(Reservasi reservasi) {
        this.listReservasi.remove(reservasi);
        this.listKamarKosong.add(reservasi.getKamar());
        this.listKamarTerpakai.remove(reservasi.getKamar());
    }

    /**
     * Overloading Method
     * Menghapus data reservasi berdasarkan index reservasi.
     * @param indexReservasi
     */
    public void removeReservasi(int indexReservasi) {
        this.listReservasi.remove(indexReservasi);
    }

    public List<Inventaris> getListInventaris() {
        return listInventaris;
    }

    public void setListInventaris(List<Inventaris> listInventaris) {
        this.listInventaris = listInventaris;
    }

    public List<Kamar> getListKamarKosong() {
        return listKamarKosong;
    }

    public void setListKamarKosong(List<Kamar> listKamarKosong) {
        this.listKamarKosong = listKamarKosong;
    }

    public void removeKamarKosong(Kamar kamar) {
        this.listKamarKosong.remove(kamar);
    }

    /**
     * Overloading method
     * Menghapus List kamar kosong berdasarkan index
     * @param indexKamar
     */
    public void removeKamarKosong(int indexKamar) {
        this.listKamarKosong.remove(indexKamar);
    }

    public void addKamarKosong(Kamar kamar) {
        this.listKamarKosong.add(kamar);
    }

    public List<Kamar> getListKamarTerpakai() {
        return listKamarTerpakai;
    }

    public void setListKamarTerpakai(List<Kamar> listKamarTerpakai) {
        this.listKamarTerpakai = listKamarTerpakai;
    }

    public void removeKamarTerpakai(Kamar kamar) {
        this.listKamarTerpakai.remove(kamar);
    }

    /**
     * Overloading method
     * Menghapus List kamar terpakai berdasarkan index
     * @param indexKamar
     */
    public void removeKamarTerpakai(int indexKamar) {
        this.listKamarTerpakai.remove(indexKamar);
    }

    public void addKamarTerpakai(Kamar kamar) {
        this.listKamarTerpakai.add(kamar);
    }

}
