package diginetmedia.com.sikedes.model;

/**
 * Created by PIER on 7/22/2016.
 */
public class Bantuan {
    private Double jumlahuang;
    private String barang;

    public Bantuan() {
    }

    public Bantuan(Double jumlahuang, String barang) {
        this.jumlahuang = jumlahuang;
        this.barang = barang;
    }

    public Double getJumlahuang() {
        return jumlahuang;
    }

    public void setJumlahuang(Double jumlahuang) {
        this.jumlahuang = jumlahuang;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }
}
