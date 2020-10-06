package com.example.tt_final_project;

public class House extends Building {
    private boolean hasGarage, hasBasement;
    private int hfBaths, fullBaths, bedR, kitchen;
    private double baseCost = 0;
    public double finalCost;

    public boolean isHasBasement() {
        return hasBasement;
    }
    public boolean isHasGarage() {
        return hasGarage;
    }
    public void setHasBasement(boolean hasBasement) {
        this.hasBasement = hasBasement;
    }
    public void setHasGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
    }
    public void setFullBaths(int fullBaths) {
        this.fullBaths = fullBaths;
    }
    public void setHfBaths(int hfBaths) {
        this.hfBaths = hfBaths;
    }
    public void setBedR(int bedR) {
        this.bedR = bedR;
    }
    public void setKitchen(int kitchen){
        this.kitchen = kitchen;
    }
    public int getKitchen() {
        return kitchen;
    }
    public int getBedR() {
        return bedR;
    }
    public int getHfBaths(){
        return hfBaths;
    }
    public int getFullBaths() {
        return fullBaths;
    }

    public double getFinalCost(int sqft) {
        baseCost += (sqft * 100);
        if(hasBasement){
            finalCost += 9260;
        }
        if(hasGarage){
            finalCost += 10000;
        }
        finalCost += kitchen * 285;
        finalCost += hfBaths * 7600;
        finalCost += fullBaths * 25000;
        finalCost += bedR * 17300;
        finalCost += baseCost;
        return finalCost;
    }
}
