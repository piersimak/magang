package diginetmedia.com.sikedes.model;

/**
 * Created by PIER on 7/21/2016.
 */
public class Laporan {
    public Laporan(String nama_pelapor, String isi_laporan) {
        this.nama_pelapor = nama_pelapor;
        this.isi_laporan = isi_laporan;
    }

    private String nama_pelapor;

    public String getIsi_laporan() {
        return isi_laporan;
    }

    public void setIsi_laporan(String isi_laporan) {
        this.isi_laporan = isi_laporan;
    }

    public String getNama_pelapor() {
        return nama_pelapor;
    }

    public void setNama_pelapor(String nama_pelapor) {
        this.nama_pelapor = nama_pelapor;
    }

    private String isi_laporan;
}
