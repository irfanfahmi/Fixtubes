package com.example.irfanfahmiwijaya.fixtubes.Adapter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by irfanfahmiwijaya on 12/04/2018.
 */

public class ListLocationModel {

    @SerializedName("data")
    private List<LocationModel> mData;

    public ListLocationModel(List<LocationModel> mData) {
        this.mData = mData;
    }

    public ListLocationModel() {
    }

    public List<LocationModel> getmData() {
        return mData;
    }

    public void setmData(List<LocationModel> mData) {
        this.mData = mData;
    }
}
