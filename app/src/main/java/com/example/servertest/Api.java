package com.example.servertest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://amirasadi13.pythonanywhere.com/";

    @GET("wellcome")
    Call<List<Human>> getHumans();
}
