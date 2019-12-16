package hoster.cli;

import java.util.HashMap;

import static java.time.temporal.ChronoUnit.DAYS;

public class App {

    private Input strInput = new Input();
    private Input intInput = new Input();
    private Dataset database;
    private boolean isLoggedIn;

    public App(Dataset dataset, boolean loggedIn) {
        database = dataset;
        isLoggedIn = loggedIn;
        if (isLoggedIn) {
            aplikasi();
        } else {
            login();
        }
    }

    private void aplikasi() {
        System.out.println("===============[HOSTER]===============");
        System.out.println("Menu: ");
        System.out.println("1. Tambah Karyawan");
        System.out.println("2. Tambah Kamar");
        System.out.println("3. Reservasi");
        System.out.println("4. List Kamar");
        System.out.println("5. List Reservasi");
        System.out.println("6. List Customer");
        System.out.println("7. List Karyawan");
        System.out.println("10. Keluar");
        switch(intInput.getInt("Pilih: ")) {
            case 1: tambahKaryawan();break;
            case 2: tambahKamar(); break;
            case 3: reservasi(); break;
            case 4: lihatKamar();break;
            case 5: lihatReservasi(); break;
            case 6: lihatCustomer(); break;
            case 7: lihatKaryawan(); break;
            case 10: System.exit(0); break;
            default: break;
        }
        aplikasi();
    }

    public void login() {
        System.out.println("===============[HOSTER - LOGIN]===============");
        String username = strInput.get("Username: ");
        String password = strInput.get("Password: ");
        HashMap<String, String> accounts = database.getAccounts();
        System.out.println();
        if (accounts.containsKey(username) && accounts.get(username).equals(password)) {
            System.out.println("Login Berhasil.");
            isLoggedIn = true;
            aplikasi();
        } else {
            System.out.println("Login gagal. Username atau password salah");
            login();
        }
    }

    private void tambahKaryawan() {
        System.out.println("===============[TAMBAH KARYAWAN]===============");
        Karyawan karyawan = new Karyawan();
        karyawan.setNamaDepan(strInput.get("Nama Depan  : "));
        karyawan.setNamaBelakang(strInput.get("Nama Belakang    : "));
        karyawan.setNoKTP(strInput.get("No KTP: "));
        karyawan.setNoTelepon(strInput.get("No Telepon : "));
        karyawan.setEmail(strInput.get("Email : "));
        karyawan.setAlamat(strInput.get("Alamat : "));
        karyawan.setKota(strInput.get("Kota: "));
        karyawan.setJenisKelamin(strInput.get("Jenis Kelamin    : "));
        karyawan.setTanggalLahir(strInput.get("Tanggal Lahir  (Y-m-d)  : "));
        karyawan.setTanggalRekrut(strInput.get("Tanggal Rekrut (Y-m-d) : "));
        database.addKaryawan(karyawan);
        System.out.println("Karyawan berhasil ditambahkan");
    }

    private void tambahKamar() {
        System.out.println("===============[TAMBAH KAMAR]===============");
        System.out.println("Tipe Kamar: ");
        System.out.println("1. Single");
        System.out.println("2. Double");
        System.out.println("3. Deluxe");
        System.out.println("10. Kembali");
        switch (intInput.getInt("Pilih Tipe: ")) {
            case 1:
                KamarSingle kamarSingle = new KamarSingle();
                kamarSingle.setKode(strInput.get("Kode Kamar Single: S-"));
                kamarSingle.setHarga(intInput.getInt("Harga Per Malam: "));
                database.addKamarSingle(kamarSingle);
                break;
            case 2:
                KamarDouble kamarDouble = new KamarDouble();
                kamarDouble.setKode(strInput.get("Kode Kamar Double: D-"));
                kamarDouble.setHarga(intInput.getInt("Harga Per Malam: "));
                database.addKamarDouble(kamarDouble);
                break;
            case 3:
                KamarDeluxe kamarDeluxe = new KamarDeluxe();
                kamarDeluxe.setKode(strInput.get("Kode Kamar Deluxe: DEX-"));
                kamarDeluxe.setHarga(intInput.getInt("Harga Per Malam: "));
                database.addKamarDeluxe(kamarDeluxe);
                break;
            case 10:
                return;
            default:
                System.out.println("Pilihan tidak sah. Silahkan memilih ulang!");
                tambahKamar();
                break;
        }
        System.out.println("Kamar Berhasil disimpan!");
    }

    private void lihatKamar() {
        System.out.println("===============[DATA KAMAR]===============");
        System.out.println("Pilihan Menu: ");
        System.out.println("1. Kamar Kosong");
        System.out.println("2. Kamar Terpakai");
        int pilihan = intInput.getInt("Pilih: ");
        if (pilihan == 1) {
            for (Kamar k : database.getListKamarKosong()) {
                System.out.println(k.toString());
            }
        } else {
            for (Kamar k: database.getListKamarTerpakai()) {
                System.out.println(k.toString());
            }
        }
    }

