package com.example.irfanfahmiwijaya.fixtubes.Adapter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by irfanfahmiwijaya on 12/04/2018.
 */

public class ListLocationModelMasjid {

    @SerializedName("data")
    private List<LocationModelMasjid> mData;

    public ListLocationModelMasjid(List<LocationModelMasjid> mData) {
        this.mData = mData;
    }

    public ListLocationModelMasjid() {
    }

    public List<LocationModelMasjid> getmData() {
        return mData;
    }

    public void setmData(List<LocationModelMasjid> mData) {
        this.mData = mData;
    }
}
