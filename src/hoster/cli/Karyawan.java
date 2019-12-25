package hoster.cli;

public class Karyawan extends Person {
    private String tanggalRekrut;


    public Karyawan(String namaDepan, String namaBelakang, String email, String noKTP, String noTelepon, String jenisKelamin, String alamat, String kota, String tanggalLahir, String tanggalRekrut) {
        setNamaDepan(namaDepan);
        setNamaBelakang(namaBelakang);
        setEmail(email);
        setNoKTP(noKTP);
        setNoTelepon(noTelepon);
        setJenisKelamin(jenisKelamin);
        setAlamat(alamat);
        setKota(kota);
        setTanggalLahir(tanggalLahir);
        setTanggalRekrut(tanggalRekrut);
    }


    public String getTanggalRekrut() {
        return tanggalRekrut;
    }

    public void setTanggalRekrut(String tanggalRekrut) {
        this.tanggalRekrut = tanggalRekrut;
    }
}
