package com.example.tt_final_project;

public class Office extends Building {
    private int hfBaths, rooms, elevators, breakRooms, parkingArea;
    private double baseCost = 0;
    public double finalCost;

    public void setHfBaths(int hfBaths) {
        this.hfBaths = hfBaths;
    }
    public void setBreakRooms(int breakRooms) {
        this.breakRooms = breakRooms;
    }
    public void setElevators(int elevators) {
        this.elevators = elevators;
    }
    public void setParkingArea(int parkingArea) {
        this.parkingArea = parkingArea;
    }
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
    public int getHfBaths() {
        return hfBaths;
    }
    public int getElevators() {
        return elevators;
    }
    public int getParkingArea() {
        return parkingArea;
    }
    public int getRooms() {
        return rooms;
    }
    public int getBreakRooms() {
        return breakRooms;
    }
    public double getFinalCost(int sqft) {
        baseCost = (sqft * 200);
        finalCost += (hfBaths * 7600);
        finalCost += (rooms * 17300);
        finalCost += (elevators * 45000);
        finalCost += (breakRooms * 15000);
        finalCost += (parkingArea * 2);
        finalCost += baseCost;
        return finalCost;
    }
}
