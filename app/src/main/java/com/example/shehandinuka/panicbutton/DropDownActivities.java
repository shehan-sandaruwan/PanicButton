package com.example.shehandinuka.panicbutton;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shehan dinuka on 11/09/2018.
 */

public class DropDownActivities extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_map);

        Spinner dropDown = findViewById(R.id.spinner);
        dropDown.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) getApplicationContext());

        List<String> categories = new ArrayList<String>();
        categories.add("Add location");
        categories.add("Remove location");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        dropDown.setAdapter(dataAdapter);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        switch (position){
            case 0:
                Intent i = new Intent(this,SetLocation.class);
                startActivity(i);
                break;
            default:
                break;
        }

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
