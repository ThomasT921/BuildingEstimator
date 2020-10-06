package com.example.tt_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class ResturantActivity extends AppCompatActivity {
    Button restaurantBack;
    EditText kitchen, parking, freezers, bathrooms, sinks, refrig;
    CheckBox driveThru;
    int areaParking, numFreezers, numBaths, sizeKitch, numSinks, numRefig, hasD;
    Boolean filled = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resturant);
        restaurantBack = findViewById(R.id.calcResturantBtn);
        kitchen = findViewById(R.id.kitchenInput);
        parking = findViewById(R.id.parkingInput);
        freezers = findViewById(R.id.freezerInput);
        bathrooms = findViewById(R.id.bathroomInput);
        sinks = findViewById(R.id.sinkInput);
        refrig = findViewById(R.id.refrigeratorsInput);
        driveThru = findViewById(R.id.driveThruChkBx);

        restaurantBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkData();
                try {
                    if (parking.toString().length() > 0) {
                        areaParking = Integer.valueOf(parking.getText().toString());
                    }
                    if (freezers.toString().length() > 0) {
                        numFreezers = Integer.valueOf(freezers.getText().toString());
                    }
                    if (bathrooms.toString().length() > 0) {
                        numBaths = Integer.valueOf(bathrooms.getText().toString());
                    }
                    if (kitchen.toString().length() > 0) {
                        sizeKitch = Integer.valueOf(kitchen.getText().toString());
                    }
                    if (sinks.toString().length() > 0) {
                        numSinks = Integer.valueOf(sinks.getText().toString());
                    }
                    if (refrig.toString().length() > 0) {
                        numRefig = Integer.valueOf(refrig.getText().toString());
                    }
                    if (driveThru.isChecked()) {
                        hasD = 1;
                    }
                }
                catch (Exception ex){
                    Toast toast = Toast.makeText(ResturantActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT);
                    toast.show();
                }

                if (filled == true){
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("refig", numRefig);
                    resultIntent.putExtra("parking", areaParking);
                    resultIntent.putExtra("bath", numBaths);
                    resultIntent.putExtra("freezers", numFreezers);
                    resultIntent.putExtra("drive", hasD);
                    resultIntent.putExtra("kitchen", sizeKitch);
                    resultIntent.putExtra("sinks", numSinks);

                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }
    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    public void checkData(){
        if (isEmpty(kitchen)){
            kitchen.setError("Square footage is required.");
            filled = false;
        }
        else{
            filled = true;
        }
        if (isEmpty(parking)){
            parking.setError("Amount of land is required.");
            filled = false;
        }
        else{
            filled = true;
        }
        if (isEmpty(freezers)){
            freezers.setError("Number of floors are required.");
            filled = false;
        }
        else{
            filled = true;
        }
        if (isEmpty(bathrooms)){
            bathrooms.setError("Number of floors are required.");
            filled = false;
        }
        else{
            filled = true;
        }
        if (isEmpty(sinks)){
            sinks.setError("Number of floors are required.");
            filled = false;
        }
        else{
            filled = true;
        }
        if (isEmpty(refrig)){
            refrig.setError("Number of floors are required.");
            filled = false;
        }
        else{
            filled = true;
        }
    }
}
