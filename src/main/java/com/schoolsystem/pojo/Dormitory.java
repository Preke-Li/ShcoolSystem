package com.schoolsystem.pojo;

import java.util.Date;

public class Dormitory {
    private int id;
    private double electricity;
    private double water;

    public int getId() {
        return id;
    }

    public double getElectricity() {
        return electricity;
    }

    public void setElectricity(double electricity) {
        this.electricity = electricity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }
}

