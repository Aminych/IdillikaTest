package org.o7planning.idillikatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class KorzinaActivity extends AppCompatActivity {

    ImageView backLayout;
    Button buttonGo;
    Intent intentBackLayout, intentButtonGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korzina);

        backLayout = findViewById(R.id.backLayout);
        buttonGo = findViewById(R.id.buttonGo);

        backLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentBackLayout = new Intent(KorzinaActivity.this, CatalogActivity.class);
                startActivity(intentBackLayout);
            }
        });

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentButtonGo = new Intent(KorzinaActivity.this, CatalogActivity.class);
                startActivity(intentButtonGo);
            }
        });

    }
}