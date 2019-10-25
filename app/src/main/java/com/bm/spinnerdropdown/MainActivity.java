package com.bm.spinnerdropdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
   Spinner spinCountry, spinPlayers;
   AutoCompleteTextView autoPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinCountry = findViewById(R.id.spinCountry);

        String countries[] = {"Nepal", "USA"};
        final String nepali[] = {"paras","Gyanandra","Sandeep","Saman","Pandey"};
        final String english[] = {"Albert", "Abel" , "john","Jobe"};

        final String lang[] = {"php","java"};

        spinCountry = findViewById(R.id.spinCountry);
        spinPlayers = findViewById(R.id.spinPlayers);

        autoPlayers = findViewById(R.id.playerAuto);

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);
        spinCountry.setAdapter(adapter);

        spinCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (spinCountry.getSelectedItem().toString().equals("Nepal")) {
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                            MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            nepali
                    );
                    spinPlayers.setAdapter(arrayAdapter);

                    ArrayAdapter<String> autoAdapter = new ArrayAdapter<>(
                            MainActivity.this,
                            android.R.layout.select_dialog_item,
                            nepali
                    );
                    autoPlayers.setAdapter(autoAdapter);
                    autoPlayers.setThreshold(1);

                }
                    else{
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                            MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            english
                    );
                        spinPlayers.setAdapter(arrayAdapter);

                    ArrayAdapter<String> autoAdapter = new ArrayAdapter<>(
                            MainActivity.this,
                            android.R.layout.select_dialog_item,
                            english
                    );
                    autoPlayers.setAdapter(autoAdapter);
                    autoPlayers.setThreshold(1);

                    }
                }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}