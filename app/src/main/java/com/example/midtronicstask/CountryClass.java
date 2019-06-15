package com.example.midtronicstask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class CountryClass extends AppCompatActivity{
    Button enter;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countries);

        enter = findViewById(R.id.submit_country);
        Spinner spin = findViewById(R.id.country_name);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.countries_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(mSelectedItemListener);
        text = spin.getSelectedItem().toString();
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetails();
            }
        });
    }

    public void openDetails() {


        fetchData fetch = new fetchData();
        fetch.execute();
        Intent intent = new Intent(this,CountryDetails.class);
        startActivity(intent);
            }

    AdapterView.OnItemSelectedListener mSelectedItemListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String text = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(),"You have selected "+ text, Toast.LENGTH_SHORT).show();
            fetchData.country = text;

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

}



