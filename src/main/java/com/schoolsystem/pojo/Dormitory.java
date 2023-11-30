package com.schoolsystem.pojo;

import java.util.Date;

public class Dormitory {
    private int id;
    private int electricity;
    private int water;

    public int getId() {
        return id;
    }

    public int getElectricity() {
        return electricity;
    }

    public void setElectricity(int electricity) {
        this.electricity = electricity;
    }

    public void setId(int id) {
        this.id = id;
    }
}

