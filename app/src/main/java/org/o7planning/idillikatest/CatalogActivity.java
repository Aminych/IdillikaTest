package org.o7planning.idillikatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.o7planning.idillikatest.Contract.CatalogListContract;
import org.o7planning.idillikatest.model.Constructor;
import org.o7planning.idillikatest.presenter.CatalogPresenter;
import org.o7planning.idillikatest.view.ConstructorListAdapter;


import java.util.ArrayList;
import java.util.List;

public class CatalogActivity extends AppCompatActivity implements CatalogListContract.View {

    ImageView korzina, backLayout;
    Intent intentKorzina, intentBackLayout;

    private CatalogPresenter catalogPresenter;
    private RecyclerView rvCatalog;
    private ArrayList<Constructor> constructorList;
    private ConstructorListAdapter constructorListAdapter;
    private GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        constructorList = new ArrayList<Constructor>();

        rvCatalog = findViewById(R.id.rvCatalog);

        layoutManager = new GridLayoutManager(this, 2);
        rvCatalog.setLayoutManager(layoutManager);
        rvCatalog.setHasFixedSize(true);

        catalogPresenter = new CatalogPresenter(this);
        catalogPresenter.requestDataFromServer();

        korzina = findViewById(R.id.korzina);
        backLayout = findViewById(R.id.backLayout);

        korzina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentKorzina = new Intent(CatalogActivity.this, KorzinaActivity.class);
                startActivity(intentKorzina);
            }
        });

        backLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentBackLayout = new Intent(CatalogActivity.this, MainActivity.class);
                startActivity(intentBackLayout);
            }
        });
    }

    @Override
    public void showLike() {

    }

    @Override
    public void hideLike() {

    }

    @Override
    public void setDataToRecycleView(List<Constructor> catalogArrayList) {
        constructorList.addAll(catalogArrayList);
        constructorListAdapter = new ConstructorListAdapter(constructorList, CatalogActivity.this);
        rvCatalog.setAdapter(constructorListAdapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }
}