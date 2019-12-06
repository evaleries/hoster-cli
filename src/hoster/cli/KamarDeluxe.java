package hoster.cli;

public class KamarDeluxe extends Kamar {
    public KamarDeluxe() {
        super("Deluxe");
    }

    @Override
    public void setKode(String kode) {
        super.setKode("DEX-" + kode);
    }
}
