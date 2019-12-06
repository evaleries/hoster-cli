package hoster.cli;

public abstract class Kamar {

    private String kode;
    private String jenis;
    private int harga;
    private String keterangan;

    public Kamar(String jenis) {
        this.jenis = jenis;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        if (keterangan.isEmpty()) {
            this.keterangan = "Tidak ada Keterangan";
        } else {
            this.keterangan = keterangan;
        }
    }

    public String getJenis() {
        return jenis;
    }

    @Override
    public String toString() {
        String str = "-------["+ jenis +"]-------";
        str += "\nJenis Kamar: " + jenis;
        str += "\nKode Kamar: " + kode;
        str += "\nHarga Kamar: Rp " + harga + " / malam";
        str += "\nKeterangan Kamar: " + keterangan;
        return str;
    }

}
