package org.o7planning.idillikatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class KorzinaActivity extends AppCompatActivity {

    ImageView backLayout;
    Intent intentBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korzina);

        backLayout = findViewById(R.id.backLayout);

        backLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentBackLayout = new Intent(KorzinaActivity.this, CatalogActivity.class);
                startActivity(intentBackLayout);
            }
        });

    }
}