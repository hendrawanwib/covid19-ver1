package id.haweje.covid19v1.model;

import com.google.gson.annotations.SerializedName;

public class Indonesia {
    @SerializedName("lastUpdate")
    private String lastUpdate;
    @SerializedName("confirmed")
    private IdnConfirmed idnConfirmed;
    @SerializedName("recovered")
    private IdnRecovered idnRecovered;

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public IdnConfirmed getIdnConfirmed() {
        return idnConfirmed;
    }

    public void setIdnConfirmed(IdnConfirmed idnConfirmed) {
        this.idnConfirmed = idnConfirmed;
    }

    public IdnRecovered getIdnRecovered() {
        return idnRecovered;
    }

    public void setIdnRecovered(IdnRecovered idnRecovered) {
        this.idnRecovered = idnRecovered;
    }

    public IdnDeaths getIdnDeaths() {
        return idnDeaths;
    }

    public void setIdnDeaths(IdnDeaths idnDeaths) {
        this.idnDeaths = idnDeaths;
    }

    public Indonesia(String lastUpdate, IdnConfirmed idnConfirmed, IdnRecovered idnRecovered, IdnDeaths idnDeaths) {
        this.lastUpdate = lastUpdate;
        this.idnConfirmed = idnConfirmed;
        this.idnRecovered = idnRecovered;
        this.idnDeaths = idnDeaths;
    }

    @SerializedName("deaths")
    private IdnDeaths idnDeaths;

    public class IdnConfirmed{
        @SerializedName("value")
        private int value;
        @SerializedName("detail")
        private String detail;

        public int getValue() {
            return value;
        }

        public String getDetail() {
            return detail;
        }

        public IdnConfirmed(int value, String detail) {
            this.value = value;
            this.detail = detail;
        }
    }
    public class IdnRecovered{
        @SerializedName("value")
        private int value;

        public IdnRecovered(int value, String detail) {
            this.value = value;
            this.detail = detail;
        }

        public int getValue() {
            return value;
        }

        public String getDetail() {
            return detail;
        }

        @SerializedName("detail")
        private String detail;
    }
    public class IdnDeaths{
        @SerializedName("value")
        private int value;
        @SerializedName("detail")
        private String detail;

        public int getValue() {
            return value;
        }

        public String getDetail() {
            return detail;
        }

        public IdnDeaths(int value, String detail) {
            this.value = value;
            this.detail = detail;
        }
    }
}
