package id.haweje.covid19v1.model.provinsi;

import com.google.gson.annotations.SerializedName;


public class ProvinsiModel {
    @SerializedName("Provinsi")
    private String provinsi;
    @SerializedName("Kode_Provi")
    private String kode_provi;
    @SerializedName("Kasus_Posi")
    private String kasus_posi;
    @SerializedName("Kasus_Semb")
    private String kasus_semb;
    @SerializedName("Kasus_Meni")
    private String kasus_meni;

    ProvinsiModel(String provinsi, String kode_provi, String kasus_posi, String kasus_semb, String kasus_meni) {
        this.provinsi = provinsi;
        this.kode_provi = kode_provi;
        this.kasus_posi = kasus_posi;
        this.kasus_semb = kasus_semb;
        this.kasus_meni = kasus_meni;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public String getKode_provi() {
        return kode_provi;
    }

    public String getKasus_posi() {
        return kasus_posi;
    }

    public String getKasus_semb() {
        return kasus_semb;
    }

    public String getKasus_meni() {
        return kasus_meni;
    }
}

