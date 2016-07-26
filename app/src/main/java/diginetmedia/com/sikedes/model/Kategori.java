package diginetmedia.com.sikedes.model;

import android.support.annotation.DrawableRes;

/**
 * Created by PIER on 7/18/2016.
 */
public class Kategori {
    public Kategori(String nama, @DrawableRes int gambar) {
        this.nama = nama;
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    private String nama;



    private @DrawableRes int gambar;
}
