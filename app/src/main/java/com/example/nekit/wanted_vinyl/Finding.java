package com.example.nekit.wanted_vinyl;

import com.google.android.gms.maps.model.LatLng;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Finding {
    @FormUrlEncoded
    @POST
    Call<String> performPostCall(@FieldMap Map<String, LatLng> places);
}