    private void reservasi() {
        System.out.println("===============[RESERVASI]===============");
        System.out.println("Menu Reservasi: ");
        System.out.println("1. Check In");
        System.out.println("2. Check Out");
        System.out.println("10. Kembali");
        switch (intInput.getInt("Pilih : ")) {
            case 1:
                System.out.println("===============[RESERVASI - CHECK IN]===============");
                Reservasi reservasi = new Reservasi();
                System.out.println("==[ Data Customer ] ==");
                Customer customer = new Customer();
                customer.setNamaDepan(strInput.get("Nama Depan  : "));
                customer.setNamaBelakang(strInput.get("Nama Belakang    : "));
                customer.setNoKTP(strInput.get("No KTP: "));
                customer.setNoTelepon(strInput.get("No Telepon : "));
                customer.setEmail(strInput.get("Email : "));
                customer.setAlamat(strInput.get("Alamat : "));
                customer.setKota(strInput.get("Kota: "));
                customer.setJenisKelamin(strInput.get("Jenis Kelamin    : "));
                customer.setTanggalLahir(strInput.get("Tanggal Lahir (Y-m-d)   : "));
                database.addCustomer(customer);
                reservasi.setCustomer(customer);

                System.out.println("==[ Data Reservasi ] ==");
                reservasi.setLamaInap(intInput.getInt("Lama Inap: "));
                System.out.println("Pilih Kamar dengan Opsi");
                for (int i = 0; i < database.getListKamarKosong().toArray().length; i++) {
                    System.out.println("================\nOpsi -> ["+ i + "]");
                    System.out.println(database.getListKamarKosong().get(i));
                }
                try {
                    Kamar kamarPilihan = database.getListKamarKosong().get(intInput.getInt("Opsi Kamar: "));
                    reservasi.setKamar(kamarPilihan);
                    System.out.println("==[ Konfirmasi & Pembayaran ] ==");
                    int totalBiaya = kamarPilihan.getHarga() * reservasi.getLamaInap();
                    System.out.println(kamarPilihan.toString());
                    System.out.println("Lama Inap: " + reservasi.getLamaInap() + " malam");
                    System.out.println("Total Biaya: Rp " + totalBiaya);
                    int biayaDibayar = intInput.getInt("Total Uang Terbayar: Rp ");
                    reservasi.setTotalPembayaran(biayaDibayar);
                    database.addReservasi(reservasi);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Kamar tidak ditemukan!");
                    return;
                }
                System.out.println("Reservasi Berhasil");
                break;
            case 2:
                System.out.println("===============[RESERVASI - CHECK OUT]===============");
                System.out.println("Pilih Nomor Reservasi");
                for (int i = 0; i < database.getListReservasi().toArray().length; i++) {
                    Reservasi resv = database.getListReservasi().get(i);
                    System.out.println("[Nomor: " + i + "] " + resv.toString(true));
                }
                try {
                    Reservasi resv = database.getListReservasi().get(intInput.getInt("Nomor Reservasi: "));
                    System.out.println(resv.toString());
                    // Kalkulasi denda
                    if (resv.getDenda() > 0 || resv.getKurangPembayaran() > 0) {
                        System.out.println("Total hari dari tanggal checkout yang ditentukan: " + resv.getTotalHariTerlambat() + " hari");
                        int total = resv.getDenda() + resv.getKurangPembayaran();
                        System.out.println("Silahkan membayar sebesar Rp. " + total);
                        int bayar = 0;
                        boolean lunas = false;
                        do {
                            bayar = intInput.getInt("Jumlah Uang: ");
                            if (bayar == total) {
                                lunas = true;
                            } else {
                                System.out.println("Jumlah uang tidak memenuhi total yang harus dibayar.");
                            }
                        } while(!lunas);
                        resv.setDenda(0);
                        resv.setKurangPembayaran(0);
                    }
                    database.removeReservasi(resv);
                    System.out.println("Proses Checkout berhasil!");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Reservasi dengan nomor tersebut tidak ditemukan!");
                }
                break;

            case 10: return;

            default:
                System.out.println("Pilihan tidak sah!");
                break;
        }
    }

    private void lihatReservasi() {
        System.out.println("===============[LIST RESERVASI]===============");
        for (Reservasi r : database.getListReservasi()) {
            System.out.println(r.toString(true));
        }
        if (database.getListReservasi().isEmpty()) {
            System.out.println("Data Reservasi Kosong");
        }
    }

    private void lihatCustomer() {
        System.out.println("===============[LIST CUSTOMER]===============");
        for (Customer c : database.getListCustomer()) {
            System.out.println(c.toString());
            System.out.println("======================");
        }
        if (database.getListCustomer().isEmpty()) {
            System.out.println("Data Customer Kosong");
        }
    }

    private void lihatKaryawan() {
        System.out.println("===============[LIST KARYAWAN]===============");
        for (Karyawan k : database.getListKaryawan()) {
            System.out.println(k.toString());
            System.out.println("======================");
        }
        if (database.getListKaryawan().isEmpty()) {
            System.out.println("Data Karyawan Kosong");
        }
    }
}
