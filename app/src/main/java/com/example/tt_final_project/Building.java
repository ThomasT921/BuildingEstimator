package com.example.tt_final_project;

public class Building {
    private int numFloors;
    private int sqFt;
    private int landAmount;
    private int total = 0;

    public int getFloors(){
        return numFloors;
    }
    public int getSqFt(){
        return sqFt;
    }
    public int getLandAmount(){
        return landAmount;
    }
    public void setNumFloors(int floors){
        numFloors = floors;
    }

    public void setLandAmount(int land) {
        landAmount = land;
    }

    public void setSqFt(int ft) {
        sqFt = ft;
    }
    public int totalCost(){
        total += sqFt * 100;
        total += landAmount * 150;
        total += numFloors * 100000;
        return total;
    }
}
