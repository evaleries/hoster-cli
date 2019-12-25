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
        String namaDepan    = strInput.get("Nama Depan  : ");
        String namaBelakang = strInput.get("Nama Belakang    : ");
        String noKTP        = strInput.get("No KTP: ");
        String noTelepon    = strInput.get("No Telepon : ");
        String email        = strInput.get("Email : ");
        String alamat       = strInput.get("Alamat : ");
        String jenisKelamin = strInput.get("Jenis Kelamin    : ");
        String kota         = strInput.get("Kota : ");
        String tanggalLahir = strInput.get("Tanggal Lahir  (Y-m-d)  : ");
        String tanggalRekrut= strInput.get("Tanggal Rekrut (Y-m-d) : ");
        Karyawan karyawan = new Karyawan(namaDepan, namaBelakang, email, noKTP, noTelepon, jenisKelamin, alamat, kota, tanggalLahir, tanggalRekrut);
        database.addKaryawan(karyawan);
        System.out.println("Karyawan berhasil ditambahkan");
    }

    private void tambahKamar() {
        String kode;
        int harga;
        System.out.println("===============[TAMBAH KAMAR]===============");
        System.out.println("Tipe Kamar: ");
        System.out.println("1. Single");
        System.out.println("2. Double");
        System.out.println("3. Deluxe");
        System.out.println("10. Kembali");
        switch (intInput.getInt("Pilih Tipe: ")) {
            case 1:
                kode    = strInput.get("Kode Kamar Single: S-");
                harga   = intInput.getInt("Harga Per Malam: ");
                KamarSingle kamarSingle = new KamarSingle(kode, harga);
                database.addKamarSingle(kamarSingle);
                break;
            case 2:
                kode    = strInput.get("Kode Kamar Double: D-");
                harga   = intInput.getInt("Harga Per Malam: ");
                KamarDouble kamarDouble = new KamarDouble(kode, harga);
                database.addKamarDouble(kamarDouble);
                break;
            case 3:
                kode    = strInput.get("Kode Kamar Deluxe: Dex-");
                harga   = intInput.getInt("Harga Per Malam: ");
                KamarDeluxe kamarDeluxe = new KamarDeluxe(kode, harga);
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
                System.out.println("==[ Data Customer ] ==");
                String namaDepan    = strInput.get("Nama Depan  : ");
                String namaBelakang = strInput.get("Nama Belakang    : ");
                String noKTP        = strInput.get("No KTP: ");
                String noTelepon    = strInput.get("No Telepon : ");
                String email        = strInput.get("Email : ");
                String alamat       = strInput.get("Alamat : ");
                String kota         = strInput.get("Kota: ");
                String jenisKelamin = strInput.get("Jenis Kelamin    : ");
                String tanggalLahir = strInput.get("Tanggal Lahir (Y-m-d)   : ");
                Customer customer = new Customer(namaDepan, namaBelakang, email, noKTP, noTelepon, jenisKelamin, alamat, kota, tanggalLahir);
                database.addCustomer(customer);

                System.out.println("==[ Data Reservasi ] ==");
                int lamaInap = intInput.getInt("Lama Inap: ");
                System.out.println("Pilih Kamar dengan Opsi");
                for (int i = 0; i < database.getListKamarKosong().toArray().length; i++) {
                    System.out.println("================\nOpsi -> ["+ i + "]");
                    System.out.println(database.getListKamarKosong().get(i));
                }
                try {
                    Kamar kamarPilihan = database.getListKamarKosong().get(intInput.getInt("Opsi Kamar: "));
                    System.out.println("==[ Konfirmasi & Pembayaran ] ==");
                    int totalBiaya = kamarPilihan.getHarga() * lamaInap;
                    System.out.println(kamarPilihan.toString());
                    System.out.println("Lama Inap: " + lamaInap + " malam");
                    System.out.println("Total Biaya: Rp " + totalBiaya);
                    int biayaDibayar = intInput.getInt("Total Uang Terbayar: Rp ");
                    Reservasi reservasi = new Reservasi(customer, kamarPilihan, lamaInap, biayaDibayar);
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
