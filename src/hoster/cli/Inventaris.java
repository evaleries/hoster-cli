package hoster.cli;

import java.util.ArrayList;
import java.util.List;
@Deprecated
public abstract class Inventaris {

    private List<Barang> listBarang = new ArrayList<Barang>();

    public List<Barang> getListBarang() {
        return listBarang;
    }

    public void addBarang(Barang barang) {
        listBarang.add(barang);
    }

    public void setListBarang(List<Barang> listBarang) {
        this.listBarang = listBarang;
    }
}
