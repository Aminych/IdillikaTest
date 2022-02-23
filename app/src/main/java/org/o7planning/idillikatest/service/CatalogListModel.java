package org.o7planning.idillikatest.service;

import android.util.Log;
import android.widget.Toast;

import org.o7planning.idillikatest.Contract.CatalogListContract;
import org.o7planning.idillikatest.model.Constructor;
import org.o7planning.idillikatest.network.ApiClient;
import org.o7planning.idillikatest.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatalogListModel implements CatalogListContract.Model {

    private final String TAG = "ConstructorListModel";
    private int pageNo = 1;

    @Override
    public void getConstructorList(onFinishedCall onFinishedCall, int pageNo) {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Constructor>> call = apiService.getCatalog();

        call.enqueue(new Callback<List<Constructor>>() {
            @Override
            public void onResponse(Call<List<Constructor>> call, Response<List<Constructor>> response) {
                ArrayList<Constructor> constructors = (ArrayList<Constructor>) response.body();
                Log.e(TAG, "Numbers of product received" + constructors.size());

                onFinishedCall.onResponse(constructors);
            }

            @Override
            public void onFailure(Call<List<Constructor>> call, Throwable t) {

                Log.e(TAG, t.toString());
                onFinishedCall.onFailure(t);

            }
        });
    }
}