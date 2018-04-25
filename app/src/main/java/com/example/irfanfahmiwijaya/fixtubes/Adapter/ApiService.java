package com.example.irfanfahmiwijaya.fixtubes.Adapter;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by irfanfahmiwijaya on 12/04/2018.
 */

public interface ApiService {
    @GET("JsonDisplayMarker.php")
    Call<ListLocationModelMasjid> getAllLocation();

    @GET("Tampil_Data_Penginapan.php")
    Call<ListLocationModelPenginapan> getAllLocationpenginapan();

    @GET("Tampil_Data_Restoran.php")
    Call<ListLocationModelRestoran> getAllLocationrestoran();
}
