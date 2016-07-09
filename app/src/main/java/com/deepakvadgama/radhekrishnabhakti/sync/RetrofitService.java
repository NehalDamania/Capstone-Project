package com.deepakvadgama.radhekrishnabhakti.sync;


import com.deepakvadgama.radhekrishnabhakti.pojo.Content;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitService {

    @POST("/api/stream/latest")
    Call<List<Content>> getContent(@Query("low") int fromId);

    @POST("/api/favorites/get")
    Call<List<Content>> getFavorites(@Query("email") String email);


}
