package com.example.irfanfahmiwijaya.fixtubes.Adapter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by irfanfahmiwijaya on 12/04/2018.
 */

public class LocationModel {

    public String getNama_masjid() {
        return nama_masjid;
    }

    public void setNama_masjid(String nama_masjid) {
        this.nama_masjid = nama_masjid;
    }

    public String getLatutide() {
        return latutide;
    }

    public void setLatutide(String latutide) {
        this.latutide = latutide;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @SerializedName("nama_masjid")
    private String nama_masjid;
    @SerializedName("latitude")
    private String latutide;
    @SerializedName("longitude")
    private String longitude;

    public LocationModel(String nama_masjid, String latutide, String longitude) {
        this.nama_masjid = nama_masjid;
        this.latutide = latutide;
        this.longitude = longitude;
    }


}
