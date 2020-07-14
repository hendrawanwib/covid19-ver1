package id.haweje.covid19v1.model.negara;

import com.google.gson.annotations.SerializedName;

public class AttributesNegara extends NegaraModel {
    @SerializedName("attributes")
    private NegaraModel negaraModel;

    public AttributesNegara(String objectId, String countryRegion, String confirmed, String recovered, String deaths) {
        super(objectId, countryRegion, confirmed, recovered, deaths);
    }

    public NegaraModel getNegaraModel() {
        return negaraModel;
    }
}
