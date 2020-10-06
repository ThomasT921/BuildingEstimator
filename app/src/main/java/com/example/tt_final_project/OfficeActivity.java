package com.example.tt_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OfficeActivity extends AppCompatActivity {
    Button officeBack;
    EditText rooms, parking, elevators, bathrooms, breakrooms;
    Boolean filled = true;
    int numRooms, parkArea, numElevators, numBath, numBreak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.office);
        officeBack = findViewById(R.id.calcOfficeBtn);
        rooms = findViewById(R.id.roomsInput);
        parking = findViewById(R.id.parkingAreaInput);
        elevators = findViewById(R.id.elevatorInput);
        bathrooms = findViewById(R.id.bathInput);
        breakrooms = findViewById(R.id.breakroomInput);

        officeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkData();
                try {
                    if (rooms.toString().length() > 0) {
                        numRooms = Integer.valueOf(rooms.getText().toString());
                    }
                    if (parking.toString().length() > 0) {
                        parkArea = Integer.valueOf(parking.getText().toString());
                    }
                    if (elevators.toString().length() > 0) {
                        numElevators = Integer.valueOf(elevators.getText().toString());
                    }
                    if (bathrooms.toString().length() > 0) {
                        numBath = Integer.valueOf(bathrooms.getText().toString());
                    }
                    if (breakrooms.toString().length() > 0) {
                        numBreak = Integer.valueOf(breakrooms.getText().toString());
                    }
                }
                catch (Exception ex){
                    Toast toast = Toast.makeText(OfficeActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT);
                    toast.show();
                }


                if (filled == true){
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("rooms", numRooms);
                    resultIntent.putExtra("parking", parkArea);
                    resultIntent.putExtra("elevators", numElevators);
                    resultIntent.putExtra("bath", numBath);
                    resultIntent.putExtra("break", numBreak);

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
        if (isEmpty(rooms)){
            rooms.setError("Square footage is required.");
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
        if (isEmpty(elevators)){
            elevators.setError("Number of floors are required.");
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
        if (isEmpty(breakrooms)){
            breakrooms.setError("Number of floors are required.");
            filled = false;
        }
        else{
            filled = true;
        }
    }
}
