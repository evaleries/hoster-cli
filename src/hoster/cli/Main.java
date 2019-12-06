package hoster.cli;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hoster - Hotel Management");

        Dataset database = new Dataset();
        HashMap<String, String> accounts = new HashMap<>();
        accounts.put("admin", "hoster");
        accounts.put("dida", "dida");
        database.setAccounts(accounts);

        KamarSingle s01 = new KamarSingle();
        KamarSingle s02 = new KamarSingle();
        KamarDouble d01 = new KamarDouble();
        KamarDouble d02 = new KamarDouble();
        KamarDeluxe dex1 = new KamarDeluxe();
        KamarDeluxe dex2 = new KamarDeluxe();

        s01.setKode("01");
        s01.setHarga(150000);
        s01.setKeterangan("Tidak Ada Keterangan");
        s02.setKode("02");
        s02.setHarga(160000);
        s02.setKeterangan("Tidak Ada Keterangan");

        d01.setKode("01");
        d01.setHarga(320000);
        d02.setKode("02");
        d02.setHarga(300000);

        dex1.setKode("01");
        dex1.setHarga(480000);
        dex2.setKode("02");
        dex2.setHarga(500000);

        database.addKamarSingle(s01);
        database.addKamarSingle(s02);
        database.addKamarDouble(d01);
        database.addKamarDouble(d02);
        database.addKamarDeluxe(dex1);
        database.addKamarDeluxe(dex2);

        Customer yogi = new Customer();
        yogi.setNamaDepan("Yogi");
        yogi.setNamaBelakang("Alex");
        yogi.setEmail("yogi@hoster.app");
        yogi.setNoKTP("350915293859231");
        yogi.setNoTelepon("08123875782");
        yogi.setJenisKelamin("L");
        yogi.setAlamat("Jl. Jalan di pagi hari 12");
        yogi.setTanggalLahir("21/04/1999");
        yogi.setKota("Jember");
        database.addCustomer(yogi);

        Customer adit = new Customer();
        adit.setNamaDepan("Adit");
        adit.setNamaBelakang("Texa");
        adit.setEmail("adit@gmail.com");
        adit.setNoKTP("3509112412231");
        adit.setNoTelepon("08141235782");
        adit.setJenisKelamin("L");
        adit.setAlamat("Jl. Jalan siapa tau jalan");
        adit.setTanggalLahir("1999-01-01");
        adit.setKota("Jember");
        database.addCustomer(adit);

        Karyawan dida = new Karyawan();
        dida.setNamaDepan("Dida");
        dida.setNamaBelakang("Hoster");
        dida.setEmail("dida@hoster.app");
        dida.setNoKTP("358392748294");
        dida.setNoTelepon("0811111111");
        dida.setJenisKelamin("L");
        dida.setAlamat("Jl. Jalan di pagi hari 21");
        dida.setKota("Surabaya");
        dida.setTanggalRekrut("01/08/2077");
        dida.setTanggalLahir("01/01/2000");
        database.addKaryawan(dida);

        Karyawan choki = new Karyawan();
        choki.setNamaDepan("Chokito");
        choki.setNamaBelakang("Fharisi");
        choki.setEmail("choki@hoster.app");
        choki.setNoKTP("350892378847273814");
        choki.setNoTelepon("081234472841");
        choki.setJenisKelamin("L");
        choki.setAlamat("Jl. Jalan di malam hari 29");
        choki.setKota("Jember");
        choki.setTanggalRekrut("01/08/2018");
        choki.setTanggalLahir("01/01/2000");
        database.addKaryawan(choki);

        Reservasi reservasi = new Reservasi();
        reservasi.setKamar(dex2);
        reservasi.setCustomer(yogi);
        reservasi.setLamaInap(3);
        reservasi.setTanggalCheckOut(LocalDate.now().minusDays(2).toString());
        reservasi.setTotalPembayaran(1200000);
        database.addReservasi(reservasi);

        Reservasi reservasi2 = new Reservasi();
        reservasi2.setKamar(d02);
        reservasi2.setCustomer(adit);
        reservasi2.setLamaInap(5);
        reservasi2.setTotalPembayaran(1500000);
        database.addReservasi(reservasi2);

        new App(database, true);
    }

}
