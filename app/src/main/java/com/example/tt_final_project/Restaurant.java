package com.example.tt_final_project;

public class Restaurant extends Building {
    private boolean hasDriveThru;
    private int parkingArea, numSinks, numRefig, numFreezers, kitchenSize, hfBaths;
    private double baseCost = 0;
    public double finalCost;

    public int getParkingArea() {
        return parkingArea;
    }
    public void setParkingArea(int parkingArea) {
        this.parkingArea = parkingArea;
    }
    public boolean isHasDriveThru() {
        return hasDriveThru;
    }
    public void setHasDriveThru(boolean hasDriveThru) {
        this.hasDriveThru = hasDriveThru;
    }
    public int getNumFreezers() {
        return numFreezers;
    }
    public void setNumFreezers(int numFreezers) {
        this.numFreezers = numFreezers;
    }
    public int getHfBaths() {
        return hfBaths;
    }
    public void setHfBaths(int hfBaths) {
        this.hfBaths = hfBaths;
    }
    public int getNumRefig() {
        return numRefig;
    }
    public void setNumRefig(int numRefig) {
        this.numRefig = numRefig;
    }
    public int getNumSinks() {
        return numSinks;
    }
    public void setNumSinks(int numSinks) {
        this.numSinks = numSinks;
    }
    public void setKitchenSize(int kitchenSize) {
        this.kitchenSize = kitchenSize;
    }
    public int getKitchenSize() {
        return kitchenSize;
    }
    public double getFinalCost(int sqft) {
        baseCost = (sqft * 150);
        if(hasDriveThru){
            finalCost += 50000;
        }
        finalCost += hfBaths * 7600;
        finalCost += kitchenSize * 285;
        finalCost += numRefig * 3500;
        finalCost += numSinks * 500;
        finalCost += numFreezers * 3500;
        finalCost += parkingArea * 2;
        finalCost += baseCost;
        return finalCost;
    }
}
