package hoster.cli;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hoster - Hotel Management");

        /**
         * Data dummy
         */
        Dataset database = new Dataset();
        HashMap<String, String> accounts = new HashMap<>();
        accounts.put("admin", "hoster");
        accounts.put("dida", "dida");
        database.setAccounts(accounts);

        KamarSingle s01 = new KamarSingle("01", 150000);
        KamarSingle s02 = new KamarSingle("02", 160000);
        KamarDouble d01 = new KamarDouble("01", 320000);
        KamarDouble d02 = new KamarDouble("02", 300000);
        KamarDeluxe dex1 = new KamarDeluxe("01", 480000);
        KamarDeluxe dex2 = new KamarDeluxe("02", 500000);
        Customer yogi = new Customer("Yogi", "Alex", "yogi@hoster.app", "350915293859231", "08123875782", "L", "Jl. Jalan di pagi hari 12", "Jember", "21/04/1999");
        Customer adit = new Customer("Adit", "Texa", "adit@gmail.com", "3509112412231", "08141235782", "L", "Jl. Jalan siapa tau jalan", "Jember", "1999-01-01");
        Karyawan dida = new Karyawan("Dida", "Hoster", "dida@hoster.app", "358392748294", "0811111111", "L", "Jl. Jalan di pagi hari 21", "Surabaya", "01/08/2077", "01/01/2000");
        Karyawan choki = new Karyawan("Chokito", "Fharisi", "choki@hoster.app", "350892378847273814", "081234472841", "L", "Jl. Jalan di malam hari 29", "Jember", "01/08/2018", "01/01/2000");
        Reservasi reservasi = new Reservasi(yogi, dex2,3, 1200000);
        Reservasi reservasi2 = new Reservasi(adit, d02, 5, 1500000);

        database.addKamarSingle(s01);
        database.addKamarSingle(s02);
        database.addKamarDouble(d01);
        database.addKamarDouble(d02);
        database.addKamarDeluxe(dex1);
        database.addKamarDeluxe(dex2);
        database.addCustomer(yogi);
        database.addCustomer(adit);
        database.addKaryawan(dida);
        database.addKaryawan(choki);
        database.addReservasi(reservasi);
        database.addReservasi(reservasi2);

        new App(database, false);
    }

}
