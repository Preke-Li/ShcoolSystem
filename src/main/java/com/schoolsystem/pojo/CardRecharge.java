package com.schoolsystem.pojo;

import java.sql.Timestamp;

public class CardRecharge {
    private int id;
    private int studentId;
    private Timestamp date;
    private int money;
    private int type;

    public CardRecharge() {
    }

    public CardRecharge(int studentId, int money) {
        this.studentId = studentId;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
