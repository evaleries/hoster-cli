package hoster.cli;

public class KamarSingle extends Kamar {

    public KamarSingle(String kode, int harga) {
        super("Single");
        this.setKode(kode);
        setHarga(harga);
    }

    @Override
    public void setKode(String kode) {
        super.setKode("S-" + kode);
    }
}
