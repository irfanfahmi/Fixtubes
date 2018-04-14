package com.example.irfanfahmiwijaya.fixtubes.Adapter;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by irfanfahmiwijaya on 12/04/2018.
 */

public interface ApiService {
    @GET("JsonDisplayMarker.php")
    Call<ListLocationModel> getAllLocation();
}
