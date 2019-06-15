package com.example.midtronicstask;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1 = findViewById(R.id.list_country);
        b2 = findViewById(R.id.mypro);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 openCounty();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }
        });
    }

    private void openProfile() {

        Intent intent = new Intent(this,profilePage.class);
        startActivity(intent);
    }

    private void openCounty() {

        Intent intent = new Intent(this, CountryClass.class);
        startActivity(intent);
    }
}
