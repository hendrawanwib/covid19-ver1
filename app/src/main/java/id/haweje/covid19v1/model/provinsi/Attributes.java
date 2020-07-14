package id.haweje.covid19v1.model.provinsi;

import com.google.gson.annotations.SerializedName;

public class Attributes extends ProvinsiModel {
    @SerializedName("attributes")
    private ProvinsiModel provinsiModel;

    public Attributes(String provinsi, String kode_provinsi, String kasus_posi, String kasus_semb, String kasus_meni) {
        super(provinsi, kode_provinsi, kasus_posi, kasus_semb, kasus_meni);
    }

    public ProvinsiModel getProvinsiModel() {
        return provinsiModel;
    }
}

