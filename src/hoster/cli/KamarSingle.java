package hoster.cli;

public class KamarSingle extends Kamar {

    public KamarSingle() {
        super("Single");
    }

    @Override
    public void setKode(String kode) {
        super.setKode("S-" + kode);
    }
}
