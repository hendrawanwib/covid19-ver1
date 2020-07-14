package id.haweje.covid19v1.model;

import com.google.gson.annotations.SerializedName;

public class World {
    @SerializedName("lastUpdate")
    private String lastUpdate;
    @SerializedName("confirmed")
    private WorldConfirmed worldConfirmed;
    @SerializedName("recovered")
    private WorldRecovered worldRecovered;

    public String getLastUpdate() {
        return lastUpdate;
    }

    public WorldConfirmed getWorldConfirmed() {
        return worldConfirmed;
    }

    public WorldRecovered getWorldRecovered() {
        return worldRecovered;
    }

    public WorldDeaths getWorldDeaths() {
        return worldDeaths;
    }

    public World(String lastUpdate, WorldConfirmed worldConfirmed, WorldRecovered worldRecovered, WorldDeaths worldDeaths) {
        this.lastUpdate = lastUpdate;
        this.worldConfirmed = worldConfirmed;
        this.worldRecovered = worldRecovered;
        this.worldDeaths = worldDeaths;
    }

    @SerializedName("deaths")
    private WorldDeaths worldDeaths;

    public class WorldRecovered{
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

        public WorldRecovered(int value, String detail) {
            this.value = value;
            this.detail = detail;
        }
    }
    public class WorldConfirmed{
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

        public WorldConfirmed(int value, String detail) {
            this.value = value;
            this.detail = detail;
        }
    }

    public class WorldDeaths{
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

        public WorldDeaths(int value, String detail) {
            this.value = value;
            this.detail = detail;
        }
    }
}
