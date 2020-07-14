package id.haweje.covid19v1.model.negara;

import com.google.gson.annotations.SerializedName;

public class NegaraModel {
    @SerializedName("OBJECTID")
    private String objectId;

    public String getObjectId() {
        return objectId;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getDeaths() {
        return deaths;
    }

    public NegaraModel(String objectId, String countryRegion, String confirmed, String recovered, String deaths) {
        this.objectId = objectId;
        this.countryRegion = countryRegion;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
    }

    @SerializedName("Country_Region")
    private String countryRegion;
    @SerializedName("Confirmed")
    private String confirmed;
    @SerializedName("Recovered")
    private String recovered;
    @SerializedName("Deaths")
    private String deaths;



}

