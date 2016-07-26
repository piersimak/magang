package diginetmedia.com.sikedes.model;

/**
 * Created by PIER on 7/19/2016.
 */
public class DataKemiskinan {
    public DataKemiskinan() {
    }

    public DataKemiskinan(String imageurl, String namakeluarga) {
        this.imageurl = imageurl;
        this.namakeluarga = namakeluarga;
    }

    public DataKemiskinan(String alamat, String imageurl, String namakeluarga) {
        this.alamat = alamat;
        this.imageurl = imageurl;
        this.namakeluarga = namakeluarga;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    private String alamat;
    private String imageurl;

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getNamakeluarga() {
        return namakeluarga;
    }

    public void setNamakeluarga(String namakeluarga) {
        this.namakeluarga = namakeluarga;
    }

    private String namakeluarga;
}
