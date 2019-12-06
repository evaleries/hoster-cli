package hoster.cli;

public class Person {
    private String noKTP;
    private String namaDepan;
    private String namaBelakang;
    private String email;
    private String noTelepon;
    private String alamat;
    private String kota;
    private String jenisKelamin;
    private String tanggalLahir;

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getNoKTP() {
        return noKTP;
    }

    public void setNoKTP(String noKTP) {
        this.noKTP = noKTP;
    }

    public String getNamaLengkap() {
        return namaDepan + " " + namaBelakang;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (! email.contains("@")) {
            this.email = email + "@hoster.app";
        } else {
            this.email = email;
        }
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisKelamin() {
        if (jenisKelamin.equals("P")) {
            return "Perempuan";
        } else if (jenisKelamin.equals("L")) {
            return "Laki-laki";
        } else {
            return "Lainnya";
        }
    }

    public void setJenisKelamin(String jenisKelamin) {
        if (! jenisKelamin.isEmpty() || ! jenisKelamin.isBlank() || jenisKelamin.length() > 1) {
            this.jenisKelamin = jenisKelamin.substring(0, 1);
        } else {
            this.jenisKelamin = jenisKelamin;
        }
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    @Override
    public String toString() {
        return "No. KTP: " + noKTP +
                "\nNama Depan: " + namaDepan +
                "\nNama Belakang: " + namaBelakang +
                "\nEmail: " + email +
                "\nNo Telepon: " + noTelepon +
                "\nAlamat: " + alamat +
                "\nKota: " + kota +
                "\nJenis Kelamin: " + jenisKelamin +
                "\nTanggal Lahir: " + tanggalLahir;
    }
}
