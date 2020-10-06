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

public class HouseActivity extends AppCompatActivity {
    Button houseBack;
    EditText beds, fBaths, hBaths, kitchen;
    CheckBox garage, basement;
    Boolean filled = true;
    int numBeds, numfBaths, numhfBaths, areaKitch, hasG, hasB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.house);
        houseBack = findViewById(R.id.calcHouseBtn);
        beds = findViewById(R.id.bedroomInput);
        fBaths = findViewById(R.id.bathroomInput);
        hBaths = findViewById(R.id.hfBathInput);
        kitchen = findViewById(R.id.kitchenSizeInput);
        garage = findViewById(R.id.garageChkBx);
        basement = findViewById(R.id.basementChkBx);

        houseBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkData();
                try {
                    if (beds.toString().length() > 0) {
                        numBeds = Integer.valueOf(beds.getText().toString());
                    }
                    if (fBaths.toString().length() > 0) {
                        numfBaths = Integer.valueOf(fBaths.getText().toString());
                    }
                    if (hBaths.toString().length() > 0) {
                        numhfBaths = Integer.valueOf(hBaths.getText().toString());
                    }
                    if (kitchen.toString().length() > 0) {
                        areaKitch = Integer.valueOf(kitchen.getText().toString());
                    }
                    if (basement.isChecked()) {
                        hasB = 1;
                    }
                    if (garage.isChecked()) {
                        hasG = 1;
                    }
                }
                catch (Exception ex){
                    Toast toast = Toast.makeText(HouseActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if (filled == true){
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("beds", numBeds);
                    resultIntent.putExtra("full", numfBaths);
                    resultIntent.putExtra("half", numhfBaths);
                    resultIntent.putExtra("basement", hasB);
                    resultIntent.putExtra("garage", hasG);
                    resultIntent.putExtra("kitchen", areaKitch);

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
        if (isEmpty(beds)){
            beds.setError("Amount of land is required.");
            filled = false;
        }
        else{
            filled = true;
        }
        if (isEmpty(fBaths)){
            fBaths.setError("Number of floors are required.");
            filled = false;
        }
        else{
            filled = true;
        }
        if (isEmpty(hBaths)){
            hBaths.setError("Number of floors are required.");
            filled = false;
        }
        else{
            filled = true;
        }
    }
}
