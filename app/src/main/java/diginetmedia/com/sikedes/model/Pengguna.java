package diginetmedia.com.sikedes.model;

/**
 * Created by PIER on 7/21/2016.
 */
public class Pengguna {
    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNamauser() {
        return namauser;
    }

    public void setNamauser(String namauser) {
        this.namauser = namauser;
    }

    private String id_user;

    public Pengguna(String id_user, String nik, String namauser) {
        this.id_user = id_user;
        this.nik = nik;
        this.namauser = namauser;
    }

    private String nik;
    private String namauser;
}
