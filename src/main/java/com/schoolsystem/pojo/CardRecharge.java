package com.schoolsystem.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CardRecharge {
    private int id;
    private int studentId;
    private Timestamp date;
    private double money;
    private int type;

    public CardRecharge() {
    }

    public CardRecharge(int studentId, double money) {
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

//    public void setMoney(BigDecimal amount) {this.money = amount;
//    }
}
