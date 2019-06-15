package com.example.midtronicstask;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CountryDetails extends AppCompatActivity {




    public static TextView callingCodeAns;
    public static TextView capitalAns;
    public static TextView borderAns;
    public static TextView regionAns;
    public static TextView subRegionAns;
    public static TextView areaAns;
    public static TextView demonymAns;
    public static TextView nativeNameAns;
    public static TextView relevanceAns;
    public static TextView alpha2CodeAns;
    public static TextView alpha3CodeAns;
    public static TextView populationAns;
    public static TextView giniAns;
    public static TextView numericCodeAns;
    public static TextView latAns;
    public static TextView lngAns;
    public static TextView topLevelDomainAns;
    public static TextView currenciesAns;
    public static TextView timezonesAns;
    public static TextView languagesAns;

    Button button;
    //public TextView capital;
    public static String country = "";

    public static TextView cName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);


        cName = findViewById(R.id.CountryHeading);
        //capital = findViewById(R.id.capital);

        capitalAns = findViewById(R.id.capitalAns);
        borderAns = findViewById(R.id.bordersAns);
        regionAns= findViewById(R.id.regionAns);
         subRegionAns= findViewById(R.id.subRegionAns);
         areaAns= findViewById(R.id.areaAns);
         demonymAns= findViewById(R.id.demonymAns);
         nativeNameAns= findViewById(R.id.nativeNameAns);
         relevanceAns= findViewById(R.id.relevanceAns);
         alpha2CodeAns= findViewById(R.id.alphacode2Ans);
         alpha3CodeAns= findViewById(R.id.alphacode3Ans);
         populationAns= findViewById(R.id.populationAns);
         giniAns= findViewById(R.id.giniAns);
         numericCodeAns= findViewById(R.id.numericCodeAns);
         latAns= findViewById(R.id.latAns);
         lngAns= findViewById(R.id.lngAns);
         topLevelDomainAns= findViewById(R.id.topLevelDomainAns);
         currenciesAns= findViewById(R.id.currenciesAns);
         timezonesAns= findViewById(R.id.timezoneAns);
         languagesAns= findViewById(R.id.languagesAns);
         callingCodeAns = findViewById(R.id.callingCodeAns);

        //capital.setText("Capital:");
        //button = findViewById(R.id.button_parse);

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData fetch = new fetchData();
                fetch.execute();


            }
        });*/
    }
}

