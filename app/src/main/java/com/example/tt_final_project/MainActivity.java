package com.example.tt_final_project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    House h1 = new House();
    Office o1 = new Office();
    Restaurant r1 = new Restaurant();
    int squareFt, land, floorAmnt;
    Button mainButton;
    RadioButton radioH, radioR, radioO;
    EditText sqft, landAmount, floors, total;
    Boolean filled = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        mainButton = findViewById(R.id.menuButton);
        radioH = findViewById(R.id.houseRb);
        radioR = findViewById(R.id.resturantRb);
        radioO = findViewById(R.id.officeRb);
        sqft = findViewById(R.id.sqftInput);
        landAmount = findViewById(R.id.landInput);
        floors = findViewById(R.id.floorsInput);
        total = findViewById(R.id.totalDisplay);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkData();
                try {
                    if (sqft.toString().length() > 0) {
                        squareFt = Integer.parseInt(sqft.getText().toString());
                    }
                    if (landAmount.toString().length() > 0) {
                        land = Integer.parseInt(landAmount.getText().toString());
                    }
                    if (floors.toString().length() > 0) {
                        floorAmnt = Integer.parseInt(floors.getText().toString());
                    }
                }
                catch(Exception ex) {
                    Toast toast = Toast.makeText(MainActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT);
                    toast.show();
                }

                if (radioH.isChecked() && filled == true){
                    h1.setSqFt(squareFt);
                    h1.setLandAmount(land);
                    h1.setNumFloors(floorAmnt);
                    openHouse();
                }
                else if (radioR.isChecked() && filled == true){
                    r1.setSqFt(squareFt);
                    r1.setLandAmount(land);
                    r1.setNumFloors(floorAmnt);
                    openResturant();
                }
                else if (radioO.isChecked() && filled == true){
                    o1.setSqFt(squareFt);
                    o1.setLandAmount(land);
                    o1.setNumFloors(floorAmnt);
                    openOffice();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Boolean hasBasement = false, hasGarage = false;
        sqft.getText().clear();
        floors.getText().clear();
        landAmount.getText().clear();
        radioH.setChecked(false);
        radioO.setChecked(false);
        radioR.setChecked(false);
        if (requestCode == 1){
            if(resultCode == RESULT_OK){
                int totalCost = 0;
                int beds = data.getIntExtra("beds", 0);
                int fullBaths = data.getIntExtra("full", 0);
                int hfBaths = data.getIntExtra("half", 0);
                int basement = data.getIntExtra("basement", 0);
                int garage = data.getIntExtra("garage", 0);
                int kitchen = data.getIntExtra("kitchen", 0);
                if (basement == 1){
                    hasBasement = true;
                }
                if(garage == 1){
                    hasGarage = true;
                }
                h1.setBedR(beds);
                h1.setFullBaths(fullBaths);
                h1.setHfBaths(hfBaths);
                h1.setHasBasement(hasBasement);
                h1.setHasGarage(hasGarage);
                h1.setKitchen(kitchen);
                totalCost += h1.totalCost();
                totalCost += h1.getFinalCost(h1.getSqFt());
                total.setText("" + totalCost);
            }
        }
        if (requestCode == 2){
            if(resultCode == RESULT_OK){
                int totalCost = 0;
                int officeRooms = data.getIntExtra("rooms", 0);
                int elevators = data.getIntExtra("elevators", 0);
                int breakRooms = data.getIntExtra("break", 0);
                int baths = data.getIntExtra("bath", 0);
                int parking = data.getIntExtra("parking", 0);
                o1.setRooms(officeRooms);
                o1.setBreakRooms(breakRooms);
                o1.setElevators(elevators);
                o1.setHfBaths(baths);
                o1.setParkingArea(parking);
                totalCost += o1.totalCost();
                totalCost += o1.getFinalCost(o1.getSqFt());
                total.setText("" + totalCost);
            }
        }
        if (requestCode == 3){
            if(resultCode == RESULT_OK){
                int totalCost = 0;
                boolean hasD = false;
                int refig = data.getIntExtra("refig", 0);
                int freezers = data.getIntExtra("freezers", 0);
                int kitchen = data.getIntExtra("kitchen", 0);
                int baths = data.getIntExtra("bath", 0);
                int parking = data.getIntExtra("parking", 0);
                int drive = data.getIntExtra("drive", 0);
                int sinks = data.getIntExtra("sinks", 0);
                if (drive == 1){
                    hasD = true;
                }
                r1.setHasDriveThru(hasD);
                r1.setHfBaths(baths);
                r1.setKitchenSize(kitchen);
                r1.setNumFreezers(freezers);
                r1.setNumRefig(refig);
                r1.setNumSinks(sinks);
                r1.setParkingArea(parking);
                totalCost += r1.totalCost();
                totalCost += r1.getFinalCost(r1.getSqFt());
                total.setText("" + totalCost);
            }
        }
    }

    private void openHouse(){
        Intent intent = new Intent(this, HouseActivity.class);
        startActivityForResult(intent, 1);
    }
    private void openOffice(){
        Intent intent = new Intent(this, OfficeActivity.class);
        startActivityForResult(intent, 2);    }
    private void openResturant(){
        Intent intent = new Intent(this, ResturantActivity.class);
        startActivityForResult(intent, 3);    }

    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    public void checkData(){
        if (isEmpty(sqft)){
            sqft.setError("Square footage is required.");
            filled = false;
        }
        else{
            filled = true;
        }
        if (isEmpty(landAmount)){
            landAmount.setError("Amount of land is required.");
            filled = false;
        }
        else{
            filled = true;
        }
        if (isEmpty(floors)){
            floors.setError("Number of floors are required.");
            filled = false;
        }
        else{
            filled = true;
        }
    }

}
