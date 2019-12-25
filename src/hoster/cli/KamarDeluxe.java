package hoster.cli;

public class KamarDeluxe extends Kamar {

    public KamarDeluxe(String kode, int harga) {
        super("Deluxe");
        this.setKode(kode);
        setHarga(harga);
    }

    @Override
    public void setKode(String kode) {
        super.setKode("DEX-" + kode);
    }
}
