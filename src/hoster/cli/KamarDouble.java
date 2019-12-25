package hoster.cli;

public class KamarDouble extends Kamar {

    public KamarDouble(String kode, int harga) {
        super("Double");
        this.setKode(kode);
        setHarga(harga);
    }

    @Override
    public void setKode(String kode) {
        super.setKode("D-" + kode);
    }
}
