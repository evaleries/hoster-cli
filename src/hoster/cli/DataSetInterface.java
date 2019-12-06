package hoster.cli;

import java.util.List;

public interface DataSetInterface {

    List<Karyawan> getListKaryawan();
    void addKaryawan(Karyawan karyawan);

    List<Customer> getListCustomer();
    void addCustomer(Customer customer);

    List<Reservasi> getListReservasi();
    void addReservasi(Reservasi reservasi);
    void removeReservasi(Reservasi reservasi);
}
