package hoster.cli;

public class KamarDouble extends Kamar {

    public KamarDouble() {
        super("Double");
    }

    @Override
    public void setKode(String kode) {
        super.setKode("D-" + kode);
    }
}
