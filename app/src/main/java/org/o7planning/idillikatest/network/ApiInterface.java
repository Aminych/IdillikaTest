package org.o7planning.idillikatest.network;

import org.o7planning.idillikatest.model.Constructor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("3")
    Call<List<Constructor>> getCatalog();
}
